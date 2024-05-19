package com.example.knou_android;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class c12_1_mainActivity extends AppCompatActivity implements c12_1_fragmentBottom.BottomListener {
    c12_1_fragmentTop top;
    c12_1_fragmentBottom bottom;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c12_1_activity_main);
        top = new c12_1_fragmentTop();
        bottom =new c12_1_fragmentBottom();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.TopFrame,top)
                .replace(R.id.BottomFrame,bottom)
                .commit();
    }


    @Override
    public void BottomSeneder(CharSequence input) {
        top.setText(input);

    }
}
