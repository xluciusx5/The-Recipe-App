package com.android.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ingredients extends AppCompatActivity
{

    //declaring the back button, which leads back to the auth activity
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        buttonBack= findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener()
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


//one doesn't need to be signed in in order to see the kitchenware and essentials pages