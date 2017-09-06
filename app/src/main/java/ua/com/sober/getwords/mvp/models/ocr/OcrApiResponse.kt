package ua.com.sober.getwords.mvp.models.ocr

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OcrApiResponse {
    @SerializedName("ParsedResults")
    @Expose
    var parsedResults: List<ParsedResult>? = null
    @SerializedName("OCRExitCode")
    @Expose
    var ocrExitCode: Int = 0
    @SerializedName("IsErroredOnProcessing")
    @Expose
    var isErroredOnProcessing: Boolean = false
    @SerializedName("ErrorMessage")
    @Expose
    var errorMessage: String? = null
    @SerializedName("ErrorDetails")
    @Expose
    var errorDetails: String? = null
    @SerializedName("ProcessingTimeInMilliseconds")
    @Expose
    var processingTimeInMilliseconds: String? = null

    class ParsedResult {
        @SerializedName("TextOverlay")
        @Expose
        var textOverlay: TextOverlay? = null
        @SerializedName("FileParseExitCode")
        @Expose
        var fileParseExitCode: Int? = null
        @SerializedName("ParsedText")
        @Expose
        var parsedText: String? = null
        @SerializedName("ErrorMessage")
        @Expose
        var errorMessage: String? = null
        @SerializedName("ErrorDetails")
        @Expose
        var errorDetails: String? = null

        override fun toString(): String {
            return "ParsedResult(textOverlay=$textOverlay, fileParseExitCode=$fileParseExitCode, parsedText=$parsedText, errorMessage=$errorMessage, errorDetails=$errorDetails)"
        }
    }

    class TextOverlay {
        @SerializedName("Lines")
        @Expose
        var lines: List<Line>? = null
        @SerializedName("HasOverlay")
        @Expose
        var hasOverlay: Boolean? = null
        @SerializedName("Message")
        @Expose
        var message: String? = null

        override fun toString(): String {
            return "TextOverlay(lines=$lines, hasOverlay=$hasOverlay, message=$message)"
        }
    }

    class Line {
        @SerializedName("Words")
        @Expose
        var words: List<Word>? = null
        @SerializedName("MaxHeight")
        @Expose
        var maxHeight: Int? = null
        @SerializedName("MinTop")
        @Expose
        var minTop: Int? = null

        override fun toString(): String {
            return "Line(words=$words, maxHeight=$maxHeight, minTop=$minTop)"
        }
    }

    class Word {
        @SerializedName("WordText")
        @Expose
        var wordText: String? = null
        @SerializedName("Left")
        @Expose
        var left: Int? = null
        @SerializedName("Top")
        @Expose
        var top: Int? = null
        @SerializedName("Height")
        @Expose
        var height: Int? = null
        @SerializedName("Width")
        @Expose
        var width: Int? = null

        override fun toString(): String {
            return "Word(wordText=$wordText, left=$left, top=$top, height=$height, width=$width)"
        }
    }

    override fun toString(): String {
        return "OcrApiResponse(parsedResults=$parsedResults, ocrExitCode=$ocrExitCode, isErroredOnProcessing=$isErroredOnProcessing, errorMessage=$errorMessage, errorDetails=$errorDetails, processingTimeInMilliseconds=$processingTimeInMilliseconds)"
    }
}
