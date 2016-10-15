
package ua.com.sober.getwords.mvp.models.ocr;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Word {

    @SerializedName("WordText")
    @Expose
    private String wordText;
    @SerializedName("Left")
    @Expose
    private Integer left;
    @SerializedName("Top")
    @Expose
    private Integer top;
    @SerializedName("Height")
    @Expose
    private Integer height;
    @SerializedName("Width")
    @Expose
    private Integer width;

    /**
     * 
     * @return
     *     The wordText
     */
    public String getWordText() {
        return wordText;
    }

    /**
     * 
     * @param wordText
     *     The WordText
     */
    public void setWordText(String wordText) {
        this.wordText = wordText;
    }

    /**
     * 
     * @return
     *     The left
     */
    public Integer getLeft() {
        return left;
    }

    /**
     * 
     * @param left
     *     The Left
     */
    public void setLeft(Integer left) {
        this.left = left;
    }

    /**
     * 
     * @return
     *     The top
     */
    public Integer getTop() {
        return top;
    }

    /**
     * 
     * @param top
     *     The Top
     */
    public void setTop(Integer top) {
        this.top = top;
    }

    /**
     * 
     * @return
     *     The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The Height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 
     * @return
     *     The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     *     The Width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
