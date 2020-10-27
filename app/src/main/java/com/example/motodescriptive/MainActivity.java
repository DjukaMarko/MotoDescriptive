package com.example.motodescriptive;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class MainActivity extends BaseActivity implements MotorAdapter.OnNoteClicked {

    private ArrayList<MotoEntity> motorcycle;
    private RecyclerView recyclerView;
    private MotorAdapter adapter;
    private SearchView searchView;
    private ImageView imageView;
    MotoEntity motoEntity, motoEntity2, motoEntity3, motoEntity4, motoEntity5;
    public static AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appDatabase = AppDatabase.getInstance(getApplicationContext());
        recyclerView = findViewById(R.id.recyclerView);
        imageView = findViewById(R.id.imageViewCollapsing);
        Glide.with(this).load("https://cdn.dealerspike.com/imglib/v1/800x600/imglib/trimsdb/8335041-0-47664921.jpg").into(imageView);
        searchView = findViewById(R.id.search_bar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#EDEDED"));


        motoEntity = new MotoEntity();
        motoEntity.setMoto_name("Aprilia dorsoduro 750");
        motoEntity.setMoto_desc("test");
        motoEntity.setMoto_img("https://upload.wikimedia.org/wikipedia/commons/c/c8/Aprilia_SMV750_Dorsoduro.jpg");

        motoEntity2 = new MotoEntity();
        motoEntity2.setMoto_name("Yamaha YZF R125");
        motoEntity2.setMoto_desc("this is awesome");
        motoEntity2.setMoto_img("https://motosvet.com/tabla/uploads/monthly_2019_06/large.yamaha_yzf_r125.jpg.1c366691f4ec323971ed7ffabf931e1e.jpg");

        motoEntity3 = new MotoEntity();
        motoEntity3.setMoto_name("KTM duke 125");
        motoEntity3.setMoto_desc("this is awesoasssme");
        motoEntity3.setMoto_img("https://bd.gaadicdn.com/processedimages/ktm/125-duke/source/125-duke5ecdf3eee8762.jpg?tr=w-360");

        motoEntity4 = new MotoEntity();
        motoEntity4.setMoto_name("suzuki");
        motoEntity4.setMoto_desc("test teste");
        motoEntity4.setMoto_img("https://prod-suzuki.azureedge.net/media/13851/jimnytransparent.png?anchor=center&mode=crop&rnd=132255608430000000");


        motoEntity5 = new MotoEntity();
        motoEntity5.setMoto_name("somos ");
        motoEntity5.setMoto_desc("tasasss is awesoasssme");
        motoEntity5.setMoto_img("https://www.kolo.si/wp-content/uploads/2016/03/MOPED-TOMOS-FLEXER.ZELEN_.jpg");




        MainActivity.appDatabase.motoDao().insert(motoEntity);
        MainActivity.appDatabase.motoDao().insert(motoEntity2);
        MainActivity.appDatabase.motoDao().insert(motoEntity3);
        MainActivity.appDatabase.motoDao().insert(motoEntity4);
        MainActivity.appDatabase.motoDao().insert(motoEntity5);

        motorcycle = new ArrayList<>();
        motorcycle.add(motoEntity);
        motorcycle.add(motoEntity2);
        motorcycle.add(motoEntity3);
        motorcycle.add(motoEntity4);
        motorcycle.add(motoEntity5);

        adapter = new MotorAdapter(motorcycle, this, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }
        });

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}