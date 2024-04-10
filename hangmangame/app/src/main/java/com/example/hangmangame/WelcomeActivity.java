package com.example.hangmangame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.hangmangame.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    private ActivityWelcomeBinding splashBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        splashBinding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(splashBinding.getRoot());

        Animation hangAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.abc_slide_in_top);
        splashBinding.textViewHang.startAnimation(hangAnimation);

        Animation manAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.abc_tooltip_enter);
        splashBinding.textViewMan.startAnimation(manAnimation);

        Animation gameAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.abc_slide_in_bottom);
        splashBinding.textViewGame.startAnimation(gameAnimation);

        Handler handler = new Handler(Looper.getMainLooper());

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}
