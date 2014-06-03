package com.fluffy_minions.prototype.mainControl;

import android.app.Fragment;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.fluffy_minions.prototype.R;

/**
 * The settings dialog. Used for modifying the profile of the user.
 */
public class Settings extends SherlockPreferenceActivity {
    public Settings() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.layout.settings_fragment);
    }
}