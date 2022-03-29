package com.allaber.belltime.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.allaber.belltime.database.App;
import com.allaber.belltime.database.AppDatabase;
import com.allaber.belltime.database.LessonDAO;
import com.allaber.belltime.database.models.Lesson;
import com.allaber.belltime.databinding.FragmentScheduleBinding;
import com.allaber.belltime.utils.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.Calendar;
import java.util.Date;

public class ScheduleFragment extends Fragment {

    private FragmentScheduleBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ScheduleViewModel scheduleViewModel =
                new ViewModelProvider(this).get(ScheduleViewModel.class);

        binding = FragmentScheduleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getContext(), getChildFragmentManager());;
        final ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        final TabLayout tabs  = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        FloatingActionButton fab = binding.floatingActionButton;
        fab.setOnClickListener(view -> AppDatabase.databaseWriteExecutor.execute(() -> {

            Lesson lesson = new Lesson();
            lesson.setLessonName("Русский");
            lesson.setStartTime(String.valueOf(new Date()));
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, 1);
            lesson.setEndTime(String.valueOf(cal.getTime()));
            int currentItem = viewPager.getCurrentItem() + 1;
            lesson.setDayOfWeek(Utils.getDayOfWeekByIndex(currentItem));
            lesson.setRoomNumber("402");
            lesson.setTeacherName("Альберт");

            LessonDAO lessonDAO = ((App) getContext().getApplicationContext()).getDatabase().lessonDAO();
            lessonDAO.insert(lesson);

        }));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}