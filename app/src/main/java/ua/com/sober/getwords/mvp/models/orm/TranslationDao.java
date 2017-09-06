package ua.com.sober.getwords.mvp.models.orm;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class TranslationDao extends BaseDaoImpl<Translation, Integer> {

    public TranslationDao(ConnectionSource connectionSource, Class<Translation> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

}
