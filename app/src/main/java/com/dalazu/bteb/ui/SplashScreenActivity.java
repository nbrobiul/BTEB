package com.dalazu.bteb.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.airbnb.lottie.LottieAnimationView;
import com.dalazu.bteb.R;

public class SplashScreenActivity extends AppCompatActivity {
    private LottieAnimationView lottieAnimationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        lottieAnimationView = findViewById(R.id.animationView);

        lottieAnimationView.playAnimation();

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                finish();
            }
        }, 3000);
    }
}
