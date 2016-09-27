package ua.com.sober.getwords.mvp.models.mstranslator;

/**
 * Created by dmitry on 9/27/16.
 */

public class TranslationMatch
{
    private String Count;

    private String MatchDegree;

    private String Rating;

    private String MatchedOriginalText;

    private String TranslatedText;

    public String getCount ()
    {
        return Count;
    }

    public void setCount (String Count)
    {
        this.Count = Count;
    }

    public String getMatchDegree ()
    {
        return MatchDegree;
    }

    public void setMatchDegree (String MatchDegree)
    {
        this.MatchDegree = MatchDegree;
    }

    public String getRating ()
    {
        return Rating;
    }

    public void setRating (String Rating)
    {
        this.Rating = Rating;
    }

    public String getMatchedOriginalText ()
    {
        return MatchedOriginalText;
    }

    public void setMatchedOriginalText (String MatchedOriginalText)
    {
        this.MatchedOriginalText = MatchedOriginalText;
    }

    public String getTranslatedText ()
    {
        return TranslatedText;
    }

    public void setTranslatedText (String TranslatedText)
    {
        this.TranslatedText = TranslatedText;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Count = "+Count+", MatchDegree = "+MatchDegree+", Rating = "+Rating+", MatchedOriginalText = "+MatchedOriginalText+", TranslatedText = "+TranslatedText+"]";
    }
}