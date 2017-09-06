package ua.com.sober.getwords.mvp.models;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface MicrosoftTokenService {
    String TOKEN_SERVICE_URL = "https://api.cognitive.microsoft.com/sts/v1.0/";

    @POST("issueToken")
    Call<String> getToken(@Header("Ocp-Apim-Subscription-Key") String key);

    class Factory {
        public static MicrosoftTokenService create() {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(TOKEN_SERVICE_URL)
                    .client(client)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            return retrofit.create(MicrosoftTokenService.class);
        }
    }
}
