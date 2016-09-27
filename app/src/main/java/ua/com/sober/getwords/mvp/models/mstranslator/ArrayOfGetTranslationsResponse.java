package ua.com.sober.getwords.mvp.models.mstranslator;

/**
 * Created by dmitry on 9/27/16.
 */

public class ArrayOfGetTranslationsResponse
{
    private GetTranslationsResponse GetTranslationsResponse;

    private String xmlns;

    public GetTranslationsResponse getGetTranslationsResponse ()
    {
        return GetTranslationsResponse;
    }

    public void setGetTranslationsResponse (GetTranslationsResponse GetTranslationsResponse)
    {
        this.GetTranslationsResponse = GetTranslationsResponse;
    }

    public String getXmlns ()
    {
        return xmlns;
    }

    public void setXmlns (String xmlns)
    {
        this.xmlns = xmlns;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [GetTranslationsResponse = "+GetTranslationsResponse+", xmlns = "+xmlns+"]";
    }
}