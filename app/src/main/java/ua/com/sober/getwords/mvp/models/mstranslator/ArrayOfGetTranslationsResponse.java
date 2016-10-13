package ua.com.sober.getwords.mvp.models.mstranslator;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by dmitry on 9/27/16.
 */

@Root(name = "ArrayOfGetTranslationsResponse")
public class ArrayOfGetTranslationsResponse {

    @Element(name = "GetTranslationsResponse", required = false)
    private GetTranslationsResponse getTranslationsResponse;


    public GetTranslationsResponse getGetTranslationsResponse() {
        return this.getTranslationsResponse;
    }

    public void setGetTranslationsResponse(GetTranslationsResponse getTranslationsResponse) {
        this.getTranslationsResponse = getTranslationsResponse;
    }


    @Override
    public String toString() {
        return "ClassPojo [GetTranslationsResponse = " + getTranslationsResponse + "]";
    }
}