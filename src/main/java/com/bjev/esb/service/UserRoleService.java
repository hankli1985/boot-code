package com.bjev.esb.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjev.esb.entity.sysbase.SysUserRole;
import com.bjev.esb.vo.req.UserRoleOperationReqVO;

/**
 * 用户角色 服务类
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
public interface UserRoleService extends IService<SysUserRole> {

    List<String> getRoleIdsByUserId(String userId);

    void addUserRoleInfo(UserRoleOperationReqVO vo);

    List<String> getUserIdsByRoleId(String roleId);
}
