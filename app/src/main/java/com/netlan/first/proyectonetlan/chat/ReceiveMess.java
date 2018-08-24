package com.netlan.first.proyectonetlan.chat;

public class ReceiveMess extends Message {

    private long hour;

    public ReceiveMess() {
    }

    public ReceiveMess(long hora) {
        this.hour = hora;
    }

    public ReceiveMess(String message, String urlPhoto, String name, String photoProfile, String photoMessage, long hour) {
        super(message, urlPhoto, name, photoProfile, photoMessage);
        this.hour = hour;
    }

    public long getHour() {
        return hour;
    }

    public void setHour(long hour) {
        this.hour = hour;
    }
}
