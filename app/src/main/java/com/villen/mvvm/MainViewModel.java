package com.villen.mvvm;

import android.util.Log;

import com.villen.mvvm.base.BaseViewModel;
import com.villen.mvvm.bean.Banner;
import com.villen.mvvm.network.ResponseCallback;

import java.util.List;

/**
 * ViewModel
 */
public class MainViewModel extends BaseViewModel<MainModel> {

    private Banner mBanner;
    /**
     * 获取实体类对象，用于 xml 中数据绑定
     */
    public Banner getBanner() {
        if (mBanner == null) {
            mBanner = new Banner();
        }
        return mBanner;
    }

    @Override
    protected MainModel createModel() {
        return new MainModel();
    }

    /**
     * 获取 banner 数据
     */
    public void getNetworkBanner() {
        if (mModel == null) {
            return;
        }
        // 收到新需求，分发给 model 处理
        mModel.getNetworkBanner(new ResponseCallback<List<Banner>>() {
            @Override
            public void onSuccess(List<Banner> banners) {
                if (banners != null && banners.size() > 0) {
                    mBanner.update(banners.get(2));
                }
            }

            @Override
            public void onFail(String msg) {
                Log.e("network", msg);
            }
        });
    }
}
