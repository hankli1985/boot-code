package com.bjev.esb.vo.resp;

import lombok.Data;

@Data
public class DictDetailRespNodeVO {

  private String title;

  private String id;

  private String field;

  private String value;

  private String pid;

  private Integer status;

  private boolean spread;
}
