package com.rz.librarycore.core;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by Rz Rasel on 2016-08-01.
 */
public class NetConnDetect {
    private Activity activity;
    private Context context;
    private static NetConnDetect instance = null;

    public static NetConnDetect getInstance(Activity argActivity, Context argContext) {
        if (instance == null) {
            instance = new NetConnDetect(argActivity, argContext);
        }
        return instance;
    }

    public NetConnDetect(Activity argActivity, Context argContext) {
        activity = argActivity;
        context = argContext;
    }

    public boolean isConnected() {
        //if (Build.VERSION.SDK_INT >= 23)
        int hasPermission = 0;
        String[] PERMISSIONS;
        int PERMISSION_CODE = 1;
        hasPermission = ContextCompat.checkSelfPermission((Activity) context, Manifest.permission.INTERNET);
        if (hasPermission != PackageManager.PERMISSION_GRANTED) {
            //LogWriter.Log("Check it", "Please set the permission INTERNET");
            PERMISSIONS = new String[]{Manifest.permission.INTERNET};
            //ActivityCompat.requestPermissions(activity, PERMISSIONS, PERMISSION_CODE);
            return false;
        }
        hasPermission = ContextCompat.checkSelfPermission((Activity) context, Manifest.permission.ACCESS_NETWORK_STATE);
        if (hasPermission != PackageManager.PERMISSION_GRANTED) {
            //LogWriter.Log("Check it", "Please set the permission ACCESS_NETWORK_STATE");
            PERMISSIONS = new String[]{Manifest.permission.ACCESS_NETWORK_STATE};
            //ActivityCompat.requestPermissions(activity, PERMISSIONS, PERMISSION_CODE);
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo == null) {
                return false;
            }
            /*int type = networkInfo.getType();
            String typeName = networkInfo.getTypeName();*/
            boolean connected = networkInfo.isConnected();
            if (connected)
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        //return false;
        /*try {
            ConnectivityManager connectivityManager = (ConnectivityManager) argContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected())
                return true;
            else
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;*/

        /*ConnectivityManager connectivityManager = (ConnectivityManager) argContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Network[] networks = connectivityManager.getAllNetworks();
            NetworkInfo networkInfo;
            for (Network mNetwork : networks) {
                networkInfo = connectivityManager.getNetworkInfo(mNetwork);
                if (networkInfo.getState().equals(NetworkInfo.State.CONNECTED)) {
                    return true;
                }
            }
        } else {
            if (connectivityManager != null) {
                //noinspection deprecation
                NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
                if (info != null) {
                    for (NetworkInfo anInfo : info) {
                        if (anInfo.getState() == NetworkInfo.State.CONNECTED) {
                            return true;
                        }
                    }
                }
            }
        }
        //Toast.makeText(mContext,mContext.getString(R.string.please_connect_to_internet),Toast.LENGTH_SHORT).show();
        return false;*/
    }

    // |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|

    /**
     * Checking for all possible internet providers
     **/
    public boolean isConnectingToInternet(Context argContext) {
        ConnectivityManager connectivity = (ConnectivityManager) argContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;
    }
    // |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|

    private boolean checkInternetConnection_temp(Context argContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) argContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if ((connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE) != null && connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED)
                || (connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState() == NetworkInfo.State.CONNECTED)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isConnected_01(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    public boolean isOnline() {
        /*final ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        int type = networkInfo.getType();
        String typeName = networkInfo.getTypeName();
        boolean connected = networkInfo.isConnected();
        if (connected)
            return true;
        else
            return false;*/
        return false;
    }
}
//<uses-permission android:name="android.permission.INTERNET" />
//<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />