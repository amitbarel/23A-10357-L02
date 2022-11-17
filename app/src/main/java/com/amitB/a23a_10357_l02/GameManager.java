package com.amitB.a23a_10357_l02;

import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

import java.util.ArrayList;

public class GameManager {

    private int score = 0;
    private int index = 0;
    private int wrong = 0;
    private int life;

    private ArrayList<Country> countries;
    private ArrayList<Question> questions;

    public GameManager(int life) {
        this.life = life;
        countries = DataManager.getCountries();
        questions = DataManager.getQuestions();
    }

    private Country current(){
        return countries.get(index);
    }

    private Question currentQuestion(){ return questions.get(index);}

    public String getOption(int i){
        return currentQuestion().getOptions().get(i);
    }

    public int getScore() {
        return score;
    }

    public int getCurrentFlag() {
        return current().getImageRes();
    }

    public int getWrong() {
        return wrong;
    }

    public boolean isGameEnded(){
        return index == countries.size();
    }

    public boolean isLose(){
        return life == wrong;
    }

    public void checkAnswer(String answer, Vibrator v){
        if(answer.equals(currentQuestion().getAnswer())){
            score += 10;
        }
        else {
            wrong++;
            //Vibrate for 500 milliseconds
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                v.vibrate(VibrationEffect.createOneShot(500,VibrationEffect.DEFAULT_AMPLITUDE));
            }else{
                v.vibrate(500);
            }
        }

        index++;
    }
}
