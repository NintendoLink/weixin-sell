package com.hik.weixinsell.study;

/**
 * 普通的泛型类
 * @param <T>
 */
public class General<T> {
    private T t;

    public General() {
    }

    public General(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
