package ua.com.sober.getwords.mvp.models.mstranslator;

/**
 * Created by dmitry on 9/27/16.
 */

public class GetTranslationsResponse
{
    private Translations Translations;

    private String State;

    private String From;

    public Translations getTranslations ()
    {
        return Translations;
    }

    public void setTranslations (Translations Translations)
    {
        this.Translations = Translations;
    }

    public String getState ()
    {
        return State;
    }

    public void setState (String State)
    {
        this.State = State;
    }

    public String getFrom ()
    {
        return From;
    }

    public void setFrom (String From)
    {
        this.From = From;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Translations = "+Translations+", State = "+State+", From = "+From+"]";
    }
}