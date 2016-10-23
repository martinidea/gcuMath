package com.gcu.math.base.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Martin on 2016/9/1.
 */
public class PreferencesUtils {

    private static Context context;

    public static void initContext(Context context) {
        PreferencesUtils.context = context;
    }

    public static String getPreferenceName() {
        return preferenceName;
    }

    /**
     * Set the default preference name.
     *
     * @param preferenceName
     */
    public static void setPreferenceName(String preferenceName) {
        PreferencesUtils.preferenceName = preferenceName;
    }

    private static String preferenceName = "UltimateAndroid";

    /**
     * Put string to preferences
     *
     * @param key   The name of the preference to modify
     * @param value The new value for the preference
     * @return Returns true if the new values were successfully written to persistent storage.
     */
    public static boolean putString(String key, String value) {
        return putString(preferenceName, key, value);
    }

    /**
     * Put string to preferences with custom preference
     *
     * @param preferenceName The custom preference name
     * @param key            The name of the preference to modify
     * @param value          The new value for the preference
     * @return Returns true if the new values were successfully written to persistent storage.
     */
    public static boolean putString(String preferenceName, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    /**
     * Get string from preferences with "" as default value
     *
     * @param key The name of the preference to retrieve
     * @return Returns the preference value if it exists, or defValue. Throws ClassCastException if there is a preference with this name that is not a String.
     */
    public static String getString(String key) {
        return getString(preferenceName, key);
    }

    /**
     * Get string from custom preferences with "" as default value
     *
     * @param preferenceName The custom preference name
     * @param key            The name of the preference to retrieve
     * @return Returns the preference value if it exists, or defValue. Throws ClassCastException if there is a preference with this name that is not a String.
     */
    public static String getString(String preferenceName, String key) {
        return getString(preferenceName, key, "");
    }

    /**
     * Get string from custom preferences with custom default value
     *
     * @param preferenceName The custom preference name
     * @param key            The name of the preference to retrieve
     * @param defaultValue   Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or defValue. Throws ClassCastException if there is a preference with this name that is not a String.
     */
    public static String getString(String preferenceName, String key, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defaultValue);
    }

    /**
     * Put int to preferences
     *
     * @param key   The name of the preference to modify
     * @param value The new value for the preference
     * @return Returns true if the new values were successfully written to persistent storage.
     */
    public static boolean putInt(String key, int value) {
        return putInt(preferenceName, key, value);
    }


    /**
     * Put int to preferences with custom preference
     *
     * @param preferenceName The custom preference name
     * @param key            The name of the preference to modify
     * @param value          The new value for the preference
     * @return Returns true if the new values were successfully written to persistent storage.
     */
    public static boolean putInt(String preferenceName, String key, int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    /**
     * Get int from preferences with 0 as default value
     *
     * @param key The name of the preference to retrieve
     * @return Returns the preference value if it exists, or defValue. Throws ClassCastException if there is a preference with this name that is not an int.
     */
    public static int getInt(String key) {
        return getInt(preferenceName, key);
    }

    /**
     * Get int from custom preferences with 0 as default value
     *
     * @param preferenceName The custom preference name
     * @param key            The name of the preference to retrieve
     * @return Returns the preference value if it exists, or defValue. Throws ClassCastException if there is a preference with this name that is not an int.
     */
    public static int getInt(String preferenceName, String key) {
        return getInt(preferenceName, key, 0);
    }


    /**
     * Get int from custom preferences with custom default value
     *
     * @param preferenceName The custom preference name
     * @param key            The name of the preference to retrieve
     * @param defaultValue   Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or defValue. Throws ClassCastException if there is a preference with this name that is not an int.
     */
    public static int getInt(String preferenceName, String key, int defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, defaultValue);
    }

    /**
     * Put long to preferences
     *
     * @param key   The name of the preference to modify
     * @param value The new value for the preference
     * @return Returns true if the new values were successfully written to persistent storage.
     */
    public static boolean putLong(String key, long value) {
        return putLong(preferenceName, key, value);
    }


