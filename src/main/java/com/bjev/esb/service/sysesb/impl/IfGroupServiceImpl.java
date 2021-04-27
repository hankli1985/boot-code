package com.bjev.esb.service.sysesb.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjev.esb.common.exception.BusinessException;
import com.bjev.esb.common.exception.code.BaseResponseCode;
import com.bjev.esb.entity.sysesb.IfGroupEntity;
import com.bjev.esb.mapper.localdb.sysesb.IfGroupMapper;
import com.bjev.esb.service.sysesb.IfGroupService;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class IfGroupServiceImpl extends ServiceImpl<IfGroupMapper, IfGroupEntity> implements IfGroupService {

  @Resource
  private IfGroupMapper ifGroupMapper;

  @Override
  public void addVo(IfGroupEntity vo) {
    IfGroupEntity tIfConfigEntity = ifGroupMapper
        .selectOne(Wrappers.<IfGroupEntity>lambdaQuery().eq(IfGroupEntity::getGroupCode, vo.getGroupCode()));
    if (tIfConfigEntity != null) {
      throw new BusinessException("接口代码已存在，请勿重复添加！");
    }
    vo.setGroupType(2);
    int i = ifGroupMapper.insert(vo);
    if (i != 1) {
      throw new BusinessException(BaseResponseCode.OPERATION_ERRO);
    }
  }

  @Override
  public void updateVo(IfGroupEntity vo) {
    int i = ifGroupMapper.updateById(vo);
    if (i != 1) {
      throw new BusinessException(BaseResponseCode.OPERATION_ERRO);
    }
  }

  @Override
  public void deleteVo(String id) {
    int i = ifGroupMapper.delete(Wrappers.<IfGroupEntity>lambdaQuery().eq(IfGroupEntity::getId, id));
    if (i != 1) {
      throw new BusinessException(BaseResponseCode.OPERATION_ERRO);
    }

  }

  @Override
  public IPage<IfGroupEntity> pageInfo(IfGroupEntity vo) {
    Page<IfGroupEntity> page = new Page<>(vo.getPage(), vo.getLimit());
    LambdaQueryWrapper<IfGroupEntity> queryWrapper = Wrappers.lambdaQuery();
    if (!StringUtils.isEmpty(vo.getGroupCode())) {
      queryWrapper.like(IfGroupEntity::getGroupCode, vo.getGroupCode());
    }
    if (!StringUtils.isEmpty(vo.getGroupName())) {
      queryWrapper.like(IfGroupEntity::getGroupName, vo.getGroupName());
    }
    if (!StringUtils.isEmpty(vo.getToSysName())) {
      queryWrapper.like(IfGroupEntity::getToSysName, vo.getToSysName());
    }
    if (!StringUtils.isEmpty(vo.getServiceType())) {
      queryWrapper.eq(IfGroupEntity::getServiceType, vo.getServiceType());
    }
    queryWrapper.eq(IfGroupEntity::getGroupType, 2);
    queryWrapper.orderByAsc(IfGroupEntity::getGroupCode);
    IPage<IfGroupEntity> iPage = ifGroupMapper.selectPage(page, queryWrapper);
    for (IfGroupEntity ifGroupEntity : iPage.getRecords()) {
      ifGroupEntity.setServiceTypeTitle(ifGroupEntity.getServiceType().getDescp());
      ifGroupEntity.setReceiveTransactionTypeTitle(ifGroupEntity.getReceiveTransactionType().getDescp());
    }
    return iPage;
  }

}
