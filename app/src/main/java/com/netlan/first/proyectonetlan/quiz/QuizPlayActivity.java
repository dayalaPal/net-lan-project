package com.netlan.first.proyectonetlan.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizPlayActivity extends AppCompatActivity {

    private TextView questi;
    private TextView Q;
    private Button ans1;
    private Button ans2;
    private Button ans3;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int Q_COUNT = 10;


    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            //{"Country", "Right Answer", "Choice1", "Choice2"}
            {"Grupo de computadoras Interconectadas entre si que comparten archivos e información","Red","Internet","Topologia"},
            {"Se refiere a la forma mas adecuada de acomodar las computadoras para eficientar su funcionamiento"," Topologia","LAN","Internet"},
            {"Esta red la forman una computadora, una tablet, un celular, un access point, generalmente es de una sola persona","PAN","LAN","WAN"},
            {"Red que abarca el mundo entero como parte geografica","WAN","MAN","LAN"},
            {"Cable formado por 8 hilos generalmente usado en todas las redes de computadoras en un edificio","Par Trenzado","Fibra Óptica","Coaxial"},
            {"Tipo de cable utilizado en la topologia en bus","Cable coaxial","Fibra óptica","Cable directo"},
            {"Una red que no requiere cables se le conoce como","Inalambrica","Punto a Punto","Cableado"},
            {"Una ventaja importante de una red de area local es:","Compartir archivos","Jugar Mario Bros.","Abrir Archivos"},
            {"Es la red mundial mejor conocida como la red de redes","Internet","Wikipedia","Red LAN"},
            {"Topologias en la cual los mensajes tienen que pasar forzosamente por cada computadora que esta conectada","Bus y anillo","Arbol y Anillo","Malla"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.netlan.first.proyectonetlan.R.layout.activity_quiz_play);

        Q = (TextView) findViewById(com.netlan.first.proyectonetlan.R.id.tv_q);
        questi = (TextView) findViewById(com.netlan.first.proyectonetlan.R.id.tv_questi);
        ans1 = (Button) findViewById(com.netlan.first.proyectonetlan.R.id.bt_anst);
        ans2 = (Button) findViewById(com.netlan.first.proyectonetlan.R.id.bt_ans2);
        ans3 = (Button) findViewById(com.netlan.first.proyectonetlan.R.id.bt_ansthree);

        //QuizArray
        for(int i = 0; i < quizData.length; i++) {
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]);
            tmpArray.add(quizData[i][2]);
            tmpArray.add(quizData[i][3]);

            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }

    public void showNextQuiz() {

        questi.setText("Q" + quizCount);

        Random random = new Random();
        int rand = random.nextInt(quizArray.size());

        ArrayList<String> quiz = quizArray.get(rand);

        questi.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        quiz.remove(0);
        Collections.shuffle(quiz);

        ans1.setText(quiz.get(0));
        ans2.setText(quiz.get(1));
        ans3.setText(quiz.get(2));

        quizArray.remove(rand);

    }

    public void checkAns (View view){
        Button ansBtn = (Button)findViewById(view.getId());
        String btnText = ansBtn.getText().toString();

        String alertTitle;

        if (btnText.equals(rightAnswer)){
            alertTitle = "Correcto!!!";
            rightAnswerCount++;

        }else{
            alertTitle = "Lo siento que pena, esta mal";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Respuesta: "+ rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (quizCount == Q_COUNT){
                    Intent intent = new Intent(getApplicationContext(), ResultQuizActivity.class);
                    intent.putExtra("Total_Resp_correct", rightAnswerCount);
                    startActivity(intent);
                }else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}


