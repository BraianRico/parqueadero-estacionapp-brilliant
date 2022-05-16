package com.example.mobile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroEntradaActivity extends AppCompatActivity implements View.OnClickListener{

    EditText reidregistro, renroplaca, remarca, remodelo, recolor, refecha;
    Button btnregistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_entrada);

        reidregistro = (EditText) findViewById(R.id.reidregistro);
        renroplaca = (EditText) findViewById(R.id.renroplaca);
        remarca = (EditText) findViewById(R.id.remarca);
        remodelo = (EditText) findViewById(R.id.remodelo);
        recolor = (EditText) findViewById(R.id.recolor);
        refecha = (EditText) findViewById(R.id.refecha);
        btnregistrar = (Button) findViewById(R.id.btnregistrar);

        btnregistrar.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnregistrar:
                registrarEntrada();
                Toast.makeText(this,"Registro Guardado!",Toast.LENGTH_LONG).show();
                Intent i2 = new Intent(RegistroEntradaActivity.this,MainActivity.class);
                startActivity(i2);
                finish();
        }

    }

    private void registrarEntrada(){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_parqueadero",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID,reidregistro.getText().toString());
        values.put(Utilidades.CAMPO_PLACA,renroplaca.getText().toString());
        values.put(Utilidades.CAMPO_MARCA,remarca.getText().toString());
        values.put(Utilidades.CAMPO_MODELO,remodelo.getText().toString());
        values.put(Utilidades.CAMPO_COLOR,recolor.getText().toString());
        values.put(Utilidades.CAMPO_FECHA,refecha.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_REGISTRO,Utilidades.CAMPO_ID,values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }
}