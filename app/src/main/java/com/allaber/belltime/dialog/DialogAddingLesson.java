package com.allaber.belltime.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import com.allaber.belltime.R;
import com.allaber.belltime.database.App;
import com.allaber.belltime.database.AppDatabase;
import com.allaber.belltime.database.LessonDAO;
import com.allaber.belltime.database.models.Lesson;
import com.allaber.belltime.utils.Utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DialogAddingLesson extends DialogFragment implements View.OnClickListener {

    private EditText textInputEditTextLessonName;
    private EditText textInputEditTextTeacherName;
    private EditText textInputEditTextRoomNumber;
    private Button buttonStartTime;
    private Button buttonEndTime;

    private int dayOfWeek;

    public DialogAddingLesson(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_adding_lesson, null);
        initiationViewElements(view);
        builder.setView(view);
        return builder.create();
    }


    private void initiationViewElements(View view) {
        view.findViewById(R.id.textViewCancel).setOnClickListener(this);
        view.findViewById(R.id.textViewAdd).setOnClickListener(this);

        buttonStartTime = view.findViewById(R.id.buttonStartTime);
        buttonStartTime.setOnClickListener(this);

        buttonEndTime = view.findViewById(R.id.buttonEndTime);
        buttonEndTime.setOnClickListener(this);

        textInputEditTextLessonName = view.findViewById(R.id.textInputEditTextLessonName);
        textInputEditTextTeacherName = view.findViewById(R.id.textInputEditTextTeacherName);
        textInputEditTextRoomNumber = view.findViewById(R.id.textInputEditTextRoomNumber);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonStartTime:
            case R.id.buttonEndTime:
                showDateTimePicker((Button) view);
                break;
            case R.id.textViewCancel:
                getDialog().dismiss();
                break;
            case R.id.textViewAdd:
                addLesson();
                getDialog().dismiss();
                break;
        }
    }

    private void addLesson() {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            Lesson lesson = getLesson();
            LessonDAO lessonDAO = ((App) getContext().getApplicationContext()).getDatabase().lessonDAO();
            lessonDAO.insert(lesson);
        });


    }

    public void showDateTimePicker(Button button) {
        new TimePickerDialog(getContext(), (view, hourOfDay, minute) -> {
            button.setText(String.format("%02d", hourOfDay) + ":" + String.format("%02d", minute));
        }, 0, 0, true).show();
    }

    public Lesson getLesson(){
        Lesson lesson = new Lesson();

        String lessonName = textInputEditTextLessonName.getText().toString();
        lesson.setLessonName(lessonName);

        String roomNumber = textInputEditTextRoomNumber.getText().toString();
        lesson.setRoomNumber(roomNumber);

        String teacherName = textInputEditTextTeacherName.getText().toString();
        lesson.setTeacherName(teacherName);

        String startTime = buttonStartTime.getText().toString();
        lesson.setStartTime(Utils.convertTimeToLong(startTime));

        String endTime = buttonEndTime.getText().toString();
        lesson.setEndTime(Utils.convertTimeToLong(endTime));

        lesson.setDayOfWeek(Utils.getDayOfWeekByIndex(dayOfWeek));
        return lesson;
    }
}