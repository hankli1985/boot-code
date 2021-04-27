package com.bjev.esb.entity.sysesb;

import lombok.Data;

@Data
public class TIfParamTemplateEntity {
  private Long pkId;
  private String paramGroup;
  private String paramCode;
  private String paramName;
  private String paramValue;
  private String paramDesc;
}
