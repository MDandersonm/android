package com.example.knou_android;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class c13_1_spinner extends AppCompatActivity {
    ArrayAdapter<CharSequence> adspin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c13_1_spinner);
        Spinner spin = (Spinner) findViewById(R.id.spinner13);
        spin.setPrompt("prompt");
        adspin = ArrayAdapter.createFromResource(this, R.array.programming_languages, android.R.layout.simple_spinner_item);
        adspin.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spin.setAdapter(adspin);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(c13_1_spinner.this, adspin.getItem(position), Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

}
