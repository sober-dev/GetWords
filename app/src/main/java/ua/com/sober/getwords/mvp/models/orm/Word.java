package ua.com.sober.getwords.mvp.models.orm;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Collection;

/**
 * Created by Dmitry on 22.10.2016.
 */

@DatabaseTable(tableName = "words")
public class Word {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String word;

    @DatabaseField()
    private int status;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Group group;

    @ForeignCollectionField(eager = true)
    private ForeignCollection<Translation> translations;


    public Word() {
    }

    public Word(String word) {
        this.word = word;
    }

    public Word(String word, Group group) {
        this.word = word;
        this.group = group;
    }

    public Word(String word, int status, Group group) {
        this.word = word;
        this.status = status;
        this.group = group;
    }


    public int getId() {
        return id;
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


    public ForeignCollection<Translation> getTranslations() {
        return translations;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
