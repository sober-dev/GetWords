package ua.com.sober.getwords.mvp.models.orm;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by Dmitry on 22.10.2016.
 */

@DatabaseTable(tableName = "groups")
public class Group {

    Group() {
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false, dataType = DataType.STRING)
    private String name;

    @DatabaseField(dataType = DataType.DATE)
    private Date lastEditDate;

    @DatabaseField(dataType = DataType.INTEGER)
    private int status;

}
