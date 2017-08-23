/*
 * 文件名称: LotteryFactory.java
 * 版权信息: Copyright 2016-2020 technology Co., LTD. All right reserved.
 * ----------------------------------------------------------------------------------------------
 * 修改历史:
 * ----------------------------------------------------------------------------------------------
 * 修改原因: 新增
 * 修改人员: Kevin
 * 修改日期: 2017/8/15
 * 修改内容: 
 */
package com.hengba.schema.factory.sim;

/**
 * 简单工厂适用于多例下的单层情况
 * @author Kevin created on 2017/8/15.
 * @since framework 1.0
 */
public class LotteryFactory {

    public Lottery getLottery(Lottery.Kind kind) {
        switch (kind) {
            case JL:
                return new JL();
            case JZ:
                return new JZ();
        }
        return null;
    }

    public static void main(String[] args) {
        LotteryFactory factory = new LotteryFactory();
        Lottery jz = factory.getLottery(Lottery.Kind.JZ);
        System.out.println(jz.rule());
        Lottery jl = factory.getLottery(Lottery.Kind.JL);
        System.out.println(jl.rule());
    }
}
