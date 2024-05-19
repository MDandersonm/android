package com.example.knou_android;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

// 콜백메서드가 자동적으로 fragment가만들어지면 자동으로 onCreateView가 실행됨\
// inflater: 화면에 뿌려주는 클래스   container: 프레임레이아웃 Bundle : 여러가지 정보들 다 넣어서 관리.

public class c12_1_fragmentBottom extends Fragment {
    public interface BottomListener{
        void BottomSeneder(CharSequence input); // 구현은 main activity가 해줌.
    }
    private BottomListener listener;
    private EditText editText;
    private Button sendButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle saveInstanceState){
        View v= inflater.inflate(R.layout.c12_1_fragment_bottom,container,false);
        editText = v.findViewById(R.id.edit_text121);
        sendButton= v.findViewById(R.id.btn_send);
        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                CharSequence input = editText.getText();
                listener.BottomSeneder(input); // -> mainActivity가 구현
            }
        });
        return v;
    }

//    Bottom프래그먼트가 메인엑티비티에서 호출이되면 혹은 선언이되면 onAttach 실행됨
//    onAttach는 프래그먼트가 액티비티에서 선언될때 호출되는 메서드이다.
    @Override
    public void onAttach(Context context){//context는 main액티비티
        super.onAttach(context);
        if(context instanceof BottomListener){//main엑티비티는 인스턴스를 상속받으니까. true
            listener = (BottomListener) context;
        }
        else{
            throw new RuntimeException(context.toString()+ " must implement FragmentBListener");
        }

    }
    @Override
    public void onDetach(){
        super.onDetach();
        listener = null;
    }





}
