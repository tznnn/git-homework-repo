package com.example.halkhomeworkatakan;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefConfig {
    private static String MY_PREFERENCE_NAME = "com.example.halkhomeworkatakan";
    private static String PREF_TOTAL_KEY = "pref_total_key";

    public static void saveTotalInPref(Context context, int total) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PREF_TOTAL_KEY, total);
        editor.apply();

    }

    public static int loadTotalFromPref(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(PREF_TOTAL_KEY, 0);

    }


}
