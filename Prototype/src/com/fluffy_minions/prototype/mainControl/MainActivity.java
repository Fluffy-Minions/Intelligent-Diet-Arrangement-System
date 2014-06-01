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


public class MainActivity extends SherlockFragmentActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    private static final Logger LOGGER = Logger.getLogger(MainActivity.class.getName());

    private SherlockFragment viewMenu;
    private PersonalProfile personalProfile;

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    private SQLiteHelper sqLiteHelper;

    public SQLiteHelper getSqLiteHelper() { return sqLiteHelper; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadPersonalProfile();


        //mNavigationDrawerFragment = (NavigationDrawerFragment)
         //       getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        //mTitle = getTitle();

       replaceFragmentWith(new ViewMenuFragment(), "Weekly menu");

        // Set up the drawer.
       /* mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));*/

        sqLiteHelper = new SQLiteHelper(this);

        try {

            sqLiteHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        try {

            sqLiteHelper.openDataBase();

        }catch(SQLException sqle) {

            throw sqle;

        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        switch(position) {
            case 0: {
                replaceFragmentWith(new ViewMenuFragment(), "Menu");
                break;
            }
            case 1: {
                replaceFragmentWith(new FillOutProfileFragment(), "Fill out profile");
                break;
            }
        }

    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
       // if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getSupportMenuInflater().inflate(R.menu.main, menu);
            //restoreActionBar();
            return true;
        //}
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1969) {
            loadPersonalProfile();
        }
    }

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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            //replaceFragmentWith(new Settings(), "Settings");
            Intent intent = new Intent(this, Settings.class);
            startActivityForResult(intent, 1969);
           // replaceFragmentWith(new FillOutProfileFragment(), "Profile");
        }
        return super.onOptionsItemSelected(item);
    }

    public void replaceFragmentWith(SherlockFragment fragment, String title) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);

        //		if(!(fragment instanceof NewPurchaseFragment) && !(fragment instanceof WalletsFragment)) {
        fragmentTransaction.addToBackStack(title);
        //		}

        mTitle = title;

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

    public void setPersonalProfile(PersonalProfile personalProfile) {
        this.personalProfile = personalProfile;
    }
}
