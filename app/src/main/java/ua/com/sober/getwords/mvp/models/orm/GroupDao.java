package ua.com.sober.getwords.mvp.models.orm;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class GroupDao extends BaseDaoImpl<Group, Integer> {

    public GroupDao(ConnectionSource connectionSource, Class<Group> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

}
