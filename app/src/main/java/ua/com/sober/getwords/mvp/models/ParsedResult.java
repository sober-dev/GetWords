
package ua.com.sober.getwords.mvp.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ParsedResult {

    @SerializedName("TextOverlay")
    @Expose
    private TextOverlay TextOverlay;
    @SerializedName("FileParseExitCode")
    @Expose
    private Integer FileParseExitCode;
    @SerializedName("ParsedText")
    @Expose
    private String ParsedText;
    @SerializedName("ErrorMessage")
    @Expose
    private String ErrorMessage;
    @SerializedName("ErrorDetails")
    @Expose
    private String ErrorDetails;

    /**
     * 
     * @return
     *     The TextOverlay
     */
    public TextOverlay getTextOverlay() {
        return TextOverlay;
    }

    /**
     * 
     * @param TextOverlay
     *     The TextOverlay
     */
    public void setTextOverlay(TextOverlay TextOverlay) {
        this.TextOverlay = TextOverlay;
    }

    /**
     * 
     * @return
     *     The FileParseExitCode
     */
    public Integer getFileParseExitCode() {
        return FileParseExitCode;
    }

    /**
     * 
     * @param FileParseExitCode
     *     The FileParseExitCode
     */
    public void setFileParseExitCode(Integer FileParseExitCode) {
        this.FileParseExitCode = FileParseExitCode;
    }

    /**
     * 
     * @return
     *     The ParsedText
     */
    public String getParsedText() {
        return ParsedText;
    }

    /**
     * 
     * @param ParsedText
     *     The ParsedText
     */
    public void setParsedText(String ParsedText) {
        this.ParsedText = ParsedText;
    }

    /**
     * 
     * @return
     *     The ErrorMessage
     */
    public String getErrorMessage() {
        return ErrorMessage;
    }

    /**
     * 
     * @param ErrorMessage
     *     The ErrorMessage
     */
    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    /**
     * 
     * @return
     *     The ErrorDetails
     */
    public String getErrorDetails() {
        return ErrorDetails;
    }

    /**
     * 
     * @param ErrorDetails
     *     The ErrorDetails
     */
    public void setErrorDetails(String ErrorDetails) {
        this.ErrorDetails = ErrorDetails;
    }

}
