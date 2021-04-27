package com.bjev.esb.entity.sysesb;

import lombok.Data;

@Data
public class TIfExecutionYearEntity {
  private Long pkId;
  private String year;
  private String ifCode;
  private Integer autoSuccess;
  private Integer autoTotal;
  private Integer handSuccess;
  private Integer handTotal;
}