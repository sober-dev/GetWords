package ua.com.sober.getwords.mvp.models;

import java.io.IOException;

import retrofit2.Call;
import ua.com.sober.getwords.BuildConfig;

public class MicrosoftTokenManager implements TokenManager {
    private static String accessToken = null;
    private static long expirationTime = 0L;

    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public boolean hasAccessToken() {
        return accessToken != null && expirationTime > System.currentTimeMillis();
    }

    @Override
    public void clearAccessToken() {
        accessToken = null;
        expirationTime = 0L;
    }

    @Override
    public String refreshAccessToken() {
        MicrosoftTokenService tokenService = MicrosoftTokenService.Factory.create();
        Call<String> call = tokenService.getToken(BuildConfig.MS_SUBSCRIPTION_KEY);
        String microsoftToken = null;
        try {
            microsoftToken = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (microsoftToken != null) {
            long eightMinutes = 480000L;
            expirationTime = eightMinutes + System.currentTimeMillis();
            accessToken = microsoftToken;
        }
        return accessToken;
    }

}
