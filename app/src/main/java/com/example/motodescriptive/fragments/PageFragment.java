package com.example.motodescriptive.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.motodescriptive.MotoEntity;
import com.example.motodescriptive.R;

import java.util.List;


public class PageFragment extends Fragment {

    TextView texttest;
    TextView texttest2;
    //TextView texttest3;
    ImageView imageFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_page, container, false);

        texttest = v.findViewById(R.id.texttest);
        texttest2 = v.findViewById(R.id.texttest2);
        //texttest3 = v.findViewById(R.id.texttest3);
        imageFragment = v.findViewById(R.id.imageFragment);

        Bundle bundle = getArguments();
        List<MotoEntity> arr = (List<MotoEntity>) bundle.getSerializable("arrayL");

        texttest.setText(arr.get(bundle.getInt("id")).getMoto_name());
        texttest2.setText(arr.get(bundle.getInt("id")).getMoto_desc());
        //texttest3.setText(arr.get(bundle.getInt("position")).getFullDescription());
        Glide.with(getContext()).load(arr.get(bundle.getInt("id")).getMoto_img()).into(imageFragment);

        return v;


    }
}