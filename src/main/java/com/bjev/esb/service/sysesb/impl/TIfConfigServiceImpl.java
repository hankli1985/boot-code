package com.bjev.esb.service.sysesb.impl;

import java.util.List;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjev.esb.common.exception.BusinessException;
import com.bjev.esb.common.exception.code.BaseResponseCode;
import com.bjev.esb.entity.sysesb.TIfConfigEntity;
import com.bjev.esb.mapper.localdb.sysesb.TIfConfigMapper;
import com.bjev.esb.service.sysesb.TIfConfigService;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TIfConfigServiceImpl extends ServiceImpl<TIfConfigMapper, TIfConfigEntity> implements TIfConfigService {

  @Resource
  private TIfConfigMapper tIfConfigMapper;

  @Override
  public List<TIfConfigEntity> findSenderAll() {

    LambdaQueryWrapper<TIfConfigEntity> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(TIfConfigEntity::getIfType, 2);
    List<TIfConfigEntity> lists = tIfConfigMapper.selectList(queryWrapper);
    return lists;
  }

  @Override
  public void addSender(TIfConfigEntity vo) {
    TIfConfigEntity tIfConfigEntity = tIfConfigMapper
        .selectOne(Wrappers.<TIfConfigEntity>lambdaQuery().eq(TIfConfigEntity::getIfCode, vo.getIfCode()));
    if (tIfConfigEntity != null) {
      throw new BusinessException("接口代码已存在，请勿重复添加！");
    }
    vo.setIfType(2);
    int i = tIfConfigMapper.insert(vo);
    if (i != 1) {
      throw new BusinessException(BaseResponseCode.OPERATION_ERRO);
    }
  }

  @Override
  public void updateSender(TIfConfigEntity vo) {
    int i = tIfConfigMapper.updateById(vo);
    if (i != 1) {
      throw new BusinessException(BaseResponseCode.OPERATION_ERRO);
    }
  }

  @Override
  public void delSender(String id) {
    int i = tIfConfigMapper.delete(Wrappers.<TIfConfigEntity>lambdaQuery().eq(TIfConfigEntity::getId, id));
    if (i != 1) {
      throw new BusinessException(BaseResponseCode.OPERATION_ERRO);
    }

  }

  @Override
  public IPage<TIfConfigEntity> pageInfo(TIfConfigEntity vo) {
    Page<TIfConfigEntity> page = new Page<>(vo.getPage(), vo.getLimit());
    LambdaQueryWrapper<TIfConfigEntity> queryWrapper = Wrappers.lambdaQuery();
    if (!StringUtils.isEmpty(vo.getIfCode())) {
      queryWrapper.like(TIfConfigEntity::getIfCode, vo.getIfCode());
    }
    if (!StringUtils.isEmpty(vo.getIfName())) {
      queryWrapper.like(TIfConfigEntity::getIfName, vo.getIfName());
    }
    if (!StringUtils.isEmpty(vo.getToSysName())) {
      queryWrapper.like(TIfConfigEntity::getToSysName, vo.getToSysName());
    }
    if (!StringUtils.isEmpty(vo.getServiceType())) {
      queryWrapper.eq(TIfConfigEntity::getServiceType, vo.getServiceType());
    }
    queryWrapper.eq(TIfConfigEntity::getIfType, 2);
    queryWrapper.orderByAsc(TIfConfigEntity::getIfCode);
    IPage<TIfConfigEntity> iPage = tIfConfigMapper.selectPage(page, queryWrapper);
    for (TIfConfigEntity tIfConfigEntity : iPage.getRecords()) {
      tIfConfigEntity.setServiceTypeTitle(tIfConfigEntity.getServiceType().getDescp());
      tIfConfigEntity.setReceiveTransactionTypeTitle(tIfConfigEntity.getReceiveTransactionType().getDescp());
    }
    return iPage;
  }

}
