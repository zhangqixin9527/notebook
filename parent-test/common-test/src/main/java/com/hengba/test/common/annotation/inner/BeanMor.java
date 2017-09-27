package com.hengba.test.common.annotation.inner;

/**
 * @author Kevin created on 2017/9/27
 */
public class BeanMor {
    private boolean isAuth;
    @BabiAnno(name = "isLove", fieldType = FieldType.BOOLEAN)
    private boolean isLove;
    private boolean isChar;

    public BeanMor(boolean isAuth, boolean isLove, boolean isChar) {
        this.isAuth = isAuth;
        this.isLove = isLove;
        this.isChar = isChar;
    }
}
