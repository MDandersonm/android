package com.example.knou_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class c10_button extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c10_event);

        //10강 위젯 이벤트 버튼 구현
        Button btnGood = (Button) findViewById(R.id.good);
        btnGood.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                TextView textPoll = (TextView) findViewById(R.id.question);
                    textPoll.setText("GOOD@ !");
            }
        });
        Button btnBad = (Button) findViewById(R.id.bad);
        btnBad.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                TextView textPoll = (TextView) findViewById(R.id.question);
                textPoll.setText("BAD@ T,T");
            }
        });
    }




}
