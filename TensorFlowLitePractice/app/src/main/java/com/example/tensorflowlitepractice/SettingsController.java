package com.example.tensorflowlitepractice;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import static android.content.SharedPreferences.*;

public class SettingsController extends AppCompatActivity {

    private EditText recycleText;
    private EditText compostText;

    private SharedPreferences sharedPreferences;

    public static final String SHARED_PREFERENCES_FILE = "com.example.tensorflowlitepractice.preferenceFile";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        recycleText = findViewById(R.id.recycableAmount);
        compostText=findViewById(R.id.compostableAmount);
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_FILE, 0);
        setSavedOptions();
    }

    public void setSavedOptions(){
        recycleText.setText(""+sharedPreferences.getInt("RecycleAmount",1));
        compostText.setText(""+sharedPreferences.getInt("CompostAmount", 1));
    }

    public void saveLocally(View view) {
        String recyclableAmount=recycleText.getText().toString();
        String compostableAmount =compostText.getText().toString();

        if(Integer.parseInt(recyclableAmount)>5){
            recyclableAmount="5";
            recycleText.setText("5");
        }
        if(Integer.parseInt(compostableAmount)>5){
            compostableAmount="5";
            compostText.setText("5");
        }

        Editor edit = sharedPreferences.edit();
        edit.putInt("RecycleAmount", Integer.parseInt(recyclableAmount));
        edit.putInt("CompostAmount", Integer.parseInt(compostableAmount));
        edit.apply();
        finish();
    }
}
