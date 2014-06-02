package com.fluffy_minions.prototype.mainControl;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragment;
import com.fluffy_minions.prototype.R;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by sorin on 3/24/14.
 */
public class Menu extends SherlockFragment {
    private Logger LOGGER = Logger.getLogger(Menu.class.getName());
    private MainActivity mainActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mainActivity = (MainActivity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();
        int day = args.getInt("day");

        SharedPreferences sharedPreferences = mainActivity.getSharedPreferences("menu", Context.MODE_PRIVATE);

        View view = inflater.inflate(R.layout.menu_fragment, container, false);

        TabHost tabHost=(TabHost)view.findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec1=tabHost.newTabSpec("Tab 1");
        spec1.setContent(R.id.tab1);
        spec1.setIndicator("Breakfast");

        TextView breakfast = (TextView) view.findViewById(R.id.breakfast_textView);
        breakfast.setText(sharedPreferences.getString(String.valueOf(day) + "0", ""));

        TabHost.TabSpec spec2=tabHost.newTabSpec("Tab 2");
        spec2.setIndicator("Lunch");
        spec2.setContent(R.id.tab2);

        TextView lunch = (TextView) view.findViewById(R.id.lunch_textView);
        lunch.setText(sharedPreferences.getString(String.valueOf(day) + "1", ""));

        TabHost.TabSpec spec3=tabHost.newTabSpec("Tab 3");
        spec3.setIndicator("Dinner");
        spec3.setContent(R.id.tab3);

        TextView dinner = (TextView) view.findViewById(R.id.dinner_textView);
        dinner.setText(sharedPreferences.getString(String.valueOf(day) + "2", ""));

        tabHost.addTab(spec1);
        tabHost.addTab(spec2);
        tabHost.addTab(spec3);

        return view;
    }
}