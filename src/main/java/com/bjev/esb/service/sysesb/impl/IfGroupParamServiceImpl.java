package com.bjev.esb.service.sysesb.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjev.esb.common.exception.BusinessException;
import com.bjev.esb.common.exception.code.BaseResponseCode;
import com.bjev.esb.entity.sysesb.IfGroupParamEntity;
import com.bjev.esb.mapper.localdb.sysesb.IfGroupParamMapper;
import com.bjev.esb.service.sysesb.IfGroupParamService;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class IfGroupParamServiceImpl extends ServiceImpl<IfGroupParamMapper, IfGroupParamEntity>
    implements IfGroupParamService {

  @Resource
  private IfGroupParamMapper ifGroupParamMapper;

  @Override
  public void addVo(IfGroupParamEntity vo) {
    IfGroupParamEntity ifGroupParamEntity = ifGroupParamMapper
        .selectOne(Wrappers.<IfGroupParamEntity>lambdaQuery().eq(IfGroupParamEntity::getGroupCode, vo.getGroupCode()));
    if (ifGroupParamEntity != null) {
      throw new BusinessException("接口代码已存在，请勿重复添加！");
    }
    // vo.setGroupType(2);
    int i = ifGroupParamMapper.insert(vo);
    if (i != 1) {
      throw new BusinessException(BaseResponseCode.OPERATION_ERRO);
    }
  }

  @Override
  public void updateVo(IfGroupParamEntity vo) {
    int i = ifGroupParamMapper.updateById(vo);
    if (i != 1) {
      throw new BusinessException(BaseResponseCode.OPERATION_ERRO);
    }
  }

  @Override
  public void deleteVo(String id) {
    int i = ifGroupParamMapper.delete(Wrappers.<IfGroupParamEntity>lambdaQuery().eq(IfGroupParamEntity::getId, id));
    if (i != 1) {
      throw new BusinessException(BaseResponseCode.OPERATION_ERRO);
    }

  }

  @Override
  public IPage<IfGroupParamEntity> pageInfo(IfGroupParamEntity vo) {
    Page<IfGroupParamEntity> page = new Page<>(vo.getPage(), vo.getLimit());
    LambdaQueryWrapper<IfGroupParamEntity> queryWrapper = Wrappers.lambdaQuery();
    if (!StringUtils.isEmpty(vo.getGroupCode())) {
      queryWrapper.eq(IfGroupParamEntity::getGroupId, vo.getGroupId());
    }
    if (!StringUtils.isEmpty(vo.getGroupCode())) {
      queryWrapper.eq(IfGroupParamEntity::getGroupCode, vo.getGroupCode());
    }
    if (!StringUtils.isEmpty(vo.getToSysName())) {
      queryWrapper.eq(IfGroupParamEntity::getToSysName, vo.getToSysName());
    }
    queryWrapper.orderByAsc(IfGroupParamEntity::getParamGroup);
    queryWrapper.orderByAsc(IfGroupParamEntity::getParamCode);
    IPage<IfGroupParamEntity> iPage = ifGroupParamMapper.selectPage(page, queryWrapper);
    // for (IfGroupParamEntity ifGroupEntity : iPage.getRecords()) {
    // ifGroupEntity.setServiceTypeTitle(ifGroupEntity.getServiceType().getDescp());
    // ifGroupEntity.setReceiveTransactionTypeTitle(ifGroupEntity.getReceiveTransactionType().getDescp());
    // }
    return iPage;
  }

}
