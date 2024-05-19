package com.example.knou_android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class c11_mainactivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c11_activity_main);
        Button callBtn =(Button) findViewById(R.id.callBtn);
        callBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                EditText telText = (EditText) findViewById(R.id.telText);
                Intent intent =new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+telText.getText()));
                startActivity(intent);
            }
        });
    }
    public void mOnClick(View v){
      Intent intent= new Intent(this,c11_subactivity.class);
      startActivity(intent);
    }

}
