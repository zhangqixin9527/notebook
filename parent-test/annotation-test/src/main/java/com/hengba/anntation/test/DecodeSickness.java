package com.hengba.anntation.test;

/**
 * @author Kevin created on 2018/3/22
 */
public class DecodeSickness {
    public static void main(String[] args) {
        Sickness sickness = new Sickness("xxx");
        sickness.show();
        System.out.println("use money: " + sickness.useMoney());
    }
}
