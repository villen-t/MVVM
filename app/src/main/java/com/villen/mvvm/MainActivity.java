package com.villen.mvvm;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.villen.mvvm.base.BaseActivity;
import com.villen.mvvm.databinding.ActivityMainBinding;

/**
 * 感谢 wanandroid 提供的开放API.
 * wanandroid 官网
 * https://www.wanandroid.com
 * <p>
 * View
 */
public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mBinding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(mBinding.getRoot());
        super.onCreate(savedInstanceState);
    }

    @Override
    public MainViewModel createViewModel() {
        return new MainViewModel();
    }

    @Override
    public void setVariable() {
        mBinding.setVm(mViewModel);
        mBinding.setBanner(mViewModel.getBanner());
    }
}