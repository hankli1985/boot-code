package com.bjev.esb.entity.sysbase;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户角色
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@Data
public class SysUserRole implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 5297837696506837557L;

    @TableId
    private String id;

    private String userId;

    private String roleId;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}