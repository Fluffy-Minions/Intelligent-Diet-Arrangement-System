package com.fluffy_minions.prototype.mainControl;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.fluffy_minions.prototype.IDAS.*;
import com.fluffy_minions.prototype.R;
import com.fluffy_minions.prototype.needsCalculators.PersonalProfile;

import java.util.logging.Logger;

/**
 * This fragment displays the days of the week and a refresh button
 * for generating a new menu.
 */
public class ViewMenuFragment extends SherlockFragment {
    private static final Logger LOGGER = Logger.getLogger(ViewMenuFragment.class.getName());
    private MainActivity mMainActivity;
    private ProgressBar progressBar;
    private boolean generating;
    private AsyncTask<Void, Void, Void> mAysncTask;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_menu_fragment, container, false);

        setHasOptionsMenu(true);

        ListView listView = (ListView) view.findViewById(R.id.day_of_week_list_view);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        progressBar.setMax(6);
        progressBar.setVisibility(View.GONE);

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

                if(generating) {
                    Toast.makeText(mMainActivity, "Please wait while a menu is generated", Toast.LENGTH_LONG).show();
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
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch(item.getItemId()) {
            case R.id.regenerate_menu: {
                if(generating) {
                    mAysncTask.cancel(true);
                    break;
                }

                mAysncTask = new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();

                        generating = true;
                        progressBar.setVisibility(View.VISIBLE);
                        item.setIcon(R.drawable.ic_action_cancel);
                        // Toast.makeText(mMainActivity, "Generating menu...", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    protected Void doInBackground(Void... voids) {
                        GenericMeal[] meals = {
                                new Breakfast(mMainActivity.getSqLiteHelper(), mMainActivity.getPersonalProfile()),
                                new Lunch(mMainActivity.getSqLiteHelper(), mMainActivity.getPersonalProfile()),
                                new Dinner(mMainActivity.getSqLiteHelper(), mMainActivity.getPersonalProfile())
                        };

                        JacopWizard jacopWizard = new JacopWizard();

                        SharedPreferences sharedPreferences = mMainActivity.getSharedPreferences("menu", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        for (int day = 0; day < 7 && !isCancelled(); ++day) {
                            for (int meal = 0; meal < 3 && !isCancelled(); ++meal) {
                                String result = "";
                                String key = String.valueOf(day) + String.valueOf(meal);

                                while(result.equals("") && !isCancelled()) {
                                    meals[meal].regenerate();
                                    result = jacopWizard.invokeTheGods(meals[meal], LOGGER);
                                }

                                editor.putString(key, result);
                            }

                            publishProgress();
                        }

                        if(!isCancelled()) { editor.commit(); }

                        return null;
                    }

                    @Override
                    protected void onProgressUpdate(Void... values) {
                        super.onProgressUpdate(values);

                        progressBar.incrementProgressBy(1);
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        super.onPostExecute(aVoid);

                        generating = false;
                        progressBar.setVisibility(View.GONE);
                        progressBar.setProgress(0);
                        item.setIcon(R.drawable.ic_action_refresh);
                        Toast.makeText(mMainActivity, "Menu generated!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    protected void onCancelled() {
                        super.onCancelled();

                        generating = false;
                        progressBar.setVisibility(View.GONE);
                        progressBar.setProgress(0);
                        item.setIcon(R.drawable.ic_action_refresh);
                        Toast.makeText(mMainActivity, "Menu generation canceled!", Toast.LENGTH_LONG).show();
                    }
                }.execute();

                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}