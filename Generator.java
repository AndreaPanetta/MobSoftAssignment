package com.example.soc7.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Generator extends Activity
{
    private Button generate;
    private RadioGroup coeliacGroup;
    private RadioButton radio_yesButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);

        coeliacGroup=(RadioGroup)findViewById(R.id.coeliac);

        generate=(Button)findViewById(R.id.gen_button);

        generate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                int selectedId = coeliacGroup.getCheckedRadioButtonId();

                radio_yesButton = (RadioButton)findViewById(selectedId);

                Toast.makeText(Generator.this, radio_yesButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_generator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
