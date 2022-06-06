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
    EditText renroplaca, remarca, remodelo, recolor;
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


    private void buscarplaca(){

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        String[] parametro= new String[]{renroplaca.getText().toString()};
        //Toast.makeText(getApplicationContext(), "La placa a buscar es "+renroplaca, Toast.LENGTH_SHORT).show();
        String[] campos=new String[]{Utilidades.CAMPO_MODELO, Utilidades.CAMPO_MARCA, Utilidades.CAMPO_COLOR};

        try{
            Cursor cursor= db.query(Utilidades.TABLA_VEHICULO, campos,Utilidades.CAMPO_ID_PLACA+"=?", parametro,null,null,null);
            cursor.moveToFirst();
            remodelo.setText(cursor.getString(0));
            remarca.setText(cursor.getString(1));
            recolor.setText(cursor.getString(2));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "La placa no existe", Toast.LENGTH_SHORT).show();
            limpiar();
        }
    }

    private void registrarIngreso(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        values.put(Utilidades.CAMPO_FECHA_HORA,mydate.toString());
        ingreso = "Ingreso";
        values.put(Utilidades.CAMPO_MOVIMIENTO,ingreso.toString());
        values.put(Utilidades.CAMPO_PLACAR,renroplaca.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_REGISTRO,Utilidades.CAMPO_ID_REGISTRO,values);
        Toast.makeText(getApplicationContext(), "Se ha guardado el ingreso "+idResultante, Toast.LENGTH_SHORT).show();
        limpiar();

    }

    private void registrarSalida(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        values.put(Utilidades.CAMPO_FECHA_HORA,mydate.toString());
        salida = "Salida";
        values.put(Utilidades.CAMPO_MOVIMIENTO,salida.toString());
        values.put(Utilidades.CAMPO_PLACAR,renroplaca.getText().toString());
        Long idResultante=db.insert(Utilidades.TABLA_REGISTRO,Utilidades.CAMPO_ID_REGISTRO,values);
        Toast.makeText(getApplicationContext(), "Se ha guardado la salida "+idResultante, Toast.LENGTH_SHORT).show();
        limpiar();
    }


    public void limpiar(){
        remodelo.setText("");
        remarca.setText("");
        recolor.setText("");
        renroplaca.setText("");

    }


}