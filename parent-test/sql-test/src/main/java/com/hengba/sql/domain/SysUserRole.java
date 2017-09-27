package com.hengba.sql.domain;

import com.hengba.sql.UpdateSql;

/**
 * Created by oukingtim
 */
@UpdateSql.Table(name = "sys_user_role")
public class SysUserRole extends BaseModel<SysUserRole> {
    @UpdateSql.ID
    private String roleId;
    @UpdateSql.ID
    private String userId;

}
