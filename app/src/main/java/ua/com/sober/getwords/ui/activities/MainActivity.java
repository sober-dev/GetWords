package ua.com.sober.getwords.ui.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import org.lucasr.twowayview.ItemClickSupport;
import org.lucasr.twowayview.ItemClickSupport.OnItemClickListener;

import java.sql.SQLException;
import java.util.List;

import ua.com.sober.getwords.R;
import ua.com.sober.getwords.mvp.models.HelperFactory;
import ua.com.sober.getwords.mvp.models.orm.Group;
import ua.com.sober.getwords.mvp.presenters.MainPresenter;
import ua.com.sober.getwords.mvp.views.MainView;
import ua.com.sober.getwords.ui.adapters.GroupsAdapter;

/**
 * Created by Dmitry on 14.10.2016.
 */

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Uri mCropImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton addNewWordsFab = (FloatingActionButton) findViewById(R.id.add_new_words_fab);
        addNewWordsFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSelectImageClick();
            }
        });

        presenter.loadGroups();
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == CropImage.CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                CropImage.startPickImageActivity(this);
            } else {
                Toast.makeText(this, "Cancelling, required permissions are not granted", Toast.LENGTH_LONG).show();
            }
        }

        if (requestCode == CropImage.PICK_IMAGE_PERMISSIONS_REQUEST_CODE) {
            if (mCropImageUri != null && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // required permissions granted, start crop image activity
                startCropImageActivity(mCropImageUri);
            } else {
                Toast.makeText(this, "Cancelling, required permissions are not granted", Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // result of crop image
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                if (resultUri != null) {
                    Log.d(TAG, "Cropped file path: " + resultUri.getPath());
                }
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }

        // result of pick image chooser
        if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode == RESULT_OK) {
            Uri imageUri = CropImage.getPickImageResultUri(this, data);

            Log.d(TAG, "Source file path: " + imageUri.getPath());

            // For API >= 23 we need to check specifically that we have permissions to read external storage.
            if (CropImage.isReadExternalStoragePermissionsRequired(this, imageUri) && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // request permissions and handle the result in onRequestPermissionsResult()
                mCropImageUri = imageUri;
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, CropImage.PICK_IMAGE_PERMISSIONS_REQUEST_CODE);
            } else {
                // no permissions required or already grunted, can start crop image activity
                startCropImageActivity(imageUri);
            }
        }

    }

    public void onSelectImageClick() {
        if (CropImage.isExplicitCameraPermissionRequired(this) && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, CropImage.CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE);
        } else {
            CropImage.startPickImageActivity(this);
        }
    }

    private void startCropImageActivity(Uri imageUri) {
        CropImage.activity(imageUri)
                .setGuidelines(CropImageView.Guidelines.ON)
                // Ocr API limit: "Each image dimension must be between 40 and 2600 pixels."
                .setRequestedSize(2600, 2600, CropImageView.RequestSizeOptions.RESIZE_INSIDE)
                .start(this);
    }

    @Override
    public void showGroups(final List<Group> groups) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.groups_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(new GroupsAdapter(groups));

//        final ItemClickSupport itemClickSupport = ItemClickSupport.addTo(recyclerView);
//
//        itemClickSupport.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(RecyclerView parent, View view, int position, long id) {
//                Log.d(TAG, "onItemClick on position: " + position +
//                        "; Group id: " + groups.get(position).getId() +
//                        "; Group name: " + groups.get(position).getName()
//                );
//            }
//        });
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "Loading groups...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmpty() {
        Toast.makeText(this, "No groups.", Toast.LENGTH_SHORT).show();
    }
}
