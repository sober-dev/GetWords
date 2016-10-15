package ua.com.sober.getwords.ui.activities;

import android.os.Bundle;

import com.hannesdorfmann.mosby.mvp.MvpActivity;

import ua.com.sober.getwords.R;
import ua.com.sober.getwords.mvp.presenters.MainPresenter;
import ua.com.sober.getwords.mvp.views.MainView;

/**
 * Created by Dmitry on 14.10.2016.
 */

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

}
