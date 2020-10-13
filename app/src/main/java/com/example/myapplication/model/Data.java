package com.example.myapplication.model;
public class Data {
    String id, nama, address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Data(String id, String nama, String address) {
        this.id = id;
        this.nama = nama;
        this.address = address;
    }
    public Data() {
    }
}
