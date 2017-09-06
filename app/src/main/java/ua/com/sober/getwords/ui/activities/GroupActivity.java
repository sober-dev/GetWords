package ua.com.sober.getwords.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpView;

import ua.com.sober.getwords.R;
import ua.com.sober.getwords.mvp.presenters.GroupPresenter;
import ua.com.sober.getwords.mvp.views.GroupView;

public class GroupActivity extends MvpActivity<GroupView, GroupPresenter> implements MvpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        // Test
        int id = getIntent().getIntExtra("id", -1);
        Toast.makeText(this, "Group id: " + id, Toast.LENGTH_LONG).show();
    }

    @NonNull
    @Override
    public GroupPresenter createPresenter() {
        return new GroupPresenter();
    }
}
