package ua.com.sober.getwords.mvp.models.orm;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Dmitry on 22.10.2016.
 */

@DatabaseTable(tableName = "words")
public class Word {

    Word() {
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false, foreign = true)
    private Group group;

    @DatabaseField(dataType = DataType.STRING)
    private String text;

    @DatabaseField(dataType = DataType.INTEGER)
    private int status;

}
