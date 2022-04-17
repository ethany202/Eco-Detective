package com.example.tensorflowlitepractice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class ObjectDescription extends Activity {

    public ImageView image;
    public TextView text;

    private String str_plastic, str_can, str_card, str_cart, str_fruit, str_vegetable, str_paper, str_glass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descriptions);

        image = findViewById(R.id.object);
        text = findViewById(R.id.description);

        description();

        switch (TemporaryUtility.currentObject) {
            case "BOTTLE":
                image.setImageResource(R.drawable.bottle);
                text.setText(str_plastic);
                break;
            case "CAN":
                image.setImageResource(R.drawable.can);
                text.setText(str_can);
                break;
            case "CARDBOARD":
                image.setImageResource(R.drawable.cardboard);
                text.setText(str_card);
                break;
            case "CARTON":
                image.setImageResource(R.drawable.carton);
                text.setText(str_cart);
                break;
            case "PAPER":
                image.setImageResource(R.drawable.paper);
                text.setText(str_paper);
                break;
            case "FRUIT":
                image.setImageResource(R.drawable.fruit);
                text.setText(str_fruit);
                break;
            case "VEGETABLE":
                image.setImageResource(R.drawable.vegetable);
                text.setText(str_vegetable);
                break;
        }
    }

    public void returnToResults(View view) {
        finish();
    }

    public void description() {
        str_plastic = "\tRecycling both glass and plastic bottles conserves natural resources, " +
                "specifically oil. One ton of recycled plastic conserves around 3.8 barrels of crude oil. " +
                "Not only that, recycling bottles decreases air pollution, as there will be less waste to incinerate";
        str_can = "\tRecycling old cans into new ones take 95% less energy than to create one "+
                "Recycling cans also releases 95% fewer greenhouse gas emissions. " +
                "There’s no limit to how many times aluminum can be recycled.";
        str_card = "\tRecycled cardboard has a wide range of uses, like cereal boxes and paper towels. " +
                "In particular, recycling cardboard helps prevent deforestation, ultimately saving many animals’ lives. " +
                "Moreover, recycling cardboard reduces landfills, thus reducing water pollution.";
        str_cart = "\tRecycled cartons are used to make eco-friendly construction material. " +
                "Recycling cartons provides paper feedstock for new paper products. " +
                "Remember to empty out your cartons before recycling!";
        str_paper = "\tRecycling paper reduces greenhouse gasses, helping limit the effects of climate change. " +
                "It takes 70% less energy and water to recycle paper compared to creating new sheets. " +
                "Every ton of recycled paper can save 17 trees.";
        str_fruit = "\tComposting fruits dampens dry materials in compost which accelerates the decomposition process. " +
                "It can enriches soil and suppresses plant diseases. " +
                "Furthermore, it reduces the need for chemical fertilizers.";
        str_vegetable = "\tLike fruits, composting vegetables dampens dry materials in compost which accelerates the decomposition process. " +
                "It can enriches soil and suppresses plant diseases. " +
                "Furthermore, it reduces the need for chemical fertilizers.";
    }
}
