package ua.com.sober.getwords.ui.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import ua.com.sober.getwords.R;
import ua.com.sober.getwords.mvp.models.HelperFactory;
import ua.com.sober.getwords.mvp.models.orm.Group;
import ua.com.sober.getwords.mvp.models.orm.Translation;
import ua.com.sober.getwords.mvp.models.orm.Word;
import ua.com.sober.getwords.mvp.presenters.MainPresenter;
import ua.com.sober.getwords.mvp.views.MainView;

/**
 * Created by Dmitry on 14.10.2016.
 */

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    private static final String TAG = "Test";
    private Uri mCropImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_load_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSelectImageClick(view);
            }
        });

        findViewById(R.id.button_db_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    testSaveResult();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

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
                    File imageFile = new File(resultUri.getPath());
                    Log.d(TAG, "Cropped image size: " + getImageFileSize(imageFile));
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

    public void onSelectImageClick(View view) {
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

    // For Logs
    private String getImageFileSize(File file) {
        try {
            // Decode image size
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(file), null, options);
            return "Width = " + options.outWidth + ", Height = " + options.outHeight;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void testSaveResult() throws Exception {
        Group group = new Group("Group1");
        HelperFactory.getHelper().getGroups().create(group);


        Word word1 = new Word("world", group);
        HelperFactory.getHelper().getWords().create(word1);

        Translation translation1 = new Translation("мир", word1);
        HelperFactory.getHelper().getTranslations().create(translation1);

        Translation translation2 = new Translation("вселенная", word1);
        HelperFactory.getHelper().getTranslations().create(translation2);


        Word word2 = new Word("house", group);
        HelperFactory.getHelper().getWords().create(word2);

        Translation translation3 = new Translation("дом", word2);
        HelperFactory.getHelper().getTranslations().create(translation3);

        Translation translation4 = new Translation("сооружение", word2);
        HelperFactory.getHelper().getTranslations().create(translation4);

    }

}
