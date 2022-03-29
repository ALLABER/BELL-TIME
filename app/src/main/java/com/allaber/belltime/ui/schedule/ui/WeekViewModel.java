package com.allaber.belltime.ui.schedule.ui;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;


import com.allaber.belltime.database.App;
import com.allaber.belltime.database.AppDatabase;
import com.allaber.belltime.database.LessonDAO;
import com.allaber.belltime.database.models.Lesson;
import com.allaber.belltime.utils.Utils;

import java.util.List;

public class WeekViewModel extends ViewModel {
    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();

    private LiveData<List<Lesson>> lessons = new MutableLiveData<>();

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public void setLessons(Context context, Lesson lesson) {
        AppDatabase db =  Room.databaseBuilder(context,
                AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
        LessonDAO lessonDAO = db.lessonDAO();

        lessonDAO.insert(lesson);
    }

    public LiveData<List<Lesson>> getLessons(Context context, int index) {
        LessonDAO lessonDAO = ((App) context.getApplicationContext()).getDatabase().lessonDAO();
        lessons = lessonDAO.getByDayOfWeekLive(Utils.getDayOfWeekByIndex(index));
        return lessons;
    }
}