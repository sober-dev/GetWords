package ua.com.sober.getwords.mvp.models.orm;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

/**
 * Created by Dmitry on 22.10.2016.
 */

public class WordDao extends BaseDaoImpl<Word, Integer> {

    public WordDao(ConnectionSource connectionSource, Class<Word> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

}
