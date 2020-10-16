package com.example.motodescriptive;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface MotoDao {

    @Query("SELECT * FROM motoentity")
    List<MotoEntity> getAll();

    @Insert
    void insertAll(MotoEntity ... motorEntity);

    @Delete
    void delete(MotoEntity ... motorEntity);

    @Query("SELECT * FROM motoentity WHERE ID IN (:motoIDS)")
    List<MotoEntity> loadAllByIds(int[] motoIDS);
}
