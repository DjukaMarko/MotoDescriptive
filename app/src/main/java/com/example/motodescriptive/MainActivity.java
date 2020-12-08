package com.example.motodescriptive;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity implements MotorAdapter.OnNoteClicked {

    private RecyclerView recyclerView;
    private MotorAdapter adapter;
    private SearchView searchView;
    private ImageView imageView;
    private Button gridButton;
    private TextView quietText;
    public static AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new WebWork().execute();
        appDatabase = AppDatabase.getInstance(getApplicationContext());
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        quietText = findViewById(R.id.quietText);
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

        List<MotoEntity> motorcycles = appDatabase.motoDao().selectAll();



        int visibility = motorcycles.size() > 0 ? View.INVISIBLE : View.VISIBLE;
        quietText.setVisibility(visibility);



        adapter = new MotorAdapter((ArrayList<MotoEntity>) motorcycles, this, getApplicationContext());
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

    private class WebWork extends AsyncTask<Void, Void, String> {


        @Override
        protected String doInBackground(Void... voids) {
            String title = "";
            try {
                Document document = Jsoup.connect("https://www.hotcars.com/best-motorcycles-for-beginners/").get();
                Elements elements = document.select("div[class=w-website]").select("div[class=w-content]");

                for(Element element: elements.select("section[class=article-body]")) {
                    title = element.select("h2").text();
                    System.out.print(title);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

        }
    }
}
