package com.bjev.esb.entity.sysesb;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bjev.esb.vo.req.PageReqVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "t_if_param")
public class TIfParamEntity extends PageReqVO implements Serializable {
  @TableId
  private String id;
  private String toSysName;
  private String ifCode;
  private String paramGroup;
  private String paramCode;
  private String paramName;
  private String paramValue;
  private String paramDesc;
  private String editAble;
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
}
