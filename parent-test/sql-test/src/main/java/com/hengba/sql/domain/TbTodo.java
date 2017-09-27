package com.hengba.sql.domain;

import com.hengba.sql.UpdateSql;

/**
 * Created by oukingtim
 */
@UpdateSql.Table(name = "tb_todo")
public class TbTodo extends BaseModel<TbTodo> {
    @UpdateSql.ID
    private String text;
}
