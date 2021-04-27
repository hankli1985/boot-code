package com.bjev.esb.service.sysesb;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bjev.esb.entity.sysesb.IfGroupEntity;

public interface IfGroupService extends IService<IfGroupEntity> {

  IPage<IfGroupEntity> pageInfo(IfGroupEntity vo);

  void addVo(IfGroupEntity vo);

  void updateVo(IfGroupEntity vo);

  void deleteVo(String id);

}
