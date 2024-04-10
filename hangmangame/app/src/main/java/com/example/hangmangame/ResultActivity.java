package com.example.hangmangame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.hangmangame.databinding.ActivityWelcomeBinding;

public class ResultActivity extends AppCompatActivity {

    private ActivityResultBinding resultBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        resultBinding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(resultBinding.getRoot());

        int score = getIntent().getIntExtra("score", 0);
        if (score != 0) {
            resultBinding.textViewScore.setText("score : " + score);
        } else {
            resultBinding.textViewScore.setVisibility(View.GONE);
            resultBinding.imageViewResult.setImageResource(R.drawable.loser);
        }

        resultBinding.buttonStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        resultBinding.buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
