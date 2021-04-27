package com.bjev.esb.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjev.esb.entity.BdBuesinessTypeEntity;
import com.bjev.esb.mapper.localdb.BdBuesinessTypeMapper;
import com.bjev.esb.service.BdBuesinessTypeService;

@Service("bdBuesinessTypeService")
public class BdBuesinessTypeServiceImpl extends ServiceImpl<BdBuesinessTypeMapper, BdBuesinessTypeEntity>
        implements BdBuesinessTypeService {

}