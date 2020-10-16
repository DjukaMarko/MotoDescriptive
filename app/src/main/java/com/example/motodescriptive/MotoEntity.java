package com.example.motodescriptive;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MotoEntity {
    @PrimaryKey
    public int ID;

    @ColumnInfo(name = "motor_name")
    public String motor_name;

    @ColumnInfo(name = "motor_desc")
    public String motor_desc;

    @ColumnInfo(name = "moto_image")
    public String moto_image;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMotor_name() {
        return motor_name;
    }

    public void setMotor_name(String motor_name) {
        this.motor_name = motor_name;
    }

    public String getMotor_desc() {
        return motor_desc;
    }

    public void setMotor_desc(String motor_desc) {
        this.motor_desc = motor_desc;
    }

    public String getMoto_image() {
        return moto_image;
    }

    public void setMoto_image(String moto_image) {
        this.moto_image = moto_image;
    }
}
