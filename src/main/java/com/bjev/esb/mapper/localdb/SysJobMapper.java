package com.bjev.esb.mapper.localdb;

import com.bjev.esb.entity.SysJobEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务 Mapper
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@Mapper
public interface SysJobMapper extends BaseMapper<SysJobEntity> {

}
