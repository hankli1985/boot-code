package com.bjev.esb;

import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bjev.esb.entity.sysesb.TIfConfigEntity;
import com.bjev.esb.mapper.localdb.sysesb.TIfConfigMapper;
import com.bjev.esb.service.sysesb.TIfConfigService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsbApplicationTests {

    @Autowired
    private TIfConfigMapper tIfConfigMapper;

    @Autowired
    private TIfConfigService tIfConfigService;

    @Test
    public void contextLoads() {
        String str2 = null;
        Map<String, Object> maps = new HashMap<>();
        maps.put("if_Code", "MES101");
        // QueryWrapper<TIfConfigEntity> queryWrapper = new QueryWrapper<>();
        // queryWrapper.eq("ifCode", "MES101");
        LambdaQueryWrapper<TIfConfigEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TIfConfigEntity::getIfCode, "MES101");
        try {
            str2 = tIfConfigMapper.selectOne(queryWrapper).toString();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        // String str2 = tIfConfigService.selectById("111111").toString();
        System.out.println(str2);
    }

    @Test
    public void test2() {
        // DeptService deptService = new DeptServiceImpl();
        LambdaQueryWrapper<TIfConfigEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TIfConfigEntity::getIfNameZh, "val");
        System.out.println(tIfConfigMapper.selectOne(queryWrapper));
    }

    @Test
    public void test3() {
        // DeptService deptService = new DeptServiceImpl();
        LambdaQueryWrapper<TIfConfigEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TIfConfigEntity::getIfType, 1);

        System.out.println(tIfConfigService.list(queryWrapper));
    }
}
