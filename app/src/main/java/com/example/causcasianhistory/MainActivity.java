package com.example.causcasianhistory;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

import com.example.causcasianhistory.ReviewActivity;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private static String clickedButton;

    ImageButton battlesButton;
    ImageButton personsButton;
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

        statesButton = (ImageButton) findViewById(R.id.statesButton);
        statesButton.setOnClickListener(this);

        locationsButton = (ImageButton) findViewById(R.id.locationsButton);
        locationsButton.setOnClickListener(this);
    }

    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, ReviewActivity.class);
        switch (v.getId()) {
            case R.id.battlesButton:
                System.out.println("TAP");
                startActivity(intent);
                String[] battleArray = getResources().getStringArray(R.array.battles);
                break;
            case R.id.personsButton:
                System.out.println("TIP");
                clickedButton = "persons";
                startActivity(intent);
                break;
            case R.id.statesButton:
                System.out.println("TUP");
                startActivity(intent);
                break;
            case R.id.locationsButton:
                System.out.println("TEP");
                startActivity(intent);
                break;
        }
    }

    public static String getClickedButton() {
        return clickedButton;
    }
}