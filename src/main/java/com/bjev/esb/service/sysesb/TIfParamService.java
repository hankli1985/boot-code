package com.bjev.esb.service.sysesb;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bjev.esb.entity.sysesb.TIfParamEntity;

public interface TIfParamService extends IService<TIfParamEntity> {

  IPage<TIfParamEntity> pageInfo(TIfParamEntity vo);

}
