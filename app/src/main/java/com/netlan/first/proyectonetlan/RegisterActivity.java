package com.netlan.first.proyectonetlan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.netlan.first.proyectonetlan.chat.User;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtEmail;
    private EditText txtPassR;
    private Button btnRegis;
    private ProgressDialog progressDialog;
    private EditText lblName;

    //* Firebase

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.netlan.first.proyectonetlan.R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        txtEmail = (EditText) findViewById(com.netlan.first.proyectonetlan.R.id.tv_email);
        txtPassR = (EditText) findViewById(com.netlan.first.proyectonetlan.R.id.tv_pass);
        btnRegis = (Button) findViewById(com.netlan.first.proyectonetlan.R.id.bt_register);
        lblName = findViewById(com.netlan.first.proyectonetlan.R.id.tv_name);

        progressDialog = new ProgressDialog(this);

        btnRegis.setOnClickListener(this);



    }

    public void registroUser() {
        final String email = txtEmail.getText().toString().trim();
        String pass = txtPassR.getText().toString().trim();
        final String userName = lblName.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this,  R.string.enter_email, Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this,  R.string.enter_pass, Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(userName)){
            Toast.makeText(this, R.string.enter_name, Toast.LENGTH_SHORT).show();
        }else {

            progressDialog.setMessage("Registrando...");
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                DatabaseReference mRef = FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid());
                                User userRegister = new User();
                                userRegister.setName(userName);
                                userRegister.setEmail(email);

                                mRef.setValue(userRegister);
                                goToModules();

                                Toast.makeText(RegisterActivity.this, getString(R.string.user_register) + txtEmail.getText(), Toast.LENGTH_SHORT).show();
                            } else {
                                // If sign in fails, display a message to the user.
                                //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                //Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                //      Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                                if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                    Toast.makeText(RegisterActivity.this, R.string.email_description, Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(RegisterActivity.this, R.string.error_register, Toast.LENGTH_SHORT).show();
                                }
                            }

                            progressDialog.dismiss();

                            // ...
                        }
                    });
        }

    }


    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void goToModules(){
        Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    public void returnRegister(View v) {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }

    private void updateUI(FirebaseUser currentUser) {
    }

    @Override
    public void onClick(View v) {
        registroUser();
    }
}

