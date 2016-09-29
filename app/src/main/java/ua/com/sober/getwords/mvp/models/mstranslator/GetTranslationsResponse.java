package ua.com.sober.getwords.mvp.models.mstranslator;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by dmitry on 9/27/16.
 */

public class GetTranslationsResponse {
    @Element(name = "From", required = false)
    private String from;

    @Element(name = "State", required = false)
    private int state;

    @ElementList(name = "Translations", required = false)
    private List<TranslationMatch> translations;

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String _value) {
        this.from = _value;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int _value) {
        this.state = _value;
    }

    public List<TranslationMatch> getTranslations() {
        return this.translations;
    }

    public void setTranslations(List<TranslationMatch> _value) {
        this.translations = _value;
    }

    @Override
    public String toString() {
        return "ClassPojo [From = " + from + ", State = " + state + ", Translations = " + translations + "]";
    }
}