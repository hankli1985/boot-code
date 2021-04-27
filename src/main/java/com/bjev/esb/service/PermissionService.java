package com.bjev.esb.service;

import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjev.esb.entity.sysbase.SysPermission;
import com.bjev.esb.vo.resp.PermissionRespNode;

/**
 * 菜单权限
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
public interface PermissionService extends IService<SysPermission> {

    List<SysPermission> getPermission(String userId);

    void deleted(String permissionId);

    List<SysPermission> selectAll();

    Set<String> getPermissionsByUserId(String userId);

    List<PermissionRespNode> permissionTreeList(String userId);

    List<PermissionRespNode> selectAllByTree();

    List<PermissionRespNode> selectAllMenuByTree(String permissionId);

}
