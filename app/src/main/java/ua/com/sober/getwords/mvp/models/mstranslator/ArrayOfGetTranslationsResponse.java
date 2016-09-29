package ua.com.sober.getwords.mvp.models.mstranslator;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by dmitry on 9/27/16.
 */

@Root(name = "ArrayOfGetTranslationsResponse", strict = false)
public class ArrayOfGetTranslationsResponse {

    @ElementList(name = "GetTranslationsResponse", inline = true, required = false)
    private List<GetTranslationsResponse> getTranslationsResponse;

    public List<GetTranslationsResponse> getGetTranslationsResponse() {
        return this.getTranslationsResponse;
    }

    public void setGetTranslationsResponse(List<GetTranslationsResponse> _value) {
        this.getTranslationsResponse = _value;
    }

    @Override
    public String toString() {
        return "ClassPojo [GetTranslationsResponse = " + getTranslationsResponse + "]";
    }
}