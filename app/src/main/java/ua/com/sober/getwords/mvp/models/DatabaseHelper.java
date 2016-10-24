package ua.com.sober.getwords.mvp.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import ua.com.sober.getwords.mvp.models.orm.Group;
import ua.com.sober.getwords.mvp.models.orm.GroupDao;
import ua.com.sober.getwords.mvp.models.orm.Translation;
import ua.com.sober.getwords.mvp.models.orm.TranslationDao;
import ua.com.sober.getwords.mvp.models.orm.Word;
import ua.com.sober.getwords.mvp.models.orm.WordDao;

/**
 * Created by Dmitry on 22.10.2016.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "getwords.db";
    private static final int DATABASE_VERSION = 1;
//    private static DatabaseHelper helper;

    private GroupDao groupDao = null;
    private WordDao wordDao = null;
    private TranslationDao translationDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

//    public static synchronized DatabaseHelper getInstance(Context context) {
//        if (helper == null) {
//            helper = new DatabaseHelper(context);
//        }
//        return helper;
//    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Group.class);
            TableUtils.createTable(connectionSource, Word.class);
            TableUtils.createTable(connectionSource, Translation.class);
        } catch (SQLException e) {
            Log.e(TAG, "error creating database " + DATABASE_NAME);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Group.class, true);
            TableUtils.dropTable(connectionSource, Word.class, true);
            TableUtils.dropTable(connectionSource, Translation.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            Log.e(TAG, "error upgrading database " + DATABASE_NAME +
                    "from version " + oldVersion +
                    "to version " + newVersion
            );
            throw new RuntimeException(e);
        }
    }

    public GroupDao getGroupDao() throws SQLException {
        if (groupDao == null) {
            groupDao = new GroupDao(getConnectionSource(), Group.class);
        }
        return groupDao;
    }

    public WordDao getWordDao() throws SQLException {
        if (wordDao == null) {
            wordDao = new WordDao(getConnectionSource(), Word.class);
        }
        return wordDao;
    }

    public TranslationDao getTranslationDao() throws SQLException {
        if (translationDao == null) {
            translationDao = new TranslationDao(getConnectionSource(), Translation.class);
        }
        return translationDao;
    }

    @Override
    public void close() {
        super.close();
        groupDao = null;
        wordDao = null;
        translationDao = null;
    }
}
