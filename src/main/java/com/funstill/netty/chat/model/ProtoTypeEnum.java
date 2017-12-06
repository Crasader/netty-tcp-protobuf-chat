package com.funstill.netty.chat.model;

/**
 * @author liukaiyang
 * @date 2017/12/6 15:58
 */
public enum ProtoTypeEnum {
    COMMON_MSG(1, "消息");
    private int index;
    private String name;

    ProtoTypeEnum(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
