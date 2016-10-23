package ua.com.sober.getwords.mvp.models.orm;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Dmitry on 22.10.2016.
 */

@DatabaseTable(tableName = "translations")
public class Translation {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String translation;

    @DatabaseField()
    private int rating;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Word word;


    public Translation() {
    }

    public Translation(String translation) {
        this.translation = translation;
    }

    public Translation(String translation, Word word) {
        this.translation = translation;
        this.word = word;
    }

    public Translation(String translation, int rating, Word word) {
        this.translation = translation;
        this.rating = rating;
        this.word = word;
    }


    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

}
