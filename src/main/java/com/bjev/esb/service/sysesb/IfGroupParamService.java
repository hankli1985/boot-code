package com.bjev.esb.service.sysesb;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bjev.esb.entity.sysesb.IfGroupParamEntity;

public interface IfGroupParamService extends IService<IfGroupParamEntity> {

  IPage<IfGroupParamEntity> pageInfo(IfGroupParamEntity vo);

  void addVo(IfGroupParamEntity vo);

  void updateVo(IfGroupParamEntity vo);

  void deleteVo(String id);

}
