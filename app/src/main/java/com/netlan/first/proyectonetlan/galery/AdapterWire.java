package com.netlan.first.proyectonetlan.galery;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.netlan.first.proyectonetlan.R;

import java.util.ArrayList;

public class AdapterWire extends RecyclerView.Adapter<AdapterWire.ViewHolderCables>
        implements View.OnClickListener{

    ArrayList<WireVo> listWire;
    private View.OnClickListener listener;

    public AdapterWire(ArrayList<WireVo> listaCables) {
        this.listWire = listaCables;
    }

    @Override
    public ViewHolderCables onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout=0;
        if (UtilitiesCable.visualizacion==UtilitiesCable.LIST){
            layout= R.layout.item_list_wires;
        }

        View view= LayoutInflater.from(parent.getContext()).inflate(layout,null,false);

        view.setOnClickListener(this);

        return new ViewHolderCables(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderCables holder, int position) {
        holder.tvName.setText(listWire.get(position).getName());

        if (UtilitiesCable.visualizacion==UtilitiesCable.LIST){
            holder.tvInfo.setText(listWire.get(position).getInfo());
        }

        holder.photo.setImageResource(listWire.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return listWire.size();
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

    public class ViewHolderCables extends RecyclerView.ViewHolder {

        TextView tvName, tvInfo;
        ImageView photo;

        public ViewHolderCables(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            if (UtilitiesCable.visualizacion==UtilitiesCable.LIST){
                tvInfo = (TextView) itemView.findViewById(R.id.tv_info);
            }
            photo = (ImageView) itemView.findViewById(R.id.iv_image);
        }
    }
}
