package com.hengba.sql.domain;

import com.hengba.sql.UpdateSql;

import java.util.List;

/**
 * Created by oukingtim
 */
@UpdateSql.Table(name = "sys_role")
public class SysRole extends BaseModel<SysRole> {
    @UpdateSql.ID
    private String roleName;
    @UpdateSql.ID
    private String remark;
    @UpdateSql.ID
    private Boolean checked;
    @UpdateSql.ID
    private List<JsTreeVM> menuTree;

    public SysRole() {
    }

    public SysRole(String roleName) {
        this.roleName = roleName;
    }
}
