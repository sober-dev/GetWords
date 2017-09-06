package ua.com.sober.getwords.mvp.views;

import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

import ua.com.sober.getwords.mvp.models.orm.Group;

public interface MainView extends MvpView {
    void showLoading();

    void showGroups(List<Group> groups);

    void showEmpty();

    void navigateToPickImageActivity();

    void navigateToGroupActivity(int id);
}
