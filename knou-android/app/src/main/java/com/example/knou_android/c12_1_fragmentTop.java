package com.example.knou_android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

// 콜백메서드가 자동적으로 fragment가만들어지면 자동으로 onCreateView가 실행됨\
// inflater: 화면에 뿌려주는 클래스   container: 프레임레이아웃 Bundle : 여러가지 정보들 다 넣어서 관리.
public class c12_1_fragmentTop extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        return inflater.inflate(R.layout.c12_1_fragment_top,container,false);
        //inflate : 화면에 구현해주는 역할
    }
    public void setText(CharSequence text){
        TextView tv = (TextView)getView().findViewById(R.id.textView1211);
        tv.setText(text);
    }

}
