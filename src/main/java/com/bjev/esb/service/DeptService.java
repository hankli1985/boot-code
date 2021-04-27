package com.bjev.esb.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjev.esb.entity.sysbase.SysDept;
import com.bjev.esb.vo.resp.DeptRespNodeVO;

/**
 * 部门
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
public interface DeptService extends IService<SysDept> {

    SysDept addDept(SysDept vo);

    void updateDept(SysDept vo);

    void deleted(String id);

    List<DeptRespNodeVO> deptTreeList(String deptId);

    List<SysDept> selectAll();
}
