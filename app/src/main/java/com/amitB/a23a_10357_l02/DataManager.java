package com.amitB.a23a_10357_l02;

import java.util.ArrayList;

public class DataManager {

    public static ArrayList<Country> getCountries(){
        ArrayList<Country> countries = new ArrayList<>();
        for (int i = 0; i< names.length; i++){
            Country c = new Country()
                    .setName(names[i])
                    .setImageRes(flags[i]);
            countries.add(c);
        }
        return countries;
    }

    public static ArrayList<Question> getQuestions(){
        ArrayList<Question> questions = new ArrayList<>();
        for (int i = 0; i< names.length; i++){
            ArrayList<String> options = new ArrayList<>();
            options.add(names[(i)%names.length]);
            options.add(names[(i+1)%names.length]);
            options.add(names[(i+2)%names.length]);
            options.add(names[(i+3)%names.length]);
            Question q = new Question()
                    .setAnswer(names[i])
                    .setImageRes(flags[i])
                    .setOptions(options);
            questions.add(q);
        }
        return questions;
    }

    private static int[] flags = new int[]{
            R.drawable.img_australia,
            R.drawable.img_belarus,
            R.drawable.img_china,
            R.drawable.img_cuba,
            R.drawable.img_european_union,
            R.drawable.img_iraq,
            R.drawable.img_israel,
            R.drawable.img_kazakhstan,
            R.drawable.img_new_zealand,
            R.drawable.img_north_korea,
            R.drawable.img_southkorea,
            R.drawable.img_uk
    };
    private static String[] names = new String[]{
            "Australia",
            "Belarus",
            "China",
            "Cuba",
            "European Union",
            "Iraq",
            "Israel",
            "Kazakhstan",
            "New Zealand",
            "North Korea",
            "South Korea",
            "United Kingdom"
    };
}
