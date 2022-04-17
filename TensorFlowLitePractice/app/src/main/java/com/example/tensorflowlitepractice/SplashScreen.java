package com.example.tensorflowlitepractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    // Delay
    private static int DELAY = 5000;

    // Fields
    Animation fadeIn, fadeOut;
    TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);

        logo = findViewById(R.id.logo);
        logo.setAnimation(fadeIn);

        new Handler().postDelayed(new Runnable() {      // Adds a 2.5 second delay between when Logo starts to fade in and fade out
            @Override
            public void run() {
                logo.setAnimation(fadeOut);
            }
        }, 2500);

        new Handler().postDelayed(new Runnable() {      // Adds a DELAY millisecond delay between Splash Screen and Main Page opening
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, DELAY);
    }
}