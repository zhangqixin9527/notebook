package com.hengba.anntation.test;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Kevin created on 2018/3/22
 */
//@Deprecated
public class Sickness {
    @Deprecated
    private String name;

    public Sickness(String name) {
        this.name = name;
    }

    public void show(){
        if(StringUtils.isBlank(name)){
            System.out.println(">>>> none <<<<");
        }
        else {
            System.out.println(String.format(">>>> %1$s <<<<", name));
        }
    }

//    @Deprecated
    public int useMoney(){
        if(StringUtils.isNoneBlank(name)){
            if(name.contains("xxx")){
                return 1000;
            } else if (name.contains("xx")){
                return 100;
            } else if(name.contains("x")){
                return 10;
            }
        }
        return 0;
    }
}
