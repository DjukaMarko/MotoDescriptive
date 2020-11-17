package com.example.motodescriptive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
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
    private EndlessRecyclerViewScrollListener scrollListener;
    private Button gridButton;
    private LinearLayoutManager linearLayoutManager;
    MotoEntity motoEntity, motoEntity2, motoEntity3, motoEntity4, motoEntity5, motoEntity6, motoEntity7;
    public static AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appDatabase = AppDatabase.getInstance(getApplicationContext());
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list
                loadNextDataFromApi(page);
            }
        };
        recyclerView.addOnScrollListener(scrollListener);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        imageView = findViewById(R.id.imageViewCollapsing);
        imageView.setClipToOutline(true);
        Glide.with(this).load("https://cdn.dealerspike.com/imglib/v1/800x600/imglib/trimsdb/8335041-0-47664921.jpg").into(imageView);
        searchView = findViewById(R.id.search_bar);
        gridButton = findViewById(R.id.gridButton);
        gridButton.setBackgroundResource(R.drawable.ic_baseline_view_headline_24);

        gridButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
                if(manager instanceof GridLayoutManager) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    gridButton.setBackgroundResource(R.drawable.ic_baseline_view_headline_24);
                } else if(manager instanceof LinearLayoutManager) {
                    recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                    gridButton.setBackgroundResource(R.drawable.ic_baseline_grid_on_24);
                }
            }
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        /*motoEntity = new MotoEntity();
        motoEntity.setMoto_name("Aprilia dorsoduro 750");
        motoEntity.setMoto_desc("The Aprilia Dorsoduro is a line of V-twin, supermotard-class motorcycles built by Aprilia, a subsidiary of Piaggio & C. SpA.");
        motoEntity.setMoto_longdesc("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
        motoEntity.setMoto_longdesc2("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
        motoEntity.setMoto_longdesc3("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
        motoEntity.setMoto_longdesc4("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
        motoEntity.setMoto_img("https://upload.wikimedia.org/wikipedia/commons/c/c8/Aprilia_SMV750_Dorsoduro.jpg");

        motoEntity2 = new MotoEntity();
        motoEntity2.setMoto_name("Yamaha YZF R125");
        motoEntity2.setMoto_desc("this is awesome");
        motoEntity2.setMoto_longdesc("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
        motoEntity2.setMoto_img("https://motosvet.com/tabla/uploads/monthly_2019_06/large.yamaha_yzf_r125.jpg.1c366691f4ec323971ed7ffabf931e1e.jpg");

        motoEntity3 = new MotoEntity();
        motoEntity3.setMoto_name("KTM duke 125");
        motoEntity3.setMoto_desc("this is awesoasssme");
        motoEntity3.setMoto_longdesc("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
        motoEntity3.setMoto_img("https://bd.gaadicdn.com/processedimages/ktm/125-duke/source/125-duke5ecdf3eee8762.jpg?tr=w-360");

        motoEntity4 = new MotoEntity();
        motoEntity4.setMoto_name("suzuki");
        motoEntity4.setMoto_desc("test teste");
        motoEntity4.setMoto_longdesc("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
        motoEntity4.setMoto_img("https://prod-suzuki.azureedge.net/media/13851/jimnytransparent.png?anchor=center&mode=crop&rnd=132255608430000000");


        motoEntity5 = new MotoEntity();
        motoEntity5.setMoto_name("somos ");
        motoEntity5.setMoto_desc("tasasss is awesoasssme");
        motoEntity5.setMoto_longdesc("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
        motoEntity5.setMoto_img("https://www.kolo.si/wp-content/uploads/2016/03/MOPED-TOMOS-FLEXER.ZELEN_.jpg");

        motoEntity6 = new MotoEntity();
        motoEntity6.setMoto_name("test ");
        motoEntity6.setMoto_desc("tasasss is awesoasssme");
        motoEntity6.setMoto_longdesc("test1");
        motoEntity6.setMoto_img("https://www.kolo.si/wp-content/uploads/2016/03/MOPED-TOMOS-FLEXER.ZELEN_.jpg");

        motoEntity7 = new MotoEntity();
        motoEntity7.setMoto_name("somos ");
        motoEntity7.setMoto_desc("tasasss isdas awesoasssme");
        motoEntity7.setMoto_longdesc("test2");
        motoEntity7.setMoto_img("https://www.kolo.si/wp-content/uploads/2016/03/MOPED-TOMOS-FLEXER.ZELEN_.jpg");


        appDatabase.motoDao().insert(motoEntity);
        appDatabase.motoDao().insert(motoEntity2);
        appDatabase.motoDao().insert(motoEntity3);
        appDatabase.motoDao().insert(motoEntity4);
        appDatabase.motoDao().insert(motoEntity5);
        appDatabase.motoDao().insert(motoEntity6);
        appDatabase.motoDao().insert(motoEntity7);*/
        motorcycle = new ArrayList<>();
        for(int i=0; i < 99; i++) {
            MotoEntity motoEntity = new MotoEntity();
            motoEntity.setMoto_name("somos " + i);
            motoEntity.setMoto_desc("tasasss isdas awesoasssme" + i);
            motoEntity.setMoto_longdesc("test2" + i);
            motoEntity.setMoto_img("https://www.kolo.si/wp-content/uploads/2016/03/MOPED-TOMOS-FLEXER.ZELEN_.jpg");

            appDatabase.motoDao().insert(motoEntity);
            motorcycle.add(motoEntity);
        }

        /*motorcycle.add(motoEntity);
        motorcycle.add(motoEntity2);
        motorcycle.add(motoEntity3);
        motorcycle.add(motoEntity4);
        motorcycle.add(motoEntity5);
        motorcycle.add(motoEntity6);
        motorcycle.add(motoEntity7);*/

        adapter = new MotorAdapter(motorcycle, this, getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return true;
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