package com.netlan.first.proyectonetlan.chat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.netlan.first.proyectonetlan.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class HolderMensaje extends RecyclerView.ViewHolder {

    private TextView tvName;
    private TextView tvMessage;
    private TextView tvHour;
    private CircleImageView cvPhotoMessageProfile;
    private ImageView ivPhotoMessage;

    public HolderMensaje (View itemView){
        super(itemView);
        tvName = (TextView) itemView.findViewById(R.id.tv_name_message);
        tvMessage = (TextView) itemView.findViewById(R.id.tv_message);
        tvHour = (TextView) itemView.findViewById(R.id.tv_hour_message);
        cvPhotoMessageProfile = (CircleImageView) itemView.findViewById(R.id.cv_photo_profiel);
        ivPhotoMessage = (ImageView) itemView.findViewById(R.id.iv_messagephoto);

    }

    public TextView getNombre() {
        return tvName;
    }

    public void setNombre(TextView nombre) {
        this.tvName = nombre;
    }

    public TextView getMensaje() {
        return tvMessage;
    }

    public void setMensaje(TextView mensaje) {
        this.tvMessage = mensaje;
    }

    public TextView getTvHour() {
        return tvHour;
    }

    public void setTvHour(TextView tvHour) {
        this.tvHour = tvHour;
    }

    public CircleImageView getCvPhotoMessageProfile() {
        return cvPhotoMessageProfile;
    }

    public void setCvPhotoMessageProfile(CircleImageView cvPhotoMessageProfile) {
        this.cvPhotoMessageProfile = cvPhotoMessageProfile;

    }

    public ImageView getIvPhotoMessage() {
        return ivPhotoMessage;
    }

    public void setIvPhotoMessage(ImageView ivPhotoMessage) {
        this.ivPhotoMessage = ivPhotoMessage;
    }
}

