package ua.com.sober.getwords;

import android.app.Application;

import ua.com.sober.getwords.mvp.models.HelperFactory;

/**
 * Created by Dmitry on 22.10.2016.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HelperFactory.setHelper(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        HelperFactory.releaseHelper();
        super.onTerminate();
    }
}
