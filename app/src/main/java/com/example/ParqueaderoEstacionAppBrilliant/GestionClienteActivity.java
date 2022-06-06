package com.example.ParqueaderoEstacionAppBrilliant;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GestionClienteActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCrearCliente, btnEditarCliente, btnregresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_cliente);

        btnCrearCliente = findViewById(R.id.btnCrearCliente); //Enlazarme con el botón
        btnEditarCliente =findViewById(R.id.btnEditarCliente);
        btnregresar=findViewById(R.id.btnregresar);
        btnCrearCliente.setOnClickListener(this);
        btnEditarCliente.setOnClickListener(this);
        btnregresar.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCrearCliente:
                Intent i1 = new Intent(GestionClienteActivity.this,CrearClienteActivity.class);
                startActivity(i1);
                break;
            /*case R.id.btnEditarCliente:
                Intent i2 = new Intent(GestionClienteActivity.this,EditarClienteActivity.class);
                startActivity(i2);
                break;*/
            case R.id.btnregresar:
                Intent i3 = new Intent(GestionClienteActivity.this,MainActivity.class);
                startActivity(i3);
                break;
            default:
                Toast.makeText(getApplicationContext(), "Presione alguna opción", Toast.LENGTH_LONG).show();
        }
    }

}
