package com.amitB.a23a_10357_l02;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private GameManager GM;
    private MaterialTextView Score;
    private ArrayList<com.google.android.material.button.MaterialButton> buttons;
    private ShapeableImageView Flag;
    private ShapeableImageView[] Hearts;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        findViews();
        GM = new GameManager(Hearts.length);
        refreshUI();

        Score.setText(score + "");
        initViews();
//        Glide.with(this).load("http://goo.gl/gEgYUd").into();
    }

    private void findViews() {
        Score = findViewById(R.id.game_LBL_Score);
        buttons = new ArrayList<>();
        buttons.add(findViewById(R.id.game_Btn_1));
        buttons.add(findViewById(R.id.game_Btn_2));
        buttons.add(findViewById(R.id.game_Btn_3));
        buttons.add(findViewById(R.id.game_Btn_4));
        Flag = findViewById(R.id.game_IMG_FLAG);
        Hearts = new ShapeableImageView[]{
                findViewById(R.id.game_IMG_heart_1),findViewById(R.id.game_IMG_heart_2),
                findViewById(R.id.game_IMG_heart_3),findViewById(R.id.game_IMG_heart_4)
        };
    }

    private void initViews(){
        buttons.get(0).setOnClickListener(view -> clicked(buttons.get(0).getText().toString()));
        buttons.get(1).setOnClickListener(view -> clicked(buttons.get(1).getText().toString()));
        buttons.get(2).setOnClickListener(view -> clicked(buttons.get(2).getText().toString()));
        buttons.get(3).setOnClickListener(view -> clicked(buttons.get(3).getText().toString()));
    }

    private void clicked(String name){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        GM.checkAnswer(name,v);
        refreshUI();
    }

    private void refreshUI() {
        if (GM.isLose()){
            openScoreScreen("Game Over: ",GM.getScore());
        }
        else if(GM.isGameEnded()){
            openScoreScreen("Winner! ",GM.getScore());
        }
        else{
            Flag.setImageResource(GM.getCurrentFlag());
            int i = 0;
            for (Button button : buttons) {
                button.setText(GM.getOption(i));
                i++;
            }
            Score.setText("" + GM.getScore());
            if (GM.getWrong() != 0){
                Hearts[Hearts.length-GM.getWrong()].setVisibility(View.INVISIBLE);
            }
        }
    }

    private void openScoreScreen(String status, int score) {
        Intent scoreIntent = new Intent(this,ScoreActivity.class);
        scoreIntent.putExtra(ScoreActivity.KEY_SCORE,score);
        scoreIntent.putExtra(ScoreActivity.KEY_STATUS,status);
        startActivity(scoreIntent);
        finish();
    }

}