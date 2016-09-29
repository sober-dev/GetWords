package ua.com.sober.getwords.mvp.models.mstranslator;

import org.simpleframework.xml.Element;

/**
 * Created by dmitry on 9/27/16.
 */

public class TranslationMatch {

    @Element(name = "Count", required = false)
    private int count;

    @Element(name = "MatchDegree", required = false)
    private int matchDegree;

    @Element(name = "MatchedOriginalText", required = false)
    private String matchedOriginalText;

    @Element(name = "Rating", required = false)
    private int rating;

    @Element(name = "TranslatedText", required = false)
    private String translatedText;

    public int getCount() {
        return this.count;
    }

    public void setCount(int _value) {
        this.count = _value;
    }

    public int getMatchDegree() {
        return this.matchDegree;
    }

    public void setMatchDegree(int _value) {
        this.matchDegree = _value;
    }

    public String getMatchedOriginalText() {
        return this.matchedOriginalText;
    }

    public void setMatchedOriginalText(String _value) {
        this.matchedOriginalText = _value;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int _value) {
        this.rating = _value;
    }

    public String getTranslatedText() {
        return this.translatedText;
    }

    public void setTranslatedText(String _value) {
        this.translatedText = _value;
    }

    @Override
    public String toString() {
        return "ClassPojo [Count = " + count + ", MatchDegree = " + matchDegree + ", Rating = " + rating + ", MatchedOriginalText = " + matchedOriginalText + ", TranslatedText = " + translatedText + "]";
    }
}