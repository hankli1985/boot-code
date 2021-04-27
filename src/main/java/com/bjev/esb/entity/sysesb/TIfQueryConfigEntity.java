package com.bjev.esb.entity.sysesb;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TIfQueryConfigEntity {
  private Long pkId;
  private String ifCode;
  private String tableId;
  private String tableDesc;
  private String parentTableId;
  private String approach;
  private String approachSuffix;
  private String approachPrefix;
  private String xmlAttr;
  private String autoQuerySql;
  private String handQuerySql;
  private Integer emptyFromDefault;
  private Integer allowEmpty;
  private Integer maxNumber;
  private String successSql;
  private String failureSql;
  private Integer sortNo;
  private TIfQueryConfigEntity parent;
  private List<TIfQueryConfigEntity> children = new ArrayList<TIfQueryConfigEntity>();

  public TIfQueryConfigEntity(Long pkId) {
    this.pkId = pkId;
  }

  public TIfQueryConfigEntity(String tableId, String tableDesc) {
    this.tableId = tableId;
    this.tableDesc = tableDesc;
  }

  public List<TIfQueryConfigEntity> getChildren() {
    return this.children;
  }

  @Deprecated
  public void setChildren(List<TIfQueryConfigEntity> children) {
    this.children = children;
  }
}
