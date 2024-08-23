package com.villen.mvvm.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity<B extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {

    protected B mBinding;
    protected VM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mViewModel = createViewModel();
        setVariable();
    }

    /**
     * 初始化 ViewModel
     * @return
     */
    public abstract VM createViewModel();

    /**
     * 初始化 xml 中定义的变量
     */
    public abstract void setVariable();

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mViewModel != null) {
            mViewModel.onDestroy();
            mViewModel = null;
        }
    }
}
