package com.example.myfirstapp;

import android.view.View;

/**
 * Created by rachelliu on 2017-05-03.
 */

public interface ClickListener{
    void onClick (View view, int position);
    void onLongClick (View view, int position);
}