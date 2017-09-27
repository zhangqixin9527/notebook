package com.hengba.sql.domain;

import com.hengba.sql.UpdateSql;

/**
 * Created by oukingtim
 */
@UpdateSql.Table(name = "tb_dict")
public class TbDict extends BaseModel<TbDict> {
    @UpdateSql.ID
    private String code;
    @UpdateSql.ID
    private String text;
    @UpdateSql.ID
    private String remark;
    @UpdateSql.ID
    private String dictClassId;

}
