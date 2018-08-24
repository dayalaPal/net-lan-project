package com.netlan.first.proyectonetlan.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartQuizActivity extends AppCompatActivity {
    private Button inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.netlan.first.proyectonetlan.R.layout.activity_start_quiz);

    }

    public void startQuiz(View v) {
        Intent intent = new Intent(getApplicationContext(), QuizPlayActivity.class);
        startActivity(intent);
    }
}
