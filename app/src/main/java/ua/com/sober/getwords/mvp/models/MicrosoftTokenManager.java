package ua.com.sober.getwords.mvp.models;

import java.io.IOException;

import retrofit2.Call;

import ua.com.sober.getwords.BuildConfig;
import ua.com.sober.getwords.mvp.models.mstranslator.MicrosoftToken;

/**
 * Created by dmitry on 10/7/16.
 */

public class MicrosoftTokenManager implements TokenManager {
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
        MicrosoftTokenService tokenService = MicrosoftTokenService.Factory.create();
        Call<MicrosoftToken> call = tokenService.getToken(
                MicrosoftTokenService.GRANT_TYPE_CLIENT_CREDENTIALS,
                MicrosoftTokenService.SCOPE_TRANSLATOR,
                BuildConfig.MS_API_CLIENT_ID,
                BuildConfig.MS_API_CLIENT_SECRET);
        MicrosoftToken microsoftToken = null;
        try {
            microsoftToken = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Integer expiresIn = microsoftToken.getExpiresIn();
        expiresTime = (expiresIn * 1000) + System.currentTimeMillis();
        accessToken = microsoftToken.getAccessToken();

        return accessToken;
    }
}
