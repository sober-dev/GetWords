package ua.com.sober.getwords.mvp.models;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import ua.com.sober.getwords.mvp.models.mstranslator.MicrosoftToken;

/**
 * Created by dmitry on 10/7/16.
 */

public interface MicrosoftTokenService {
    String DATAMARKET_OAUTH_URL = "https://datamarket.accesscontrol.windows.net/v2/";
    String GRANT_TYPE_CLIENT_CREDENTIALS = "client_credentials";
    String SCOPE_TRANSLATOR = "http://api.microsofttranslator.com";


    @POST("OAuth2-13")
    @FormUrlEncoded
    Call<MicrosoftToken> getToken(@Field("grant_type") String grantType,
                                  @Field("scope") String scope,
                                  @Field("client_id") String clientId,
                                  @Field("client_secret") String clientSecret);

    class Factory {
        public static MicrosoftTokenService create() {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(DATAMARKET_OAUTH_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(MicrosoftTokenService.class);
        }
    }
}
