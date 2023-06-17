package com.example.progrsofhifzstdnt;

import java.util.Arrays;

public class HafizStudent {

    private int id;
    private String name;
    private int age;
    private String clas;
    private int sabaqPara;
    private int sabaqStVrse;
    private int sabaqLsVrse;
    private int sabaqi;
    private String Manzil;

    @Override
    public String toString() {
        return "HafizStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", clas='" + clas + '\'' +
                ", sabaqPara=" + sabaqPara +
                ", sabaqStVrse=" + sabaqStVrse +
                ", sabaqLsVrse=" + sabaqLsVrse +
                ", sabaqi=" + sabaqi +
                ", Manzil='" + Manzil + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public int getSabaqPara() {
        return sabaqPara;
    }

    public void setSabaqPara(int sabaqPara) {
        this.sabaqPara = sabaqPara;
    }

    public int getSabaqStVrse() {
        return sabaqStVrse;
    }

    public void setSabaqStVrse(int sabaqStVrse) {
        this.sabaqStVrse = sabaqStVrse;
    }

    public int getSabaqLsVrse() {
        return sabaqLsVrse;
    }

    public void setSabaqLsVrse(int sabaqLsVrse) {
        this.sabaqLsVrse = sabaqLsVrse;
    }

    public int getSabaqi() {
        return sabaqi;
    }

    public void setSabaqi(int sabaqi) {
        this.sabaqi = sabaqi;
    }

    public String getManzil() {
        return Manzil;
    }

    public void setManzil(String manzil) {
        Manzil = manzil;
    }
}
