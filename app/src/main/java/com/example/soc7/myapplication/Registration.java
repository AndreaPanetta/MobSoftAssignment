/**
 ************************************************************************************************
 * Name: Andrea Panetta
 * Student No: C13312461
 * Description: Registration - When brought to the Register screen, the user enters their details.
 *                             When completed, they are brought to the Generator Screen, where
 *                             they can give any details about their everyday diet.
 ************************************************************************************************
 */

package com.example.soc7.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends Activity
{
    private static Button back;
    private static Button register;
    EditText USER_NAME, USER_PASS, F_NAME, L_NAME, EMAIL, AGE;
    String f_name;
    String l_name;
    String age;
    String email;
    String password;
    String Username;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        F_NAME = (EditText) findViewById(R.id.f_name);
        L_NAME = (EditText) findViewById(R.id.l_name);
        EMAIL = (EditText) findViewById(R.id.email);
        USER_NAME = (EditText) findViewById(R.id.Username);
        USER_PASS = (EditText) findViewById(R.id.password);
        AGE = (EditText) findViewById(R.id.age);

        register = (Button) findViewById(R.id.reg_button);
        back = (Button)findViewById(R.id.back1);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Username = USER_NAME.getText().toString();
                password = USER_PASS.getText().toString();
                f_name = F_NAME.getText().toString();
                l_name = L_NAME.getText().toString();
                email = EMAIL.getText().toString();
                age = AGE.getText().toString();
                Bundle b = new Bundle();

                DatabaseOp DB = new DatabaseOp(ctx);
                DB.insertInformation(DB, Username, password,f_name,l_name, email, age);
                Toast.makeText(getBaseContext(), "Registration sucess", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Registration.this, Generator.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Bundle b = new Bundle();
                Intent intent = new Intent(Registration.this, MainActivity.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registration, menu);
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
