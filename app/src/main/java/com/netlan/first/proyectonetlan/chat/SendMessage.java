package com.netlan.first.proyectonetlan.chat;


import java.util.Map;

public class SendMessage extends Message {
    private Map mpHour;

    public SendMessage() {
    }

    public SendMessage(Map hora) {
        this.mpHour = hora;
    }

    public SendMessage(String message, String name, String photoProfile, String photoMessage, Map mpHour) {
        super(message, name, photoProfile, photoMessage);
        this.mpHour = mpHour;
    }

    public SendMessage(String message, String urlPhoto, String name, String photoProfile, String photoMessage, Map mpHour) {
        super(message,urlPhoto, name, photoProfile, photoMessage);
        this.mpHour = mpHour;
    }

    public Map getMpHour() {
        return mpHour;
    }

    public void setMpHour(Map mpHour) {
        this.mpHour = mpHour;
    }
}

