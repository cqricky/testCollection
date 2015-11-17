package com.hj.fx;

/**
 * Created by caiqing on 15/11/17.
 */
public class Info<T> {
    private T value;

    public Info() {
    }
    public Info(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
