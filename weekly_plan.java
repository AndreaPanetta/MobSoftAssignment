package com.example.soc7.myapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class weekly_plan extends ListActivity
{
    private static Button goBack;

    String[] DayOfWeek = {"Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, DayOfWeek));

        goBack();
    }

    public void goBack()
    {
        goBack = (Button)findViewById(R.id.back3);

        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(weekly_plan.this, Generator.class);
                startActivity(intent);
            }
        });

    }
}