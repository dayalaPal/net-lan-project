package com.netlan.first.proyectonetlan;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.netlan.first.proyectonetlan.R.layout.activity_dow);
    }

    //RedesSociales

    public void irFacebook(View v) {
        Uri uriUrl = Uri.parse("https://www.facebook.com/Net-Lan-339526579922312/?modal=admin_todo_tour");
        Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(intent);
    }

    public void irTwit(View v) {
        Uri uriUrl2 = Uri.parse("https://www.twiteer.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl2);
        startActivity(intent);
    }

    public void irYou(View v) {
        Uri uriUrl3 = Uri.parse("https://www.youtube.com/channel/UCDM4nXVGYBTwNEiXW0HZ4nQ?view_as=subscriber");
        Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl3);
        startActivity(intent);
    }

    //Acceso a descargar cisco

    public void cisco(View v) {
        Uri uriUrl = Uri.parse("https://play.google.com/store/apps/details?id=com.netacad.PacketTracerM");
        Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(intent);
    }

    public void irGoogle(View v) {
        Uri uriUrl = Uri.parse("https://www.google.com/?gws_rd=ssl");
        Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(intent);
    }
}
