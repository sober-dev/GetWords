
package ua.com.sober.getwords.mvp.models.ocr;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Line {

    @SerializedName("Words")
    @Expose
    private List<Word> Words = new ArrayList<Word>();
    @SerializedName("MaxHeight")
    @Expose
    private Integer MaxHeight;
    @SerializedName("MinTop")
    @Expose
    private Integer MinTop;

    /**
     * 
     * @return
     *     The Words
     */
    public List<Word> getWords() {
        return Words;
    }

    /**
     * 
     * @param Words
     *     The Words
     */
    public void setWords(List<Word> Words) {
        this.Words = Words;
    }

    /**
     * 
     * @return
     *     The MaxHeight
     */
    public Integer getMaxHeight() {
        return MaxHeight;
    }

    /**
     * 
     * @param MaxHeight
     *     The MaxHeight
     */
    public void setMaxHeight(Integer MaxHeight) {
        this.MaxHeight = MaxHeight;
    }

    /**
     * 
     * @return
     *     The MinTop
     */
    public Integer getMinTop() {
        return MinTop;
    }

    /**
     * 
     * @param MinTop
     *     The MinTop
     */
    public void setMinTop(Integer MinTop) {
        this.MinTop = MinTop;
    }

}
