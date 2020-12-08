package com.example.motodescriptive;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {MotoEntity.class}, version = 19)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    private static String NAME = "moto-database";
    public abstract MotoDao motoDao();


    public static synchronized AppDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, NAME).createFromAsset("moto-database5.db").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        }
        return instance;


    }


}
