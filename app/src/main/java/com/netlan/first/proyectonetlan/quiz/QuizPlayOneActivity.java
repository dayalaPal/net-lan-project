package com.netlan.first.proyectonetlan.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.netlan.first.proyectonetlan.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizPlayOneActivity extends AppCompatActivity {

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
            {"Cuantos tipos de topología de red  mas comunes existen.","5","6","3"},

            {"Las topologías físicas más comunes son.","estrella, anillo, malla","estrella,datos", "envío,malla"},

            {"Está topología esta caracterizada por una dorsal principal con dispositivos de red interconectados."," Ducto","Estrella","Anillo"},

            {"En esta topología las computadoras en la red se conectan a un dispositivo central o a un conmutador.","Estrella","Anillo","Ducto"},

            {"Esta topología conecta los dispositivos de red uno tras otro sobre el cable en un círculo físico","Anillo","Malla","Ducto"},

            {"Topología que utiliza conexiones redundantes entre los dispositivos como una estrategía de tolerancia a fallas","Malla","Ducto","Estrella"},

            {"Son la combinación de dos o más topologías en una misma red"," Híbridas ","Ducto","Anillo"},

            {"Las topologías lógicas más comunes son","Medio compartido, token","Topología de datos", "Topología de envio"},

            {"En este tipo de topología lógica que los dispositivos tienen la habilidad de acceder al medio compartido.","Medio compartido ","Token","Ducto"},

            {"Estas topologías funcionan utilizando un testigo o estafeta para proveer acceso al medio físico.","Topología en token","Topología con medio compartido","Ambos"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_play_one);

        Q = (TextView) findViewById(R.id.tv_q);
        questi = (TextView) findViewById(R.id.tv_questi);
        ans1 = (Button) findViewById(R.id.bt_ansone);
        ans2 = (Button) findViewById(R.id.bt_ans2);
        ans3 = (Button) findViewById(R.id.bt_ansthree);



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
                    Intent intent = new Intent(getApplicationContext(), ResultQuizOneActivity.class);
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
