package ua.com.sober.getwords.mvp.presenters;

import android.util.Log;

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

    private static final String TAG = MainPresenter.class.getSimpleName();
    private List<Group> groups;

    public void loadGroups() {
        if (isViewAttached() && getView() != null) {
            getView().showLoading();
            // Need async loader
            try {
                groups = HelperFactory.getHelper().getGroupDao().queryForAll();
                if (isViewAttached()) {
                    if (groups.isEmpty()) {
//                        getView().showEmpty();

                        // Test
                        for (int i = 1; i <= 20; i++) {
                            Group group = new Group("Group " + i);
                            HelperFactory.getHelper().getGroupDao().create(group);
                        }

                        groups = HelperFactory.getHelper().getGroupDao().queryForAll();
                        if (!groups.isEmpty()) {
                            getView().showGroups(groups);
                        } else {
                            getView().showEmpty();
                        }

                    } else {
                        getView().showGroups(groups);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void onGroupItemClicked(int position) {
        if (isViewAttached() && getView() != null) {
            getView().navigateToGroupScreen(groups.get(position).getId());
        }
        Log.d(TAG, "Clicked on position: " + position);
    }

    public void onAddFabClicked() {
    }
}
