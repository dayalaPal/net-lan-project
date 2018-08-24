package com.netlan.first.proyectonetlan.galery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.netlan.first.proyectonetlan.R;

import java.util.ArrayList;

public class TypesWiresActivity extends AppCompatActivity {

    ArrayList<WireVo> listWire;
    RecyclerView rvWire;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types_wires);
        construirRecycler();

    }

    private void llenarDispositivos() {
        listWire.add(new WireVo("Cable Cruzado","Utilizamos un cable cruzado para interconectar señales de entrada y salida entre conectores",R.drawable.cruzadoc));
        listWire.add(new WireVo("Cable Directo","Es utlizado para conectar dos PCs directamente o equipos activos entre si, como hub con hub, con switch, router, etc. ",R.drawable.directoc));
        listWire.add(new WireVo("Cable Serial","Permite conectar el puerto serial de la computadora al puerto RJ45 de la consola de un router Cisco ",R.drawable.serial));


    }

    public void onClick(View view) {



        construirRecycler();
    }

    private void construirRecycler() {
        listWire =new ArrayList<>();
        rvWire = (RecyclerView) findViewById(R.id.rv_id);

        if (UtilitiesCable.visualizacion==UtilitiesCable.LIST){
            rvWire.setLayoutManager(new LinearLayoutManager(this));
        }else {
            rvWire.setLayoutManager(new GridLayoutManager(this,3));
        }

        llenarDispositivos();

        AdapterWire adapter=new AdapterWire(listWire);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Selección: "+ listWire.get
                                (rvWire.getChildAdapterPosition(view))
                                .getName(),Toast.LENGTH_SHORT).show();
            }
        });

        rvWire.setAdapter(adapter);
    }
}
