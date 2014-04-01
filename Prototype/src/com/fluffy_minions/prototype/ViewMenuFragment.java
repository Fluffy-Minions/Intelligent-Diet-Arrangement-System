package com.fluffy_minions.prototype;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by sorin on 3/24/14.
 */
public class ViewMenuFragment extends Fragment {
    private MainActivity mMainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_menu_fragment, container, false);

        setHasOptionsMenu(true);

        ListView listView = (ListView) view.findViewById(R.id.day_of_week_list_view);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle args = new Bundle();
                args.putString("day", (String)adapterView.getItemAtPosition(i));

                Fragment fragment = new Menu();
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
    public void onCreateOptionsMenu(android.view.Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.view_menu_menu, menu);
    }
}