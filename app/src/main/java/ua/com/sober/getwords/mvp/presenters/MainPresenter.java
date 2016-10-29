package ua.com.sober.getwords.mvp.presenters;

import android.net.Uri;
import android.util.Log;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.com.sober.getwords.BuildConfig;
import ua.com.sober.getwords.mvp.models.HelperFactory;
import ua.com.sober.getwords.mvp.models.MicrosoftTranslatorApiService;
import ua.com.sober.getwords.mvp.models.OcrApiService;
import ua.com.sober.getwords.mvp.models.ms.ArrayOfGetTranslationsResponse;
import ua.com.sober.getwords.mvp.models.ocr.OcrApiResponse;
import ua.com.sober.getwords.mvp.models.orm.Group;
import ua.com.sober.getwords.mvp.views.MainView;

/**
 * Created by dmitry on 9/20/16.
 */

public class MainPresenter extends MvpBasePresenter<MainView> {

    private static final String TAG = MainPresenter.class.getSimpleName();
    private List<Group> groups;
    private OcrApiResponse ocrResponse;
    private ArrayOfGetTranslationsResponse translationsResponse;

    public void loadGroups() {
        if (isViewAttached() && getView() != null) {
            getView().showLoading();
            // Need async loader
            try {
                groups = HelperFactory.getHelper().getGroupDao().queryForAll();
                if (isViewAttached()) {
                    if (groups.isEmpty()) {
//                        getView().showEmpty();

                        // Test
                        for (int i = 1; i <= 20; i++) {
                            Group group = new Group("Group " + i);
                            HelperFactory.getHelper().getGroupDao().create(group);
                        }

                        groups = HelperFactory.getHelper().getGroupDao().queryForAll();
                        if (!groups.isEmpty()) {
                            getView().showGroups(groups);
                        } else {
                            getView().showEmpty();
                        }

                    } else {
                        getView().showGroups(groups);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void onAddFabClicked() {
        if (isViewAttached() && getView() != null) {
            getView().navigateToPickImageActivity();
        }
    }

    public void onGroupItemClicked(int position) {
        if (isViewAttached() && getView() != null) {
            getView().navigateToGroupActivity(groups.get(position).getId());
        }
        Log.d(TAG, "Clicked on position: " + position);
    }

    public void getWordsFromImage(Uri uri) {
        OcrApiResponse ocrApiResponse = getOcrResponse(uri);
        if (ocrApiResponse != null) {
            Log.d(TAG, ocrApiResponse.toString());
        } else {

        }


    }

    private OcrApiResponse getOcrResponse(Uri uri) {
        OcrApiService service = OcrApiService.Factory.create();
        ocrResponse = null;
        File file = new File(uri.getPath());

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
                    ocrResponse = response.body();

                } else {

                }
            }

            @Override
            public void onFailure(Call<OcrApiResponse> call, Throwable t) {

            }
        });

        return ocrResponse;
    }

    private void getAllTranslations() {

    }

    // Max 10 strings
    private ArrayOfGetTranslationsResponse getTranslationsResponse(List<String> strings) {
        MicrosoftTranslatorApiService service = MicrosoftTranslatorApiService.Factory.create();
        translationsResponse = null;



        return translationsResponse;
    }
}
