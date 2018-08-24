package com.netlan.first.proyectonetlan.galery;

public class DevicesVo {

    private String name;
    private String info;
    private int photo;

    public DevicesVo(){

    }

    public DevicesVo(String nombre, String info, int foto) {
        this.name = nombre;
        this.info = info;
        this.photo = foto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}


