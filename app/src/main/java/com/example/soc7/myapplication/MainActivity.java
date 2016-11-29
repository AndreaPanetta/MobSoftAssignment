/**
 ************************************************************************************************
 * Name: Andrea Panetta
 * Student No: C13312461
 * Description: Main Activity - This consists of the Login Screen where you have the option of
 *                              Logging in or Registering your details. With the use of SQLite
 *                              I was able to create a database for the user details and access
 *                              it with the Login details. When Registering, you should be able
 *                              to enter your details
 ************************************************************************************************
 */

package com.example.soc7.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.soc7.myapplication.R;

public class MainActivity extends Activity
{

    /* Declare/Initialize Variables and layout elements/buttons */
    private static EditText user;
    private static EditText password;
    String username,pass;
    private static Button login;
    private static Button register;
    Context CTX = this;
    int status = 0;

    /*Any classes are created here, in this instance the login class is created*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login();
    }

    /*Login class is called*/
    public void Login()
    {
        user = (EditText)findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
        login = (Button)findViewById(R.id.button1);
        register = (Button)findViewById(R.id.button2);

        /*When the login button is clicked, this method is called */
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                status =1;
                Bundle b = new Bundle();
                b.putInt("status", status);

                /*If the user details entered are correct, the user is Welcomed*/
                if(status ==1)
                {
                    Toast.makeText(getApplicationContext(),"Please Wait..", Toast.LENGTH_SHORT).show();
                    username = user.getText().toString();
                    pass = password.getText().toString();
                    DatabaseOp DOP = new DatabaseOp(CTX);
                    Cursor CR = DOP.getInformation(DOP);
                    CR.moveToFirst();

                    /*User login first declared as false, if login correct then boolean changes to true*/
                    boolean loginstatus = false;
                    String NAME = "";
                    do
                    {
                        if(username.equals(CR.getString(0)) && (pass.equals(CR.getString(1))))
                        {
                            loginstatus = true;
                            NAME = CR.getString(0);
                        }
                    }while(CR.moveToNext());
                    /*When the login is sucessfull, it brings you to the Generator page*/
                    if(loginstatus)
                    {
                        Toast.makeText(getApplicationContext(),"Login Sucessfull \n Welcome!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Generator.class);
                        intent.putExtras(b);
                        startActivity(intent);

                    }

                    /*Otherwise, the user will be told the Login Failed and be brought to Register instead*/
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Login Failed \n Please Register", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Registration.class);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                }

            }
        });

        register.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
