package com.example.ParqueaderoEstacionAppBrilliant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ParqueaderoEstacionAppBrilliant.utilidades.Utilidades;

import java.util.Calendar;

public class GestionPagosActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBuscar, btnPagar, btnRegresar, btnImprimir;
    EditText campoPlaca, campoIngreso, campoSalida, campoCelda, campoCostoTotal, campoEstado;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_gestion_pagos);

        campoPlaca=(EditText) findViewById(R.id.NumPlacaPago);
        campoIngreso=(EditText) findViewById(R.id.reingresopago);
        campoSalida=(EditText) findViewById(R.id.resalidapago);
        campoCelda=(EditText) findViewById(R.id.receldapago);
        campoCostoTotal=(EditText) findViewById(R.id.recostototal);
        campoEstado=(EditText) findViewById(R.id.reestado);

        btnBuscar= (Button)findViewById(R.id.btnBuscar);
        btnPagar= (Button)findViewById(R.id.btnPagar);
        btnImprimir= (Button)findViewById(R.id.btnImprimir);
        btnRegresar=(Button)findViewById(R.id.btnRegresar);

        btnBuscar.setOnClickListener(this);
        btnPagar.setOnClickListener(this);
        btnImprimir.setOnClickListener(this);
        btnRegresar.setOnClickListener(this);

    }




    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnBuscar:
                buscarPago();
                break;
            case R.id.btnPagar:
                registrarPago();
                break;
            /*case R.id.btnImprimir:
                Intent i3 = new Intent(GestionPagosActivity.this,ListarCeldaActivity.class);
                i3.putExtra("dato", idCliente);
                startActivity(i3);
                break;*/
            case R.id.btnRegresar:
                Intent i2 = new Intent(GestionPagosActivity.this,MainActivity.class);
                startActivity(i2);


        }


    }

    public void buscarPago(){

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        String[] parametro= new String[]{campoPlaca.getText().toString()};
        String[] campos= new String[]
                {
                        Utilidades.CAMPO_HORAINGRESO,
                        Utilidades.CAMPO_HORASALIDA,
                        Utilidades.CAMPO_CELDAVEHICULO,
                        Utilidades.CAMPO_COSTOTOTAL,
                        Utilidades.CAMPO_ESTADOPAGO
                };

        //Traer datos de vehiculo
        try{
            Cursor cursor = db.query(Utilidades.TABLA_VEHICULOS, campos, Utilidades.CAMPO_IDPLACAVEHICULO+"=?", parametro, null, null, null);
            cursor.moveToFirst();
            campoIngreso.setText(cursor.getString(0));
            campoSalida.setText(cursor.getString(1));
            campoCelda.setText(cursor.getString(2));
            campoCostoTotal.setText(cursor.getString(3));
            campoEstado.setText(cursor.getString(4));
            cursor.close();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "La placa no existe ", Toast.LENGTH_LONG).show();
            limpiar();
        }

    }

    private void registrarPago() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametro2 = new String[]{campoPlaca.getText().toString()};

        String[] campos = new String[]
                {
                        Utilidades.CAMPO_HORAINGRESO,
                        Utilidades.CAMPO_HORASALIDA,
                        Utilidades.CAMPO_ESTADOPAGO
                };

        Cursor cursor = db.query(Utilidades.TABLA_VEHICULOS, campos, Utilidades.CAMPO_IDPLACAVEHICULO + "=?", parametro2, null, null, null);
        cursor.moveToFirst();


        if(cursor.getString(1) == null) {
            Toast.makeText(getApplicationContext(), "ERROR, aun no se ha registrado la salida del vehiculo ", Toast.LENGTH_SHORT).show();
            limpiar();
            cursor.close();
        }else if(cursor.getString(2) != null) {
                Toast.makeText(getApplicationContext(), "ERROR, El pago ya fue realizado ", Toast.LENGTH_SHORT).show();

            }else if(cursor.getString(0) != null && cursor.getString(1) != null && cursor.getString(2) == null){

            ContentValues values1 = new ContentValues();
            values1.put(Utilidades.CAMPO_ESTADOPAGO, "Realizado");
            //Aca debo de registrar el pago
            db.update(Utilidades.TABLA_VEHICULOS, values1, Utilidades.CAMPO_IDPLACAVEHICULO + "=?", parametro2);

            Toast.makeText(getApplicationContext(), "Pago Realizado", Toast.LENGTH_SHORT).show();
            limpiar();
            cursor.close();

        } else {
            Toast.makeText(getApplicationContext(), "ERROR, No se puede registrar el pago", Toast.LENGTH_SHORT).show();
            limpiar();
            cursor.close();

        }
    }

    //Método para limpiar los datos de las vistas
    private void limpiar() {
        campoIngreso.setText("");
        campoSalida.setText("");
        campoCelda.setText("");
        campoCostoTotal.setText("");
        campoEstado.setText("");

    }

}
