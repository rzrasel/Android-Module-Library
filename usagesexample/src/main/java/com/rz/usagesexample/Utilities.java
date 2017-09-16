package com.rz.usagesexample;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.EnvironmentCompat;
import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;
//import com.daimajia.slider.library.SliderLayout.Transformer;
//import com.sharktube.BDNewsHeadlines.R;
//import entities.UpdateTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class Utilities {
    public static final String ANDROID_OS_SYSTEMPROPERTIES = "android.os.SystemProperties";
    public static final String METHOD_NAME_GET = "get";
    public static final String PARAM_SERIAL_NO = "ro.serialno";

    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    /*public static Transformer getRandomAnimationName() {
        switch (new Random().nextInt(16)) {
            case 0:
                return Transformer.Default;
            case 1:
                return Transformer.Accordion;
            case 2:
                return Transformer.Background2Foreground;
            case 3:
                return Transformer.DepthPage;
            case 4:
                return Transformer.CubeIn;
            case 5:
                return Transformer.Accordion;
            case 6:
                return Transformer.FlipHorizontal;
            case 7:
                return Transformer.FlipPage;
            case 8:
                return Transformer.Foreground2Background;
            case 9:
                return Transformer.RotateDown;
            case 10:
                return Transformer.RotateUp;
            case 11:
                return Transformer.Stack;
            case 12:
                return Transformer.Tablet;
            case 13:
                return Transformer.ZoomIn;
            case 14:
                return Transformer.ZoomOutSlide;
            case 15:
                return Transformer.ZoomOut;
            default:
                return Transformer.Default;
        }
    }*/

    public static int getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    private static String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        return !Character.isUpperCase(first) ? Character.toUpperCase(first) + s.substring(1) : s;
    }

    public static String getSmartPhoneID() {
        try {
            Class<?> c = Class.forName(ANDROID_OS_SYSTEMPROPERTIES);
            String serialNo = (String) c.getMethod(METHOD_NAME_GET, new Class[]{String.class}).invoke(c, new Object[]{PARAM_SERIAL_NO});
            Log.e("DeviceID", "serialNo: " + serialNo);
            if (serialNo == null || serialNo.trim().equals("") || serialNo.trim().equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
                serialNo = Build.SERIAL;
            }
            if (serialNo.trim().equals("")) {
                return "Serial_Not_Found";
            }
            return serialNo.trim();
        } catch (Exception e) {
            Log.e("DeviceID", "Device ID Not Found");
            return "NO_ID";
        }
    }

    public static void rateUs(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + context.getPackageName())));
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void gotoMarket(Context context, String packageName) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void moreApps(Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pub:Shark Tube Inc.")));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, "Could't lunch the market", Toast.LENGTH_LONG).show();
        }
    }

    public static void shareUs(Context context) {
        Intent sharingIntent = new Intent("android.intent.action.SEND");
        sharingIntent.setType("text/plain");
        String shareBody = "Best Daily Breaking News Alert app in App store. You can download it from here.\n https://play.google.com/store/apps/details?id=" + context.getPackageName();
        sharingIntent.putExtra("android.intent.extra.SUBJECT", context.getString(R.string.app_name));
        sharingIntent.putExtra("android.intent.extra.TEXT", shareBody);
        context.startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    /*public static boolean isPackageInstalled(String packagename, Context context) {
        try {
            context.getPackageManager().getPackageInfo(packagename, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }*/

    public static String getDate(String date) {
        TimeZone tz = Calendar.getInstance().getTimeZone();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("EEE, d MMM yyyy hh:mm:ss aa");
        simpleDateFormat.setTimeZone(tz);
        String formattedDate = "";
        try {
            return outputDateFormat.format(Long.valueOf(simpleDateFormat.parse(date).getTime() + ((long) tz.getRawOffset())));
        } catch (ParseException e) {
            e.printStackTrace();
            return formattedDate;
        } catch (Throwable th) {
            return formattedDate;
        }
    }

    public static int getApplicationVersion() {
        return 21;
    }

    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    /*public static String getAccountInformation(Context context) {
        Pattern emailPattern = Patterns.EMAIL_ADDRESS;
        if (ContextCompat.checkSelfPermission(context, "android.permission.GET_ACCOUNTS") != 0) {
            return getSmartPhoneID() + "-no-mail@gmail.com";
        }
        for (Account account : AccountManager.get(context).getAccountsByType("com.google")) {
            if (emailPattern.matcher(account.name).matches()) {
                return account.name;
            }
        }
        return getSmartPhoneID() + "-no-mail@gmail.com";
    }*/

    /*public static UpdateTime dayDifference(String s) {
        UpdateTime updateTime = new UpdateTime();
        String FinalDate = s;
        try {
            SimpleDateFormat dates = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss.SSS'Z'");
            Date date1 = dates.parse(new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss.SSS'Z'").format(new Date()));
            Date date2 = dates.parse(FinalDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date2);
            calendar.add(10, 6);
            long differenceDates = Math.abs(date1.getTime() - calendar.getTime().getTime()) / 1000;
            String dayDifference;
            if (differenceDates < 60) {
                dayDifference = Long.toString(differenceDates);
                updateTime.lastUpdate = 1;
                updateTime.date = dayDifference + " সেকেন্ড  আগে।";
            } else if (differenceDates > 60 && differenceDates < 3600) {
                long t = differenceDates / 60;
                dayDifference = Long.toString(t);
                updateTime.lastUpdate = (int) t;
                updateTime.date = dayDifference + " মিনিট আগে।";
            } else if (differenceDates > 3600 && differenceDates < 86400) {
                updateTime.date = Long.toString(differenceDates / 3600) + " ঘন্টা আগে।";
                updateTime.lastUpdate = ((int) differenceDates) / 60;
            } else if (differenceDates > 86400 && differenceDates < 2592000) {
                updateTime.date = Long.toString(differenceDates / 86400) + " দিন  আগে।";
                updateTime.lastUpdate = ((int) differenceDates) / 60;
            } else if (differenceDates > 2592000) {
                updateTime.date = getDate(s);
                updateTime.lastUpdate = ((int) differenceDates) / 60;
            } else {
                updateTime.date = "এইমাত্র।";
                updateTime.lastUpdate = 0;
            }
        } catch (Exception exception) {
            Log.e("DIDN'T WORK", "exception " + exception);
            updateTime.date = "এইমাত্র।";
            updateTime.lastUpdate = 0;
        }
        return updateTime;
    }*/

    public static void putPref(String key, float value, Context context) {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public static void putPrefForTheam(String key, int value, Context context) {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getPref(String key, Context context) {
        int i = 1;
        try {
            i = PreferenceManager.getDefaultSharedPreferences(context).getInt(key, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /*public static boolean getShowDialogPermission(Context context) {
        int counter = PreferenceManager.getInstance(context).getIntValue(GCMConstants.BACK_CLICK);
        if (counter == -1) {
            counter = 0;
        }
        counter++;
        doLogs("Clicked counter: " + counter);
        if (counter >= 5) {
            PreferenceManager.getInstance(context).setIntValue(GCMConstants.BACK_CLICK, 0);
            return true;
        }
        PreferenceManager.getInstance(context).setIntValue(GCMConstants.BACK_CLICK, counter);
        return false;
    }

    public static boolean getShowUpdateDialogPermission(Context context) {
        int counter = PreferenceManager.getInstance(context).getIntValue(GCMConstants.UPDATE_DIALOG);
        if (counter == -1) {
            counter = 0;
        }
        counter++;
        doLogs("Clicked counter: " + counter);
        if (counter >= 3) {
            PreferenceManager.getInstance(context).setIntValue(GCMConstants.UPDATE_DIALOG, 0);
            return true;
        }
        PreferenceManager.getInstance(context).setIntValue(GCMConstants.UPDATE_DIALOG, counter);
        return false;
    }*/

    public static void doLogs(String message) {
        Log.e("Utilities", message);
    }

    public static float getPref_text_size(String key, Context context) {
        float currentTextSize = PreferenceManager.getDefaultSharedPreferences(context).getFloat(key, 32.0f);
        Log.e("TextSize", "Retrieve Current Text Size " + currentTextSize);
        return currentTextSize;
    }

    public static float getPref_line_specing(String key, Context context) {
        float currentTextSpacing = PreferenceManager.getDefaultSharedPreferences(context).getFloat(key, 25.0f);
        Log.e("TextSize", "Retrieve Current Text Spacing " + currentTextSpacing);
        return currentTextSpacing;
    }
}
