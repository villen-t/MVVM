package com.villen.mvvm.bean;

public interface IUpdateListener<T> {
    /**
     * 获取到新数据后，用于更新与 xml 绑定的实体类的属性值
     * @param t
     */
    void update(T t);
}
