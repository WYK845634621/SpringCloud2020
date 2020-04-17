package com.yikai.springcloud.vo;

import java.io.Serializable;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Date 2020/4/16 14:40
 */
public class ParamVo <P, C> implements Serializable {
    private static final long serialVersionUID = 1L;
    private P pagger;
    private C condition;

    public ParamVo() {
    }

    public P getPagger() {
        return this.pagger;
    }

    public void setPagger(P pagger) {
        this.pagger = pagger;
    }

    public C getCondition() {
        return this.condition;
    }

    public void setCondition(C condition) {
        this.condition = condition;
    }
}