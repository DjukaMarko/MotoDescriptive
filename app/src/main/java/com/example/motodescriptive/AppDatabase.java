package com.example.motodescriptive;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MotoEntity.class}, version = 5, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    private static String NAME = "moto-database";
    public abstract MotoDao motoDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        }
        return instance;


    }

}
