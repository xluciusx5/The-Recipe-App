package com.android.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ToolsActivity extends AppCompatActivity
{
    //implementation of the back button on the kitchenware page, which leads the user back to the auth page
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        button2= findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                backToLogin();
            }
        });
    }

    public void backToLogin()
    {
        Intent intent= new Intent(this, AuthActivity.class);
        startActivity(intent);
    }
}


