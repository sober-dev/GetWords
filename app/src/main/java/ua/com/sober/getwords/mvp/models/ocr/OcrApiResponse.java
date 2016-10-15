
package ua.com.sober.getwords.mvp.models.ocr;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class OcrApiResponse {

    @SerializedName("ParsedResults")
    @Expose
    private List<ParsedResult> parsedResults = new ArrayList<ParsedResult>();
    @SerializedName("OCRExitCode")
    @Expose
    private Integer oCRExitCode;
    @SerializedName("IsErroredOnProcessing")
    @Expose
    private Boolean isErroredOnProcessing;
    @SerializedName("ErrorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("ErrorDetails")
    @Expose
    private String errorDetails;
    @SerializedName("ProcessingTimeInMilliseconds")
    @Expose
    private String processingTimeInMilliseconds;

    /**
     * 
     * @return
     *     The parsedResults
     */
    public List<ParsedResult> getParsedResults() {
        return parsedResults;
    }

    /**
     * 
     * @param parsedResults
     *     The ParsedResults
     */
    public void setParsedResults(List<ParsedResult> parsedResults) {
        this.parsedResults = parsedResults;
    }

    /**
     * 
     * @return
     *     The oCRExitCode
     */
    public Integer getOCRExitCode() {
        return oCRExitCode;
    }

    /**
     * 
     * @param oCRExitCode
     *     The OCRExitCode
     */
    public void setOCRExitCode(Integer oCRExitCode) {
        this.oCRExitCode = oCRExitCode;
    }

    /**
     * 
     * @return
     *     The isErroredOnProcessing
     */
    public Boolean getIsErroredOnProcessing() {
        return isErroredOnProcessing;
    }

    /**
     * 
     * @param isErroredOnProcessing
     *     The IsErroredOnProcessing
     */
    public void setIsErroredOnProcessing(Boolean isErroredOnProcessing) {
        this.isErroredOnProcessing = isErroredOnProcessing;
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

    /**
     * 
     * @return
     *     The processingTimeInMilliseconds
     */
    public String getProcessingTimeInMilliseconds() {
        return processingTimeInMilliseconds;
    }

    /**
     * 
     * @param processingTimeInMilliseconds
     *     The ProcessingTimeInMilliseconds
     */
    public void setProcessingTimeInMilliseconds(String processingTimeInMilliseconds) {
        this.processingTimeInMilliseconds = processingTimeInMilliseconds;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
