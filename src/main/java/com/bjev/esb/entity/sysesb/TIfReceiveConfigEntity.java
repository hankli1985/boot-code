package com.bjev.esb.entity.sysesb;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TIfReceiveConfigEntity {
  private Long pkId;
  private String ifCode;
  private String tableId;
  private String tableDesc;
  private String tableName;
  private String parentTableId;
  private String approach;
  private Integer isValueApproach;
  private String approachSuffix;
  private String revisionName;
  private Integer tableType;
  private String keySequence;
  private String keyClass;
  private Integer createType;
  private Integer updateType;
  private String deleteSql;
  private Integer emptyFromParent;
  private Integer sortNo;
  private String fullApproach;
  private String fullApproachSuffix;
  private TIfReceiveConfigEntity parent;
  private List<TIfReceiveConfigEntity> children = new ArrayList<TIfReceiveConfigEntity>();

  public TIfReceiveConfigEntity(final Long pkId) {
    this.pkId = pkId;
  }

  public List<TIfReceiveConfigEntity> getChildren() {
    return this.children;
  }

  @Deprecated
  public void setChildren(final List<TIfReceiveConfigEntity> children) {
    this.children = children;
  }

}
