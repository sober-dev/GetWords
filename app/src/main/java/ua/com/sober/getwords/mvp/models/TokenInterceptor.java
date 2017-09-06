package ua.com.sober.getwords.mvp.models;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {
    private final TokenManager tokenManager;

    public TokenInterceptor(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request authorisedRequest = originalRequest;
        if (tokenManager.hasAccessToken()) {
            authorisedRequest = originalRequest.newBuilder()
                    .addHeader("Authorization", "Bearer" + " " + tokenManager.getAccessToken())
                    .build();
        }

        Response response = chain.proceed(authorisedRequest);
        boolean unauthorized = response.code() == 400;
        if (unauthorized) {
            tokenManager.clearAccessToken();
            authorisedRequest = originalRequest.newBuilder()
                    .addHeader("Authorization", "Bearer" + " " + tokenManager.refreshAccessToken())
                    .build();
            response = chain.proceed(authorisedRequest);
        }
        return response;
    }
}
