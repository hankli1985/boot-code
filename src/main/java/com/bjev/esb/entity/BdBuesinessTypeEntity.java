package com.bjev.esb.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.bjev.esb.vo.req.PageReqVO;

import java.io.Serializable;
import java.util.Date;

/**
 * 业务类型
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2020-07-21 11:21:29
 */
@TableName("bd_buesiness_type")
public class BdBuesinessTypeEntity extends PageReqVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 业务id
	 */
	@TableId("business_id")
	private Integer businessId;

	/**
	 * 业务名
	 */
	@TableField("business_name")
	private String businessName;

	/**
	 * 日期
	 */
	@TableField("business_month")
	private Date businessMonth;

}
