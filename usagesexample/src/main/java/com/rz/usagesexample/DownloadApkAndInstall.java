package com.rz.usagesexample;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Rz Rasel on 2017-08-30.
 */

public class DownloadApkAndInstall extends AsyncTask<String, Integer, Boolean> {
    private Context context;
    private String downloadApkFileName = "app-apk.apk";

    public DownloadApkAndInstall(Context argContext) {
        context = argContext;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        System.out.println("Downloading...");

    }

    protected void onProgressUpdate(Integer... argProgress) {
        super.onProgressUpdate(argProgress);
        System.out.println("PROGRESS: " + argProgress[0]);
    }

    @Override
    protected Boolean doInBackground(String... argParam) {
        Boolean flag = false;

        try {
            String strURLApk = argParam[0];
            //URL urlAPK = new URL("http://androidpala.com/tutorial/app-debug.apk");
            URL urlAPK = new URL(strURLApk);

            HttpURLConnection httpURLConnection = (HttpURLConnection) urlAPK.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.connect();

            String PATH = Environment.getExternalStorageDirectory() + "/Download/";
            File file = new File(PATH);
            file.mkdirs();

            File outputFile = new File(file, downloadApkFileName);

            if (outputFile.exists()) {
                outputFile.delete();
            }

            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            InputStream inputStream = httpURLConnection.getInputStream();

            //int total_size = 1431692;//size of apk
            int totalSize = httpURLConnection.getContentLength();//size of apk
            System.out.println("TOTAL_SIZE: " + totalSize);

            byte[] buffer = new byte[1024];
            int len1 = 0;
            int per = 0;
            int downloaded = 0;
            while ((len1 = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len1);
                downloaded += len1;
                per = (int) (downloaded * 100 / totalSize);
                publishProgress(per);
            }
            fileOutputStream.close();
            inputStream.close();

            onInistallAPK(PATH);

            flag = true;
        } catch (Exception e) {
            //Log.e(TAG, "Update Error: " + e.getMessage());
            System.out.println("Update Error: " + e.getMessage());
            flag = false;
        }
        return flag;

    }

    @Override
    protected void onPostExecute(Boolean argResult) {
        super.onPostExecute(argResult);
        /*bar.dismiss();
        if (result) {
            Toast.makeText(getApplicationContext(), "Update Done", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Error: Try Again", Toast.LENGTH_SHORT).show();
        }*/
        System.out.println("COMPLETE:::::::::::::::::");
    }

    void onInistallAPK(String argLocation) {
        /*Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(new File(argLocation + downloadApkFileName)), "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);*/
        System.out.println("FILE_PATH: " + argLocation + downloadApkFileName);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(new File(argLocation + downloadApkFileName));
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        context.startActivity(intent);

    }
}