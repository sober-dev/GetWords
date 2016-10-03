package ua.com.sober.getwords.mvp.models;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.POST;
import ua.com.sober.getwords.mvp.models.mstranslator.ArrayOfGetTranslationsResponse;

/**
 * Created by dmitry on 9/26/16.
 */

public interface MicrosoftTranslatorApiService {
    @POST("GetTranslationsArray")
    Call<ArrayOfGetTranslationsResponse> getTranslationsArray();

    class Factory {
        public static MicrosoftTranslatorApiService create() {
            Strategy strategy = new AnnotationStrategy();
            Serializer serializer = new Persister(strategy);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            httpClient
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Interceptor.Chain chain) throws IOException {
                            Request original = chain.request();

                            Request.Builder requestBuilder = original.newBuilder()
                                    .header("Authorization", "auth-value");
                            Request request = requestBuilder.build();
                            return chain.proceed(request);
                        }
                    });

            OkHttpClient client = httpClient.build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.microsofttranslator.com/V2/Http.svc/")
                    .client(client)
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                    .build();
            return retrofit.create(MicrosoftTranslatorApiService.class);
        }
    }
}
