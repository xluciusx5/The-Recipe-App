package com.android.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private EditText recipeNameEt;
    private ListView recipesLv;
    //api which was chosen to work with
    private String url = "https://www.themealdb.com/api/json/v1/1/search.php";

    private ArrayList<Recipe> recipesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipeNameEt = findViewById(R.id.main_et_recipename);
        recipesLv = findViewById(R.id.main_lv_recipes);

        findViewById(R.id.main_btn_search).setOnClickListener(new View.OnClickListener()
        {
            //getting the recipe name that is going to be inputed by the user and later used to search for it using the api
            @Override
            public void onClick(View view)
            {
                if(isEmpty(recipeNameEt))
                {
                    Toast.makeText(MainActivity.this, "Enter recipe name first", Toast.LENGTH_LONG).show();
                }
                else
                {
                    searchRecipe(recipeNameEt.getText().toString());
                }
            }
        });
    }

    public boolean isEmpty(EditText etText)
    {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }

    //implementation of the seach feature, which enables the user to search using the mealdb api
    public void searchRecipe(String name)
    {
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url+"?s="+name, null, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                recipesList.clear();
                recipesLv.invalidateViews();

                try{
                    //searching for meals
                JSONArray meals = response.getJSONArray("meals");

                for(int i=0; i<meals.length();i++)
                {
                    //getting the categories given by the api's default state
                    JSONObject meal = meals.getJSONObject(i);
                    recipesList.add(new Recipe(meal.getString("idMeal"),
                            meal.getString("strMeal"),
                            meal.getString("strCategory"),
                            meal.getString("strArea"),
                            meal.getString("strInstructions"),
                            meal.getString("strMealThumb"),
                            meal.getString("strTags")));
                }

                    RecipeAdapter adapter = new RecipeAdapter(MainActivity.this, recipesList);
                    recipesLv.setAdapter(adapter);

                } catch (JSONException e)
                {
                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(MainActivity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);
    }
}