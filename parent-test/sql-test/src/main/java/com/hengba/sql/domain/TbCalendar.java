package com.hengba.sql.domain;

import com.hengba.sql.UpdateSql;

/**
 * Created by oukingtim
 */
@UpdateSql.Table(name = "tb_calendar")
public class TbCalendar extends BaseModel<TbCalendar> {
    @UpdateSql.ID
    private String title;
    @UpdateSql.ID
    private String start;
    @UpdateSql.ID
    private String end;
    @UpdateSql.ID
    private String color;

}
