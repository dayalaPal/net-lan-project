package com.netlan.first.proyectonetlan.chat;


import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.netlan.first.proyectonetlan.FireBaseClass;
import com.netlan.first.proyectonetlan.R;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity {

    private CircleImageView cvPhotoProfile;
    private TextView tvName;
    private RecyclerView rvMessage;
    private EditText etMessage;
    private Button btnSend;
    private AdapterMessenger adapter;
    private ImageButton btnSendPhoto;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseStorage storage;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private DatabaseReference dbRefUsers = FirebaseDatabase.getInstance().getReference();
    private StorageReference storageReference;
    private static final int PHOTO_SEND = 1;
    private static final int PHOTO_PERFIL = 2;
    private static final int RESULT_OK = 3;
    private String fotoPerfilCadena;
    private String name;
    private String urlImgUser;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.netlan.first.proyectonetlan.R.layout.activity_chat);

        loadUserFromDataBase();

        cvPhotoProfile = (CircleImageView) findViewById(R.id.cv_photoprofile);
        tvName = (TextView) findViewById(R.id.tv_name);
        rvMessage = (RecyclerView) findViewById(com.netlan.first.proyectonetlan.R.id.rvMessage);
        etMessage = (EditText) findViewById(com.netlan.first.proyectonetlan.R.id.et_message);
        btnSend = (Button) findViewById(com.netlan.first.proyectonetlan.R.id.bt_send);
        btnSendPhoto = (ImageButton) findViewById(com.netlan.first.proyectonetlan.R.id.bt_sendphoto);
        fotoPerfilCadena = "";

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference(FireBaseClass.CHAT_REFERENCE);//sala de chat(tvName)
        storage = FirebaseStorage.getInstance();



        adapter = new AdapterMessenger(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        rvMessage.setLayoutManager(l);
        rvMessage.setAdapter(adapter);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.push().setValue(new SendMessage(etMessage.getText().toString(),name,fotoPerfilCadena,"1",

                        ServerValue.TIMESTAMP));
                etMessage.setText("");
            }
        });

        btnSendPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image/jpeg");
                i.putExtra(Intent.EXTRA_LOCAL_ONLY,true);
                startActivityForResult(Intent.createChooser(i,getString(R.string.select_photo)), PHOTO_SEND);
            }
        });

        cvPhotoProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image/jpeg");
                i.putExtra(Intent.EXTRA_LOCAL_ONLY,true);
                startActivityForResult(Intent.createChooser(i,getString(R.string.select_photo)), PHOTO_PERFIL);

            }
        });

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollbar();
            }
        });

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ReceiveMess m = dataSnapshot.getValue(ReceiveMess.class);
                adapter.addMensaje(m);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void setScrollbar(){
        rvMessage.scrollToPosition(adapter.getItemCount()-1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PHOTO_SEND) {
            Uri u = data.getData();
            storageReference = storage.getReference(FireBaseClass.CHAT_IMAGES_REFERENCE);//imagenes_chat
            final StorageReference fotoReferencia = storageReference.child(u.getLastPathSegment());
            fotoReferencia.putFile(u).addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Uri u = taskSnapshot.getDownloadUrl();
                    SendMessage m = new SendMessage(name+getString(R.string.send_photo), u.toString(), tvName.getText().toString(), fotoPerfilCadena, "2", ServerValue.TIMESTAMP);
                    databaseReference.push().setValue(m);


                }
            });

        }else if(requestCode == PHOTO_PERFIL){
            Uri u = data.getData();
            if(u!=null){
                storageReference = storage.getReference(getString(R.string.photo_send));//imagenes_chat
                final StorageReference fotoReferencia = storageReference.child(u.getLastPathSegment());
                fotoReferencia.putFile(u).addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Uri u = taskSnapshot.getDownloadUrl();
                        fotoPerfilCadena = u.toString();
                        SendMessage m = new SendMessage(name + getString(R.string.profile_photo_updated), u.toString(), tvName.getText().toString(), fotoPerfilCadena, "2", ServerValue.TIMESTAMP);
                        databaseReference.push().setValue(m);
                        Glide.with(ChatActivity.this).load(u.toString()).into(cvPhotoProfile);
                        Map<String, Object> urlImg = new HashMap<>();
                        urlImg.put("urlImg", u.toString());
                        dbRefUsers.child("Users/"+user.getUid()).updateChildren(urlImg);


                    }
                });
            }

        }
    }


    private void loadUserFromDataBase(){
        dbRefUsers.child("Users/"+user.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                name = user.getName();
                tvName.setText(name);
                Glide.with(ChatActivity.this).load(user.getUrlImg()).into(cvPhotoProfile);
                fotoPerfilCadena = user.getUrlImg();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}

