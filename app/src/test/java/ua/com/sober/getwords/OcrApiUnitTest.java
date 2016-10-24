package ua.com.sober.getwords;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.CountDownLatch;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.com.sober.getwords.mvp.models.OcrApiService;
import ua.com.sober.getwords.mvp.models.ocr.OcrApiResponse;

/**
 * Created by Dmitry on 16.10.2016.
 */

public class OcrApiUnitTest {
    private final CountDownLatch latch = new CountDownLatch(1);
    private OcrApiService service;
    private OcrApiResponse result;
    private File file;

    @Before
    public void beforeTest() {
        service = OcrApiService.Factory.create();
        file = new File("src/test/java/ua/com/sober/getwords/ocr_test_img.jpg");
    }

    @Test
    public void testOcrApi() throws InterruptedException {
        assertNotNull(service);
        assertFalse(file.length() == 0);

//        Response parts
        RequestBody apikey = RequestBody.create(MediaType.parse("text/plain"), BuildConfig.OCR_API_KEY);
        RequestBody language = RequestBody.create(MediaType.parse("text/plain"), "eng");
        RequestBody isOverlayRequired = RequestBody.create(MediaType.parse("text/plain"), "true");
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part fileBody = MultipartBody.Part.createFormData("file", file.getName(), requestFile);

        Call<OcrApiResponse> call = service.parseImage(apikey, language, isOverlayRequired, fileBody);
        call.enqueue(new Callback<OcrApiResponse>() {
            @Override
            public void onResponse(Call<OcrApiResponse> call, Response<OcrApiResponse> response) {
                if (response.isSuccessful()) {
                    result = response.body();
                    latch.countDown();
                } else {
                    latch.countDown();
                }
            }

            @Override
            public void onFailure(Call<OcrApiResponse> call, Throwable t) {
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
