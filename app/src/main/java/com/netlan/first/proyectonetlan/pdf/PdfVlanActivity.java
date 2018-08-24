package com.netlan.first.proyectonetlan.pdf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.netlan.first.proyectonetlan.R;

public class PdfVlanActivity extends AppCompatActivity {
    PDFView pdvV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_vlan);

        pdvV = (PDFView)findViewById(R.id.pv_pdfvlan);
        pdvV.fromAsset("vlan.pdf").load();
    }
}
