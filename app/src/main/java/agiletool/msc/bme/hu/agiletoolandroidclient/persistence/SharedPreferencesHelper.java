package agiletool.msc.bme.hu.agiletoolandroidclient.persistence;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

@Singleton
public class SharedPreferencesHelper {

    private static final String PREFERENCES_NAME = "AGILE_TOOL";

    private Application application;

    public SharedPreferencesHelper(Application application) {
        this.application = application;
    }

    public void saveItem(String id, String value) {
        SharedPreferences preferences = application.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(id, value);

        editor.apply();
    }

    public void saveItem(String id, String[] values) {
        SharedPreferences preferences = application.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

//        editor.putStringSet(id, values);

        editor.apply();
    }

    public String getItem(String id) {
        SharedPreferences preferences = application.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

        return preferences.getString(id, "");
    }
}
