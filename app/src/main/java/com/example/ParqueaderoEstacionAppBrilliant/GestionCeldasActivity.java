package com.example.ParqueaderoEstacionAppBrilliant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GestionCeldasActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnRegresar, btnCrearCelda, btnEditarCelda, btnAsignarCelda, btnListarCeldas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_celdas);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        btnCrearCelda = (Button) findViewById(R.id.btnCrearCelda);
        btnEditarCelda = (Button) findViewById(R.id.btnEditarCelda);
        btnAsignarCelda = (Button) findViewById(R.id.btnAsignarCelda);
        btnListarCeldas = (Button) findViewById(R.id.btnListarCeldas);

        btnRegresar.setOnClickListener(this);
        btnCrearCelda.setOnClickListener(this);
        btnEditarCelda.setOnClickListener(this);
        btnAsignarCelda.setOnClickListener(this);
        btnListarCeldas.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnCrearCelda:
                Intent i = new Intent(GestionCeldasActivity.this,CrearCeldaActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.btnEditarCelda:
                Intent i1 = new Intent(GestionCeldasActivity.this,EditarCeldaActivity.class);
                startActivity(i1);
                finish();
                break;
            case R.id.btnAsignarCelda:
                Intent i2 = new Intent(GestionCeldasActivity.this,AsignarCeldaActivity.class);
                startActivity(i2);
                finish();
                break;
            case R.id.btnListarCeldas:
                Intent i3 = new Intent(GestionCeldasActivity.this,ListarCeldaActivity.class);
                startActivity(i3);
                finish();
                break;
            case R.id.btnRegresar:
                Intent i4 = new Intent(GestionCeldasActivity.this,MainActivity.class);
                startActivity(i4);
                finish();
                break;
        }
    }

}
