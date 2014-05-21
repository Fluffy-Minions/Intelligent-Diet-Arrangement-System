package com.fluffy_minions.prototype;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import com.actionbarsherlock.app.SherlockFragment;
import com.fluffy_minions.prototype.needsCalculators.PersonalProfile;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by sorin on 3/24/14.
 */
public class FillOutProfileFragment extends Fragment {
    private Spinner genderSpinner;
    private Spinner activitySpinner;
    private EditText heightEditText;
    private EditText weightEditText;
    private DatePicker datePicker;
    private double age;

    MainActivity mainActivity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mainActivity = (MainActivity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fill_out_profile_fragment, container, false);

        final Button birthdayButton = (Button) view.findViewById(R.id.birthday_button);
        Button saveButton = (Button) view.findViewById(R.id.save_button);

        genderSpinner = (Spinner) view.findViewById(R.id.gender_spinner);
        activitySpinner = (Spinner) view.findViewById(R.id.activity_spinner);
        heightEditText = (EditText) view.findViewById(R.id.height_edit_text);
        weightEditText = (EditText) view.findViewById(R.id.weight_edit_text);

        SharedPreferences pref = mainActivity.getSharedPreferences("profile", Context.MODE_PRIVATE);

        if(!pref.getString("gender", "").equals("")) {
            genderSpinner.setSelection(Arrays.asList(getResources().getStringArray(R.array.genders)).indexOf(pref.getString("gender", "")));
            activitySpinner.setSelection(Arrays.asList(getResources().getStringArray(R.array.activity_levels)).indexOf(pref.getString("activity", "")));
            heightEditText.setText(String.valueOf(pref.getInt("height", 0)));
            weightEditText.setText(String.valueOf(pref.getInt("weight", 0)));
            birthdayButton.setText("Birthday: " + String.valueOf(Calendar.getInstance().get(Calendar.YEAR) - pref.getInt("age", 0)));
            age = Calendar.getInstance().get(Calendar.YEAR) - pref.getInt("age", 0);
        }

        birthdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),  new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker1, int i, int i2, int i3) {
                        datePicker = datePicker1;
                        birthdayButton.setText("Birthday: " + datePicker.getYear() + "-" + datePicker.getMonth() + "-" + datePicker.getDayOfMonth());
                    }
                }, 2014, 5, 1);

                datePickerDialog.show();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersonalProfile personalProfile = new PersonalProfile();
                SharedPreferences.Editor editor = mainActivity.getSharedPreferences("profile", Context.MODE_PRIVATE).edit();

                personalProfile.setGender(genderSpinner.getSelectedItem().toString());
                editor.putString("gender", genderSpinner.getSelectedItem().toString());

                personalProfile.setActivityLevel(activitySpinner.getSelectedItem().toString());
                editor.putString("activity", activitySpinner.getSelectedItem().toString());

                personalProfile.setHeight(Double.parseDouble(heightEditText.getEditableText().toString()));
                editor.putInt("height", (int) Double.parseDouble(heightEditText.getEditableText().toString()));

                personalProfile.setWeight(Double.parseDouble(weightEditText.getEditableText().toString()));
                editor.putInt("weight", (int) Double.parseDouble(weightEditText.getEditableText().toString()));

                if(datePicker != null) {
                    personalProfile.setAge(Calendar.getInstance().get(Calendar.YEAR) - datePicker.getYear());
                    editor.putInt("age", Calendar.getInstance().get(Calendar.YEAR) - datePicker.getYear());
                } else {
                    personalProfile.setAge(age);
                    editor.putInt("age", (int) age);
                }

                editor.commit();

                mainActivity.setPersonalProfile(personalProfile);


            }
        });

        return view;
    }
}