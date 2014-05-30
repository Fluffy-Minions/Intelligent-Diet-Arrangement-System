package com.fluffy_minions.prototype;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.*;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.fluffy_minions.prototype.IDAS.Breakfast;
import com.fluffy_minions.prototype.IDAS.Dinner;
import com.fluffy_minions.prototype.IDAS.IMeal;
import com.fluffy_minions.prototype.IDAS.Lunch;
import com.fluffy_minions.prototype.needsCalculators.PersonalProfile;

import java.util.logging.Logger;

/**
 * Created by sorin on 3/24/14.
 */
public class ViewMenuFragment extends SherlockFragment {
    private static final Logger LOGGER = Logger.getLogger(ViewMenuFragment.class.getName());
    private MainActivity mMainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_menu_fragment, container, false);

        setHasOptionsMenu(true);

        ListView listView = (ListView) view.findViewById(R.id.day_of_week_list_view);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                if(mMainActivity.getPersonalProfile() == null || !mMainActivity.getPersonalProfile().isComplete()) {
                    Toast.makeText(mMainActivity, "Please fill out your profile", Toast.LENGTH_LONG).show();
                    return;
                }

                if(mMainActivity.getSharedPreferences("menu", Context.MODE_PRIVATE).getString("00", "").equals("")) {
                    Toast.makeText(mMainActivity, "Please generate a menu", Toast.LENGTH_LONG).show();
                    return;
                }

                Bundle args = new Bundle();
                args.putInt("day", i);

                 SherlockFragment fragment = new Menu();
                fragment.setArguments(args);

                mMainActivity.replaceFragmentWith(fragment, (String)adapterView.getItemAtPosition(i));
            }
        });

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mMainActivity = (MainActivity) activity;
    }

    @Override
    public void onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.view_menu_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.regenerate_menu: {
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();

                        Toast.makeText(mMainActivity, "Generating menu...", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    protected Void doInBackground(Void... voids) {
                        IMeal[] meals = {
                                new Breakfast(mMainActivity.getSqLiteHelper(), mMainActivity.getPersonalProfile()),
                                new Lunch(mMainActivity.getSqLiteHelper(), mMainActivity.getPersonalProfile()),
                                new Dinner(mMainActivity.getSqLiteHelper(), mMainActivity.getPersonalProfile())
                        };

                        PersonalProfile personalProfile = mMainActivity.getPersonalProfile();

                        JacopWizard jacopWizard = new JacopWizard();

                        SharedPreferences sharedPreferences = mMainActivity.getSharedPreferences("menu", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        for (int day = 0; day < 7; ++day) {
                            for (int meal = 0; meal < 3; ++meal) {
                                meals[meal].regenerate();

                                String key = String.valueOf(day) + String.valueOf(meal);
                                String value = jacopWizard.invokeTheGods(meals[meal], personalProfile, LOGGER);

                                editor.putString(key, value);
                            }
                        }

                        editor.commit();

                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        super.onPostExecute(aVoid);

                        Toast.makeText(mMainActivity, "Menu generated!", Toast.LENGTH_LONG).show();
                    }
                }.execute();

            }
            default: { return super.onOptionsItemSelected(item); }
        }
    }

    /*@Override
    public void onCreateOptionsMenu(android.view.Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.view_menu_menu, menu);
    }*/
}