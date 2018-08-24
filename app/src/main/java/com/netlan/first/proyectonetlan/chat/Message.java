package com.netlan.first.proyectonetlan.chat;

public class Message {

    private String message;
    private String urlPhoto;
    private String name;
    private String photoProfile;
    private String photoMessage;


    public Message() {
    }

    public Message(String mensaje, String nombre, String fotoPerfil, String type_mansaje) {
        this.message = mensaje;
        this.name = nombre;
        this.photoProfile = fotoPerfil;
        this.photoMessage = type_mansaje;

    }

    public Message(String mensaje, String urlFoto, String nombre, String fotoPerfil, String type_mansaje) {
        this.message = mensaje;
        this.urlPhoto = urlFoto;
        this.name = nombre;
        this.photoProfile = fotoPerfil;
        this.photoMessage = type_mansaje;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }

    public String getPhotoMessage() {
        return photoMessage;
    }

    public void setPhotoMessage(String photoMessage) {
        this.photoMessage = photoMessage;
    }



    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}
