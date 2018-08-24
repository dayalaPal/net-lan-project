package com.netlan.first.proyectonetlan.pdf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.netlan.first.proyectonetlan.R;

public class PdfSubnetActivity extends AppCompatActivity {
    PDFView pdvSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_subnet);

        pdvSub = (PDFView)findViewById(R.id.pv_pdfsub);
        pdvSub.fromAsset("subneteo.pdf").load();

    }
}
