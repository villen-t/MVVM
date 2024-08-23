package com.villen.mvvm.network;

import com.villen.mvvm.bean.Banner;
import com.villen.mvvm.constant.HttpConstant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Api 接口
 */
public interface ApiService {

    /**
     * 获取首页轮播图
     * @return 轮播图列表
     */
    @GET(HttpConstant.GET_BANNERS_URL)
    Call<BaseResponse<List<Banner>>> getBanners();

}
