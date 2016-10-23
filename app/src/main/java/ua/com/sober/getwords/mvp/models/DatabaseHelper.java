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
    private static DatabaseHelper helper;

    private GroupDao groups = null;
    private WordDao words = null;
    private TranslationDao translations = null;

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

    public GroupDao getGroups() throws SQLException {
        if (groups == null) {
            groups = new GroupDao(getConnectionSource(), Group.class);
        }
        return groups;
    }

    public WordDao getWords() throws SQLException {
        if (words == null) {
            words = new WordDao(getConnectionSource(), Word.class);
        }
        return words;
    }

    public TranslationDao getTranslations() throws SQLException {
        if (translations == null) {
            translations = new TranslationDao(getConnectionSource(), Translation.class);
        }
        return translations;
    }

    @Override
    public void close() {
        super.close();
        groups = null;
        words = null;
        translations = null;
    }
}
