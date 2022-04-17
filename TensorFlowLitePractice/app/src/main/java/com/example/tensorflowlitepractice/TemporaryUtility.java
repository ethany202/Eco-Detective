package com.example.tensorflowlitepractice;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TemporaryUtility {

    public static HashSet<String> recycables = new HashSet<String>(){{
        add("PAPER");
        add("CARDBOARD");
        add("CAN");
        add("CARTON");
        add("BOTTLE");
    }};

    public static HashSet<String> compostables = new HashSet<String>(){{
        add("PAPER");
        add("CARDBOARD");
    }};

    public static HashSet<String> veggies = new HashSet<String>(){{
        add("CAULIFLOWER");
        add("ZUCCHINI");
        add("CUCUMBER");
        add("BROCCOLI");
    }};

    public static HashSet<String> fruits = new HashSet<String>(){{
        add("APPLE");
        add("BANANA");
        add("ORANGE");
        add("LEMON");
        add("STRAWBERRY");
;    }};

    public static HashSet<String> currentRecyclables = new HashSet<String>();
    public static HashSet<String> currentCompostables = new HashSet<String>();

    public static int recycableCount=1;
    public static int compostableCount=1;

    public static String currentObject;

}
