package com.example.knou_android;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Calendar;

public class c14_dialog extends AppCompatActivity {
//    달력선택
    Button btnSelectedDate;
    DatePickerDialog datePickerDialog;
    TextView display;


//    타임피커
    TimePicker timePicker1;
    TextView text142;
    Button button142;

    private static final String TAG = "c14_dialog";
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c14_dialog);
            Log.d(TAG, "onCreate: 시작");


//        달력선택
        btnSelectedDate= (Button)findViewById(R.id.button141);
        display= (TextView) findViewById(R.id.text141);

//        타임피커

        // 타임피커 초기화
        timePicker1 = findViewById(R.id.timePicker1);
        text142 = findViewById(R.id.text142);
        button142 = findViewById(R.id.button142);

            Log.d(TAG, "현재 SDK_INT: " + Build.VERSION.SDK_INT);
            Log.d(TAG, "M 버전 코드 (Android 6.0): " + Build.VERSION_CODES.M);

            if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            Log.d(TAG,"타임피커 시작.");
//            timePicker1 =findViewById(R.id.timePicker1);
            final Calendar c =Calendar.getInstance();
            int mHour = c.get(Calendar.HOUR_OF_DAY);
            int mMinute =c.get(Calendar.MINUTE);
            timePicker1.setHour(mHour);
            timePicker1.setMinute(mMinute);

        }
//        button142= findViewById(R.id.button142);
        button142.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
                    Log.d(TAG,"onClick진입");
//                    text142= findViewById(R.id.text142);
                    int mHour=timePicker1.getHour();
                    int mMinute = timePicker1.getMinute();
                    text142.setText("[time]"+mHour+":"+mMinute);

                }
            }
        });

    }

    //alert Dialog
    public void mOnClick14(View v){
        //this :액티비티 (context객체를 상속하고 있음)
        AlertDialog.Builder bld = new AlertDialog.Builder(this);
        bld.setTitle("MESSAGe");
        bld.setMessage("ALertDialog Test is success");
        bld.setIcon(R.mipmap.ic_launcher);
        bld.setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        bld.show();
    }

    public void mOnClick141(View v){
        if(v==btnSelectedDate){
            final Calendar c= Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth= c.get(Calendar.MONTH);
            int mDay= c.get(Calendar.DAY_OF_MONTH);
            datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){
                //ok버튼을 눌렀을떄 호출됨.
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                    display.setText(dayOfMonth+ "/ "+ (monthOfYear+1)+ "/"+ year);
                }

            },mYear,mMonth,mDay
            );
            datePickerDialog.show();
        }
    }





}
