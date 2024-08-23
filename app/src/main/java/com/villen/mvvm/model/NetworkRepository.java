package com.villen.mvvm.model;

import com.villen.mvvm.bean.Banner;
import com.villen.mvvm.constant.HttpConstant;
import com.villen.mvvm.network.ApiService;
import com.villen.mvvm.network.BaseResponse;
import com.villen.mvvm.network.ResponseCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Network Repository
 */
public final class NetworkRepository {

    private ApiService mService;

    private NetworkRepository() {
        createService();
    }

    public static NetworkRepository getInstance() {
        return SingletonHolder.sInstance;
    }

    private static final class SingletonHolder {
        private static final NetworkRepository sInstance = new NetworkRepository();
    }

    /**
     * 请求 banner 数据
     */
    public void requestBanners(ResponseCallback<List<Banner>> callback) {
        mService.getBanners().enqueue(new Callback<BaseResponse<List<Banner>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<Banner>>> call, Response<BaseResponse<List<Banner>>> response) {
                BaseResponse<List<Banner>> body = response.body();
                if (response.isSuccessful() && body != null) {
                    if (body.getErrorCode() == 0) {
                        callback.onSuccess(body.getData());
                    } else {
                        callback.onFail(body.getErrorMsg());
                    }
                } else {
                    callback.onFail(response.message());
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<Banner>>> call, Throwable throwable) {
                callback.onFail(throwable.getMessage());
            }
        });
    }

    private void createService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService = retrofit.create(ApiService.class);
    }
}
