package com.bjev.esb.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjev.esb.config.aop.annotation.LogAnnotation;
import com.bjev.esb.common.utils.DataResult;
import org.springframework.web.bind.annotation.*;
import com.bjev.esb.service.ISysGeneratorService;
import com.bjev.esb.entity.SysGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 代码生成
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@Api(tags = "系统模块-代码生成")
@RestController
@RequestMapping("/sysGenerator")
public class SysGeneratorController {
  @Resource
  private ISysGeneratorService sysGeneratorService;

  /**
   * 生成代码
   */
  @ApiOperation(value = "生成")
  @GetMapping("/gen")
  @RequiresPermissions("sysGenerator:add")
  @LogAnnotation(title = "代码生成", action = "代码生成")
  public void code(String tables, HttpServletResponse response) throws IOException {
    byte[] data = sysGeneratorService.generatorCode(tables.split(","));

    response.reset();
    response.setHeader("Content-Disposition", "attachment; filename=\"manager.zip\"");
    response.addHeader("Content-Length", "" + data.length);
    response.setContentType("application/octet-stream; charset=UTF-8");

    IOUtils.write(data, response.getOutputStream());
  }

  @ApiOperation(value = "查询分页数据")
  @PostMapping("/listByPage")
  @RequiresPermissions("sysGenerator:list")
  public DataResult findListByPage(@RequestBody SysGenerator vo) {
    Page<SysGenerator> page = new Page<>(vo.getPage(), vo.getLimit());
    IPage<SysGenerator> iPage = sysGeneratorService.selectAllTables(page, vo);
    return DataResult.success(iPage);
  }
}
