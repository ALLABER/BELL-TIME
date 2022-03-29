package com.allaber.belltime.ui.schedule.ui;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.allaber.belltime.R;
import com.allaber.belltime.database.models.Lesson;

import java.util.List;

public class LessonsAdapter extends
        RecyclerView.Adapter<LessonsAdapter.ViewHolder> {

    private List<Lesson> mLesson;

    // Pass in the contact array into the constructor
    public LessonsAdapter(List<Lesson> contacts) {
        mLesson = contacts;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView startTime;
        public TextView endTime;
        public TextView lessonName;
        public TextView roomNumber;
        public TextView teacherName;

        public ViewHolder(View itemView) {
            super(itemView);
            startTime = (TextView) itemView.findViewById(R.id.start_time);
            endTime = (TextView) itemView.findViewById(R.id.end_time);
            lessonName = (TextView) itemView.findViewById(R.id.lesson_name);
            roomNumber = (TextView) itemView.findViewById(R.id.room_number);
            teacherName = (TextView) itemView.findViewById(R.id.teacher_name);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.item_lesson, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Lesson lesson = mLesson.get(position);

//        holder.startTime.setText(lesson.getStartTime());
//        holder.endTime.setText(lesson.getEndTime());

        holder.startTime.setText("08:30");
        holder.endTime.setText("10:00");

        holder.lessonName.setText(lesson.getLessonName());
        holder.roomNumber.setText(lesson.getRoomNumber());
        holder.teacherName.setText(lesson.getTeacherName());

    }

    @Override
    public int getItemCount() {
        return mLesson.size();
    }
}