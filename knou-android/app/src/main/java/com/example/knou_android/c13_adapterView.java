package com.example.knou_android;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class c13_adapterView extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c13_adapter_view);
        ArrayList<String> arGeneral = new ArrayList<String>();
        arGeneral.add("apple");
        arGeneral.add("banana");
        arGeneral.add("orange");
        arGeneral.add("mango");

        ArrayAdapter<String> adapter;
//어댑터를 하나 만들어서 거기에 데이터(Array)를 담아서  ListView에 붙여준다.
        // (this :메인엑티비티 , 하나만선택하는 체크형태 , 데이터들)
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arGeneral);
        ListView list = (ListView) findViewById(R.id.list13);
//        list.setAdapter(adapter);

//sol-2 values/arrays에서 가져와서 뿌려주기
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.programming_languages, android.R.layout.simple_list_item_multiple_choice);
        list.setAdapter(adapter2);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setDivider(new ColorDrawable(Color.BLUE));
        list.setDividerHeight(5);

    }

}
