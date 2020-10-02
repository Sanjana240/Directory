package com.example.directory;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 4000;
    private TextView textView;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        textView = findViewById(R.id.mb);
        imageView = findViewById(R.id.proimg);
        Animation myanim = AnimationUtils.loadAnimation(R.anim.mytransition);
        textView.startAnimation(myanim);
        imageView.startAnimation(myanim);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        new Handler().postDelayed(new Runnable(){
            public void run()
            {
                Intent intent = new Intent(MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
