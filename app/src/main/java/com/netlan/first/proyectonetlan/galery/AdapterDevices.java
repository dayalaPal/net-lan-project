package com.netlan.first.proyectonetlan.galery;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.netlan.first.proyectonetlan.R;

import java.util.ArrayList;
public class AdapterDevices
        extends RecyclerView.Adapter<AdapterDevices.ViewHolderDispositivos>
        implements View.OnClickListener {

    ArrayList<DevicesVo> listDevices;
    private View.OnClickListener listener;

    public AdapterDevices(ArrayList<DevicesVo> listaDispositivos) {
        this.listDevices = listaDispositivos;
}
    @Override
    public ViewHolderDispositivos onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout=0;
        if (Utilities.visualizacion==Utilities.LIST){
            layout= R.layout.iem_list_devices;
        }else {
            layout=R.layout.item_grid_devices;
        }

        View view= LayoutInflater.from(parent.getContext()).inflate(layout,null,false);

        view.setOnClickListener(this);

        return new ViewHolderDispositivos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDispositivos holder, int position) {
        holder.tvName.setText(listDevices.get(position).getName());

        if (Utilities.visualizacion==Utilities.LIST){
            holder.tvInfo.setText(listDevices.get(position).getInfo());
        }

        holder.photo.setImageResource(listDevices.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return listDevices.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderDispositivos extends RecyclerView.ViewHolder {

        TextView tvName, tvInfo;
        ImageView photo;

        public ViewHolderDispositivos(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            if (Utilities.visualizacion==Utilities.LIST){
                tvInfo = (TextView) itemView.findViewById(R.id.tv_info);
            }
            photo = (ImageView) itemView.findViewById(R.id.iv_image);
        }
    }
}

