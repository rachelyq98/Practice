package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * sendMessage does something in response to the button
     * @param view
     */
    public void sendMessage (View view){
        Intent intent = new Intent (this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText2);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void goToRecycler (View view){
        Intent intent = new Intent (this, DisplayRecyclerActivity.class);
        startActivity (intent);
    }

    public void goToWebApi (View view){
        Intent intent = new Intent(this, WebAPIActivity.class);
        TextView txtView = (TextView) findViewById(R.id.webInfo);
        startActivity (intent);
    }

    public void displayNames (View view){
        Intent intent = new Intent(this, DisplayFinalActivity.class);
        startActivity (intent);
    }
}
