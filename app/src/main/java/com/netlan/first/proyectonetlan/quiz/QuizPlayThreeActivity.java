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

public class QuizPlayThreeActivity extends AppCompatActivity {

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
            {"¿Que es Spanning tree?","Un protocolo de red de nivel 2 del modelo OSI","Protocolo de Redes","Una cada de red"},
            {"Su función es la de gestionar la presencia de bucles en topologías de red","STP","TPS","HTTPS"},
            {"STP es transparente a las estaciones de usuario. "," Verdadero","Falso","Ni idea"},
            {"STP se ejecuta en bridges y switches.","Verdadero","Falso","Solo en uno"},
            {"El propósito principal de STP es garantizar que usted no cree loops cuando tenga trayectorias redundantes en su red","Verdadero","Falso","En duda"},
            {"Los loops son fatales para una red.","Verdadero","Falso","Si y no"},
            {"En un dominio de difusión solo puede existir un switch raíz."," Elección de un Switch Raíz ","Puerto Raíz","Ambos"},
            {"Los puertos se encuentran en estado de envío o retransmisión y proporcionan conectividad hacia atrás al Switch","Raíz","STP","TPS"},
            {"Se encarga de reconocer y administrar bucles en topologias de redes ","STP","PTS","HTTP"},
            {"Sentido general es un ciclo que se repite indefinidamente hasta que uno de los elementos que lo mantiene desaparezca","Bucle","Redundancia","Raiz"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_play_three);

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
                    Intent intent = new Intent(getApplicationContext(), ResultQuizThreeActivity.class);
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
