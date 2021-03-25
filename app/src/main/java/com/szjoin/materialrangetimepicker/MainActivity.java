package com.szjoin.materialrangetimepicker;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.wdullaer.materialdatetimepicker.date.range.DatePickerRangeDialog;
import com.wdullaer.materialdatetimepicker.date.range.time.RadialRangePickerLayout;
import com.wdullaer.materialdatetimepicker.date.range.time.TimePickerRangeDialog;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerRangeDialog.OnDateSetListener, TimePickerRangeDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Button dateButton = (Button) findViewById(R.id.date_button);
        Button timeButton = (Button) findViewById(R.id.time_button);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,MainRangeActivity.class));
            }
        });
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainSingleActivity.class));
            }
        });





    }

    @Override
    public void onDateSet(DatePickerRangeDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {


    }

    @Override
    public void onTimeSet(RadialRangePickerLayout view, int hourOfDay, int minute, int hourOfDayEnd, int minuteEnd) {

    }
}