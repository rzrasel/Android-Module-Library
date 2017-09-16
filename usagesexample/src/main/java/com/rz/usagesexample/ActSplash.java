package com.rz.usagesexample;

import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActSplash extends AppCompatActivity {
    //Permission Request
    private final int PERMISSION_REQUEST_CODE = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int permissionResult = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permissionResult == PackageManager.PERMISSION_GRANTED) {
                //Log.v(TAG,"Permission is granted");
                System.out.println("Permission is granted");
                //File write logic here
                new DownloadApkAndInstall(this).execute("http://androidpala.com/tutorial/app-debug.apk");
            } else {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
            }
        } else {
            new DownloadApkAndInstall(this).execute("http://androidpala.com/tutorial/app-debug.apk");
        }
        System.out.println("PHONE_ID: " + Utilities.getSmartPhoneID());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Log.e("value", "Permission Granted, Now you can use local drive .");
                } else {
                    //Log.e("value", "Permission Denied, You cannot use local drive .");
                }
                break;
        }
    }
}
/*
http://androidpala.com/install-android-app-programmatically/
https://stackoverflow.com/questions/2983073/how-to-know-the-size-of-a-file-before-downloading-it
http://androidpala.com/install-android-app-programmatically/

Permission
https://stackoverflow.com/questions/33162152/storage-permission-error-in-marshmallow

*/
