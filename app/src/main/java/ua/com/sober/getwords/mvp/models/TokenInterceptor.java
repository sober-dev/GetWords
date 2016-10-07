package ua.com.sober.getwords.mvp.models;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import ua.com.sober.getwords.mvp.models.TokenManager;

/**
 * Created by dmitry on 10/7/16.
 */

public class TokenInterceptor implements Interceptor {
    private final TokenManager tokenManager;

    public TokenInterceptor(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request authorisedRequest = originalRequest;
        if (tokenManager.hasToken()) {
            authorisedRequest = originalRequest.newBuilder()
                    .addHeader("Authorization", "Bearer" + " " + tokenManager.getToken())
                    .build();
        }

        Response response = chain.proceed(authorisedRequest);
        boolean unauthorized = response.code() == 400;
        if (unauthorized) {
            tokenManager.clearToken();
            String newToken = tokenManager.refreshToken();
            authorisedRequest = originalRequest.newBuilder()
                    .addHeader("Authorization", "Bearer" + " " + newToken)
                    .build();
            return chain.proceed(authorisedRequest);
        }
        return response;
    }
}
