package com.hengba.sql.domain;

import com.hengba.sql.UpdateSql;

/**
 * Created by oukingtim
 */
@UpdateSql.Table(name = "tb_dict_class")
public class TbDictClass extends BaseModel<TbDictClass> {
    @UpdateSql.ID
    private String code;
    @UpdateSql.ID
    private String remark;

}
