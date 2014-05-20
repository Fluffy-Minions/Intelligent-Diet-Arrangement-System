package com.fluffy_minions.prototype;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import com.fluffy_minions.prototype.needsCalculators.PersonalProfile;

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

                personalProfile.setGender(genderSpinner.getSelectedItem().toString());
                personalProfile.setActivityLevel(activitySpinner.getSelectedItem().toString());
                personalProfile.setHeight(Double.parseDouble(heightEditText.getEditableText().toString()));
                personalProfile.setWeight(Double.parseDouble(weightEditText.getEditableText().toString()));
                personalProfile.setAge(Calendar.getInstance().get(Calendar.YEAR) - datePicker.getYear());

                mainActivity.setPersonalProfile(personalProfile);
            }
        });

        return view;
    }
}