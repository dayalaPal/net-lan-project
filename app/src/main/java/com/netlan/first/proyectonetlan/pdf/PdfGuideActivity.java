package com.netlan.first.proyectonetlan.pdf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.netlan.first.proyectonetlan.R;

public class PdfGuideActivity extends AppCompatActivity {
    PDFView pdvM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_manual);


        pdvM = (PDFView)findViewById(R.id.pv_pdfman);
        pdvM.fromAsset("topologias.pdf").load();

    }
}
