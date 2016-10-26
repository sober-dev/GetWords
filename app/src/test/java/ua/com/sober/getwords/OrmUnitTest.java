package ua.com.sober.getwords;

import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.ForeignCollection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import ua.com.sober.getwords.mvp.models.HelperFactory;
import ua.com.sober.getwords.mvp.models.orm.Group;
import ua.com.sober.getwords.mvp.models.orm.Translation;
import ua.com.sober.getwords.mvp.models.orm.Word;

/**
 * Created by dmitry on 10/24/16.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 16)
public class OrmUnitTest {

    @Test
    public void dataRetentionTest() throws SQLException {
        Group group = new Group("Group1");
        HelperFactory.getHelper().getGroupDao().create(group);

        Word word = new Word("world", group);
        HelperFactory.getHelper().getWordDao().create(word);

        List<Translation> translations = Arrays.asList(
                new Translation("мир", 0, word),
                new Translation("свет", 1, word),
                new Translation("вселенная", 2, word),
                new Translation("царство", 3, word)
        );
        HelperFactory.getHelper().getTranslationDao().create(translations);

        List<Group> groupList = HelperFactory.getHelper().getGroupDao().queryForAll();

        assertNotNull(groupList);
        assertFalse(groupList.isEmpty());

        for (Group g : groupList) {
            System.out.println(g.toString());

            ForeignCollection<Word> wordCollection = g.getWords();

            CloseableIterator<Word> wordIterator = wordCollection.closeableIterator();
            try {
                assertTrue(wordIterator.hasNext());
                while (wordIterator.hasNext()) {
                    Word w = wordIterator.next();
                    System.out.println(w.toString());

                    ForeignCollection<Translation> translationCollection = w.getTranslations();

                    assertNotNull(translationCollection);
                    assertFalse(translationCollection.isEmpty());

                    for (Translation t : translationCollection) {
                        System.out.println(t.toString());
                    }
                }
            } finally {
                try {
                    wordIterator.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