    /**
     * Put long to preferences with custom preference
     *
     * @param preferenceName The custom preference name
     * @param key            The name of the preference to modify
     * @param value          The new value for the preference
     * @return Returns true if the new values were successfully written to persistent storage.
     */
    public static boolean putLong(String preferenceName, String key, long value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    /**
     * get long preferences
     *
     * @param key The name of the preference to retrieve
     * @return The preference value if it exists, or 0. Throws ClassCastException if there is a preference with this
     * name that is not a long
     */
    public static long getLong(String key) {
        return getLong(preferenceName, key);
    }

    /**
     * Get long from custom preferences with 0 as default value
     *
     * @param preferenceName The custom preference name
     * @param key            The name of the preference to retrieve
     * @return Returns the preference value if it exists, or defValue. Throws ClassCastException if there is a preference with this name that is not an int.
     */
    public static long getLong(String preferenceName, String key) {
        return getLong(preferenceName, key, 0);
    }


    /**
     * Get long from custom preferences with custom default value
     *
     * @param preferenceName The custom preference name
     * @param key            The name of the preference to retrieve
     * @param defaultValue   Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or defValue. Throws ClassCastException if there is a preference with this name that is not a long.
     */
    public static long getLong(String preferenceName, String key, long defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(key, defaultValue);
    }

    /**
     * Put float to preferences
     *
     * @param key   The name of the preference to modify
     * @param value The new value for the preference
     * @return Returns true if the new values were successfully written to persistent storage.
     */
    public static boolean putFloat(String key, float value) {
        return putFloat(preferenceName, key, value);
    }

    /**
     * Put float to preferences with custom preference
     *
     * @param preferenceName The custom preference name
     * @param key            The name of the preference to modify
     * @param value          The new value for the preference
     * @return Returns true if the new values were successfully written to persistent storage.
     */
    public static boolean putFloat(String preferenceName, String key, float value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }

    /**
     * Get float from preferences with 0 as default value
     *
     * @param key The name of the preference to retrieve
     * @return Returns the preference value if it exists, or defValue. Throws ClassCastException if there is a preference with this name that is not an int.
     */
    public static float getFloat(String key) {
        return getFloat(preferenceName, key);
    }

    /**
     * Get int from custom preferences with 0 as default value
     *
     * @param preferenceName The custom preference name
     * @param key            The name of the preference to retrieve
     * @return Returns the preference value if it exists, or defValue. Throws ClassCastException if there is a preference with this name that is not an int.
     */
    public static float getFloat(String preferenceName, String key) {
        return getFloat(preferenceName, key, 0);
    }


    /**
     * Get float from custom preferences with custom default value
     *
     * @param preferenceName The custom preference name
     * @param key            The name of the preference to retrieve
     * @param defaultValue   Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or defValue. Throws ClassCastException if there is a preference with this name that is not a float.
     */
    public static float getFloat(String preferenceName, String key, float defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        return sharedPreferences.getFloat(key, defaultValue);
    }

    /**
     * Put boolean to preferences
     *
     * @param key   The name of the preference to modify
     * @param value The new value for the preference
     * @return Returns true if the new values were successfully written to persistent storage.
     */
    public static boolean putBoolean(String key, boolean value) {

        return putBoolean(preferenceName, key, value);
    }

    /**
     * Put boolean to preferences with custom preference
     *
     * @param preferenceName The custom preference name
     * @param key            The name of the preference to modify
     * @param value          The new value for the preference
     * @return Returns true if the new values were successfully written to persistent storage.
     */
    public static boolean putBoolean(String preferenceName, String key, boolean value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    /**
     * Get boolean from preferences with false as default value
     *
     * @param key The name of the preference to retrieve
     * @return Returns the preference value if it exists, or defValue. Throws ClassCastException if there is a preference with this name that is not a boolean.
     */
    public static boolean getBoolean(String key) {
        return getBoolean(preferenceName, key);
    }

    /**
     * Get boolean from custom preferences with false as default value
     *
     * @param preferenceName The custom preference name
     * @param key            The name of the preference to retrieve
     * @return Returns the preference value if it exists, or defValue. Throws ClassCastException if there is a preference with this name that is not a boolean.
     */
    public static boolean getBoolean(String preferenceName, String key) {
        return getBoolean(preferenceName, key, false);
    }

    /**
     * Get boolean from custom preferences with custom default value
     *
     * @param preferenceName The custom preference name
     * @param key            The name of the preference to retrieve
     * @param defaultValue   Value to return if this preference does not exist.
     * @return Returns the preference value if it exists, or defValue. Throws ClassCastException if there is a preference with this name that is not a boolean.
     */
    public static boolean getBoolean(String preferenceName, String key, boolean defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public static void clearSharePreference(Context context) {
        clearSharePreference(preferenceName);
    }

    public static void clearSharePreference(String preferenceName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
}