package com.villen.mvvm.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.villen.mvvm.BR;

/**
 * Banner 结构体
 */
public class Banner extends BaseObservable implements IUpdateListener<Banner> {

    /**
     * desc : 一起来做个App吧
     * id : 10
     * imagePath : https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png
     * isVisible : 1
     * order : 1
     * title : 一起来做个App吧
     * type : 1
     * url : https://www.wanandroid.com/blog/show/2
     */

    private String desc;
    private int id;
    private String imagePath;
    private int isVisible;
    private int order;
    private String title;
    private int type;
    private String url;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void update(Banner banner) {
        setDesc(banner.desc);
        setId(banner.id);
        setImagePath(banner.imagePath);
        setIsVisible(banner.isVisible);
        setOrder(banner.order);
        setTitle(banner.title);
        setType(banner.type);
        setUrl(banner.url);
    }

    @Override
    public String toString() {
        return "Banner{" +
                "desc='" + desc + '\'' +
                ", id=" + id +
                ", imagePath='" + imagePath + '\'' +
                ", isVisible=" + isVisible +
                ", order=" + order +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", url='" + url + '\'' +
                '}';
    }
}
