package ua.com.sober.getwords.mvp.models;

public interface TokenManager {
    String getAccessToken();

    boolean hasAccessToken();

    void clearAccessToken();

    String refreshAccessToken();
}