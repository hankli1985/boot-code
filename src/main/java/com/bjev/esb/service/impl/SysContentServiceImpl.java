package com.bjev.esb.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjev.esb.entity.SysContentEntity;
import com.bjev.esb.mapper.localdb.SysContentMapper;
import com.bjev.esb.service.SysContentService;

/**
 * 内容 服务类
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@Service("sysContentService")
public class SysContentServiceImpl extends ServiceImpl<SysContentMapper, SysContentEntity>
        implements SysContentService {

}