package com.netlan.first.proyectonetlan;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class GlosaryActivity extends AppCompatActivity {

    Button btWOne, btWTwo, btWThree, btWFour, btWFive, btWSix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.netlan.first.proyectonetlan.R.layout.activity_glosary);

        btWOne =(Button)findViewById(com.netlan.first.proyectonetlan.R.id.bt_isp);
        btWTwo =(Button)findViewById(com.netlan.first.proyectonetlan.R.id.bt_ip);
        btWThree =(Button)findViewById(com.netlan.first.proyectonetlan.R.id.bt_enlace);
        btWFour =(Button)findViewById(com.netlan.first.proyectonetlan.R.id.bt_dhcp);
        btWFive =(Button)findViewById(com.netlan.first.proyectonetlan.R.id.bt_host);
        btWSix =(Button)findViewById(com.netlan.first.proyectonetlan.R.id.bt_ethernet);

        btWOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(GlosaryActivity.this);
                alertDialogBuilder
                        .setMessage(R.string.used_term)
                        .setCancelable(false)
                        .setPositiveButton(R.string.return_glossary, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i= new Intent(getApplicationContext(), GlosaryActivity.class);
                                startActivity(i);
                                finish();

                            }
                        }).setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
        btWTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(GlosaryActivity.this);
                alertDialogBuilder
                        .setMessage(R.string.protocol_address)
                        .setCancelable(false)
                        .setPositiveButton(R.string.return_glossary, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i= new Intent(getApplicationContext(), GlosaryActivity.class);
                                startActivity(i);
                                finish();

                            }
                        }).setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });

        btWThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(GlosaryActivity.this);
                alertDialogBuilder
                        .setMessage(R.string.devices_description)
                        .setCancelable(false)
                        .setPositiveButton(R.string.return_glossary, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i= new Intent(getApplicationContext(), GlosaryActivity.class);
                                startActivity(i);
                                finish();

                            }
                        }).setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });


        btWFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(GlosaryActivity.this);
                alertDialogBuilder
                        .setMessage(R.string.configuration_description)
                        .setCancelable(false)
                        .setPositiveButton(R.string.return_glossary, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i= new Intent(getApplicationContext(), GlosaryActivity.class);
                                startActivity(i);
                                finish();
                            }
                        }).setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });

        btWFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(GlosaryActivity.this);
                alertDialogBuilder
                        .setMessage(R.string.name_description)
                        .setCancelable(false)
                        .setPositiveButton(R.string.return_glossary, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i= new Intent(getApplicationContext(),GlosaryActivity.class);
                                startActivity(i);
                                finish();

                            }
                        }).setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        finish();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });

        btWSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(GlosaryActivity.this);
                alertDialogBuilder
                        .setMessage(R.string.ethernet_description)
                        .setCancelable(false)
                        .setPositiveButton(R.string.return_glossary, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i= new Intent(getApplicationContext(), GlosaryActivity.class);
                                startActivity(i);
                                finish();

                            }
                        }).setNegativeButton(R.string.exit, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });

    }
}
