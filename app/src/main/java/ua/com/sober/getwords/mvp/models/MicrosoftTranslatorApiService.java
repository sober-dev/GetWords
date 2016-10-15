package ua.com.sober.getwords.mvp.models;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ua.com.sober.getwords.mvp.models.ms.ArrayOfGetTranslationsResponse;
import ua.com.sober.getwords.mvp.models.ms.GetTranslationsArrayRequest;

/**
 * Created by dmitry on 9/26/16.
 */

public interface MicrosoftTranslatorApiService {
    @POST("GetTranslationsArray")
    Call<ArrayOfGetTranslationsResponse> getTranslationsArray(@Body GetTranslationsArrayRequest body);

    class Factory {
        public static MicrosoftTranslatorApiService create() {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            Strategy strategy = new AnnotationStrategy();
            Serializer serializer = new Persister(strategy);

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(new TokenInterceptor(new MicrosoftTokenManager()))
                    .build();

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
