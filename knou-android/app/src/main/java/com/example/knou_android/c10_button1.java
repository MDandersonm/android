package com.example.knou_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class c10_button1 extends AppCompatActivity implements View.OnClickListener {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c10_event);

        //10강 위젯 이벤트 버튼 구현
        Button btnGood = (Button) findViewById(R.id.good);
        btnGood.setOnClickListener(this);
        Button btnBad = (Button) findViewById(R.id.bad);
        btnBad.setOnClickListener(this);
    }

    public void onClick(View v) {
        TextView textPoll = (TextView) findViewById(R.id.question);
        if (v.getId() == R.id.good) {
            textPoll.setText("GOOD !");
        } else if (v.getId() == R.id.bad) {
            textPoll.setText("bad T.T");
        }
    }


}
