package com.example.tensorflowlitepractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;

public class HandleResults extends Activity {

    public RelativeLayout recyclableLayout;
    public RelativeLayout compostableLayout;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_layout);


        recyclableLayout = findViewById(R.id.recycablesLayout);
        compostableLayout = findViewById(R.id.compostablesLayout);

        recyclableLayout.removeAllViews();
        compostableLayout.removeAllViews();

        populateRecyclables();
        populateCompostables();


    }



    public void populateRecyclables(){
        try{
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(20,20,20,20);
            int previousID = -1;
//            if(TemporaryUtility.currentRecyclables.size()==0) {
//                params.addRule(RelativeLayout.BELOW, R.id.recycablesText);
//                TextView text = new TextView(this);
//                text.setText("No Recyclable Objects Present");
//                text.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
//                text.setLayoutParams(params);
//                recyclableLayout.addView(text);
//            }
            for(String recyclable : TemporaryUtility.currentRecyclables){
                if(previousID==-1){
                    params.addRule(RelativeLayout.BELOW, R.id.recycablesText);
                }
                else{
                    params.addRule(RelativeLayout.BELOW, previousID);
                }
                int viewID = View.generateViewId();
                Button btn = new Button(this);
                btn.setText(recyclable);
                btn.setId(viewID);
                btn.setLayoutParams(params);
                btn.setOnClickListener(this::onClickResult);
                btn.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                recyclableLayout.addView(btn);
                previousID = viewID;
            }
        }
        catch(Exception e){
            Log.e("ERROR", e.toString());
        }
    }

    public void populateCompostables(){
        try{
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(20,20,20,20);
            int previousID = -1;
//            if(TemporaryUtility.currentCompostables.size()==0) {
//                params.addRule(RelativeLayout.BELOW, R.id.compostablesText);
//                TextView text = new TextView(this);
//                text.setText("No Compostable Objects Present");
//                text.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
//                text.setLayoutParams(params);
//                compostableLayout.addView(text);
//            }

            for(String compostable : TemporaryUtility.currentCompostables){
                if(previousID==-1){
                    params.addRule(RelativeLayout.BELOW, R.id.recycablesText);
                }
                else{
                    params.addRule(RelativeLayout.BELOW, previousID);
                }

                int viewID = View.generateViewId();

                Button btn = new Button(this);
                btn.setText(compostable);
                btn.setId(viewID);
                btn.setLayoutParams(params);
                btn.setOnClickListener(this::onClickResult);
                btn.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);
                compostableLayout.addView(btn);

                previousID = viewID;
            }
        }
        catch(Exception e){
            Log.e("ERROR", e.toString());
        }
    }

    public void onClickResult(View view){
        TemporaryUtility.currentObject = ((Button)view).getText().toString();
        Intent intent=new Intent(this, ObjectDescription.class);
        startActivity(intent);
    }

    public void returnHome(View view) {
        finish();
    }
}
