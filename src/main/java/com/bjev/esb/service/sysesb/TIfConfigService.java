package com.bjev.esb.service.sysesb;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bjev.esb.entity.sysesb.TIfConfigEntity;

public interface TIfConfigService extends IService<TIfConfigEntity> {

  List<TIfConfigEntity> findSenderAll();

  IPage<TIfConfigEntity> pageInfo(TIfConfigEntity vo);

  void addSender(TIfConfigEntity vo);

  void updateSender(TIfConfigEntity vo);

  void delSender(String id);

}
