package com.netlan.first.proyectonetlan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.netlan.first.proyectonetlan.chat.ChatActivity;
import com.netlan.first.proyectonetlan.galery.GalleryDevices;
import com.netlan.first.proyectonetlan.galery.PacketDevicesActivity;
import com.netlan.first.proyectonetlan.module.ModulesActivity;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void irIntro(View v) {
        Intent intent = new Intent(getApplicationContext(), IntroductionActivity.class);
        startActivity(intent);
    }

    public void irMod(View v) {
        Intent intent = new Intent(getApplicationContext(), ModulesActivity.class);
        startActivity(intent);
    }

    public void irChat(View v) {
        Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
        startActivity(intent);
    }

    public void irGaleria(View v) {
        Intent intent = new Intent(getApplicationContext(), GalleryDevices.class);
        startActivity(intent);
    }


    public void irIconos(View v) {
        Intent intent = new Intent(getApplicationContext(), PacketDevicesActivity.class);
        startActivity(intent);
    }

    public void irAcer(View v) {
        Intent intent = new Intent(getApplicationContext(), DowActivity.class);
        startActivity(intent);
    }
}
