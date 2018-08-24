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

public class GalleryDevices extends AppCompatActivity {

    ArrayList<DevicesVo> listDevices;
    RecyclerView recyclerDevices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_devices);

        construirRecycler();
    }

    private void llenarDispositivos(){

        listDevices.add(new DevicesVo("Router","Es un dispositivo electrónico que tiene como función principal, la correcta interconexión de redes y balanceo de carga de datos",R.drawable.router));
        listDevices.add(new DevicesVo("Switch","Es un dispositivo que sirve para conectar varios elementos dentro de una red. ",R.drawable.swit));
        listDevices.add(new DevicesVo("Cable Consola","Permite conectar el puerto serial de la computadora al puerto RJ45 de la consola de un router Cisco ",R.drawable.consola));
        listDevices.add(new DevicesVo("Cable Serial","Se utilizan para transferir datos entre dispositivos los cuales utilizan técnicas de comunicación de bits desde un puerto hasta otro. ",R.drawable.serial));
        listDevices.add(new DevicesVo("Cable de Red","se usa en redes de computadoras o sistemas informáticos o electrónicos para conectar un dispositivo electrónico con otro.",R.drawable.cablered));
        listDevices.add(new DevicesVo("Switch Multicapa"," además de funcionar como un switch común y corriente (Capa2), te hace funciones de capa 3. Es decir, que tiene las funcionalidades de un router (enrutar). Puedes hacer que el switch te sirva de router entre diferentes VLANs.",R.drawable.multicapa));
        listDevices.add(new DevicesVo("Pc","Es un tipo de microcomputadora diseñada en principio para ser utilizada por una persona a la vez. ",R.drawable.pc));
        listDevices.add(new DevicesVo("Servidor","Es un equipo informático que forma parte de una red y provee servicios a otros equipos cliente. Se denomina servidor dedicado, aquel que dedica todos sus recursos a atender solicitudes de los equipos cliente.",R.drawable.servidor));
        listDevices.add(new DevicesVo("Access Point","Es un dispositivo de red que interconecta equipos de comunicación inalámbricos, para formar una red inalámbrica que interconecta dispositivos móviles o tarjetas de red inalámbricas.",R.drawable.acces));

    }
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.bt_list: Utilities.visualizacion=Utilities.LIST;
                break;
            case R.id.bt_grid: Utilities.visualizacion=Utilities.GRID;
                break;
        }
        construirRecycler();
    }

    private void construirRecycler() {
        listDevices =new ArrayList<>();
        recyclerDevices = (RecyclerView) findViewById(R.id.rv_id);

        if (Utilities.visualizacion==Utilities.LIST){
            recyclerDevices.setLayoutManager(new LinearLayoutManager(this));
        }else {
            recyclerDevices.setLayoutManager(new GridLayoutManager(this,3));
        }

        llenarDispositivos();

        AdapterDevices adapter=new AdapterDevices(listDevices);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Selección: "+ listDevices.get
                                (recyclerDevices.getChildAdapterPosition(view))
                                .getName(),Toast.LENGTH_SHORT).show();
            }
        });

        recyclerDevices.setAdapter(adapter);
    }


}
