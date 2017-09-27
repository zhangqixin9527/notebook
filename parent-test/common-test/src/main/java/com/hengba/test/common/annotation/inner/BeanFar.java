package com.hengba.test.common.annotation.inner;

/**
 * @author Kevin created on 2017/9/27
 */
public class BeanFar extends BeanMor {
    @BabiAnno(name = "tel", fieldType = FieldType.STRING)
    private String tel;
    private String company;

    public BeanFar(boolean isAuth, boolean isLove, boolean isChar, String tel, String company) {
        super(isAuth, isLove, isChar);
        this.tel = tel;
        this.company = company;
    }
}
