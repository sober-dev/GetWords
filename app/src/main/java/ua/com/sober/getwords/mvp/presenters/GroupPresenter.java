package ua.com.sober.getwords.mvp.presenters;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.List;

import ua.com.sober.getwords.mvp.models.orm.Word;
import ua.com.sober.getwords.mvp.views.GroupView;

/**
 * Created by dmitry on 10/25/16.
 */

public class GroupPresenter extends MvpBasePresenter<GroupView> {

    private static final String TAG = GroupPresenter.class.getSimpleName();
    private List<Word> groups;

    public void loadWords() {

    }

    public void onGreenButtonClicked() {

    }

    public void onYellowButtonClicked() {

    }

}
