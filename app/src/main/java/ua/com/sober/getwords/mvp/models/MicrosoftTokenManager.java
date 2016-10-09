package ua.com.sober.getwords.mvp.models;

/**
 * Created by dmitry on 10/7/16.
 */

public class MicrosoftTokenManager implements TokenManager {
//    MicrosoftTokenService service = MicrosoftTokenService.Factory.create();
//    Call<MicrosoftToken> call = service.getToken(
//                    MicrosoftTokenService.GRANT_TYPE_CLIENT_CREDENTIALS,
//                    MicrosoftTokenService.SCOPE_TRANSLATOR,
//                    "clientId",
//                    "clientSecret") ;
//
//    call.enqueue(new Callback<MicrosoftToken>() {
//        @Override
//        public void onResponse(Call<MicrosoftToken> call, Response<MicrosoftToken> response) {
//
//        }
//
//        @Override
//        public void onFailure(Call<MicrosoftToken> call, Throwable t) {
//
//        }
//    });

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
