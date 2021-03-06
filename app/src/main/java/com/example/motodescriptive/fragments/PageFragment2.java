package com.example.motodescriptive.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.motodescriptive.MotoEntity;
import com.example.motodescriptive.R;

import java.util.List;

public class PageFragment2 extends Fragment {

    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_page2, container, false);

        textView = v.findViewById(R.id.texttest3);

        Bundle bundle = getArguments();
        List<MotoEntity> arr = (List<MotoEntity>) bundle.getSerializable("arrayL");
        String text = arr.get(bundle.getInt("id")).getMoto_longdesc4();
        textView.setText(text);




        return v;


    }
}