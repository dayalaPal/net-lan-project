package com.netlan.first.proyectonetlan.pdf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.netlan.first.proyectonetlan.R;

public class PdfStpActivity extends AppCompatActivity {
    PDFView pdvStp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_stp);

        pdvStp = (PDFView)findViewById(R.id.pv_pdfStp);
        pdvStp.fromAsset("stp.pdf").load();
    }
}
