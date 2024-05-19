package com.example.knou_android;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class c12_mainActivity extends AppCompatActivity {
    FragmentManager manager;
    FragmentTransaction ft;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c12_activity_main);
        manager = getSupportFragmentManager();//프래그먼트 매니저를 가져옴
        ft = manager.beginTransaction();//
    }

    public void showFragment(View view){
        ft= manager.beginTransaction();
        if(view==findViewById(R.id.button121)){
            c12_fragment1 fr1= new c12_fragment1();
            ft.replace(R.id.fragment_container,fr1);
            ft.commit();
        }else{
            c12_fragment2 fr2= new c12_fragment2();
            ft.replace(R.id.fragment_container,fr2);
            ft.commit();
        }
    }

}
