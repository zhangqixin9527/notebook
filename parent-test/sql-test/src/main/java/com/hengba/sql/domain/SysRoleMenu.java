package com.hengba.sql.domain;

import com.hengba.sql.UpdateSql;

/**
 * Created by oukingtim
 */
@UpdateSql.Table(name = "sys_role_menu")
public class SysRoleMenu extends BaseModel<SysRoleMenu> {
    @UpdateSql.ID
    private String roleId;
    @UpdateSql.ID
    private String menuId;

    public SysRoleMenu(String menuId) {
        this.menuId = menuId;
    }

    public SysRoleMenu() {
    }
}
