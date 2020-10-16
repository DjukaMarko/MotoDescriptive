package com.example.motodescriptive;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MotoEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MotoDao motoDao();
}