package ua.com.sober.getwords;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.com.sober.getwords.mvp.models.MicrosoftTranslatorApiService;
import ua.com.sober.getwords.mvp.models.ms.ArrayOfGetTranslationsResponse;
import ua.com.sober.getwords.mvp.models.ms.GetTranslationsArrayRequest;

import static org.junit.Assert.assertNotNull;

public class MicrosoftApiUnitTest {
    private final CountDownLatch latch = new CountDownLatch(1);
    private MicrosoftTranslatorApiService service;
    private GetTranslationsArrayRequest request;
    private ArrayOfGetTranslationsResponse result;

    @Before
    public void beforeTest() {
        service = MicrosoftTranslatorApiService.Factory.create();
        request = new GetTranslationsArrayRequest();
        GetTranslationsArrayRequest.Texts texts = new GetTranslationsArrayRequest.Texts();
        GetTranslationsArrayRequest.Options options = new GetTranslationsArrayRequest.Options();

        List<GetTranslationsArrayRequest.StringWithNamespace> textsList = Arrays.asList(
                new GetTranslationsArrayRequest.StringWithNamespace("independence"),
                new GetTranslationsArrayRequest.StringWithNamespace("verify"),
                new GetTranslationsArrayRequest.StringWithNamespace("pattern"),
                new GetTranslationsArrayRequest.StringWithNamespace("water"),
                new GetTranslationsArrayRequest.StringWithNamespace("instruction"),
                new GetTranslationsArrayRequest.StringWithNamespace("wallpaper"),
                new GetTranslationsArrayRequest.StringWithNamespace("snickers"),
                new GetTranslationsArrayRequest.StringWithNamespace("book"),
                new GetTranslationsArrayRequest.StringWithNamespace("half"),
                new GetTranslationsArrayRequest.StringWithNamespace("knitting")
        );

        texts.setTexts(textsList);
        options.setIncludeMultipleMTAlternatives(true);
        options.setState(777);

        request.setAppId("");
        request.setTexts(texts);
        request.setFrom("en");
        request.setTo("ru");
        request.setMaxTranslations(5);
        request.setOptions(options);
    }

    @Test
    public void testMSApi() throws InterruptedException {
        assertNotNull(service);
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
        assertNotNull(result);
        System.out.println(result.toString());
    }

    @After
    public void afterTest() {
        result = null;
    }
}
