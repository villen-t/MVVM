package com.villen.mvvm.base;

public abstract class BaseViewModel<M extends BaseModel> {

    protected M mModel;

    public BaseViewModel() {
        this.mModel = createModel();
    }

    protected abstract M createModel();

    public void onDestroy() {
        if (mModel != null) {
            mModel = null;
        }
    }
}
