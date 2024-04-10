package com.example.hangmangame;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageViewHangman;
    private Button buttonHint;
    private Button floatingActionButton;
    private List<Button> buttonList = new ArrayList<>();
    private String question = "";
    private String hint = "";
    private String questionView = "";
    private List<Integer> imageList = new ArrayList<>();
    private int imageNumber = 0;
    private int score = 0;
    private GradientDrawable shapeDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        imageViewHangman = findViewById(R.id.imageView_hangman);
        buttonHint = findViewById(R.id.buttonHint);
        floatingActionButton = findViewById(R.id.floatingActionButton);

        imageList.add(R.drawable.image1);
        imageList.add(R.drawable.image2);
        imageList.add(R.drawable.image3);
        imageList.add(R.drawable.image4);
        imageList.add(R.drawable.image5);
        imageList.add(R.drawable.image6);
        imageList.add(R.drawable.image7);

        buttonList.add(findViewById(R.id.buttonA));
        buttonList.add(findViewById(R.id.buttonB));
        buttonList.add(findViewById(R.id.buttonC));
        buttonList.add(findViewById(R.id.buttonD));
        buttonList.add(findViewById(R.id.buttonE));
        buttonList.add(findViewById(R.id.buttonF));
        buttonList.add(findViewById(R.id.buttonG));
        buttonList.add(findViewById(R.id.buttonH));
        buttonList.add(findViewById(R.id.buttonI));
        buttonList.add(findViewById(R.id.buttonJ));
        buttonList.add(findViewById(R.id.buttonK));
        buttonList.add(findViewById(R.id.buttonL));
        buttonList.add(findViewById(R.id.buttonM));
        buttonList.add(findViewById(R.id.buttonN));
        buttonList.add(findViewById(R.id.buttonO));
        buttonList.add(findViewById(R.id.buttonP));
        buttonList.add(findViewById(R.id.buttonQ));
        buttonList.add(findViewById(R.id.buttonR));
        buttonList.add(findViewById(R.id.buttonS));
        buttonList.add(findViewById(R.id.buttonT));
        buttonList.add(findViewById(R.id.buttonU));
        buttonList.add(findViewById(R.id.buttonV));
        buttonList.add(findViewById(R.id.buttonW));
        buttonList.add(findViewById(R.id.buttonX));
        buttonList.add(findViewById(R.id.buttonY));
        buttonList.add(findViewById(R.id.buttonZ));

        startGame();

        for (Button button : buttonList) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    buttonClick(button, button.getText().toString());
                }
            });
        }

        buttonHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHintDialog();
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHowToPlayDialog();
            }
        });
    }

    private void startGame() {
        imageNumber = 0;
        imageViewHangman.setImageResource(R.drawable.hangman_default);
        textView.setText("");
        int lengthOfDictionary = WordData.getHangmanDictionaryLength();
        int questionNumber = new Random().nextInt(lengthOfDictionary);
        question = WordData.getHangmanList().get(questionNumber).getKey().toUpperCase();
        hint = WordData.getHangmanList().get(questionNumber).getValue();
        for (int i = 0; i < question.length(); i++) {
            if (question.charAt(i) != ' ') {
                questionView += '_';
            } else {
                questionView += ' ';
            }
        }
        for (Button button : buttonList) {
            button.setClickable(true);
            shapeDrawable = (GradientDrawable) button.getBackground();
            shapeDrawable.setColor(Color.GRAY);
        }
        textView.setText(questionView);
    }

    private void buttonClick(Button button, String letter) {
        shapeDrawable = (GradientDrawable) button.getBackground();
        shapeDrawable.setColor(getResources().getColor(R.color.colorPrimary));

        button.setClickable(false);

        if (question.contains(letter)) {
            for (int indexOfLetter = 0; indexOfLetter < question.length(); indexOfLetter++) {
                if (question.charAt(indexOfLetter) == letter.charAt(0)) {
                    questionView = replaceCharAtIndex(questionView, indexOfLetter, letter.charAt(0));
                }
            }
            textView.setText(questionView);
            if (!questionView.contains("_")) {
                score++;
                questionView = "";
                showAlertDialog();
            }
        } else {
            if (imageNumber < 6) {
                imageViewHangman.setImageResource(imageList.get(imageNumber));
                imageNumber++;
            } else {
                imageViewHangman.setImageResource(imageList.get(6));
                moveToResultActivity();
            }
        }
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Correct !")
                .setMessage(question + " is the right answer")
                .setIcon(R.drawable.alert_icon)
                .setNegativeButton("Results", (dialogInterface, i) -> moveToResultActivity())
                .setPositiveButton("One More", (dialogInterface, i) -> startGame());
        alertDialog.create().show();
    }

    private void moveToResultActivity() {
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }

    private void showHintDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Hint")
                .setMessage(hint)
                .setIcon(R.drawable.hint_icon)
                .setPositiveButton("Ok", (dialogInterface, i) -> {
                });
        alertDialog.create().show();
    }

    private void showHowToPlayDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("How To Play")
                .setIcon(R.drawable.how_to_play)
                .setPositiveButton("Got it", (dialogInterface, i) -> {
                });
        View customDialogLayout = getLayoutInflater().inflate(R.layout.dialog_box, null);
        alertDialog.setView(customDialogLayout);
        alertDialog.create().show();
    }

    private String replaceCharAtIndex(String question, int indexOfLetter, char letter) {
        StringBuilder stringBuilder = new StringBuilder(question);
        stringBuilder.setCharAt(indexOfLetter, letter);
        return stringBuilder.toString();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveToResultActivity();
    }
}
