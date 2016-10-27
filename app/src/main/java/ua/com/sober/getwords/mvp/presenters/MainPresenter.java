package ua.com.sober.getwords.mvp.presenters;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.sql.SQLException;
import java.util.List;

import ua.com.sober.getwords.mvp.models.HelperFactory;
import ua.com.sober.getwords.mvp.models.orm.Group;
import ua.com.sober.getwords.mvp.views.MainView;

/**
 * Created by dmitry on 9/20/16.
 */
public class MainPresenter extends MvpBasePresenter<MainView> {

    public void loadGroups() {
        getView().showLoading();

        // Need async loader
        try {
            List<Group> groups = HelperFactory.getHelper().getGroupDao().queryForAll();
            if (isViewAttached()) {
                if (groups.isEmpty()) {
                    getView().showEmpty();

                    // Test
                    for (int i = 1; i <= 20; i++) {
                        Group group = new Group("Group " + i);
                        HelperFactory.getHelper().getGroupDao().create(group);
                    }

                } else {
                    getView().showGroups(groups);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void onGroupClicked() {
    }

    public void onAddNewWordsClicked() {
    }
}
