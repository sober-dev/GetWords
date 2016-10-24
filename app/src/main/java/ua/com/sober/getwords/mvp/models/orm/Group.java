package ua.com.sober.getwords.mvp.models.orm;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * Created by Dmitry on 22.10.2016.
 */

@DatabaseTable(tableName = "groups")
public class Group {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String name;

    @DatabaseField()
    private Date lastEditDate;

    @DatabaseField()
    private int status;

    @ForeignCollectionField()
    private ForeignCollection<Word> words;


    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, Date lastEditDate) {
        this.name = name;
        this.lastEditDate = lastEditDate;
    }

    public Group(String name, Date lastEditDate, int status) {
        this.name = name;
        this.lastEditDate = lastEditDate;
        this.status = status;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public ForeignCollection<Word> getWords() {
        return words;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
