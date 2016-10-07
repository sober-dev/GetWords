package ua.com.sober.getwords.mvp.models;

/**
 * Created by dmitry on 10/7/16.
 */

public interface TokenManager {
    String getToken();
    boolean hasToken();
    void clearToken();
    String refreshToken();
}