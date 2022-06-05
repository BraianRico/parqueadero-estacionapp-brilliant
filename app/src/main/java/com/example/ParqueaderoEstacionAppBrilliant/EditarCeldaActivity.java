package com.example.ParqueaderoEstacionAppBrilliant;

import android.annotation.SuppressLint;
import android.content.ContentValues;
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

public class EditarCeldaActivity extends AppCompatActivity implements View.OnClickListener{

    EditText campoIdCelda, campoUbicacionCelda;
    Button btnActualizar, btnEliminar, btnBuscar, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_celda);
        campoIdCelda= findViewById(R.id.campoIdCelda);
        campoUbicacionCelda=findViewById(R.id.campoUbicacionCelda);
        btnBuscar=findViewById(R.id.btnBuscar);
        btnActualizar=findViewById(R.id.btnActualizarCelda);
        btnEliminar=findViewById(R.id.btnEliminarCelda);
        btnRegresar=findViewById(R.id.btnRegresar);
        btnBuscar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnActualizar.setOnClickListener(this);
        btnRegresar.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnBuscar:
                buscarCelda();
                break;
            case R.id.btnActualizarCelda:
                actualizarCelda();
                Intent i2 = new Intent(EditarCeldaActivity.this,GestionCeldasActivity.class);
                startActivity(i2);
                break;
            case R.id.btnEliminarCelda:
                eliminarCelda();
                Intent i3 = new Intent(EditarCeldaActivity.this,GestionCeldasActivity.class);
                startActivity(i3);
                break;
            case R.id.btnRegresar:
                Intent i4 = new Intent(EditarCeldaActivity.this,GestionCeldasActivity.class);
                startActivity(i4);
                break;
        }
}

    public void buscarCelda(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        String[] parametro= new String[]{campoIdCelda.getText().toString()};
        String[] campos=new String[]{Utilidades.CAMPO_UBICACION};

        try{
            Cursor cursor= db.query(Utilidades.TABLA_CELDA, campos,Utilidades.CAMPO_CELDA+"=?", parametro,null,null,null);
            cursor.moveToFirst();
            campoUbicacionCelda.setText(cursor.getString(0));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "La ubicación no existe", Toast.LENGTH_SHORT).show();
            limpiar();
        }
    }

    public void actualizarCelda(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        String[] parametro= new String[]{campoIdCelda.getText().toString()};
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_UBICACION,campoUbicacionCelda.getText().toString());
        db.update(Utilidades.TABLA_CELDA, values, Utilidades.CAMPO_CELDA+"=?",parametro);
        Toast.makeText(getApplicationContext(), "Se ha actualizado la celda", Toast.LENGTH_SHORT).show();
        limpiar();
    }

    public void eliminarCelda(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        String[] parametro= new String[]{campoIdCelda.getText().toString()};
        db.delete(Utilidades.TABLA_CELDA,Utilidades.CAMPO_CELDA+"=?", parametro);
        Toast.makeText(getApplicationContext(), "Se ha eliminado la celda", Toast.LENGTH_SHORT).show();
        limpiar();
    }

    //Método para limpiar los datos de las vistas
    public void limpiar(){
        campoIdCelda.setText("");
        campoUbicacionCelda.setText("");
    }

}
