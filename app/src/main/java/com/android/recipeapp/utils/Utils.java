package com.android.recipeapp.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;


public final class Utils
{

    public static void showToast(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static boolean isEmpty(EditText etText)
    {
        if(etText.getText().toString().trim().length() > 0)
            return false;
        return true;
    }


}
