
package ua.com.sober.getwords.mvp.models.ocr;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Line {

    @SerializedName("Words")
    @Expose
    private List<Word> words = new ArrayList<Word>();
    @SerializedName("MaxHeight")
    @Expose
    private Integer maxHeight;
    @SerializedName("MinTop")
    @Expose
    private Integer minTop;

    /**
     * 
     * @return
     *     The words
     */
    public List<Word> getWords() {
        return words;
    }

    /**
     * 
     * @param words
     *     The Words
     */
    public void setWords(List<Word> words) {
        this.words = words;
    }

    /**
     * 
     * @return
     *     The maxHeight
     */
    public Integer getMaxHeight() {
        return maxHeight;
    }

    /**
     * 
     * @param maxHeight
     *     The MaxHeight
     */
    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }

    /**
     * 
     * @return
     *     The minTop
     */
    public Integer getMinTop() {
        return minTop;
    }

    /**
     * 
     * @param minTop
     *     The MinTop
     */
    public void setMinTop(Integer minTop) {
        this.minTop = minTop;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
