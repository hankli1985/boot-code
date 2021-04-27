package com.bjev.esb.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjev.esb.common.utils.DataResult;
import com.bjev.esb.config.aop.annotation.LogAnnotation;
import com.bjev.esb.entity.sysbase.SysRole;
import com.bjev.esb.service.RoleService;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 角色管理
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@RequestMapping("/sys")
@RestController
@Api(tags = "组织模块-角色管理")
public class RoleController {
  @Resource
  private RoleService roleService;

  @PostMapping("/role")
  @ApiOperation(value = "新增角色接口")
  @LogAnnotation(title = "角色管理", action = "新增角色")
  @RequiresPermissions("sys:role:add")
  public DataResult addRole(@RequestBody @Valid SysRole vo) {
    return DataResult.success(roleService.addRole(vo));
  }

  @DeleteMapping("/role/{id}")
  @ApiOperation(value = "删除角色接口")
  @LogAnnotation(title = "角色管理", action = "删除角色")
  @RequiresPermissions("sys:role:deleted")
  public DataResult deleted(@PathVariable("id") String id) {
    roleService.deletedRole(id);
    return DataResult.success();
  }

  @PutMapping("/role")
  @ApiOperation(value = "更新角色信息接口")
  @LogAnnotation(title = "角色管理", action = "更新角色信息")
  @RequiresPermissions("sys:role:update")
  public DataResult updateDept(@RequestBody SysRole vo) {
    if (StringUtils.isEmpty(vo.getId())) {
      return DataResult.fail("id不能为空");
    }
    roleService.updateRole(vo);
    return DataResult.success();
  }

  @GetMapping("/role/{id}")
  @ApiOperation(value = "查询角色详情接口")
  @LogAnnotation(title = "角色管理", action = "查询角色详情")
  @RequiresPermissions("sys:role:detail")
  public DataResult detailInfo(@PathVariable("id") String id) {
    return DataResult.success(roleService.detailInfo(id));
  }

  @PostMapping("/roles")
  @ApiOperation(value = "分页获取角色信息接口")
  @LogAnnotation(title = "角色管理", action = "分页获取角色信息")
  @RequiresPermissions("sys:role:list")
  public DataResult pageInfo(@RequestBody SysRole vo) {
    Page<SysRole> page = new Page<>(vo.getPage(), vo.getLimit());
    LambdaQueryWrapper<SysRole> queryWrapper = Wrappers.lambdaQuery();
    if (!StringUtils.isEmpty(vo.getName())) {
      queryWrapper.like(SysRole::getName, vo.getName());
    }
    if (!StringUtils.isEmpty(vo.getStartTime())) {
      queryWrapper.gt(SysRole::getCreateTime, vo.getStartTime());
    }
    if (!StringUtils.isEmpty(vo.getEndTime())) {
      queryWrapper.lt(SysRole::getCreateTime, vo.getEndTime());
    }
    if (!StringUtils.isEmpty(vo.getStatus())) {
      queryWrapper.eq(SysRole::getStatus, vo.getStatus());
    }
    queryWrapper.orderByDesc(SysRole::getCreateTime);
    return DataResult.success(roleService.page(page, queryWrapper));
  }

}
