package com.bjev.esb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjev.esb.entity.sysbase.SysRolePermission;
import com.bjev.esb.vo.req.RolePermissionOperationReqVO;

/**
 * 角色权限关联
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
public interface RolePermissionService extends IService<SysRolePermission> {

    void addRolePermission(RolePermissionOperationReqVO vo);
}
