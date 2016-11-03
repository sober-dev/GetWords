package ua.com.sober.getwords.mvp.models.ms;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by dmitry on 9/27/16.
 */

@Root(name = "ArrayOfGetTranslationsResponse")
public class ArrayOfGetTranslationsResponse {

    @ElementList(name = "GetTranslationsResponse", entry = "GetTranslationsResponse", inline = true)
    private List<GetTranslationsResponse> getTranslationsResponses;


    public List<GetTranslationsResponse> getGetTranslationsResponses() {
        return this.getTranslationsResponses;
    }

    public void setGetTranslationsResponses(List<GetTranslationsResponse> getTranslationsResponses) {
        this.getTranslationsResponses = getTranslationsResponses;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


    public static class GetTranslationsResponse {

        @Element(name = "From")
        private String from;

        @Element(name = "State", required = false)
        private Integer state;

        @Element(name = "Translations")
        private Translations translations;


        public String getFrom() {
            return this.from;
        }

        public void setFrom(String from) {
            this.from = from;
        }


        public Integer getState() {
            return this.state;
        }

        public void setState(Integer state) {
            this.state = state;
        }


        public Translations getTranslations() {
            return this.translations;
        }

        public void setTranslations(Translations translationses) {
            this.translations = translationses;
        }


        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }

    }


    public static class Translations {

        @ElementList(name = "TranslationMatch", entry = "TranslationMatch", inline = true)
        private List<TranslationMatch> translationMatch;


        public List<TranslationMatch> getTranslationMatch() {
            return this.translationMatch;
        }

        public void setTranslationMatch(List<TranslationMatch> translationMatches) {
            this.translationMatch = translationMatches;
        }


        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }

    }


    public static class TranslationMatch {

        @Element(name = "Error", required = false)
        private String error;

        @Element(name = "Count")
        private Integer count;

        @Element(name = "MatchDegree")
        private Integer matchDegree;

        @Element(name = "MatchedOriginalText", required = false)
        private String matchedOriginalText;

        @Element(name = "Rating")
        private Integer rating;

        @Element(name = "TranslatedText")
        private String translatedText;


        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }


        public Integer getCount() {
            return this.count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }


        public Integer getMatchDegree() {
            return this.matchDegree;
        }

        public void setMatchDegree(Integer matchDegree) {
            this.matchDegree = matchDegree;
        }


        public String getMatchedOriginalText() {
            return this.matchedOriginalText;
        }

        public void setMatchedOriginalText(String matchedOriginalText) {
            this.matchedOriginalText = matchedOriginalText;
        }


        public Integer getRating() {
            return this.rating;
        }

        public void setRating(Integer rating) {
            this.rating = rating;
        }


        public String getTranslatedText() {
            return this.translatedText;
        }

        public void setTranslatedText(String translatedText) {
            this.translatedText = translatedText;
        }


        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }

    }

}