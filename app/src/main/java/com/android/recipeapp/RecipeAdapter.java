package com.android.recipeapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecipeAdapter extends ArrayAdapter<Recipe>
{
    Context context;
    public RecipeAdapter(Context context, ArrayList<Recipe> recipes)
    {
        super(context, 0, recipes);
        this.context = context;
    }

    @Override
    //method which enables the app to store and display the api information we want to see
    public View getView(int position, View convertView, ViewGroup parent)
    {
        //enabling the
        Recipe recipe = getItem(position);
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.recipe_viewholder, parent, false);
        }

        ImageView recipeIv =  convertView.findViewById(R.id.reci_iv_img);
        TextView titleTv =  convertView.findViewById(R.id.reci_tv_title);
        TextView detailTv =  convertView.findViewById(R.id.reci_tv_details);
        Glide.with(context).load(recipe.imgUrl).into(recipeIv);
        titleTv.setText(recipe.title);
        detailTv.setText("RECIPE ID: "+ recipe.idMeal + "\nCATEGORIES: "+recipe.category +"\nTYPE: " + recipe.type+
                "\nTAGS: " + recipe.tags +
                "\nINSTRUCTIONS: " + recipe.instructions);

        return convertView;
    }
}