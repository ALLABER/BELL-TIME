package com.allaber.belltime.utils;

import static com.allaber.belltime.utils.Thesaurus.APP_PREFERENCES;

import android.content.Context;
import android.content.SharedPreferences;

import com.allaber.belltime.R;

import java.util.LinkedList;
import java.util.List;

public class PreferenceManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor spEditor;
    private int SHARED_PREFERENCES_MODE = 0;

    public PreferenceManager(Context context) {
        sharedPreferences = context.getSharedPreferences(APP_PREFERENCES, SHARED_PREFERENCES_MODE);
        spEditor = sharedPreferences.edit();
    }

    public List<Integer> getSelectedDaysOfWeek() {
        List<Integer> selectedDaysOfWeek = new LinkedList<>();

        if(selectedMonday()) selectedDaysOfWeek.add(R.string.string_monday);
        if(selectedTuesday()) selectedDaysOfWeek.add(R.string.string_tuesday);
        if(selectedWednesday()) selectedDaysOfWeek.add(R.string.string_wednesday);
        if(selectedThursday()) selectedDaysOfWeek.add(R.string.string_thursday);
        if(selectedFriday()) selectedDaysOfWeek.add(R.string.string_friday);
        if(selectedSaturday()) selectedDaysOfWeek.add(R.string.string_saturday);
        if(selectedSunday()) selectedDaysOfWeek.add(R.string.string_sunday);

        return selectedDaysOfWeek;
    }

    private boolean selectedMonday() {
        return true;
    }

    private boolean selectedTuesday() {
        return true;
    }

    private boolean selectedWednesday() {
        return true;
    }

    private boolean selectedThursday() {
        return true;
    }

    private boolean selectedFriday() {
        return true;
    }

    private boolean selectedSaturday() {
        return true;
    }

    private boolean selectedSunday() {
        return true;
    }

}
