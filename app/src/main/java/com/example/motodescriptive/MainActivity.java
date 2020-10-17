package com.example.motodescriptive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.SearchView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MotorAdapter.OnNoteClicked {

    private ArrayList<MotoEntity>motorcycle;
    private RecyclerView recyclerView;
    private MotorAdapter adapter;
    private SearchView searchView;

    public static AppDatabase appDatabase;
    public MotoEntity motoEntity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.realparent, new RecFragment()).commit();
        appDatabase = AppDatabase.getInstance(getApplicationContext());

        motoEntity = new MotoEntity();
        motoEntity.setMoto_name("Aprilia dorsoduro 750");
        motoEntity.setMoto_desc("test");
        motoEntity.setMoto_img("https://upload.wikimedia.org/wikipedia/commons/c/c8/Aprilia_SMV750_Dorsoduro.jpg");
        appDatabase.motoDao().insert(motoEntity);

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.search_bar);

        motorcycle = new ArrayList<>();
        motorcycle.add(motoEntity);

        adapter = new MotorAdapter(motorcycle, this, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });



    }
    @Override
    public void OnNote(Bundle bundle) {
        Intent intent = new Intent(getApplicationContext(), Fragments.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}