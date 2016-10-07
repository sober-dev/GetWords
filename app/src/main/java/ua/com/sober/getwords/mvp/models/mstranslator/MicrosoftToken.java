package ua.com.sober.getwords.mvp.models.mstranslator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dmitry on 10/7/16.
 */

public class MicrosoftToken {
    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("expires_in")
    @Expose
    private Integer expiresIn;
    @SerializedName("scope")
    @Expose
    public String scope;
    @SerializedName("token_type")
    @Expose
    public String tokenType;

    @Override
    public String toString() {
        return "MicrosoftToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", scope='" + scope + '\'' +
                ", tokenType='" + tokenType + '\'' +
                '}';
    }
}
