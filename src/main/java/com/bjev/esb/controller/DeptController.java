package com.bjev.esb.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.bjev.esb.common.utils.DataResult;
import com.bjev.esb.config.aop.annotation.LogAnnotation;
import com.bjev.esb.entity.sysbase.SysDept;
import com.bjev.esb.service.DeptService;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 部门管理
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@RequestMapping("/sys")
@RestController
@Api(tags = "组织模块-机构管理")
public class DeptController {
    @Resource
    private DeptService deptService;

    @PostMapping("/dept")
    @ApiOperation(value = "新增组织接口")
    @LogAnnotation(title = "机构管理", action = "新增组织")
    @RequiresPermissions("sys:dept:add")
    public DataResult addDept(@RequestBody @Valid SysDept vo) {
        return DataResult.success(deptService.addDept(vo));
    }

    @DeleteMapping("/dept/{id}")
    @ApiOperation(value = "删除组织接口")
    @LogAnnotation(title = "机构管理", action = "删除组织")
    @RequiresPermissions("sys:dept:deleted")
    public DataResult deleted(@PathVariable("id") String id) {
        deptService.deleted(id);
        return DataResult.success();
    }

    @PutMapping("/dept")
    @ApiOperation(value = "更新组织信息接口")
    @LogAnnotation(title = "机构管理", action = "更新组织信息")
    @RequiresPermissions("sys:dept:update")
    public DataResult updateDept(@RequestBody SysDept vo) {
        if (StringUtils.isEmpty(vo.getId())) {
            return DataResult.fail("id不能为空");
        }
        deptService.updateDept(vo);
        return DataResult.success();
    }

    @GetMapping("/dept/{id}")
    @ApiOperation(value = "查询组织详情接口")
    @LogAnnotation(title = "机构管理", action = "查询组织详情")
    @RequiresPermissions("sys:dept:detail")
    public DataResult detailInfo(@PathVariable("id") String id) {
        return DataResult.success(deptService.getById(id));
    }

    @GetMapping("/dept/tree")
    @ApiOperation(value = "树型组织列表接口")
    @LogAnnotation(title = "机构管理", action = "树型组织列表")
    @RequiresPermissions(value = { "sys:user:list", "sys:user:update", "sys:user:add", "sys:dept:add",
            "sys:dept:update" }, logical = Logical.OR)
    public DataResult getTree(@RequestParam(required = false) String deptId) {
        return DataResult.success(deptService.deptTreeList(deptId));
    }

    @GetMapping("/depts")
    @ApiOperation(value = "获取机构列表接口")
    @LogAnnotation(title = "机构管理", action = "获取所有组织机构")
    @RequiresPermissions("sys:dept:list")
    public DataResult getDeptAll() {
        return DataResult.success(deptService.selectAll());
    }

}
