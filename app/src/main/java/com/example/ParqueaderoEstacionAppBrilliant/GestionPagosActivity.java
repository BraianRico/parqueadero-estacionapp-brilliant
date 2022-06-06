/*package com.example.ParqueaderoEstacionAppBrilliant;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ParqueaderoEstacionAppBrilliant.utilidades.Utilidades;

public class GestionPagosActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBuscar, btnPagar, btnConsultar, btnRegresar;
    EditText campoIdDocumento, campoNombre;
    String idCliente;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_pagos);

        campoIdDocumento= findViewById(R.id.campoIdDocumento);
        campoNombre= findViewById(R.id.campoNombre);

        btnBuscar= findViewById(R.id.btnBuscar);
        btnPagar= findViewById(R.id.btnPagar);
        btnConsultar= findViewById(R.id.btnConsultar);
        btnRegresar=findViewById(R.id.btnRegresar);

        btnBuscar.setOnClickListener(this);
        btnPagar.setOnClickListener(this);
        btnConsultar.setOnClickListener(this);
        btnRegresar.setOnClickListener(this);

        conn=new ConexionSQLiteHelper(getApplicationContext(), "parqueadero_db", null, 1);

    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnBuscar:
                buscarCliente();
                break;
            case R.id.btnPagar:
                Intent i2 = new Intent(GestionPagosActivity.this,PagarActivity.class);
                i2.putExtra("dato", idCliente);
                startActivity(i2);
                break;
            case R.id.btnConsultar:
                Intent i3 = new Intent(GestionPagosActivity.this,ListarPagosActivity.class);
                i3.putExtra("dato", idCliente);
                startActivity(i3);
                break;
            case R.id.btnRegresar:
                Intent i4 = new Intent(GestionPagosActivity.this,MainActivity.class);
                startActivity(i4);
                break;
            default:
                Toast.makeText(getApplicationContext(), "Presione alguna opción", Toast.LENGTH_LONG).show();
        }


    }

    public void buscarCliente(){

        SQLiteDatabase db= conn.getReadableDatabase();
        String[] parametros={campoIdDocumento.getText().toString()};
        String[] campos= {Utilidades.CAMPO_NOMBRE};

        //Traer datos de usuario
        try{
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_IDU+"=?", parametros, null, null, null);
            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            cursor.close();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "El usuario no existe ", Toast.LENGTH_LONG).show();
            limpiar();
        }

        //traer datos de id cliente
        String[] parametros1={campoIdDocumento.getText().toString()};
        String[] campos1= {Utilidades.CAMPO_ID_CLIENTE};

        try {
            Cursor cursor1 = db.query(Utilidades.TABLA_CLIENTE, campos1, Utilidades.CAMPO_IDUC+"=?", parametros1, null, null, null);
            cursor1.moveToFirst();
            idCliente= cursor1.getString(0);
            Toast.makeText(getApplicationContext(), "El id del cliente es  "+ idCliente, Toast.LENGTH_LONG).show();
            cursor1.close();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "El usuario no existe ", Toast.LENGTH_LONG).show();
            limpiar();

        }

    }

    //Método para limpiar los datos de las vistas
    private void limpiar() {
        campoNombre.setText("");
    }

}*/
