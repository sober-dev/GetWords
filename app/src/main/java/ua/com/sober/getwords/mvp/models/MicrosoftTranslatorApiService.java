package ua.com.sober.getwords.mvp.models;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

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

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.microsofttranslator.com/V2/Http.svc/")
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                    .build();
            return retrofit.create(MicrosoftTranslatorApiService.class);
        }
    }
}
