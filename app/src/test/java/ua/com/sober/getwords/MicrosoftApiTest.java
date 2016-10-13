package ua.com.sober.getwords;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.com.sober.getwords.mvp.models.MicrosoftTranslatorApiService;
import ua.com.sober.getwords.mvp.models.mstranslator.ArrayOfGetTranslationsResponse;
import ua.com.sober.getwords.mvp.models.mstranslator.GetTranslationsArrayRequest;

/**
 * Created by Dmitry on 14.10.2016.
 */

public class MicrosoftApiTest {
    private final CountDownLatch latch = new CountDownLatch(1);
    private MicrosoftTranslatorApiService service;
    private GetTranslationsArrayRequest request;
    private ArrayOfGetTranslationsResponse result;

    @Before
    public void beforeTest() {
        service = MicrosoftTranslatorApiService.Factory.create();
        GetTranslationsArrayRequest.Texts texts = new GetTranslationsArrayRequest.Texts();
        List<GetTranslationsArrayRequest.StringWithNamespace> textsList = Arrays.asList(
                new GetTranslationsArrayRequest.StringWithNamespace("lazy"),
                new GetTranslationsArrayRequest.StringWithNamespace("world"),
                new GetTranslationsArrayRequest.StringWithNamespace("hole"));
        texts.setTexts(textsList);
        GetTranslationsArrayRequest.Options options = new GetTranslationsArrayRequest.Options();
        options.setState(777);
        request = new GetTranslationsArrayRequest();
        request.setAppId("");
        request.setTexts(texts);
        request.setFrom("en");
        request.setTo("ru");
        request.setMaxTranslations(5);
        request.setOptions(options);
    }

    @Test
    public void testMSApi() throws InterruptedException {
        Assert.assertNotNull(service);
        Call<ArrayOfGetTranslationsResponse> call = service.getTranslationsArray(request);
        call.enqueue(new Callback<ArrayOfGetTranslationsResponse>() {
            @Override
            public void onResponse(Call<ArrayOfGetTranslationsResponse> call, Response<ArrayOfGetTranslationsResponse> response) {
                if (response.isSuccessful()) {
                    result = response.body();
                    latch.countDown();
                } else {
                    latch.countDown();
                }
            }

            @Override
            public void onFailure(Call<ArrayOfGetTranslationsResponse> call, Throwable t) {
                latch.countDown();
            }
        });
        latch.await();
        Assert.assertNotNull(service);
    }

    @After
    public void afterTest() {
        result.toString();
    }
}
