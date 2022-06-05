package com.example.ParqueaderoEstacionAppBrilliant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SalidaVehiculosActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_entrada_salida);

        btnSalida = (Button) findViewById(R.id.btnRegistrarSalida);
        btnSalida.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegistrarSalida:
                Intent i = new Intent(SalidaVehiculosActivity.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}