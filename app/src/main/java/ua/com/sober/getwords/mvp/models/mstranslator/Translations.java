package ua.com.sober.getwords.mvp.models.mstranslator;

/**
 * Created by dmitry on 9/27/16.
 */

public class Translations
{
    private TranslationMatch[] TranslationMatch;

    public TranslationMatch[] getTranslationMatch ()
    {
        return TranslationMatch;
    }

    public void setTranslationMatch (TranslationMatch[] TranslationMatch)
    {
        this.TranslationMatch = TranslationMatch;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [TranslationMatch = "+TranslationMatch+"]";
    }
}