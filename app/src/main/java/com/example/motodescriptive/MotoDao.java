package com.example.motodescriptive;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MotoDao {
    @Query("SELECT * FROM motoentity")
    List<MotoEntity> selectAll();

    @Query("SELECT * FROM motoentity WHERE moto_name LIKE :name")
    List<MotoEntity> checkForName(String name);

    @Query("SELECT COUNT(*) FROM motoentity where moto_name = :name")
    int agentsCount(String name);

    @Insert
    void insert(MotoEntity motoEntity);

    @Update
    void update(MotoEntity motoEntity);

    @Delete
    void delete(MotoEntity motoEntity);

    @Query("DELETE FROM motoentity where ID = :motoid")
    void deleteById(int motoid);





}
