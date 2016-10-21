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
import ua.com.sober.getwords.mvp.presenters.MainPresenter;
import ua.com.sober.getwords.mvp.views.MainView;

/**
 * Created by Dmitry on 14.10.2016.
 */

public class MainActivity extends MvpActivity<MainView, MainPresenter> implements MainView {

    private static final String TAG = "Test";
    private Uri mCropImageUri;
//    static final int REQUEST_TAKE_PHOTO = 1;
//    private String mCurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        findViewById(R.id.button_test_cam).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                testCamera();
//            }
//        });

        findViewById(R.id.button_load_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSelectImageClick(view);
            }
        });
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

//    public void testCamera() {
//        dispatchTakePictureIntent();
//    }
//
//    public void testGallery() {
//    }

    public void onSelectImageClick(View view) {
        if (CropImage.isExplicitCameraPermissionRequired(this) && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, CropImage.CAMERA_CAPTURE_PERMISSIONS_REQUEST_CODE);
        } else {
            CropImage.startPickImageActivity(this);
        }
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

//        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
//            if (data != null) {
//                mCurrentPhotoPath = String.valueOf(data.getData());
//            }
//            File imageFile = new File(mCurrentPhotoPath);
//            Uri imageUri = Uri.fromFile(imageFile);
//            Log.d(TAG, "Source file path: " + imageUri.getPath());
//            Log.d(TAG, "Source image size: " + getImageFileSize(imageFile));
//            startCropImageActivity(imageUri);
//        }

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

        // handle result of pick image chooser
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

//    private void dispatchTakePictureIntent() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            File photoFile = null;
//            try {
//                photoFile = createImageFile();
//            } catch (IOException e) {
//                Log.e(TAG, "Error occurred while creating the File");
//                e.printStackTrace();
//            }
//            if (photoFile != null) {
//                Uri photoURI = FileProvider
//                        .getUriForFile(this, "ua.com.sober.getwords.fileprovider", photoFile);
//                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
//
//                // Fix FATAL EXCEPTION: java.lang.SecurityException:
//                // Permission Denial: opening provider android.support.v4.content.FileProvider...
//                Intent fixIntent = fixTakePictureIntent(takePictureIntent, photoURI);
//
//                startActivityForResult(fixIntent, REQUEST_TAKE_PHOTO);
//            }
//        }
//    }
//
//    private Intent fixTakePictureIntent(Intent takePictureIntent, Uri photoURI) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            takePictureIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            ClipData clip = ClipData.newUri(getContentResolver(), "A photo", photoURI);
//            takePictureIntent.setClipData(clip);
//            takePictureIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
//        } else {
//            List<ResolveInfo> resInfoList = getPackageManager()
//                    .queryIntentActivities(takePictureIntent, PackageManager.MATCH_DEFAULT_ONLY);
//
//            for (ResolveInfo resolveInfo : resInfoList) {
//                String packageName = resolveInfo.activityInfo.packageName;
//                grantUriPermission(packageName, photoURI, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
//            }
//        }
//        return takePictureIntent;
//    }
//
//    private File createImageFile() throws IOException {
//        // Create an image file name
//        String imageFileName = "source";
//        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        File image = File.createTempFile(
//                imageFileName,  /* prefix */
//                ".jpg",         /* suffix */
//                storageDir      /* directory */
//        );
//
//        // Save a file path
//        mCurrentPhotoPath = image.getAbsolutePath();
//        return image;
//    }

    private void startCropImageActivity(Uri imageUri) {
        CropImage.activity(imageUri)
                .setGuidelines(CropImageView.Guidelines.ON)
                //Ocr API limit: "Each image dimension must be between 40 and 2600 pixels."
                .setRequestedSize(2600, 2600, CropImageView.RequestSizeOptions.RESIZE_INSIDE)
                .start(this);
    }

//    For Logs
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

//    private Bitmap decodeFile(File file) {
//        try {
//            // Decode image size
//            BitmapFactory.Options options = new BitmapFactory.Options();
//            options.inJustDecodeBounds = true;
//            BitmapFactory.decodeStream(new FileInputStream(file), null, options);
//
//            // The new size we want to scale to
//            final int MAX_IMG_SIZE = 2600;
//
//            // Find the correct scale value. It should be the power of 2.
//            int scale = 1;
//            int tmpWidth = options.outWidth;
//            int tmpHeight = options.outHeight;
//            while (tmpWidth > MAX_IMG_SIZE || tmpHeight > MAX_IMG_SIZE) {
//                tmpWidth /= 2;
//                tmpHeight /= 2;
//                scale *= 2;
//            }
//
//            // Decode with inSampleSize
//            BitmapFactory.Options options1 = new BitmapFactory.Options();
//            options1.inSampleSize = scale;
//            return BitmapFactory.decodeStream(new FileInputStream(file), null, options1);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
