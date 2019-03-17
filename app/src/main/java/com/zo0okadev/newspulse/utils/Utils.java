package com.zo0okadev.newspulse.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Utils {

    public static String getElapsedTime(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long timeMilliseconds = date != null ? date.getTime() : 0;

        long timeElapsedInSeconds = (System.currentTimeMillis() - timeMilliseconds) / 1000;

        if (timeElapsedInSeconds < 60) {
            return timeElapsedInSeconds + " seconds ago.";
        } else if (timeElapsedInSeconds < 3600) {
            timeElapsedInSeconds = timeElapsedInSeconds / 60;
            return timeElapsedInSeconds + " minutes ago.";
        } else if (timeElapsedInSeconds < 86400) {
            timeElapsedInSeconds = timeElapsedInSeconds / 3600;
            return timeElapsedInSeconds + " hours ago.";
        } else if (timeElapsedInSeconds < 2592000) {
            timeElapsedInSeconds = timeElapsedInSeconds / 86400;
            return timeElapsedInSeconds + " days ago.";
        } else if (timeElapsedInSeconds < 31104000) {
            timeElapsedInSeconds = timeElapsedInSeconds / 2592000;
            return timeElapsedInSeconds + " month(s) ago.";
        } else {
            timeElapsedInSeconds = timeElapsedInSeconds / 31104000;
            return timeElapsedInSeconds + " year(s) ago.";
        }

    }

    public static String getFormattedDate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date = null;
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat targetFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm", Locale.getDefault());
        return targetFormat.format(date);
    }
}

