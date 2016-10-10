package ua.com.sober.getwords.mvp.models;

/**
 * Created by dmitry on 10/7/16.
 */

public interface TokenManager {
    String getAccessToken();
    boolean hasAccessToken();
    void clearAccessToken();
    String refreshAccessToken();
}