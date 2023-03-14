package com.android.recipeapp;

public class Recipe
{
    //fields needed to use the mealdb api
    public String idMeal, title, category, type, instructions, imgUrl, tags;

    public Recipe(String idMeal, String title, String category, String type, String instructions, String imgUrl, String tags)
    {
        this.idMeal = idMeal;
        this.title = title;
        this.category = category;
        this.type = type;
        this.instructions = instructions;
        this.imgUrl = imgUrl;
        this.tags = tags;
    }

    public Recipe()
    {

    }
}


