package com.example.motodescriptive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    public static AppDatabase appDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.realparent, new RecFragment()).commit();
        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "moto-database").build();
        MotoEntity motoEntity = new MotoEntity();
        motoEntity.setMotor_name("Aprilia Dorsoduro 750");
        motoEntity.setMotor_desc("pretty good");
        motoEntity.setMoto_image("https://s1.cdn.autoevolution.com/images/moto_gallery/APRILIADorsoduro750ABS-4840_2.jpg");

    }

}