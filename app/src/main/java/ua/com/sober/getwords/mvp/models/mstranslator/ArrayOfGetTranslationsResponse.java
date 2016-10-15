package ua.com.sober.getwords.mvp.models.mstranslator;

import org.simpleframework.xml.Element;
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

    public void setGetTranslationsResponse(List<GetTranslationsResponse> getTranslationsResponses) {
        this.getTranslationsResponse = getTranslationsResponses;
    }


    @Override
    public String toString() {
        String listString = "ClassPojo ";

        for (GetTranslationsResponse getTranslationsResponse : this.getTranslationsResponse) {
            listString += "[GetTranslationsResponse = " + getTranslationsResponse.toString() + "] ";
        }

        return listString;

    }


    public static class GetTranslationsResponse {

        @Element(name = "From", required = false)
        private String from;

        @Element(name = "State", required = false)
        private Integer state;

        @ElementList(name = "Translations", required = false)
        private List<Translations> translations;


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


        public List<Translations> getTranslations() {
            return this.translations;
        }

        public void setTranslations(List<Translations> translationses) {
            this.translations = translationses;
        }


        @Override
        public String toString() {
            String listString = "ClassPojo [From = " + from + ", State = " + state + ", ";

            for (Translations translations : this.translations) {
                listString += "[Translations = " + translations.toString() + "] ";
            }

            return listString;

        }

    }


    public static class Translations {

        @ElementList(name = "TranslationMatch", required = false)
        private List<TranslationMatch> translationMatch;


        public List<TranslationMatch> getTranslationMatch() {
            return this.translationMatch;
        }

        public void setTranslationMatch(List<TranslationMatch> translationMatches) {
            this.translationMatch = translationMatches;
        }


        @Override
        public String toString() {
            String listString = "ClassPojo ";

            for (TranslationMatch translationMatch : this.translationMatch) {
                listString += "[TranslationMatch = " + translationMatch.toString() + "] ";
            }

            return listString;
        }

    }


    public static class TranslationMatch {

        @Element(name = "Count", required = false)
        private Integer count;

        @Element(name = "MatchDegree", required = false)
        private Integer matchDegree;

        @Element(name = "MatchedOriginalText", required = false)
        private String matchedOriginalText;

        @Element(name = "Rating", required = false)
        private Integer rating;

        @Element(name = "TranslatedText", required = false)
        private String translatedText;


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
            return "ClassPojo [Count = " + count + ", MatchDegree = " + matchDegree + ", Rating = " + rating + ", MatchedOriginalText = " + matchedOriginalText + ", TranslatedText = " + translatedText + "]";
        }

    }

}