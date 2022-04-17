package com.example.causcasianhistory;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private static String clickedButton;

    ImageButton battlesButton;
    ImageButton personsButton;
    ImageButton ethnosesButton;
    ImageButton statesButton;
    ImageButton locationsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        battlesButton = (ImageButton) findViewById(R.id.battlesButton);
        battlesButton.setOnClickListener(this);

        personsButton = (ImageButton) findViewById(R.id.personsButton);
        personsButton.setOnClickListener(this);

        ethnosesButton = (ImageButton) findViewById(R.id.ethnosesButton);
        ethnosesButton.setOnClickListener(this);

        statesButton = (ImageButton) findViewById(R.id.statesButton);
        statesButton.setOnClickListener(this);

        locationsButton = (ImageButton) findViewById(R.id.locationsButton);
        locationsButton.setOnClickListener(this);
    }

    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, ReviewActivity.class);
        switch (v.getId()) {
            case R.id.battlesButton:
                startActivity(intent);
                ReviewActivity.getArray(getResources().getStringArray(R.array.ivents), getResources().getStringArray(R.array.ivents_title), ImageArrays.iventImages);
                break;
            case R.id.personsButton:
//                clickedButton = "persons";
                startActivity(intent);
                ReviewActivity.getArray(getResources().getStringArray(R.array.persons), getResources().getStringArray(R.array.persons_title), ImageArrays.personImages);
                break;
            case R.id.ethnosesButton:
                startActivity(intent);
                ReviewActivity.getArray(getResources().getStringArray(R.array.ethnoses), getResources().getStringArray(R.array.ethnoses_title), ImageArrays.ethnoImages);
                break;
            case R.id.statesButton:
                startActivity(intent);
                ReviewActivity.getArray(getResources().getStringArray(R.array.states), getResources().getStringArray(R.array.states_title), ImageArrays.stateImages);
                break;
            case R.id.locationsButton:
                startActivity(intent);
                ReviewActivity.getArray(getResources().getStringArray(R.array.cities), getResources().getStringArray(R.array.cities_title), ImageArrays.cityImages);
                break;
        }
    }

//    public static String getClickedButton() {
//        return clickedButton;
//    }
}