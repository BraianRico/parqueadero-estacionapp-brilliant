package com.example.ParqueaderoEstacionAppBrilliant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SalidaVehiculosActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnsalidaregresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aaaactivity_salida_vehiculos);

        btnsalidaregresar = (Button) findViewById(R.id.btnSalidaRegresar);
        btnsalidaregresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSalidaRegresar:
                Intent i = new Intent(SalidaVehiculosActivity.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}