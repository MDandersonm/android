package com.example.knou_android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

class TestView extends View {
    public TestView(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.CYAN);
        Paint Pnt = new Paint();
        Pnt.setColor(Color.RED);
        Pnt.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawRect(120, 100, 320, 500, Pnt);
    }
}

public class MainActivity extends AppCompatActivity {
    SoundPool mPool;
    int mDing;

    AudioManager mAm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //        6강 레이아웃  클릭여부에 따라 그림 보였다가 안보였다가
//        findViewById(R.id.btn061).setOnClickListener(
//                new View.OnClickListener(){
//                    public void onClick(View v){
//                        ImageView img = (ImageView) findViewById(R.id.img1);
//                        if(img.getVisibility()== View.VISIBLE){
//                            img.setVisibility(View.GONE);
//                        }else{
//                            img.setVisibility(View.VISIBLE);
//                        }
//                    }
//                }
//        );

        //8강 캔버스 도형그리기
//        TestView tv= new TestView(this);
//        setContentView(tv);

//       8강 버튼클릭시 Toast, 음원재생 효과
//        findViewById(R.id.shortmsg).setOnClickListener(mClickListener);
//        findViewById(R.id.longmsg).setOnClickListener(mClickListener);
//
//        mPool =new SoundPool(1,AudioManager.STREAM_MUSIC,0);//스트림개수, 스트림타입,음질
//        mDing= mPool.load(this,R.raw.sunny,1);
//        mAm= (AudioManager) getSystemService(AUDIO_SERVICE);
//        findViewById(R.id.beep1).setOnClickListener(mClickListener1);
//        findViewById(R.id.beep2).setOnClickListener(mClickListener1);


        //9강 이벤트1
        //뷰가 이벤트가 발생됐을때 처리하는것까지 겸함
        //
//        View vw = new MyView(this);
//        setContentView(vw);

//        9강 이벤트1
//        이벤트리스너활용
//        View vw = new View(this);
//        vw.setOnTouchListener(TouchListener);
//        setContentView(vw);

//9강 뷰를 통한 이벤트 리스너 구현

        MyView1 vw = new MyView1(this);
        vw.setOnTouchListener(vw);
        setContentView(vw);




        //        EdgeToEdge.enable(this);//이거있으면 상태바 색상적용안됨

//        setContentView(R.layout.c10_event);


////         상태바 및 탐색 바 색상 변경
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            // 상태바 색상 설정
//            window.setStatusBarColor(ContextCompat.getColor(this, R.color.mycolor));
//            // 탐색 바 색상 설정
//            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.mycolor));
//        }
//
//
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main8), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });


    }


    public void onButtonClick(View view) {
        TextView text1 = (TextView) findViewById(R.id.text1);
        int id = view.getId(); // 뷰의 ID를 가져옵니다.
        if (id == R.id.button1) {
            text1.setText("HELLO");
        } else if (id == R.id.button2) {
            text1.setText("WORLD");
        }
    }

    public void onButtonClick1(View view) {
        EditText edit = (EditText) findViewById(R.id.edit1);
        String str = edit.getText().toString();
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }

    public void onButtonClick2(View view) {
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        TextView text2 = (TextView) findViewById(R.id.text2);
//        switch(view.getId()){
//            case R.id.button4:
        if (switch1.isChecked()) {
            text2.setText("Switch On");
        } else {
            text2.setText("Switch OFF");
        }

//        }

    }

    //8강 토스트
    View.OnClickListener mClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            // 로그를 사용하여 버전 정보 출력
            Log.d("VersionInfo", "SDK_INT: " + Build.VERSION.SDK_INT + ", LOLLIPOP: " + Build.VERSION_CODES.LOLLIPOP);
            System.out.println("VersionInfo" + "SDK_INT: " + Build.VERSION.SDK_INT + ", LOLLIPOP: " + Build.VERSION_CODES.LOLLIPOP);
            int id = v.getId(); // 뷰의 ID를 가져옵니다.

            // 첫 번째 if 조건문으로 shortmsg ID를 검사합니다.
            if (id == R.id.shortmsg) {
                Toast.makeText(MainActivity.this, "short Time Message", Toast.LENGTH_SHORT).show();
            }
            // else if 조건문으로 longmsg ID를 검사합니다.
            else if (id == R.id.longmsg) {
                Toast.makeText(MainActivity.this, "long Time Message", Toast.LENGTH_LONG).show();
            }
        }
    };

    //8강 소리재생
    Button.OnClickListener mClickListener1 = new Button.OnClickListener() {
        public void onClick(View v) {
            MediaPlayer player;

            int id = v.getId(); // 뷰의 ID를 가져옵니다.

            if (id == R.id.beep1) {
                mPool.play(mDing, 1, 1, 0, 0, 1);
            } else if (id == R.id.beep2) {
                mAm.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);
            }
        }
    };

    //9강 이벤트1
    class MyView extends View {
        public MyView(Context context) {
            super(context);
        }

        public boolean onTouchEvent(MotionEvent event) {
            super.onTouchEvent(event);
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Toast.makeText(MainActivity.this, "Touch Event Received", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }

    //9강 이벤트1 - 터치 리스너
    class TouchListenerClass implements View.OnTouchListener {
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Toast.makeText(MainActivity.this, "Touch Event Received", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }

    TouchListenerClass TouchListener = new TouchListenerClass();

    //

    class MyView1 extends View implements View.OnTouchListener {
        public MyView1(Context context) {
            super(context);
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                Toast.makeText(MainActivity.this, "Touch Event Received", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }


}
