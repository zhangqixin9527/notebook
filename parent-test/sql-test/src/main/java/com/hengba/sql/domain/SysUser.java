package com.hengba.sql.domain;

import com.hengba.sql.UpdateSql;

import java.util.List;

/**
 * Created by oukingtim
 */
@UpdateSql.Table(name = "sys_user")
public class SysUser extends BaseModel<SysUser> {
    @UpdateSql.ID
    private String username;
    @UpdateSql.ID
    private String password;
    @UpdateSql.ID
    private String email;
    @UpdateSql.ID
    private String mobile;
    @UpdateSql.ID
    private String status;
    @UpdateSql.ID
    private List<SysRole> rolelist;


    public SysUser(String username) {
        this.username = username;
    }

    public SysUser() {
    }
}
