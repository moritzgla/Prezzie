package com.example.prezziemobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.prezziemobile.R;

public class StartActivity extends AppCompatActivity {

    private ImageView animatedArrow;
    private TextView animatedText;
    float x1, x2, y1, y2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start2);



        animatedArrow = findViewById(R.id.imageView3);
        animatedText = findViewById(R.id.textView);

        YoYo.with(Techniques.FadeIn)
                .duration(2500)
                .repeat(100)
                .playOn(animatedArrow);
        YoYo.with(Techniques.FadeIn)
                .duration(2500)
                .repeat(1000)
                .playOn(animatedText);
    }


    public boolean onTouchEvent(MotionEvent touchevent){
        SharedPreferences loginpref = getSharedPreferences("logintesting", Context.MODE_PRIVATE);

        switch (touchevent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                if(y2<y1){
                    if(loginpref.contains("isLoggedIn")){
                        Intent i = new Intent(StartActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                    else{
                        Intent i = new Intent(StartActivity.this, LoginActivity.class);
                        startActivity(i);
                    }

                }
                break;
        } return false;
    }
}
