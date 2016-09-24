
package ua.com.sober.getwords.mvp.models.ocr;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Word {

    @SerializedName("WordText")
    @Expose
    private String WordText;
    @SerializedName("Left")
    @Expose
    private Integer Left;
    @SerializedName("Top")
    @Expose
    private Integer Top;
    @SerializedName("Height")
    @Expose
    private Integer Height;
    @SerializedName("Width")
    @Expose
    private Integer Width;

    /**
     * 
     * @return
     *     The WordText
     */
    public String getWordText() {
        return WordText;
    }

    /**
     * 
     * @param WordText
     *     The WordText
     */
    public void setWordText(String WordText) {
        this.WordText = WordText;
    }

    /**
     * 
     * @return
     *     The Left
     */
    public Integer getLeft() {
        return Left;
    }

    /**
     * 
     * @param Left
     *     The Left
     */
    public void setLeft(Integer Left) {
        this.Left = Left;
    }

    /**
     * 
     * @return
     *     The Top
     */
    public Integer getTop() {
        return Top;
    }

    /**
     * 
     * @param Top
     *     The Top
     */
    public void setTop(Integer Top) {
        this.Top = Top;
    }

    /**
     * 
     * @return
     *     The Height
     */
    public Integer getHeight() {
        return Height;
    }

    /**
     * 
     * @param Height
     *     The Height
     */
    public void setHeight(Integer Height) {
        this.Height = Height;
    }

    /**
     * 
     * @return
     *     The Width
     */
    public Integer getWidth() {
        return Width;
    }

    /**
     * 
     * @param Width
     *     The Width
     */
    public void setWidth(Integer Width) {
        this.Width = Width;
    }

}
