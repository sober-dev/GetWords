package ua.com.sober.getwords.jobs;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;

import java.util.List;

import ua.com.sober.getwords.mvp.models.MicrosoftTranslatorApiService;
import ua.com.sober.getwords.mvp.models.ms.ArrayOfGetTranslationsResponse;

/**
 * Created by Dmitry on 10/31/2016.
 */

public class TranslationJob extends Job {

    private static final String TAG = TranslationJob.class.getSimpleName();
    private List<String> strings;

    public TranslationJob(List<String> strings) {
        super(new Params(Priority.MID));
        this.strings = strings;
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        Log.d(TAG, strings.toString());
    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {

    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }

    private void getAllTranslations() {

    }

    // Max 10 strings
    private ArrayOfGetTranslationsResponse getTranslationsResponse(List<String> strings) {
        MicrosoftTranslatorApiService service = MicrosoftTranslatorApiService.Factory.create();
        ArrayOfGetTranslationsResponse translationsResponse = null;


        return translationsResponse;
    }
}
