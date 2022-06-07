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

public class AsignarCeldaActivity extends AppCompatActivity implements View.OnClickListener{

    EditText campoIdCelda, campoPlacaId;
    Button btnRegresar, btnAsignarCelda;
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignar_celda);
        campoIdCelda= findViewById(R.id.campoIdCelda);
        campoPlacaId=findViewById(R.id.campoPlacaId);
        btnRegresar=findViewById(R.id.btnRegresar);
        btnAsignarCelda=findViewById(R.id.btnAsignarCelda);
        btnRegresar.setOnClickListener(this);
        btnAsignarCelda.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAsignarCelda:
                asignarCelda();
                Intent i2 = new Intent(AsignarCeldaActivity.this,GestionCeldasActivity.class);
                startActivity(i2);
                break;
            case R.id.btnRegresar:
                Intent i3 = new Intent(AsignarCeldaActivity.this,GestionCeldasActivity.class);
                startActivity(i3);
                break;
        }
    }

    public void asignarCelda(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();

        //Asignación de celda
        String[] parametro= new String[]{campoIdCelda.getText().toString()};
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_IDPLACAVEHICULOC,campoPlacaId.getText().toString());
        values.put(Utilidades.CAMPO_ESTADO,"1");
        db.update(Utilidades.TABLA_CELDA, values, Utilidades.CAMPO_CELDA+"=?",parametro);
        Toast.makeText(getApplicationContext(), "Se ha asignado la celda", Toast.LENGTH_SHORT).show();
        limpiar();

    }

    public void limpiar(){
        campoIdCelda.setText("");
        campoPlacaId.setText("");
    }
}
