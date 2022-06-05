package com.example.ParqueaderoEstacionAppBrilliant;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btngestioncliente, btnEntradaSalida, btnSalir, btnceldas, btnpagos, btnnovedades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlace del boton con la vista
        btngestioncliente = findViewById(R.id.btngestioncliente);
        btnEntradaSalida = findViewById(R.id.btnEntradaSalida);
        btnceldas = findViewById(R.id.btnceldas);
        btnpagos = findViewById(R.id.btnpagos);
        btnSalir = findViewById(R.id.btnSalir);

        //Detección de la presión del botón
        btngestioncliente.setOnClickListener(this);
        btnEntradaSalida.setOnClickListener(this);
        btnceldas.setOnClickListener(this);
        btnpagos.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"parqueadero_db",null,1);
    }


    public void onClick(View view) {
        Intent miIntent=null;
        switch (view.getId()){

            case R.id.btnSalir:
                miIntent=new Intent(MainActivity.this, LoginActivity.class);
                break;
            case R.id.btngestioncliente:
                miIntent=new Intent(MainActivity.this, GestionClienteActivity.class);
                break;
            case R.id.btnEntradaSalida:
                miIntent=new Intent(MainActivity.this, RegistroEntradaSalidaActivity.class);
                break;
            case R.id.btnceldas:
                miIntent=new Intent(MainActivity.this,GestionCeldasActivity.class);
                break;

            case R.id.btnpagos:
                miIntent=new Intent(MainActivity.this,GestionPagosActivity.class);
                break;

        }
        if (miIntent!=null){
            startActivity(miIntent);
        }
    }
}