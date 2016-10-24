package ua.com.sober.getwords.mvp.models.ms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

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
    private String scope;

    @SerializedName("token_type")
    @Expose
    private String tokenType;


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }


    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }


    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }


    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
