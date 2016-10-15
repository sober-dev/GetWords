
package ua.com.sober.getwords.mvp.models.ocr;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class ParsedResult {

    @SerializedName("TextOverlay")
    @Expose
    private TextOverlay textOverlay;
    @SerializedName("FileParseExitCode")
    @Expose
    private Integer fileParseExitCode;
    @SerializedName("ParsedText")
    @Expose
    private String parsedText;
    @SerializedName("ErrorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("ErrorDetails")
    @Expose
    private String errorDetails;

    /**
     * 
     * @return
     *     The textOverlay
     */
    public TextOverlay getTextOverlay() {
        return textOverlay;
    }

    /**
     * 
     * @param textOverlay
     *     The TextOverlay
     */
    public void setTextOverlay(TextOverlay textOverlay) {
        this.textOverlay = textOverlay;
    }

    /**
     * 
     * @return
     *     The fileParseExitCode
     */
    public Integer getFileParseExitCode() {
        return fileParseExitCode;
    }

    /**
     * 
     * @param fileParseExitCode
     *     The FileParseExitCode
     */
    public void setFileParseExitCode(Integer fileParseExitCode) {
        this.fileParseExitCode = fileParseExitCode;
    }

    /**
     * 
     * @return
     *     The parsedText
     */
    public String getParsedText() {
        return parsedText;
    }

    /**
     * 
     * @param parsedText
     *     The ParsedText
     */
    public void setParsedText(String parsedText) {
        this.parsedText = parsedText;
    }

    /**
     * 
     * @return
     *     The errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 
     * @param errorMessage
     *     The ErrorMessage
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * 
     * @return
     *     The errorDetails
     */
    public String getErrorDetails() {
        return errorDetails;
    }

    /**
     * 
     * @param errorDetails
     *     The ErrorDetails
     */
    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
