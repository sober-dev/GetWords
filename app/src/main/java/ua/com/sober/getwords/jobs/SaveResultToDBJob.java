package ua.com.sober.getwords.jobs;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;

/**
 * Created by Dmitry on 10/31/2016.
 */

public class SaveResultToDBJob extends Job {

    protected SaveResultToDBJob(Params params) {
        super(params);
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {

    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {

    }
}
