package com.allaber.belltime.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.allaber.belltime.database.models.Lesson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Lesson.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract LessonDAO lessonDAO();
}
