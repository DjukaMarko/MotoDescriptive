package com.example.motodescriptive;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import java.util.ArrayList;

public class RecFragment extends Fragment implements MotorAdapter.OnNoteClicked {

    private ArrayList<MotoEntity>motorcycle;
    private RecyclerView recyclerView;
    private MotorAdapter adapter;
    private SearchView searchView;
    MotoEntity motoEntity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rec, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);
        searchView = v.findViewById(R.id.search_bar);
        motoEntity = new MotoEntity();
        motoEntity.setMoto_name("Aprilia dorsoduro 750");
        motoEntity.setMoto_desc("test");
        motoEntity.setMoto_img("https://upload.wikimedia.org/wikipedia/commons/c/c8/Aprilia_SMV750_Dorsoduro.jpg");
        MainActivity.appDatabase.motoDao().insert(motoEntity);

        motorcycle = new ArrayList<>();
        motorcycle.add(motoEntity);

        adapter = new MotorAdapter(motorcycle, this, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

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
        return v;
    }

    @Override
    public void OnNote(Bundle bundle) {
        Intent intent = new Intent(getContext(), Fragments.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}