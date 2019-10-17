package com.vitraining.riilcashsdk.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class Commons {
    public static final String TAG = Commons.class.getSimpleName().toUpperCase();
    public static final Boolean SHOW_DEV_LOG = true;

    public static String getServerUrl(Context context) {
        String url;
        url = "https://common.riilcash.com/";
        Log.e(TAG, "getServerUrl--> url: " + url);
        return url;
    }

    public static void showToast(Context context, String message, Boolean lengthShort) {
        if (lengthShort)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static String getToken(Context context) {
        String s = "";
        if (!SharedData.getKey(context, SharedData.ACCESS_TOKEN).isEmpty())
            s = SharedData.getKey(context, SharedData.ACCESS_TOKEN);

        return s;
    }

    public static void showProgressDialog(ProgressDialog progressDialog, String msg) {
        progressDialog.setMessage(msg);
        //progressDialog.setTitle(title);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }
}
