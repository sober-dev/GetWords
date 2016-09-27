package ua.com.sober.getwords.mvp.models;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.POST;
import ua.com.sober.getwords.mvp.models.mstranslator.MicrosoftTranslatorApiResponse;

/**
 * Created by dmitry on 9/26/16.
 */

public interface MicrosoftTranslatorApiService {
    @POST("GetTranslationsArray")
    Call<MicrosoftTranslatorApiResponse> getTranslationsArray();

    class Factory {
        public static MicrosoftTranslatorApiService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.microsofttranslator.com/V2/Http.svc/")
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();
            return retrofit.create(MicrosoftTranslatorApiService.class);
        }
    }
}
