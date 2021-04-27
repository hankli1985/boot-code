package com.bjev.esb.service.sysesb.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjev.esb.entity.sysesb.TIfParamEntity;
import com.bjev.esb.mapper.localdb.sysesb.TIfParamMapper;
import com.bjev.esb.service.sysesb.TIfParamService;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TIfParamServiceImpl extends ServiceImpl<TIfParamMapper, TIfParamEntity> implements TIfParamService {

  @Resource
  private TIfParamMapper tIfParamMapper;

  @Override
  public IPage<TIfParamEntity> pageInfo(TIfParamEntity vo) {
    Page<TIfParamEntity> page = new Page<>(vo.getPage(), vo.getLimit());
    LambdaQueryWrapper<TIfParamEntity> queryWrapper = Wrappers.lambdaQuery();
    queryWrapper.eq(TIfParamEntity::getIfCode, vo.getIfCode());
    if (!StringUtils.isEmpty(vo.getToSysName())) {
      queryWrapper.eq(TIfParamEntity::getToSysName, vo.getToSysName());
    }
    queryWrapper.orderByAsc(TIfParamEntity::getParamCode);

    IPage<TIfParamEntity> iPage = tIfParamMapper.selectPage(page, queryWrapper);
    System.out.println(iPage);
    return iPage;
  }

}
