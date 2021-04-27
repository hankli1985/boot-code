package com.bjev.esb.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjev.esb.entity.sysbase.SysRole;

/**
 * 角色
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
public interface RoleService extends IService<SysRole> {

    SysRole addRole(SysRole vo);

    void updateRole(SysRole vo);

    SysRole detailInfo(String id);

    void deletedRole(String id);

    List<SysRole> getRoleInfoByUserId(String userId);

    List<String> getRoleNames(String userId);

    List<SysRole> selectAllRoles();
}
