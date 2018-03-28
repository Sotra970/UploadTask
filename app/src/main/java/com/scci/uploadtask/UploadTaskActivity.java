package com.scci.uploadtask;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UploadTaskActivity extends AppCompatActivity {


    @BindView(R.id.startup_1_check_box)
    CheckBox startup1CheckBox ;

    @BindView(R.id.startup_2_check_box)
    CheckBox startup2CheckBox ;

    @BindView(R.id.startup_3_check_box)
    CheckBox startup3CheckBox ;

    @BindView(R.id.startup_4_check_box)
    CheckBox startup4CheckBox ;


    @BindView(R.id.appsplash_rd)
    RadioButton appsplash_rd ;



    @BindView(R.id.markaitve_rd)
    RadioButton markaitve_rd ;



    @BindView(R.id.devology_rd)
    RadioButton devology_rd ;

    @BindView(R.id.investneur_rd)
    RadioButton investneur_rd ;

    @BindView(R.id.techsolve_rd)
    RadioButton techsolve_rd ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_task);
        ButterKnife.bind(this);

    }

    ArrayList<String> getSelectedStartups(){
        ArrayList<String> selectedSartups = new ArrayList<>() ;
        if (startup1CheckBox.isChecked()){
            selectedSartups.add("1") ;
        }

        if (startup2CheckBox.isChecked()){
            selectedSartups.add("2") ;
        }

        if (startup3CheckBox.isChecked()){
            selectedSartups.add("3") ;
        }


        if (startup4CheckBox.isChecked()){
            selectedSartups.add("4") ;
        }
        return  selectedSartups ;
    }



    int getSelecctedWorkShop(){

        if (appsplash_rd.isChecked())
            return 1;

        if (devology_rd.isChecked())
            return 2;

        if (markaitve_rd.isChecked())
            return 3;


        if (investneur_rd.isChecked())
            return 4;

        if (techsolve_rd.isChecked())
            return 5;

        return 0 ;
    }

    @BindView(R.id.date_txt)
    TextView  date_txt ;


    @OnClick(R.id.date_txt)
    void select_Date(){
        Calendar calendar = Calendar.getInstance() ;
        DatePickerDialog.OnDateSetListener  listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                date_txt.setText(year + " - " + (month+1) + " - " + day);

            }
        } ;
       new DatePickerDialog(UploadTaskActivity.this,
               listener,
               calendar.get(Calendar.YEAR),
               calendar.get(Calendar.MONTH),
               calendar.get(Calendar.DAY_OF_MONTH)
       ).show();


    }

    @BindView(R.id.time_txt)
    TextView time_txt ;

    @OnClick(R.id.time_txt)
    void selectTime(){

        Calendar calendar = Calendar.getInstance() ;
        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int h, int m) {
                if (h > 12 ){
                    h = h-12 ;
                }
//                 int hour12 = h>12 ? h-12 : h ;

                time_txt.setText(h + " : " + m);
            }
        };

        new TimePickerDialog(this ,
                listener  ,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE) ,
                false).show(); ;

    }

}
