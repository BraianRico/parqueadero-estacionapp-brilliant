package com.example.ParqueaderoEstacionAppBrilliant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroPagosActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnparegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aaaactivity_registro_pagos);

        btnparegresar = (Button) findViewById(R.id.btnparegresar);

        btnparegresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnparegresar:
                Intent i = new Intent(RegistroPagosActivity.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}