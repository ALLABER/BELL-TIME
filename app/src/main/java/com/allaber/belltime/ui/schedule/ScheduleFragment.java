package com.allaber.belltime.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.allaber.belltime.database.AppDatabase;
import com.allaber.belltime.databinding.FragmentScheduleBinding;
import com.allaber.belltime.dialog.DialogAddingLesson;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class ScheduleFragment extends Fragment {

    private FragmentScheduleBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentScheduleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getContext(), getChildFragmentManager());;
        final ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        final TabLayout tabs  = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        FloatingActionButton fab = binding.floatingActionButton;
        fab.setOnClickListener(view -> AppDatabase.databaseWriteExecutor.execute(() -> {
            showDialogAddingLesson(viewPager.getCurrentItem() + 1);
        }));

        return root;
    }

    private void showDialogAddingLesson(int dayOfWeek){
        DialogAddingLesson dialogAddingLesson = new DialogAddingLesson(dayOfWeek);
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        dialogAddingLesson.show(transaction, "DialogAddingLesson");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}