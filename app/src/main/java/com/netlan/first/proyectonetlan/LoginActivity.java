package com.netlan.first.proyectonetlan;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtEmail;
    private EditText txtPass;
    private Button btnLogin;
    private ProgressDialog progressDialog;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.netlan.first.proyectonetlan.R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        txtEmail = (EditText) findViewById(com.netlan.first.proyectonetlan.R.id.tv_email);
        txtPass = (EditText) findViewById(com.netlan.first.proyectonetlan.R.id.et_password);
        btnLogin = (Button) findViewById(com.netlan.first.proyectonetlan.R.id.bt_one);

        progressDialog = new ProgressDialog(this);

        btnLogin.setOnClickListener(this);
    }

    private void loginUser() {
        String email = txtEmail.getText().toString().trim();
        String pass = txtPass.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, R.string.enter_email, Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, R.string.enter_pass, Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage(getString(R.string.enter));
        progressDialog.show();


        //Loguear
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, getString(R.string.welcome) + txtEmail.getText(), Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(getApplication(), IntroductionActivity.class);
                            startActivity(intent);

                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(LoginActivity.this, R.string.email_description, Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginActivity.this, R.string.error_register, Toast.LENGTH_SHORT).show();
                            }
                        }

                        progressDialog.dismiss();

                        // ...
                    }
                });

    }


    public void irRegistro(View v) {
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        loginUser();
    }

    private void goToModul() {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            goToModul();

        }
    }
}