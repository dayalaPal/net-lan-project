package com.netlan.first.proyectonetlan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {


    EditText etField1, etField2;
    TextView tvResult;
    int num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        etField1 = (EditText) findViewById(R.id.et_numone);
        etField2 = (EditText) findViewById(R.id.et_numtwo);
        tvResult = (TextView) findViewById(R.id.tv_result);
    }

    public void onClick(View view) {

        num1= Integer.parseInt(etField1.getText().toString()) ;
        num2= Integer.parseInt(etField2.getText().toString()) ;

        switch (view.getId()){
            case R.id.bt_sum: sumar();
                break;
            case R.id.bt_rest: restar();
                break;
            case R.id.bt_multi: multiplicar();
                break;
            case R.id.bt_div: dividir();
                break;
        }

    }

    private void sumar() {
        int suma=num1+num2;
        tvResult.setText(getString(R.string.result_sum)+suma);
    }

    private void restar() {
        int resta=num1-num2;
        tvResult.setText(getString(R.string.result_rest)+resta);
    }

    private void multiplicar() {
        int mult=num1*num2;
        tvResult.setText(getString(R.string.result_multiplication)+mult);
    }

    private void dividir() {

        if(num2>0){
            int div=num1/num2;
            tvResult.setText(getString(R.string.result_division)+div);
        }else{
            Toast.makeText(this,"Advertencia",Toast.LENGTH_LONG).show();
            tvResult.setText(R.string.num_higher);
        }


    }
}

