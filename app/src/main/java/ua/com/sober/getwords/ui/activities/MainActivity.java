package ua.com.sober.getwords.ui.activities;

import android.os.Bundle;

import com.arellomobile.mvp.MvpActivity;

import ua.com.sober.getwords.R;
import ua.com.sober.getwords.mvp.views.MainView;

public class MainActivity extends MvpActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void uploadImage() {

    }
}
