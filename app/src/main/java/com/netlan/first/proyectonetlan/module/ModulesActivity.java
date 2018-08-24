package com.netlan.first.proyectonetlan.module;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;

import com.netlan.first.proyectonetlan.DowActivity;
import com.netlan.first.proyectonetlan.pdf.ExtraPracticesFragment;
import com.netlan.first.proyectonetlan.LoginActivity;
import com.netlan.first.proyectonetlan.chat.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ModulesActivity extends AppCompatActivity implements
        OneModuleFragment.OnFragmentInteractionListener,
        TwoModuleFragment.OnFragmentInteractionListener,
        ThreeModuleFragment.OnFragmentInteractionListener,
        FourModuleFragment.OnFragmentInteractionListener,
        ExtraPracticesFragment.OnFragmentInteractionListener {
    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle ;
    private Fragment fragment;
    private FragmentTransaction tran;

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private TextView lblUserName, lblEmail;
    private ImageView imgUserPhoto;

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.netlan.first.proyectonetlan.R.layout.activity_modules);


        //Contenedor de Fragmen

        mDrawerlayout = (DrawerLayout) findViewById(com.netlan.first.proyectonetlan.R.id.drawer);
        mToggle  = new ActionBarDrawerToggle(this,mDrawerlayout, com.netlan.first.proyectonetlan.R.string.open, com.netlan.first.proyectonetlan.R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        final FirebaseUser user = mAuth.getCurrentUser();

        final NavigationView navigationView = (NavigationView) findViewById(com.netlan.first.proyectonetlan.R.id.nv_navegation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int idItemSelected = item.getItemId();
                tran = getSupportFragmentManager().beginTransaction();
                switch (idItemSelected){
                    case com.netlan.first.proyectonetlan.R.id.m1:
                        fragment = new OneModuleFragment();
                        tran.replace(com.netlan.first.proyectonetlan.R.id.cf_modules,fragment).commit();
                        break;
                    case com.netlan.first.proyectonetlan.R.id.m2:
                        fragment = new TwoModuleFragment();
                        tran.replace(com.netlan.first.proyectonetlan.R.id.cf_modules,fragment).commit();
                        break;
                    case com.netlan.first.proyectonetlan.R.id.m3:
                        fragment = new ThreeModuleFragment();
                        tran.replace(com.netlan.first.proyectonetlan.R.id.cf_modules,fragment).commit();
                        break;
                    case com.netlan.first.proyectonetlan.R.id.m4:
                        fragment = new FourModuleFragment();
                        tran.replace(com.netlan.first.proyectonetlan.R.id.cf_modules,fragment).commit();
                        break;

                    case com.netlan.first.proyectonetlan.R.id.pp:
                        fragment = new ExtraPracticesFragment();
                        tran.replace(com.netlan.first.proyectonetlan.R.id.cf_modules,fragment).commit();
                        break;

                    case com.netlan.first.proyectonetlan.R.id.cerrar:
                        logOut();
                        break;


                }
                mDrawerlayout.closeDrawers();
                return true;
            }
        });

        final View navView = navigationView.getHeaderView(0);

        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid());


        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User userProfile = dataSnapshot.getValue(User.class);
                lblUserName = navView.findViewById(com.netlan.first.proyectonetlan.R.id.tv_name);
                lblEmail = navView.findViewById(com.netlan.first.proyectonetlan.R.id.tv_emailuser);
                lblUserName.setText(userProfile.getName());
                lblEmail.setText(userProfile.getEmail());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }

    private void logOut() {
        mAuth.signOut();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user==null){
            goToLogin();
        }

    }

    private void goToLogin() {
        Intent intent = new Intent(ModulesActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true ;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

   public void onClick(View v) {
       Intent intent = new Intent(getApplicationContext(), DowActivity.class);
       startActivity(intent);

    }

}
