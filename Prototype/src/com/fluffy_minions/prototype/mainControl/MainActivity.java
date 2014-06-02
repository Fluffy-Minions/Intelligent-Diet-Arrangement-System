package com.fluffy_minions.prototype.mainControl;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.*;
import com.fluffy_minions.prototype.*;
import com.fluffy_minions.prototype.needsCalculators.PersonalProfile;

import java.io.IOException;
import java.util.logging.Logger;


public class MainActivity extends SherlockFragmentActivity {
    private static final Logger LOGGER = Logger.getLogger(MainActivity.class.getName());
    private PersonalProfile personalProfile;
    private SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadPersonalProfile();

        replaceFragmentWith(new ViewMenuFragment(), "Weekly menu");

        sqLiteHelper = new SQLiteHelper(this);

        try {
            sqLiteHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            sqLiteHelper.openDataBase();
        } catch(SQLException sqle) {
            throw sqle;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
        getSupportMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1969) {
            loadPersonalProfile();
        }
    }

    /**
     * Loads the personal profile from the SharedPreferences
     */
    public void loadPersonalProfile() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        personalProfile = new PersonalProfile();

        String gender = preferences.getString("gender", null);
        String activity = preferences.getString("activity", null);
        String height = preferences.getString("height", null);
        String weight = preferences.getString("weight", null);
        String age = preferences.getString("age", null);

        if(gender != null) { personalProfile.setGender(gender); }
        if(activity != null) { personalProfile.setActivityLevel(activity); }
        if(height != null) { personalProfile.setHeight(Double.parseDouble(height)); }
        if(weight != null) { personalProfile.setWeight(Double.parseDouble(weight)); }
        if(age != null) { personalProfile.setAge(Double.parseDouble(age)); }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Intent intent = new Intent(this, Settings.class);
            startActivityForResult(intent, 1969);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Replaces the current fragment with the given one.
     *
     * @param fragment the new fragment
     * @param title the title to show in the action bar
     */
    public void replaceFragmentWith(SherlockFragment fragment, String title) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);

        fragmentTransaction.addToBackStack(title);

        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if(fragmentManager.getBackStackEntryCount() == 1) { return; }

        super.onBackPressed();
    }

    public PersonalProfile getPersonalProfile() {
        return personalProfile;
    }

    public SQLiteHelper getSqLiteHelper() { return sqLiteHelper; }
}
