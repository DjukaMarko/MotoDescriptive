package com.example.motodescriptive;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.motodescriptive.fragments.PageFragment;
import com.example.motodescriptive.fragments.PageFragment2;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Fragments extends BaseActivity {

    TextView texttest;
    ViewPager pager;
    PagerAdapter pagerAdapter;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        texttest = findViewById(R.id.texttest);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        Fragment frg = new PageFragment();
        Fragment frg2 = new PageFragment2();
        frg.setArguments(extras);
        frg2.setArguments(extras);


        ArrayList<Fragment> list = new ArrayList<>();

        list.add(frg);
        list.add(frg2);

        pager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tablayout);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(pager);


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