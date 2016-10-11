package ua.com.sober.getwords.mvp.models;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.com.sober.getwords.mvp.models.mstranslator.MicrosoftToken;

/**
 * Created by dmitry on 10/7/16.
 */

public class MicrosoftTokenManager implements TokenManager {
    private MicrosoftTokenService tokenService = MicrosoftTokenService.Factory.create();
    private Call<MicrosoftToken> call = tokenService.getToken(
            MicrosoftTokenService.GRANT_TYPE_CLIENT_CREDENTIALS,
            MicrosoftTokenService.SCOPE_TRANSLATOR,
            " ",    //clientId
            " ");   //clientSecret
    private String accessToken = null;
    private Long expiresTime = 0L;

    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public boolean hasAccessToken() {
        return accessToken != null && (expiresTime - 60000) > System.currentTimeMillis();
    }

    @Override
    public void clearAccessToken() {
        accessToken = null;
        expiresTime = 0L;
    }

    @Override
    public String refreshAccessToken() {
        call.enqueue(new Callback<MicrosoftToken>() {
            @Override
            public void onResponse(Call<MicrosoftToken> call, Response<MicrosoftToken> response) {
                if (response.isSuccessful()) {
                    MicrosoftToken microsoftToken = response.body();
                    Integer expiresIn = microsoftToken.getExpiresIn();
                    expiresTime = (expiresIn * 1000) + System.currentTimeMillis();
                    accessToken = microsoftToken.getAccessToken();
                    Log.d("Result", accessToken);
                } else {
                    Log.d("Error", "Error token response");
                }
            }

            @Override
            public void onFailure(Call<MicrosoftToken> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
        while (accessToken == null) {
            Log.d("Error", "Wait token response");
        }
        return accessToken;
    }
}
