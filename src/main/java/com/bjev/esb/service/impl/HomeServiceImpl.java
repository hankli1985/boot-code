package com.bjev.esb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bjev.esb.entity.sysbase.SysDept;
import com.bjev.esb.entity.sysbase.SysUser;
import com.bjev.esb.service.DeptService;
import com.bjev.esb.service.HomeService;
import com.bjev.esb.service.PermissionService;
import com.bjev.esb.service.UserService;
import com.bjev.esb.vo.resp.HomeRespVO;
import com.bjev.esb.vo.resp.PermissionRespNode;
import com.bjev.esb.vo.resp.UserInfoRespVO;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * 首页
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Resource
    private UserService userService;
    @Resource
    private DeptService deptService;
    @Resource
    private PermissionService permissionService;

    @Override
    public HomeRespVO getHomeInfo(String userId) {

        SysUser sysUser = userService.getById(userId);
        UserInfoRespVO vo = new UserInfoRespVO();

        if (sysUser != null) {
            BeanUtils.copyProperties(sysUser, vo);
            SysDept sysDept = deptService.getById(sysUser.getDeptId());
            if (sysDept != null) {
                vo.setDeptId(sysDept.getId());
                vo.setDeptName(sysDept.getName());
            }
        }

        List<PermissionRespNode> menus = permissionService.permissionTreeList(userId);

        HomeRespVO respVO = new HomeRespVO();
        respVO.setMenus(menus);
        respVO.setUserInfo(vo);

        return respVO;
    }
}
