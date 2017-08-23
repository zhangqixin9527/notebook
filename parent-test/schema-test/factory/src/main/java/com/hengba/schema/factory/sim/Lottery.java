package com.hengba.schema.factory.sim;

/**
 * @author Kevin created on 2017/8/15.
 * @since framework 1.0
 */
public interface Lottery {
    String rule();

    public enum Kind{
        JZ,JL
    }
}
