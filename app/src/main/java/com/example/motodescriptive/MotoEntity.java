package com.example.motodescriptive;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MotoEntity {
    @PrimaryKey
    public int ID;

    @ColumnInfo(name = "moto_name")
    public String moto_name;

    @ColumnInfo(name = "moto_desc")
    public String moto_desc;

    @ColumnInfo(name = "moto_img")
    public String moto_img;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMoto_name() {
        return moto_name;
    }

    public void setMoto_name(String moto_name) {
        this.moto_name = moto_name;
    }

    public String getMoto_desc() {
        return moto_desc;
    }

    public void setMoto_desc(String moto_desc) {
        this.moto_desc = moto_desc;
    }

    public String getMoto_img() {
        return moto_img;
    }

    public void setMoto_img(String moto_img) {
        this.moto_img = moto_img;
    }
}
