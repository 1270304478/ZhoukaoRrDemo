package login.bwie.com.zhoukaorrdemo.Adapter;

import android.app.Application;

import login.bwie.com.zhoukaorrdemo.utils.ImageLoaderUtil;

/**
 * 此类的作用：
 *
 * @author: forever
 * @date: 2017/9/15 9:49
 */
public class ImageApplcation extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderUtil.initConfig(this);
    }
}
