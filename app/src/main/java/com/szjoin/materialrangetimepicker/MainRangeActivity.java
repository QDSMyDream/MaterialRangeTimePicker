package com.szjoin.materialrangetimepicker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.wdullaer.materialdatetimepicker.date.range.DatePickerRangeDialog;
import com.wdullaer.materialdatetimepicker.date.range.time.RadialRangePickerLayout;
import com.wdullaer.materialdatetimepicker.date.range.time.TimePickerRangeDialog;

import java.util.Calendar;

public class MainRangeActivity extends AppCompatActivity implements DatePickerRangeDialog.OnDateSetListener, TimePickerRangeDialog.OnTimeSetListener {
    private TextView dateTextView;
    private TextView timeTextView;
    private boolean mAutoHighlight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_range_main);

        // Find our View instances
        dateTextView = (TextView)findViewById(R.id.date_textview);
        timeTextView = (TextView)findViewById(R.id.time_textview);
        Button dateButton = (Button)findViewById(R.id.date_button);
        Button timeButton = (Button)findViewById(R.id.time_button);

        CheckBox ahl = (CheckBox) findViewById(R.id.autohighlight_checkbox);
        ahl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mAutoHighlight = b;
            }
        });

        // Show a datepicker when the dateButton is clicked
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerRangeDialog dpd = DatePickerRangeDialog.newInstance(
                        MainRangeActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.setAutoHighlight(true);
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                TimePickerRangeDialog tpd = TimePickerRangeDialog.newInstance(
                        MainRangeActivity.this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        false
                );
                tpd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {

                    }
                });
                tpd.show(getFragmentManager(), "Timepickerdialog");
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        DatePickerRangeDialog dpd = (DatePickerRangeDialog) getFragmentManager().findFragmentByTag("Datepickerdialog");
        if(dpd != null) dpd.setOnDateSetListener(this);
    }


    @Override
    public void onDateSet(DatePickerRangeDialog view, int year, int monthOfYear, int dayOfMonth, int yearEnd, int monthOfYearEnd, int dayOfMonthEnd) {
        String date = "你选择日期: 从- "+dayOfMonth+"/"+(++monthOfYear)+"/"+year+" 到 "+dayOfMonthEnd+"/"+(++monthOfYearEnd)+"/"+yearEnd;
        dateTextView.setText(date);
    }


    @Override
    public void onTimeSet(RadialRangePickerLayout view, int hourOfDay, int minute, int hourOfDayEnd, int minuteEnd) {
        String hourString = hourOfDay < 10 ? "0"+hourOfDay : ""+hourOfDay;
        String minuteString = minute < 10 ? "0"+minute : ""+minute;
        String hourStringEnd = hourOfDayEnd < 10 ? "0"+hourOfDayEnd : ""+hourOfDayEnd;
        String minuteStringEnd = minuteEnd < 10 ? "0"+minuteEnd : ""+minuteEnd;
        String time = "你选择时间：从- "+hourString+"h"+minuteString+" 到 - "+hourStringEnd+"h"+minuteStringEnd;

        timeTextView.setText(time);
    }
}
