package com.example.motodescriptive;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import java.lang.ref.WeakReference;


public class MainActivity extends AppCompatActivity {

    public static AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.realparent, new RecFragment()).commit();
        appDatabase = AppDatabase.getInstance(getApplicationContext());


    }

}