package ua.com.sober.getwords.jobs;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import ua.com.sober.getwords.BuildConfig;
import ua.com.sober.getwords.GetWordsApplication;
import ua.com.sober.getwords.mvp.models.OcrApiService;
import ua.com.sober.getwords.mvp.models.ocr.Line;
import ua.com.sober.getwords.mvp.models.ocr.OcrApiResponse;
import ua.com.sober.getwords.mvp.models.ocr.ParsedResult;
import ua.com.sober.getwords.mvp.models.ocr.Word;

/**
 * Created by Dmitry on 10/31/2016.
 */

public class ParseImageJob extends Job {

    private static final String TAG = ParseImageJob.class.getSimpleName();
    private Uri uri;
    private OcrApiResponse ocrApiResponse;

    public ParseImageJob(Uri uri) {
        super(new Params(Priority.MID).requireNetwork());
        this.uri = uri;
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        ocrApiResponse = getOcrApiResponse(uri);
        if (ocrApiResponse != null) {
            Log.d(TAG, ocrApiResponse.toString());

            // Start TranslationJob
            JobManager jobManager = GetWordsApplication.getInstance().getJobManager();
            jobManager.addJobInBackground(new TranslationJob(getWordsFromOcrResponse(ocrApiResponse)));
        } else {
            Log.d(TAG, "Free OCR API ERROR");
        }
    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {

    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }

    private OcrApiResponse getOcrApiResponse(Uri uri) {
        OcrApiService service = OcrApiService.Factory.create();
        ocrApiResponse = null;
        File file = new File(uri.getPath());

        // Request parts
        RequestBody apikey = RequestBody.create(MediaType.parse("text/plain"), BuildConfig.OCR_API_KEY);
        RequestBody language = RequestBody.create(MediaType.parse("text/plain"), "eng");
        RequestBody isOverlayRequired = RequestBody.create(MediaType.parse("text/plain"), "true");
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part fileBody = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        Call<OcrApiResponse> call = service.parseImage(apikey, language, isOverlayRequired, fileBody);
        try {
            ocrApiResponse = call.execute().body();
        } catch (IOException e) {
            Log.d(TAG, "No response from the ocr server =(");
            e.printStackTrace();
        }

        return ocrApiResponse;
    }

    private List<String> getWordsFromOcrResponse(OcrApiResponse ocrResponse) {
        List<String> strings = new ArrayList<>();

        if (!ocrResponse.getIsErroredOnProcessing() &&
                ocrResponse.getOCRExitCode() == 1 &&
                ocrResponse.getParsedResults() != null &&
                !ocrResponse.getParsedResults().isEmpty()) {

            List<ParsedResult> parsedResults = ocrResponse.getParsedResults();
            for (ParsedResult result : parsedResults) {

                if (result.getTextOverlay() != null) {

                    if (!result.getTextOverlay().getLines().isEmpty()) {

                        List<Line> lines = result.getTextOverlay().getLines();
                        for (Line line : lines) {

                            if (!line.getWords().isEmpty()) {

                                List<Word> words = line.getWords();
                                for (Word word : words) {

                                    if (!word.getWordText().isEmpty()) {
                                        strings.add(word.getWordText());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Log.d(TAG, "Words:" + strings.toString());
            return strings.isEmpty() ? null : strings;
        } else {
            // If an error occurred when parsing the Image
            return null;
        }
    }

}
