package com.jw.myproject.pattern.singleton.register;

/**
 * @author lijw
 * @date 2020/10/26 17:17
 */
public enum SingleEnum {

    INSTANCE;

    private Object data;

    SingleEnum() {

    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    SingleEnum(Object data) {
        this.data = data;
    }

    public static SingleEnum getInstance() {
        return INSTANCE;
    }
}
