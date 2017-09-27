package com.hengba.test.common.annotation.inner;

/**
 * @author Kevin created on 2017/9/27
 */
public class Bean extends BeanFar implements BeanIface {
    @BabiAnno(name = "id", fieldType = FieldType.INTEGER)
    private int id;
    @BabiAnno(name = "name", fieldType = FieldType.STRING)
    private String name;
    @BabiAnno(name = "age", fieldType = FieldType.INTEGER)
    private int age;
    @BabiAnno(name = "sex", fieldType = FieldType.BOOLEAN)
    private boolean sex;
    private String home;

    public Bean(boolean isAuth, boolean isLove, boolean isChar, String tel, String company,
                int id, String name, int age, boolean sex, String home) {
        super(isAuth, isLove, isChar, tel, company);
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.home = home;
    }

    @Override
    public void sayABC() {

    }
}
