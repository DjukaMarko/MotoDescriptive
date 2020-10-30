package com.example.motodescriptive;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class MotoEntity implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int ID;

    @ColumnInfo(name = "moto_name")
    public String moto_name;

    @ColumnInfo(name = "moto_desc")
    public String moto_desc;

    @ColumnInfo(name = "moto_longdesc")
    public String moto_longdesc;

    @ColumnInfo(name = "moto_longdesc2")
    public String moto_longdesc2;

    @ColumnInfo(name = "moto_longdesc3")
    public String moto_longdesc3;

    @ColumnInfo(name = "moto_longdesc4")
    public String moto_longdesc4;

    public String getMoto_longdesc2() {
        return moto_longdesc2;
    }

    public void setMoto_longdesc2(String moto_longdesc2) {
        this.moto_longdesc2 = moto_longdesc2;
    }

    public String getMoto_longdesc3() {
        return moto_longdesc3;
    }

    public void setMoto_longdesc3(String moto_longdesc3) {
        this.moto_longdesc3 = moto_longdesc3;
    }

    public String getMoto_longdesc4() {
        return moto_longdesc4;
    }

    public void setMoto_longdesc4(String moto_longdesc4) {
        this.moto_longdesc4 = moto_longdesc4;
    }

    public String getMoto_longdesc() {
        return moto_longdesc;
    }

    public void setMoto_longdesc(String moto_longdesc) {
        this.moto_longdesc = moto_longdesc;
    }

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
