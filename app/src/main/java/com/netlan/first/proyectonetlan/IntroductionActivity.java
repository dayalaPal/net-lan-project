package com.netlan.first.proyectonetlan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.netlan.first.proyectonetlan.module.ModulesActivity;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

public class IntroductionActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private Button btnHome;
    private Button   btnGlosary;
    public static final String user = "names";
    private ImageButton img;

    YouTubePlayerFragment youTubePlayerFragment;
    public static final String DEVELOPER_KEY = "AIzaSyCYr335mo0HCr7TDYZb0Yg47sJ87ip3F3c";
    private static final String V_ID  = "Zn8y9eiHB6Y";
    private static final int REC_DIA_REQ = 1;


    Button clk;
    VideoView videov;
    MediaController mediaC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.netlan.first.proyectonetlan.R.layout.activity_introductin);


        youTubePlayerFragment = (YouTubePlayerFragment)getFragmentManager().findFragmentById(com.netlan.first.proyectonetlan.R.id.videoView);
        youTubePlayerFragment.initialize(DEVELOPER_KEY, this);

        btnHome = findViewById(com.netlan.first.proyectonetlan.R.id.bt_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroductionActivity.this, ModulesActivity.class);
                startActivity(intent);
            }
        });


        btnGlosary = findViewById(com.netlan.first.proyectonetlan.R.id.bt_glossary);
        btnGlosary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroductionActivity.this, GlosaryActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (b) {
            youTubePlayer.cueVideo(V_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult erroReason ) {
        if (erroReason.isUserRecoverableError()){
            erroReason.getErrorDialog(this, REC_DIA_REQ).show();
        }else {
            String erroMessage = String.format(
                    getString(R.string.start_youtube), erroReason.toString());
            Toast.makeText(this, erroMessage, Toast.LENGTH_LONG).show();
        }
    }

     @Override
     public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REC_DIA_REQ) {
            getYouTubePlayerProvider().initialize(DEVELOPER_KEY, this);
        }
     }

     protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView)findViewById(com.netlan.first.proyectonetlan.R.id.videoView);
     }





}