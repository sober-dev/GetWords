package ua.com.sober.getwords.ui.activities;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.com.sober.getwords.R;
import ua.com.sober.getwords.mvp.models.MicrosoftTranslatorApiService;
import ua.com.sober.getwords.mvp.models.mstranslator.ArrayOfGetTranslationsResponse;
import ua.com.sober.getwords.mvp.models.mstranslator.GetTranslationsArrayRequest;
import ua.com.sober.getwords.mvp.presenters.MainPresenter;
import ua.com.sober.getwords.mvp.views.MainView;

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.testMSApi_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testMSApi();
            }
        });
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    private void testMSApi() {
        GetTranslationsArrayRequest.Texts texts = new GetTranslationsArrayRequest.Texts();
        List<GetTranslationsArrayRequest.StringWithNamespace> textsList;
        textsList = Arrays.asList(
                new GetTranslationsArrayRequest.StringWithNamespace("lazy"),
                new GetTranslationsArrayRequest.StringWithNamespace("world"),
                new GetTranslationsArrayRequest.StringWithNamespace("hole"));
        texts.setTexts(textsList);
        GetTranslationsArrayRequest.Options options = new GetTranslationsArrayRequest.Options();
        options.setState(777);

        GetTranslationsArrayRequest request = new GetTranslationsArrayRequest();
        request.setAppId("");
        request.setTexts(texts);
        request.setFrom("en");
        request.setTo("ru");
        request.setMaxTranslations(5);
        request.setOptions(options);

        MicrosoftTranslatorApiService service = MicrosoftTranslatorApiService.Factory.create();
        Call<ArrayOfGetTranslationsResponse> call = service.getTranslationsArray(request);

        call.enqueue(new Callback<ArrayOfGetTranslationsResponse>() {
            @Override
            public void onResponse(Call<ArrayOfGetTranslationsResponse> call, Response<ArrayOfGetTranslationsResponse> response) {
                if (response.isSuccessful()) {
                    ArrayOfGetTranslationsResponse result = response.body();
                    Log.d("Result", result.toString());
                } else {
                    Log.d("Error", "Error translations response");
                }
            }

            @Override
            public void onFailure(Call<ArrayOfGetTranslationsResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

}
