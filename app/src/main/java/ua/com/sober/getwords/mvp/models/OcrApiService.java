package ua.com.sober.getwords.mvp.models;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import ua.com.sober.getwords.mvp.models.ocr.OcrApiResponse;

/**
 * Created by dmitry on 5/17/16.
 */
public interface OcrApiService {
    @Multipart
    @POST("parse/image")
    Call<OcrApiResponse> parseImage(@Part("apikey") String apikey,
                                    @Part("language") String language,
                                    @Part("isOverlayRequired") String isOverlayRequired,
                                    @Part("file") RequestBody file);

    class Factory {
        public static OcrApiService create() {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.ocr.space/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(OcrApiService.class);
        }
    }
}
