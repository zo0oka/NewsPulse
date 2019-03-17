package com.zo0okadev.newspulse.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.zo0okadev.newspulse.R;

public class AppRater {

    private final static int DAYS_UNTIL_PROMPT = 3;//Min number of days
    private final static int LAUNCHES_UNTIL_PROMPT = 3;//Min number of launches

    public static void launchTracker(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("apprater", 0);
        if (prefs.getBoolean("dontshowagain", false)) {
            return;
        }

        SharedPreferences.Editor editor = prefs.edit();

        // Increment launch counter
        long launch_count = prefs.getLong("launch_count", 0) + 1;
        editor.putLong("launch_count", launch_count);

        // Get date of first launch
        long date_firstLaunch = prefs.getLong("date_firstlaunch", 0);
        if (date_firstLaunch == 0) {
            date_firstLaunch = System.currentTimeMillis();
            editor.putLong("date_firstlaunch", date_firstLaunch);
        }

        // Wait at least n days before opening
        if (launch_count >= LAUNCHES_UNTIL_PROMPT) {
            if (System.currentTimeMillis() >= date_firstLaunch +
                    (DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000)) {
                showRateDialog(context, editor);
            }
        }

        editor.apply();
    }

    public static void showRateDialog(final Context context, final SharedPreferences.Editor editor) {
        MaterialAlertDialogBuilder alertDialog = new MaterialAlertDialogBuilder(context)
                .setTitle("Rate " + context.getString(R.string.app_name))
                .setMessage("If you enjoy using " + context.getString(R.string.app_name) +
                        ", please take a moment to rate it. Thanks for your support!")
                .setPositiveButton("Rate App", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            context.startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("market://details?id=" + context.getPackageName())));
                        } catch (ActivityNotFoundException e) {
                            context.startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName())));
                        }
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("No, Thanks", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (editor != null) {
                            editor.putBoolean("dontshowagain", true);
                            editor.commit();
                        }
                        dialog.dismiss();
                    }
                })
                .setNeutralButton("Later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}

