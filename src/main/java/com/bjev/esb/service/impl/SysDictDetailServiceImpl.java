package com.bjev.esb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjev.esb.common.exception.BusinessException;
import com.bjev.esb.entity.SysDictEntity;
import com.bjev.esb.mapper.localdb.SysDictDetailMapper;
import com.bjev.esb.mapper.localdb.SysDictMapper;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.bjev.esb.entity.SysDictDetailEntity;
import com.bjev.esb.service.SysDictDetailService;
import com.bjev.esb.vo.resp.DictDetailRespNodeVO;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

/**
 * 数据字典 服务类
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@Service("sysDictDetailService")
public class SysDictDetailServiceImpl extends ServiceImpl<SysDictDetailMapper, SysDictDetailEntity>
    implements SysDictDetailService {
  @Resource
  private SysDictDetailMapper sysDictDetailMapper;
  @Resource
  private SysDictMapper sysDictMapper;

  @Override
  public IPage<SysDictDetailEntity> listByPage(Page<SysDictDetailEntity> page, String dictId) {

    SysDictEntity sysDictEntity = sysDictMapper.selectById(dictId);
    if (sysDictEntity == null) {
      throw new BusinessException("获取字典数据失败!");
    }

    LambdaQueryWrapper<SysDictDetailEntity> wrapper = Wrappers.lambdaQuery();
    wrapper.eq(SysDictDetailEntity::getDictId, dictId);
    wrapper.orderByAsc(SysDictDetailEntity::getSort);
    IPage<SysDictDetailEntity> result = sysDictDetailMapper.selectPage(page, wrapper);
    if (!CollectionUtils.isEmpty(result.getRecords())) {
      result.getRecords().parallelStream().forEach(entity -> entity.setDictName(sysDictEntity.getName()));
    }
    return result;
  }

  @Override
  public List<DictDetailRespNodeVO> list(String dictName) {
    SysDictEntity sysDictEntity = sysDictMapper
        .selectOne(Wrappers.<SysDictEntity>lambdaQuery().eq(SysDictEntity::getName, dictName));
    if (sysDictEntity == null) {
      throw new BusinessException(9999, "未查询到相关数据!");
    }
    List<SysDictDetailEntity> dictDetailEntities = sysDictDetailMapper.selectList(
        Wrappers.<SysDictDetailEntity>lambdaQuery().eq(SysDictDetailEntity::getDictId, sysDictEntity.getId()));
    List<DictDetailRespNodeVO> result = new ArrayList<>();
    for (SysDictDetailEntity dictDetailEntity : dictDetailEntities) {
      DictDetailRespNodeVO respNodeVO = new DictDetailRespNodeVO();
      respNodeVO.setTitle(dictDetailEntity.getLabel());
      respNodeVO.setId(dictDetailEntity.getId());
      respNodeVO.setValue(dictDetailEntity.getValue());
      result.add(respNodeVO);
    }
    return result;
  }
}