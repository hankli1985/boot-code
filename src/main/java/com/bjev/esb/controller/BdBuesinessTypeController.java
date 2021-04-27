package com.bjev.esb.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import com.bjev.esb.common.utils.DataResult;

import com.bjev.esb.entity.BdBuesinessTypeEntity;
import com.bjev.esb.service.BdBuesinessTypeService;

/**
 * 业务类型
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2020-07-21 11:21:29
 */
@Controller
@RequestMapping("/")
public class BdBuesinessTypeController {
  @Autowired
  private BdBuesinessTypeService bdBuesinessTypeService;

  /**
   * 跳转到页面
   */
  @GetMapping("/index/bdBuesinessType")
  public String bdBuesinessType() {
    return "bdbuesinesstype/list";
  }

  @ApiOperation(value = "新增")
  @PostMapping("bdBuesinessType/add")
  @RequiresPermissions("bdBuesinessType:add")
  @ResponseBody
  public DataResult add(@RequestBody BdBuesinessTypeEntity bdBuesinessType) {
    bdBuesinessTypeService.save(bdBuesinessType);
    return DataResult.success();
  }

  @ApiOperation(value = "删除")
  @DeleteMapping("bdBuesinessType/delete")
  @RequiresPermissions("bdBuesinessType:delete")
  @ResponseBody
  public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids) {
    bdBuesinessTypeService.removeByIds(ids);
    return DataResult.success();
  }

  @ApiOperation(value = "更新")
  @PutMapping("bdBuesinessType/update")
  @RequiresPermissions("bdBuesinessType:update")
  @ResponseBody
  public DataResult update(@RequestBody BdBuesinessTypeEntity bdBuesinessType) {
    bdBuesinessTypeService.updateById(bdBuesinessType);
    return DataResult.success();
  }

  @ApiOperation(value = "查询分页数据")
  @PostMapping("bdBuesinessType/listByPage")
  @RequiresPermissions("bdBuesinessType:list")
  @ResponseBody
  public DataResult findListByPage(@RequestBody BdBuesinessTypeEntity bdBuesinessType) {
    Page<BdBuesinessTypeEntity> page = new Page<>(bdBuesinessType.getPage(), bdBuesinessType.getLimit());
    LambdaQueryWrapper<BdBuesinessTypeEntity> queryWrapper = Wrappers.lambdaQuery();
    // 查询条件示例
    // queryWrapper.eq(BdBuesinessTypeEntity::getId, bdBuesinessType.getId());
    IPage<BdBuesinessTypeEntity> iPage = bdBuesinessTypeService.page(page, queryWrapper);
    return DataResult.success(iPage);
  }

}
