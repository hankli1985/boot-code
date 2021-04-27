package com.bjev.esb.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bjev.esb.entity.sysbase.SysUser;
import com.bjev.esb.vo.req.LoginReqVO;
import com.bjev.esb.vo.req.RegisterReqVO;
import com.bjev.esb.vo.req.UpdatePasswordReqVO;
import com.bjev.esb.vo.resp.LoginRespVO;
import com.bjev.esb.vo.resp.UserOwnRoleRespVO;

/**
 * 用户 服务类
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
public interface UserService extends IService<SysUser> {

    String register(RegisterReqVO vo);

    LoginRespVO login(LoginReqVO vo);

    void updateUserInfo(SysUser vo, String operationId);

    IPage<SysUser> pageInfo(SysUser vo);

    void addUser(SysUser vo);

    void logout();

    void updatePwd(UpdatePasswordReqVO vo, String userId);

    List<SysUser> getUserListByDeptIds(List<Object> deptIds);

    UserOwnRoleRespVO getUserOwnRole(String userId);

    void updateUserInfoMy(SysUser vo, String userId);
}
