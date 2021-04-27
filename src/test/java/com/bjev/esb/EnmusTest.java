package com.bjev.esb;

import com.bjev.esb.entity.enums.ServiceTypeEnum;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnmusTest {

  @Test
  public void test1() {
    ServiceTypeEnum enum1 = ServiceTypeEnum.RESTFul;
    System.out.println(enum1);
    System.out.println(enum1.getCode());
    System.out.println(enum1.getDescp());
    System.out.println(enum1.name());
  }

}
