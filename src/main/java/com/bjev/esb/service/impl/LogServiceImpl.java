package com.bjev.esb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjev.esb.entity.SysLog;
import com.bjev.esb.mapper.localdb.SysLogMapper;
import com.bjev.esb.service.LogService;
import org.springframework.stereotype.Service;

/**
 * 系统日志
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@Service
public class LogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements LogService {
}
