package com.example.knou_android;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class c10_timer extends AppCompatActivity {
    int value = 0;
    TextView mText;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c10_event);
        mText = (TextView) findViewById(R.id.text10);
        mHandler.sendEmptyMessage(0);
    }

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            value++;
            mText.setText("Timer Value = " + value);
            mHandler.sendEmptyMessageDelayed(0, 1000);
        }

    };

}
