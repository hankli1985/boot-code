package com.bjev.esb.controller.sysesb;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.bjev.esb.common.utils.DataResult;
import com.bjev.esb.entity.sysesb.IfGroupEntity;
import com.bjev.esb.entity.sysesb.IfGroupParamEntity;
import com.bjev.esb.service.sysesb.IfGroupParamService;
import com.bjev.esb.service.sysesb.IfGroupService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/esb")
@RestController
public class IfGroupController {

  @Resource
  private IfGroupService ifGroupService;
  @Resource
  private IfGroupParamService ifGroupParamService;

  @PostMapping("/ifGroups")
  public DataResult getGroups(@RequestBody IfGroupEntity vo) {
    return DataResult.success(ifGroupService.pageInfo(vo));
  }

  @PostMapping("/ifGroup")
  // @ApiOperation(value = "新增用户接口")
  // @RequiresPermissions("sys:user:add")
  // @LogAnnotation(title = "用户管理", action = "新增用户")
  public DataResult addGroup(@RequestBody @Valid IfGroupEntity vo) {
    ifGroupService.addVo(vo);
    DataResult dataresult = DataResult.success();
    System.out.println(dataresult);
    return dataresult;
  }

  @PutMapping("/ifGroup")
  // @ApiOperation(value = "新增用户接口")
  // @RequiresPermissions("sys:user:add")
  // @LogAnnotation(title = "用户管理", action = "新增用户")
  public DataResult updateGroup(@RequestBody @Valid IfGroupEntity vo) {
    ifGroupService.updateVo(vo);
    return DataResult.success();
  }

  @DeleteMapping("/ifGroup")
  // @ApiOperation(value = "删除用户接口")
  // @LogAnnotation(title = "用户管理", action = "删除用户")
  // @RequiresPermissions("sys:user:deleted")
  public DataResult deletedGroup(@RequestBody @Valid String id) {
    ifGroupService.deleteVo(id);
    return DataResult.success();
  }

  @PostMapping("ifGroupParam")
  public DataResult getGroupParams(@RequestBody IfGroupParamEntity vo) {
    return DataResult.success(ifGroupParamService.pageInfo(vo));

  }
}
