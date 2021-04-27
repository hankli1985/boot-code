package com.bjev.esb.entity.sysbase;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色权限
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@Data
public class SysRolePermission implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @TableId
    private String id;

    private String roleId;

    private String permissionId;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}