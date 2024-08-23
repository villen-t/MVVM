package com.villen.mvvm.network;

/**
 * 响应回调
 * @param <T>
 */
public interface ResponseCallback<T> {
    void onSuccess(T t);
    void onFail(String msg);
}
