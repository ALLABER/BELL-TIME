package com.allaber.belltime.ui.schedule.ui;

import static com.allaber.belltime.utils.Thesaurus.ARG_SECTION_NUMBER;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.allaber.belltime.database.App;
import com.allaber.belltime.database.AppDatabase;
import com.allaber.belltime.database.LessonDAO;
import com.allaber.belltime.database.models.Lesson;
import com.allaber.belltime.databinding.FragmentLessonsBinding;
import com.allaber.belltime.utils.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;
import java.util.Date;

public class WeekFragment extends Fragment {

    private WeekViewModel weekViewModel;
    private FragmentLessonsBinding binding;
    private int index = 1;
    private LessonsAdapter lessonsAdapter;

    public static WeekFragment newInstance(int index) {
        WeekFragment fragment = new WeekFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        weekViewModel = new ViewModelProvider(this).get(WeekViewModel.class);

        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        weekViewModel.setIndex(index);
    }

    private void subscribeToLessons() {
        weekViewModel.getLessons(getContext(), index).observe(getViewLifecycleOwner(), lessons -> {
            lessonsAdapter = new LessonsAdapter(lessons);
            RecyclerView recyclerView = binding.recyclerView;
            recyclerView.setAdapter(lessonsAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLessonsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        subscribeToLessons();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}