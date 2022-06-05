package com.example.ParqueaderoEstacionAppBrilliant;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ParqueaderoEstacionAppBrilliant.utilidades.Utilidades;

public class CrearCeldaActivity extends AppCompatActivity implements View.OnClickListener{

    EditText campoIdCelda, campoUbicacionCelda;
    Button btnRegresar, btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_celda);
        campoIdCelda= findViewById(R.id.campoIdCelda);
        campoUbicacionCelda=findViewById(R.id.campoUbicacionCelda);
        btnRegresar=findViewById(R.id.btnRegresar);
        btnGuardar=findViewById(R.id.btnGuardar);
        btnRegresar.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnGuardar:
                crearcelda();
                break;
            case R.id.btnRegresar:
                Intent i2 = new Intent(CrearCeldaActivity.this,GestionCeldasActivity.class);
                startActivity(i2);
                break;
        }
    }

    public void crearcelda(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Utilidades.CAMPO_CELDA,campoIdCelda.getText().toString());
        values.put(Utilidades.CAMPO_UBICACION,campoUbicacionCelda.getText().toString());
        values.put(Utilidades.CAMPO_ESTADO, "0");
        Long idResultante=db.insert(Utilidades.TABLA_CELDA,Utilidades.CAMPO_CELDA,values);
        Toast.makeText(getApplicationContext(), "Se ha guardado la celda "+idResultante, Toast.LENGTH_SHORT).show();
        limpiar();
    }

    //Método para limpiar los datos de las celdas
    public void limpiar(){
        campoIdCelda.setText("");
        campoUbicacionCelda.setText("");
    }

}
