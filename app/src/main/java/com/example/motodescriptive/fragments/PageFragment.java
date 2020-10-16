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
import com.example.motodescriptive.MainActivity;
import com.example.motodescriptive.MotoEntity;
import com.example.motodescriptive.MotorItems;
import com.example.motodescriptive.R;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class PageFragment extends Fragment {

    TextView texttest;
    TextView texttest2;
    TextView texttest3;
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
        texttest3 = v.findViewById(R.id.texttest3);
        imageFragment = v.findViewById(R.id.imageFragment);

        Bundle bundle = getArguments();
        //ArrayList<MotorItems> arr = bundle.getParcelableArrayList("arrayL");
        ArrayList<MotoEntity> motoEntities = (ArrayList<MotoEntity>) MainActivity.appDatabase.motoDao().getAll();

        texttest.setText(motoEntities.get(bundle.getInt("position")).getMotor_name());
        texttest2.setText(motoEntities.get(bundle.getInt("position")).getMotor_desc());
        Glide.with(getContext()).load(motoEntities.get(bundle.getInt("position")).getMoto_image()).into(imageFragment);

        return v;


    }
}