package ua.com.sober.getwords.mvp.models;

import retrofit2.Call;
import ua.com.sober.getwords.mvp.models.mstranslator.MicrosoftToken;

/**
 * Created by dmitry on 10/7/16.
 */

public class MicrosoftTokenManager implements TokenManager {
    MicrosoftTokenService microsoftTokenService = MicrosoftTokenService.Factory.create();

    private Call<MicrosoftToken> call = microsoftTokenService.getToken(
                    MicrosoftTokenService.GRANT_TYPE_CLIENT_CREDENTIALS,
                    MicrosoftTokenService.SCOPE_TRANSLATOR,
                    "clientId",
                    "clientSecret");
    //call.

    @Override
    public String getToken() {
        return null;
    }

    @Override
    public boolean hasToken() {
        return false;
    }

    @Override
    public void clearToken() {

    }

    @Override
    public String refreshToken() {
        return null;
    }
}
