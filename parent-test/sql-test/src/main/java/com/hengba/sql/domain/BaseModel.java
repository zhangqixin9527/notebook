//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hengba.sql.domain;


import com.hengba.sql.UpdateSql;

import java.io.Serializable;
import java.util.Date;

/**
 * 通用实体（通用字段）
 * Created by oukingtim
 */
public abstract class BaseModel<T extends BaseModel> implements Serializable {
    private static final long serialVersionUID = 1L;
    @UpdateSql.ID
    private String id;
    @UpdateSql.ID
    private String createUserId;
    @UpdateSql.ID
    private Date createTime;
    @UpdateSql.ID
    private String updateUserId;
    @UpdateSql.ID
    private Date updateTime;

    protected Serializable pkVal() {
        // TODO Auto-generated method stub
        return id;
    }
}
