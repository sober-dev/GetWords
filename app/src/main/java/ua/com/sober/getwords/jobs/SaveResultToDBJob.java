package ua.com.sober.getwords.jobs;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;

import java.util.List;
import java.util.Map;

public class SaveResultToDBJob extends Job {

    private static final String TAG = SaveResultToDBJob.class.getSimpleName();
    private Map<String, List<String>> vocabularyList;

    protected SaveResultToDBJob(Map<String, List<String>> vocabularyList) {
        super(new Params(Priority.MID));
        this.vocabularyList = vocabularyList;
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {

    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {

    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }
}
