package ua.com.sober.getwords.mvp.models.ms

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "ArrayOfGetTranslationsResponse")
class ArrayOfGetTranslationsResponse {
    @field:ElementList(name = "GetTranslationsResponse", entry = "GetTranslationsResponse", inline = true)
    var getTranslationsResponses: List<GetTranslationsResponse>? = null

    class GetTranslationsResponse {
        @field:Element(name = "From")
        var from: String? = null

        @field:Element(name = "State", required = false)
        var state: Int? = null

        @field:Element(name = "Translations")
        var translations: Translations? = null

        override fun toString(): String {
            return "GetTranslationsResponse(from=$from, state=$state, translations=$translations)"
        }
    }


    class Translations {
        @field:ElementList(name = "TranslationMatch", entry = "TranslationMatch", inline = true)
        var translationMatch: List<TranslationMatch>? = null

        override fun toString(): String {
            return "Translations(translationMatch=$translationMatch)"
        }
    }


    class TranslationMatch {
        @field:Element(name = "Error", required = false)
        var error: String? = null

        @field:Element(name = "Count")
        var count: Int? = null

        @field:Element(name = "MatchDegree")
        var matchDegree: Int? = null

        @field:Element(name = "MatchedOriginalText", required = false)
        var matchedOriginalText: String? = null

        @field:Element(name = "Rating")
        var rating: Int? = null

        @field:Element(name = "TranslatedText")
        var translatedText: String? = null

        override fun toString(): String {
            return "TranslationMatch(error=$error, count=$count, matchDegree=$matchDegree, matchedOriginalText=$matchedOriginalText, rating=$rating, translatedText=$translatedText)"
        }
    }

    override fun toString(): String {
        return "ArrayOfGetTranslationsResponse(getTranslationsResponses=$getTranslationsResponses)"
    }
}