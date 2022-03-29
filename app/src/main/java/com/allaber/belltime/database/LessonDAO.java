package com.allaber.belltime.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.allaber.belltime.database.models.Lesson;

import java.util.List;

@Dao
public interface LessonDAO {

    @Query("SELECT * FROM lesson WHERE dayOfWeek = :dayOfWeek")
    LiveData<List<Lesson>> getByDayOfWeekLive(String dayOfWeek);

    @Query("SELECT * FROM lesson")
    List<Lesson> getAll();

    @Query("SELECT * FROM lesson WHERE id = :id")
    Lesson getById(long id);

    @Query("SELECT * FROM lesson WHERE dayOfWeek = :dayOfWeek")
    List<Lesson> getByDayOfWeek(String dayOfWeek);

    @Insert
    void insert(Lesson lesson);

    @Update
    void update(Lesson lesson);

    @Delete
    void delete(Lesson lesson);
}