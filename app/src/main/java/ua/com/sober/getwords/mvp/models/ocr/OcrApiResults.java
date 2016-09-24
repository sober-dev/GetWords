
package ua.com.sober.getwords.mvp.models.ocr;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class OcrApiResults {

    @SerializedName("ParsedResults")
    @Expose
    private List<ParsedResult> ParsedResults = new ArrayList<ParsedResult>();
    @SerializedName("OCRExitCode")
    @Expose
    private Integer OCRExitCode;
    @SerializedName("IsErroredOnProcessing")
    @Expose
    private Boolean IsErroredOnProcessing;
    @SerializedName("ErrorMessage")
    @Expose
    private Object ErrorMessage;
    @SerializedName("ErrorDetails")
    @Expose
    private Object ErrorDetails;
    @SerializedName("ProcessingTimeInMilliseconds")
    @Expose
    private String ProcessingTimeInMilliseconds;

    /**
     * 
     * @return
     *     The ParsedResults
     */
    public List<ParsedResult> getParsedResults() {
        return ParsedResults;
    }

    /**
     * 
     * @param ParsedResults
     *     The ParsedResults
     */
    public void setParsedResults(List<ParsedResult> ParsedResults) {
        this.ParsedResults = ParsedResults;
    }

    /**
     * 
     * @return
     *     The OCRExitCode
     */
    public Integer getOCRExitCode() {
        return OCRExitCode;
    }

    /**
     * 
     * @param OCRExitCode
     *     The OCRExitCode
     */
    public void setOCRExitCode(Integer OCRExitCode) {
        this.OCRExitCode = OCRExitCode;
    }

    /**
     * 
     * @return
     *     The IsErroredOnProcessing
     */
    public Boolean getIsErroredOnProcessing() {
        return IsErroredOnProcessing;
    }

    /**
     * 
     * @param IsErroredOnProcessing
     *     The IsErroredOnProcessing
     */
    public void setIsErroredOnProcessing(Boolean IsErroredOnProcessing) {
        this.IsErroredOnProcessing = IsErroredOnProcessing;
    }

    /**
     * 
     * @return
     *     The ErrorMessage
     */
    public Object getErrorMessage() {
        return ErrorMessage;
    }

    /**
     * 
     * @param ErrorMessage
     *     The ErrorMessage
     */
    public void setErrorMessage(Object ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    /**
     * 
     * @return
     *     The ErrorDetails
     */
    public Object getErrorDetails() {
        return ErrorDetails;
    }

    /**
     * 
     * @param ErrorDetails
     *     The ErrorDetails
     */
    public void setErrorDetails(Object ErrorDetails) {
        this.ErrorDetails = ErrorDetails;
    }

    /**
     * 
     * @return
     *     The ProcessingTimeInMilliseconds
     */
    public String getProcessingTimeInMilliseconds() {
        return ProcessingTimeInMilliseconds;
    }

    /**
     * 
     * @param ProcessingTimeInMilliseconds
     *     The ProcessingTimeInMilliseconds
     */
    public void setProcessingTimeInMilliseconds(String ProcessingTimeInMilliseconds) {
        this.ProcessingTimeInMilliseconds = ProcessingTimeInMilliseconds;
    }

}
