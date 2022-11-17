package com.amitB.a23a_10357_l02;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
    String answer;
    ArrayList<String> options;
    int imageRes;

    public Question(){
    }

    public String getAnswer() {
        return answer;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getImageRes() {
        return imageRes;
    }

    public Question setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public Question setOptions(ArrayList<String> options) {
        Collections.shuffle(options);
        this.options = options;
        return this;
    }

    public Question setImageRes(int imageRes) {
        this.imageRes = imageRes;
        return this;
    }
}
