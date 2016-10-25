package ua.com.sober.getwords.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpView;

import ua.com.sober.getwords.R;
import ua.com.sober.getwords.mvp.presenters.GroupPresenter;
import ua.com.sober.getwords.mvp.views.GroupView;

/**
 * Created by dmitry on 10/25/16.
 */

public class GroupActivity extends MvpActivity<GroupView, GroupPresenter> implements MvpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
    }

    @NonNull
    @Override
    public GroupPresenter createPresenter() {
        return new GroupPresenter();
    }
}
