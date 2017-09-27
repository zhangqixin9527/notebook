package com.hengba.sql.domain;

import com.hengba.sql.UpdateSql;

/**
 * Created by oukingtim
 */
@UpdateSql.Table(name = "sys_menu")
public class SysMenu extends BaseModel<SysMenu> {
    @UpdateSql.ID
    private String parentId;
    @UpdateSql.ID
    private String name;
    @UpdateSql.ID
    private String type;
    @UpdateSql.ID
    private String icon;
    @UpdateSql.ID
    private String title;
    @UpdateSql.ID
    private Integer level;
    @UpdateSql.ID
    private Integer order;


}
