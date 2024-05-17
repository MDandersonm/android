package com.example.knou_android;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

//사각형 움직이기 게임
public class c09_event1 extends AppCompatActivity {
    private MyView vw;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vw = new MyView(this);
        vw.setFocusable(true);
        vw.setFocusableInTouchMode(true);
        setContentView(vw);

//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

    }

    protected class MyView extends View {
        float mX, mY, mR, mL;
        int mColor;

        public MyView(Context context) {
            super(context);
            mX = 500;
            mY = 500;
            mR = 600;
            mL = 600;
            mColor = Color.RED;
        }

        public void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            Paint pnt = new Paint();
            pnt.setColor(mColor);
            pnt.setAntiAlias(true);
            canvas.drawRect(mX, mY, mR, mL, pnt);
        }

        public boolean onKeyDown(int KeyCode, KeyEvent event) {
            super.onKeyDown(KeyCode, event);
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                switch (KeyCode) {
                    case KeyEvent.KEYCODE_DPAD_LEFT:
                        mX -= 5;
                        mR -= 5;
                        invalidate();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_RIGHT:
                        mX += 5;
                        mR += 5;
                        invalidate();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_UP:
                        mY -= 5;
                        mL -= 5;
                        invalidate();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_DOWN:
                        mY += 5;
                        mL += 5;
                        invalidate();
                        return true;


                }
            }
            return false;
        }

        public void setFocusable(boolean b) {

        }

    }
}
