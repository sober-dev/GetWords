package ua.com.sober.getwords.mvp.models.mstranslator;

/**
 * Created by dmitry on 9/27/16.
 */

public class MicrosoftTranslatorApiResponse
{
    private ArrayOfGetTranslationsResponse ArrayOfGetTranslationsResponse;

    public ArrayOfGetTranslationsResponse getArrayOfGetTranslationsResponse ()
    {
        return ArrayOfGetTranslationsResponse;
    }

    public void setArrayOfGetTranslationsResponse (ArrayOfGetTranslationsResponse ArrayOfGetTranslationsResponse)
    {
        this.ArrayOfGetTranslationsResponse = ArrayOfGetTranslationsResponse;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ArrayOfGetTranslationsResponse = "+ArrayOfGetTranslationsResponse+"]";
    }
}
