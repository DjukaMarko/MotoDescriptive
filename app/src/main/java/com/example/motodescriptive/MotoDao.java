package com.example.motodescriptive;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MotoDao {
    @Query("SELECT * FROM motoentity")
    List<MotoEntity> selectAll();

    @Query("SELECT COUNT(*) FROM motoentity where moto_name = :name")
    int agentsCount(String name);

    @Insert
    void insert(MotoEntity motoEntity);

    @Delete
    void delete(MotoEntity motoEntity);




}
