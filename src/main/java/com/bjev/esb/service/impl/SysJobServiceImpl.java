package com.bjev.esb.service.impl;

import com.bjev.esb.common.exception.BusinessException;
import com.bjev.esb.common.job.utils.ScheduleUtils;
import com.bjev.esb.common.utils.Constant;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjev.esb.entity.SysJobEntity;
import com.bjev.esb.mapper.localdb.SysJobMapper;
import com.bjev.esb.service.SysJobService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * 定时任务 服务类
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@Service("sysJobService")
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJobEntity> implements SysJobService {
    @Resource
    private Scheduler scheduler;
    @Resource
    private SysJobMapper sysJobMapper;

    /**
     * 项目启动时，初始化定时器
     */
    @PostConstruct
    public void init() {
        List<SysJobEntity> scheduleJobList = this.list();
        for (SysJobEntity scheduleJob : scheduleJobList) {
            CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, scheduleJob.getId());
            // 如果不存在，则创建
            if (cronTrigger == null) {
                ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
            } else {
                ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
            }
        }
    }

    @Override
    public void saveJob(SysJobEntity sysJob) {
        sysJob.setStatus(Constant.ScheduleStatus.NORMAL.getValue());
        this.save(sysJob);

        ScheduleUtils.createScheduleJob(scheduler, sysJob);
    }

    @Override
    public void updateJobById(SysJobEntity sysJob) {
        SysJobEntity sysJobEntity = this.getById(sysJob.getId());
        if (sysJobEntity == null) {
            throw new BusinessException("获取定时任务异常");
        }
        sysJob.setStatus(sysJobEntity.getStatus());
        ScheduleUtils.updateScheduleJob(scheduler, sysJob);

        this.updateById(sysJob);
    }

    @Override
    public void delete(List<String> ids) {
        for (String jobId : ids) {
            ScheduleUtils.deleteScheduleJob(scheduler, jobId);
        }
        sysJobMapper.deleteBatchIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void run(List<String> ids) {
        for (String jobId : ids) {
            ScheduleUtils.run(scheduler, this.getById(jobId));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pause(List<String> ids) {
        for (String jobId : ids) {
            ScheduleUtils.pauseJob(scheduler, jobId);
        }

        updateBatch(ids, Constant.ScheduleStatus.PAUSE.getValue());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void resume(List<String> ids) {
        for (String jobId : ids) {
            ScheduleUtils.resumeJob(scheduler, jobId);
        }

        updateBatch(ids, Constant.ScheduleStatus.NORMAL.getValue());
    }

    @Override
    public void updateBatch(List<String> ids, int status) {
        ids.parallelStream().forEach(id -> {
            SysJobEntity sysJobEntity = new SysJobEntity();
            sysJobEntity.setId(id);
            sysJobEntity.setStatus(status);
            baseMapper.updateById(sysJobEntity);
        });
    }
}