package com.bjev.esb.vo.resp;

import java.util.List;

import com.bjev.esb.entity.sysbase.SysRole;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * UserOwnRoleRespVO
 *
 * @author wenbin
 * @version V1.0
 * @date 2020年3月18日
 */
@Data
public class UserOwnRoleRespVO {
    @ApiModelProperty("所有角色集合")
    private List<SysRole> allRole;
    @ApiModelProperty(value = "用户所拥有角色集合")
    private List<String> ownRoles;
}
