package com.dasktelor.testrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//запускаемая активность
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //получаем данные, которые получили от 1 активности
        String data = getIntent().getExtras().getString("name");

    }
}