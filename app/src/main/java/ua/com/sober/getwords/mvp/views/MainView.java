package ua.com.sober.getwords.mvp.views;

import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

import ua.com.sober.getwords.mvp.models.orm.Group;

/**
 * Created by dmitry on 5/20/16.
 */

public interface MainView extends MvpView {
    void showGroups(List<Group> groups);

    void showLoading();

    void showEmpty();

    void navigateToGroupScreen(int id);

    void navigateToPickImage();
}
