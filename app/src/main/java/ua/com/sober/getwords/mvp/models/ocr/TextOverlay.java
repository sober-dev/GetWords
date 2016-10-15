
package ua.com.sober.getwords.mvp.models.ocr;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class TextOverlay {

    @SerializedName("Lines")
    @Expose
    private List<Line> lines = new ArrayList<Line>();
    @SerializedName("HasOverlay")
    @Expose
    private Boolean hasOverlay;
    @SerializedName("Message")
    @Expose
    private String message;

    /**
     * 
     * @return
     *     The lines
     */
    public List<Line> getLines() {
        return lines;
    }

    /**
     * 
     * @param lines
     *     The Lines
     */
    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    /**
     * 
     * @return
     *     The hasOverlay
     */
    public Boolean getHasOverlay() {
        return hasOverlay;
    }

    /**
     * 
     * @param hasOverlay
     *     The HasOverlay
     */
    public void setHasOverlay(Boolean hasOverlay) {
        this.hasOverlay = hasOverlay;
    }

    /**
     * 
     * @return
     *     The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 
     * @param message
     *     The Message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
