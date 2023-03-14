package com.android.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.recipeapp.models.User;
import com.android.recipeapp.utils.Utils;

import java.util.List;

public class AuthActivity extends AppCompatActivity
{

    //declaring buttons
    private Button button; //kitchenware button
    private Button button5;// pantry essentials button

    //user credentials and specific actions perequisites
    public Button signinBtn, registerBtn;
    public EditText usernameEt, passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        button= findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                opneToolsActivity();
            }
        });

        button5= findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openEssentials();
            }
        });

        signinBtn = findViewById(R.id.main_btn_signin);
        registerBtn = findViewById(R.id.main_btn_register);

        usernameEt = findViewById(R.id.main_et_username);
        passwordEt = findViewById(R.id.main_et_password);

        signinBtn.setText("User Signin");
        signinBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //checking to see if there is actual info being added to the fields
                //if not, an error message will appear
                if(Utils.isEmpty(usernameEt) || Utils.isEmpty(passwordEt))
                {
                    Utils.showToast(AuthActivity.this, "Some fields are empty");
                }
                else
                {
                    //checking to see if the credentials are existent in the db
                    DbHelper dbHelper = new DbHelper(AuthActivity.this);
                    List<User> users = dbHelper.getAllUsers(dbHelper);
                    boolean isValidUser = false;
                    for(User user: users)
                    {
                        if(user.username.equals(usernameEt.getText().toString()) &&
                                user.password.equals(passwordEt.getText().toString()))
                        {
                            isValidUser=true;
                        }
                    }

                    if(isValidUser)
                    //if the credentials check out, the main activity starts, i.e. being able to search for a recipe.
                    {
                        startActivity(new Intent(AuthActivity.this, MainActivity.class));
                    }
                    else
                    {
                        //if the credentials don't match any db info, an error will appear
                        Utils.showToast(AuthActivity.this, "Invalid credentials");
                    }
                }
            }
        });

        //implementation of the register button, that adds the inserted
        //user credentials to a cache sqllite db
        registerBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //checking to see if there is actual info being added to the fields
                //if not, an error message will appear
                if(Utils.isEmpty(usernameEt) || Utils.isEmpty(passwordEt))
                {
                    Utils.showToast(AuthActivity.this, "Some fields are empty");
                }
                else
                {
                    //adding a new user to the cache db
                    DbHelper dbHelper = new DbHelper(AuthActivity.this);
                    long id = dbHelper.addUser(dbHelper, new User(usernameEt.getText().toString(), passwordEt.getText().toString()));
                    if(id>0)
                    {
                        Utils.showToast(AuthActivity.this, "User registered successfully");
                        usernameEt.setText("");
                        passwordEt.setText("");
                    }

                    //if the credential is already taken, the user must know they need to choose another nick
                    else
                    {
                        Utils.showToast(AuthActivity.this, "username taken already");
                    }
                }
            }
        });
    }

    // methods actionating the buttons which lead to kitchenware and essentials activities
    public void opneToolsActivity()
    {
        Intent intent= new Intent(this, ToolsActivity.class);
        startActivity(intent);
    }

    public void openEssentials(){

        Intent intent= new Intent(this, Ingredients.class);
        startActivity(intent);
    }
}