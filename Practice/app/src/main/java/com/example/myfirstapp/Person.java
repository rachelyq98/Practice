package com.example.myfirstapp;

import android.media.Image;
import android.media.ImageWriter;

/**
 * Created by rachelliu on 2017-05-04.
 */

public class Person {

    private String name, idNum, avatar;
    public Person(){
    }
    public Person(String name, String idNum, String avatar){
        this.name = name;
        this.idNum = idNum;
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getIdNum() {
        return idNum;
    }

    public String getName() {
        return name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public void setName(String name) {
        this.name = name;
    }
}
