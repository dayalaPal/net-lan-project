package com.netlan.first.proyectonetlan.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.netlan.first.proyectonetlan.R;

public class StartQuizOneActivity extends AppCompatActivity {
    private Button inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz_one);

    }

    public void startQuiz(View v) {
        Intent intent = new Intent(getApplicationContext(), QuizPlayOneActivity.class);
        startActivity(intent);
    }
}
