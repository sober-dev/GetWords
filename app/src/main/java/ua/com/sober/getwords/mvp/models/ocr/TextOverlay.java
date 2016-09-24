
package ua.com.sober.getwords.mvp.models.ocr;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class TextOverlay {

    @SerializedName("Lines")
    @Expose
    private List<Line> Lines = new ArrayList<Line>();
    @SerializedName("HasOverlay")
    @Expose
    private Boolean HasOverlay;
    @SerializedName("Message")
    @Expose
    private String Message;

    /**
     * 
     * @return
     *     The Lines
     */
    public List<Line> getLines() {
        return Lines;
    }

    /**
     * 
     * @param Lines
     *     The Lines
     */
    public void setLines(List<Line> Lines) {
        this.Lines = Lines;
    }

    /**
     * 
     * @return
     *     The HasOverlay
     */
    public Boolean getHasOverlay() {
        return HasOverlay;
    }

    /**
     * 
     * @param HasOverlay
     *     The HasOverlay
     */
    public void setHasOverlay(Boolean HasOverlay) {
        this.HasOverlay = HasOverlay;
    }

    /**
     * 
     * @return
     *     The Message
     */
    public String getMessage() {
        return Message;
    }

    /**
     * 
     * @param Message
     *     The Message
     */
    public void setMessage(String Message) {
        this.Message = Message;
    }

}
