package ua.com.sober.getwords.jobs;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.birbit.android.jobqueue.Job;
import com.birbit.android.jobqueue.Params;
import com.birbit.android.jobqueue.RetryConstraint;

import org.apache.commons.collections4.ListUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import ua.com.sober.getwords.mvp.models.MicrosoftTranslatorApiService;
import ua.com.sober.getwords.mvp.models.ms.ArrayOfGetTranslationsResponse;
import ua.com.sober.getwords.mvp.models.ms.GetTranslationsArrayRequest;

public class TranslationJob extends Job {

    private static final String TAG = TranslationJob.class.getSimpleName();
    private List<String> listOfWords;

    public TranslationJob(List<String> strings) {
        super(new Params(Priority.MID));
        this.listOfWords = strings;
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {
        Map<String, List<String>> vocabularyList = getVocabularyList(listOfWords);
        Log.d(TAG, "Vocabulary list:" + vocabularyList.toString());
    }

    @Override
    protected void onCancel(int cancelReason, @Nullable Throwable throwable) {

    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(@NonNull Throwable throwable, int runCount, int maxRunCount) {
        return null;
    }

    private Map<String, List<String>> getVocabularyList(List<String> strings) {
        Map<String, List<String>> vocabularyList = new LinkedHashMap<>();
        List<List<String>> allTranslations = new ArrayList<>();

        for (List<String> partition : ListUtils.partition(strings, 10)) {
            ArrayOfGetTranslationsResponse response = getTranslationsResponse(partition);

            if (response != null) {
                List<ArrayOfGetTranslationsResponse.GetTranslationsResponse> getTranslationsResponses =
                        response.getGetTranslationsResponses();

                if (!getTranslationsResponses.isEmpty()) {
                    // Words
                    for (ArrayOfGetTranslationsResponse.GetTranslationsResponse getTranslationsResponse : getTranslationsResponses) {

                        List<String> translations = new ArrayList<>();

                        List<ArrayOfGetTranslationsResponse.TranslationMatch> matches =
                                getTranslationsResponse.getTranslations().getTranslationMatch();
                        if (!matches.isEmpty()) {

                            // Translations
                            for (ArrayOfGetTranslationsResponse.TranslationMatch match : matches) {
                                translations.add(match.getTranslatedText());
                            }
                        }

                        allTranslations.add(translations);
                    }
                }
            }
        }

        for (int i = 0; i < strings.size(); i++) {
            vocabularyList.put(strings.get(i), allTranslations.get(i));
        }

        return vocabularyList;
    }

    // Max 10 strings
    private ArrayOfGetTranslationsResponse getTranslationsResponse(List<String> strings) {
        MicrosoftTranslatorApiService service = MicrosoftTranslatorApiService.Factory.create();
        ArrayOfGetTranslationsResponse translationsResponse = null;

        GetTranslationsArrayRequest request = new GetTranslationsArrayRequest();
        GetTranslationsArrayRequest.Texts texts = new GetTranslationsArrayRequest.Texts();
        GetTranslationsArrayRequest.Options options = new GetTranslationsArrayRequest.Options();
        List<GetTranslationsArrayRequest.StringWithNamespace> textsList = new ArrayList<>();

        for (String string : strings) {
            textsList.add(new GetTranslationsArrayRequest.StringWithNamespace(string));
        }
        texts.setTexts(textsList);
        options.setIncludeMultipleMTAlternatives(true);
//        options.setState(id);

        request.setAppId("");
        request.setTexts(texts);
        request.setFrom("en");
        request.setTo("ru");
        request.setMaxTranslations(5);
        request.setOptions(options);

        Call<ArrayOfGetTranslationsResponse> call = service.getTranslationsArray(request);
        try {
            translationsResponse = call.execute().body();
        } catch (IOException e) {
            Log.d(TAG, "No response from the translation server =(");
            e.printStackTrace();
        }

        return translationsResponse;
    }
}
