package com.netlan.first.proyectonetlan.quiz;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.netlan.first.proyectonetlan.module.ModulesActivity;

public class ResultQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.netlan.first.proyectonetlan.R.layout.activity_result_quiz);

        TextView result = (TextView)findViewById(com.netlan.first.proyectonetlan.R.id.tv_result);
        TextView puntaje = (TextView)findViewById(com.netlan.first.proyectonetlan.R.id.tv_score);

        int punt = getIntent().getIntExtra("Total_Resp_correct",0);

        SharedPreferences settings = getSharedPreferences("Quiz", Context.MODE_PRIVATE);
        int totalPnt = settings.getInt("Puntaje Total ", 0);
        totalPnt += punt;

        result.setText(punt + " /10");
        puntaje.setText("Puntaje Total: " + totalPnt);

        SharedPreferences.Editor edit = settings.edit();
        edit.putInt("Puntaje total: ", + totalPnt);
        edit.commit();

    }

    public void retornar(View v) {
        Intent intent = new Intent(getApplicationContext(), StartQuizActivity.class);
        startActivity(intent);
    }

    public void salir(View v) {
        Intent intent = new Intent(getApplicationContext(), ModulesActivity.class);
        startActivity(intent);
    }
}

