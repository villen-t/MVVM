package com.villen.mvvm;

import com.villen.mvvm.base.BaseModel;
import com.villen.mvvm.bean.Banner;
import com.villen.mvvm.model.NetworkRepository;
import com.villen.mvvm.network.ResponseCallback;

import java.util.List;

/**
 * Model
 */
public class MainModel extends BaseModel {

    public void getNetworkBanner(ResponseCallback<List<Banner>> callback) {
        // 收到需求，请求接口数据
        NetworkRepository.getInstance().requestBanners(callback);
    }
}
