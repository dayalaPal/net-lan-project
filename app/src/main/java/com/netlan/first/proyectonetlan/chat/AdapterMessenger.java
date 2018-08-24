package com.netlan.first.proyectonetlan.chat;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.netlan.first.proyectonetlan.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdapterMessenger extends RecyclerView.Adapter<HolderMensaje> {

    private List<ReceiveMess> listMessage = new ArrayList<>();
    private Context c;


    public AdapterMessenger(Context c) {
        this.c = c;
    }

    public void addMensaje (ReceiveMess m ){
        listMessage.add(m);
        notifyItemInserted(listMessage.size());

    }

    @NonNull
    @Override
    public HolderMensaje onCreateViewHolder(@NonNull ViewGroup parent, int viewTipe ) {

        View v = LayoutInflater.from(c).inflate(R.layout.activity_card_view_mensajes,parent,false);
        return new HolderMensaje(v);

    }

    @Override
    public void onBindViewHolder(@NonNull HolderMensaje holder, int position) {
        holder.getNombre().setText(listMessage.get(position).getName());
        holder.getMensaje().setText(listMessage.get(position).getMessage());

        if(listMessage.get(position).getPhotoMessage() != null) {

            if(listMessage.get(position).getPhotoMessage().equals("2")){
                holder.getIvPhotoMessage().setVisibility(View.VISIBLE);
                holder.getMensaje().setVisibility(View.VISIBLE);
                Glide.with(c).load(listMessage.get(position).getUrlPhoto()).into(holder.getIvPhotoMessage());
            }else {
                holder.getIvPhotoMessage().setVisibility(View.GONE);
                holder.getMensaje().setVisibility(View.VISIBLE);

            }


        }

        if (listMessage.get(position).getPhotoProfile() != null){
            holder.getCvPhotoMessageProfile().setImageResource(R.mipmap.ic_launcher);

        }else {
            Glide.with(c).load(listMessage.get(position).getPhotoProfile()).into(holder.getCvPhotoMessageProfile());
        }
        Long codigoHora = listMessage.get(position).getHour();
        Date d = new Date(codigoHora);
        SimpleDateFormat adf = new SimpleDateFormat("hh:mm:ss a");//a pm o am

        holder.getTvHour().setText(adf.format(d));

    }

    @Override
    public int getItemCount() {
        return listMessage.size();
    }
}