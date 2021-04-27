package com.bjev.esb.entity.sysesb;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bjev.esb.entity.enums.ServiceTypeEnum;
import com.bjev.esb.entity.enums.TransactionTypeEnum;
import com.bjev.esb.vo.req.PageReqVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("if_group")
public class IfGroupEntity extends PageReqVO implements Serializable {
  @TableId
  private String id;
  private String groupCode;
  private String groupName;
  private String groupNameZh;
  private String toSysName;
  private Integer groupType;
  private ServiceTypeEnum serviceType;
  @TableField(exist = false)
  private String serviceTypeTitle;
  private String serviceClass;
  private TransactionTypeEnum receiveTransactionType;
  @TableField(exist = false)
  private String receiveTransactionTypeTitle;
  private String receiveDeleteFlag;
  private String sendSuccessFlag;
  private String dbProc;
  @TableField(fill = FieldFill.INSERT)
  private Date createTime;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;

}
