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

import com.example.ParqueaderoEstacionAppBrilliant.utilidades.Utilidades;

import java.util.Calendar;

public class RegistroEntradaSalidaActivity extends AppCompatActivity implements View.OnClickListener{

    //se inicializan los campos y boton que se utilizan
    EditText renroplaca, remarca, remodelo, recolor, recliente, reingreso, resalida;
    Button btnRegistrarIngreso, btnRegistrarSalida, btnBuscar, btnRegresar;
    String mydate, ingreso, salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_registro_entrada_salida);

        renroplaca = (EditText) findViewById(R.id.NumplacaEntradaSalida);
        remarca = (EditText) findViewById(R.id.remarca);
        remodelo = (EditText) findViewById(R.id.remodelo);
        recolor = (EditText) findViewById(R.id.recolor);
        recliente = (EditText) findViewById(R.id.recliente);
        reingreso = (EditText) findViewById(R.id.reingreso);
        resalida = (EditText) findViewById(R.id.resalida);


        btnRegistrarIngreso = (Button) findViewById(R.id.btnRegistrarIngreso);
        btnRegistrarSalida = (Button) findViewById(R.id.btnRegistrarSalida);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);

        btnRegistrarIngreso.setOnClickListener(this);
        btnRegistrarSalida.setOnClickListener(this);
        btnBuscar.setOnClickListener(this);
        btnRegresar.setOnClickListener(this);


    }


    public void onClick(View v){


        switch (v.getId()){
            //funcionalidad del boton
            case R.id.btnBuscar:
                buscarplaca();
                break;
            case R.id.btnRegistrarIngreso:
                registrarIngreso();
                break;
            case R.id.btnRegistrarSalida:
                registrarSalida();
                break;
            case R.id.btnRegresar:
                //registrarEntrada();
                //Toast.makeText(this,"Registro Guardado!",Toast.LENGTH_LONG).show();
                Intent i2 = new Intent(RegistroEntradaSalidaActivity.this,MainActivity.class);
                startActivity(i2);
                //finish();
        }

    }


    public void buscarplaca(){

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        String[] parametro= new String[]{renroplaca.getText().toString()};
        //Toast.makeText(getApplicationContext(), "La placa a buscar es "+renroplaca, Toast.LENGTH_SHORT).show();
        String[] campos=new String[]{Utilidades.CAMPO_MODELOVEHICULO, Utilidades.CAMPO_MARCAVEHICULO, Utilidades.CAMPO_COLORVEHICULO,
                Utilidades.CAMPO_NOMBRECLIENTEVEHICULO, Utilidades.CAMPO_HORAINGRESO, Utilidades. CAMPO_HORASALIDA};

        try{
            Cursor cursor= db.query(Utilidades.TABLA_VEHICULOS, campos,Utilidades.CAMPO_IDPLACAVEHICULO+"=?", parametro,null,null,null);
            cursor.moveToFirst();

            remodelo.setText(cursor.getString(0));
            remarca.setText(cursor.getString(1));
            recolor.setText(cursor.getString(2));
            recliente.setText(cursor.getString(3));
            reingreso.setText(cursor.getString(4));
            resalida.setText(cursor.getString(5));


            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "La placa no existe", Toast.LENGTH_SHORT).show();
            limpiar();
        }
    }

    private void registrarIngreso(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        String[] parametro1= new String[]{renroplaca.getText().toString()};
        String[] campos=new String[]{Utilidades.CAMPO_HORAINGRESO};

                Cursor cursor= db.query(Utilidades.TABLA_VEHICULOS, campos,Utilidades.CAMPO_IDPLACAVEHICULO+"=?", parametro1,null,null,null);
                cursor.moveToFirst();
                if (cursor.getString(0) != null) {
                    Toast.makeText(getApplicationContext(), "Ya existe una fecha de INGRESO, porfavor ingrese una fecha de SALIDA", Toast.LENGTH_SHORT).show();

                }else{
                   ContentValues values1 = new ContentValues();
                    mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                    values1.put(Utilidades.CAMPO_HORAINGRESO, mydate.toString());

                    db.update(Utilidades.TABLA_VEHICULOS, values1, Utilidades.CAMPO_IDPLACAVEHICULO + "=?", parametro1);
                    Toast.makeText(getApplicationContext(), "Se ha guardado la fecha de INGRESO ", Toast.LENGTH_SHORT).show();
                    limpiar();
                    cursor.close();
                }


    }

    private void registrarSalida(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        String[] parametro2= new String[]{renroplaca.getText().toString()};
        String[] campos=new String[]{Utilidades.CAMPO_HORAINGRESO, Utilidades.CAMPO_HORASALIDA};

        Cursor cursor= db.query(Utilidades.TABLA_VEHICULOS, campos,Utilidades.CAMPO_IDPLACAVEHICULO+"=?", parametro2,null,null,null);
        cursor.moveToFirst();
        if (cursor.getString(1) != null) {
            Toast.makeText(getApplicationContext(), "Ya existe una fecha de SALIDA", Toast.LENGTH_SHORT).show();

        }else if (cursor.getString(0) == null){
            Toast.makeText(getApplicationContext(), "No existe una fecha de INGRESO", Toast.LENGTH_SHORT).show();
        }else{
            ContentValues values1 = new ContentValues();
            mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
            values1.put(Utilidades.CAMPO_HORASALIDA, mydate.toString());

            db.update(Utilidades.TABLA_VEHICULOS, values1, Utilidades.CAMPO_IDPLACAVEHICULO + "=?", parametro2);
            Toast.makeText(getApplicationContext(), "Se ha guardado la fecha de SALIDA ", Toast.LENGTH_SHORT).show();
            limpiar();
            cursor.close();
        }
    }


    public void limpiar(){
        remodelo.setText("");
        remarca.setText("");
        recolor.setText("");
        renroplaca.setText("");
        recliente.setText("");
        reingreso.setText("");
        resalida.setText("");
    }


}