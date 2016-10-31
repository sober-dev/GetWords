package ua.com.sober.getwords;

import android.app.Application;

import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.config.Configuration;

import ua.com.sober.getwords.mvp.models.HelperFactory;

/**
 * Created by Dmitry on 22.10.2016.
 */

public class GetWordsApplication extends Application {
    private static GetWordsApplication instance;
    private JobManager jobManager;

    public GetWordsApplication() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getJobManager();
        HelperFactory.setHelper(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        HelperFactory.releaseHelper();
        super.onTerminate();
    }

    public static GetWordsApplication getInstance() {
        return instance;
    }

    public synchronized JobManager getJobManager() {
        if (jobManager == null) {
            configureJobManager();
        }
        return jobManager;
    }

    private void configureJobManager() {
        Configuration.Builder builder = new Configuration.Builder(this)
                .minConsumerCount(1)//always keep at least one consumer alive
                .maxConsumerCount(3)//up to 3 consumers at a time
                .loadFactor(3)//3 jobs per consumer
                .consumerKeepAlive(120);//wait 2 minute
        jobManager = new JobManager(builder.build());
    }
}
