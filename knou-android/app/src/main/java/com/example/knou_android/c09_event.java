package com.example.knou_android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
//그림판  직선 그리기
public class c09_event extends AppCompatActivity {
    private MyView vw;
    public class Vertex{
        float x;
        float y;
        boolean Draw;
        Vertex(float ax, float ay, boolean ad){
            x=ax;
            y=ay;
            Draw=ad;
        }
    }
    ArrayList<Vertex> arVertex;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vw= new MyView(this);
        setContentView(vw);
        arVertex = new ArrayList<Vertex>();

//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

    }

    protected class MyView extends View {
        Paint pnt;
        public MyView(Context context){
            super(context);
            pnt=new Paint();
            pnt.setColor(Color.BLUE);
            pnt.setStrokeWidth(3);
            pnt.setAntiAlias(true);
        }
        public void onDraw(Canvas canvas){
            int i;
            canvas.drawColor(Color.LTGRAY);
            for(i=0; i< arVertex.size(); i++){
                if(arVertex.get(i).Draw){//draw가  true면
                    canvas.drawLine(arVertex.get(i-1).x, arVertex.get(i-1).y, arVertex.get(i).x, arVertex.get(i).y ,pnt);
                }
            }

        }

        public boolean onTouchEvent(MotionEvent event){
            if(event.getAction()== MotionEvent.ACTION_DOWN){//touch하기 시작했을때 화면에 닿는 순간.
                arVertex.add(new Vertex(event.getX(), event.getY(),false));
                return true;

            }
            if(event.getAction()== MotionEvent.ACTION_MOVE){//움직인거
                arVertex.add(new Vertex(event.getX(), event.getY(),true));
                invalidate();
                //invalidate()를 호출하면 안드로이드 시스템은 View의 onDraw() 메소드를 다시 호출하여 뷰를 갱신하도록 스케줄링합니다.
                return true;

            }
            return false;
        }
    }
}
