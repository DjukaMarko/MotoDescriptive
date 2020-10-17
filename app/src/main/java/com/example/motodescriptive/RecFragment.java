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
    MotoEntity motoEntity, motoEntity2, motoEntity3, motoEntity4, motoEntity5;
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