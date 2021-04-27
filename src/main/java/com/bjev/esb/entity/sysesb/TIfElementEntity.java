package com.bjev.esb.entity.sysesb;

import lombok.Data;

@Data
public class TIfElementEntity {
  private Long pkId;
  private String ifCode;
  private String elementName;
  private String tableId;
  private String fieldName;
  private String defaultValue;
  private String xmlAttr;
  private String creator;
  private Integer fieldType;
  private String userFieldType;
  private Integer maxLength;
  private Integer isActive;
  private Integer nullAble;
  private Integer insertAble;
  private Integer updateAble;
  private Integer sortNo;
  private String elementDesc;
  private String dataConvert;
  private String dataFormat;

  public TIfElementEntity(Long pkId) {
    this.pkId = pkId;
  }

}
