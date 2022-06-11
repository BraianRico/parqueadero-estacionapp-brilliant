package com.example.ParqueaderoEstacionAppBrilliant;

import android.annotation.SuppressLint;
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

public class EditarClienteActivity extends AppCompatActivity implements View.OnClickListener {

    EditText  campoNombreCliente, campoTelefono, campoCorreo, campoPlaca, campoModelo, campoMarca, campoColor, campoIdCedula;
    Button btnRegresar, btnGuardar, btnConsultar, btnEliminar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_editar_cliente);

        campoIdCedula= findViewById(R.id.campoIdCedula);
        campoNombreCliente=findViewById(R.id.campoNombreCliente);
        campoTelefono=findViewById(R.id.campoIdTelefono);
        campoCorreo=findViewById(R.id.campoIdCorreo);
        campoPlaca=findViewById(R.id.campoIdPlaca);
        campoModelo=findViewById(R.id.campoIdModelo);
        campoMarca=findViewById(R.id.campoIdMarca);
        campoColor=findViewById(R.id.campoIdColor);
        btnConsultar=findViewById(R.id.btnConsultar);
        btnRegresar=findViewById(R.id.btnRegresar);
        btnGuardar=findViewById(R.id.btnActualizarCliente);
        btnEliminar2=findViewById(R.id.btnEliminarCliente);
        btnRegresar.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);
        btnEliminar2.setOnClickListener(this);
        btnConsultar.setOnClickListener(this);

    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnActualizarCliente:
                actualizarCliente();
                Intent i2 = new Intent(EditarClienteActivity.this, GestionClienteActivity.class);
                startActivity(i2);
                break;
            case R.id.btnRegresar:
                Intent i3 = new Intent(EditarClienteActivity.this, GestionClienteActivity.class);
                startActivity(i3);
                break;
            case R.id.btnConsultar:
                consultar();
                break;
            case R.id.btnEliminarCliente:
                eliminarCliente();
                Intent i4 = new Intent(EditarClienteActivity.this, GestionClienteActivity.class);
                startActivity(i4);
                break;
        }

    }

    private void actualizarCliente(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();

        String[] parametro= new String[]{campoIdCedula.getText().toString()};

        //Datos de CLIENTES
        ContentValues values= new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRECLIENTE,campoNombreCliente.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONOCLIENTE,campoTelefono.getText().toString());
        values.put(Utilidades.CAMPO_CORREOCLIENTE,campoCorreo.getText().toString());

        db.update(Utilidades.TABLA_CLIENTES, values, Utilidades.CAMPO_IDCLIENTE+"=?",parametro);

        //Datos de VEHICULOS
        String[] parametro1 = new  String[]{campoNombreCliente.getText().toString()};
        ContentValues values1= new ContentValues();
        values1.put(Utilidades.CAMPO_IDPLACAVEHICULO,campoPlaca.getText().toString());
        values1.put(Utilidades.CAMPO_MARCAVEHICULO,campoMarca.getText().toString());
        values1.put(Utilidades.CAMPO_MODELOVEHICULO,campoModelo.getText().toString());
        values1.put(Utilidades.CAMPO_COLORVEHICULO,campoColor.getText().toString());
        values1.put(Utilidades.CAMPO_IDCLIENTEVEHICULO,campoIdCedula.getText().toString());
        values1.put(Utilidades.CAMPO_NOMBRECLIENTEVEHICULO,campoNombreCliente.getText().toString());

        db.update(Utilidades.TABLA_VEHICULOS, values1, Utilidades.CAMPO_NOMBRECLIENTEVEHICULO+"=?",parametro1);

        limpiar();
        Toast.makeText(getApplicationContext(), "Se ha actualizado el cliente  ", Toast.LENGTH_LONG).show();


    }

    public void eliminarCliente(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        String[] parametro1= new String[]{campoIdCedula.getText().toString()};
        db.delete(Utilidades.TABLA_CLIENTES,Utilidades.CAMPO_IDCLIENTE+"=?", parametro1);
        Toast.makeText(getApplicationContext(), "Se ha eliminado el cliente", Toast.LENGTH_SHORT).show();
        limpiar();
    }

    private void consultar(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        String[] parametro= new String[]{campoIdCedula.getText().toString()};
        String[] campos=new String[]{Utilidades.CAMPO_NOMBRECLIENTE, Utilidades.CAMPO_TELEFONOCLIENTE, Utilidades.CAMPO_CORREOCLIENTE};
        //Busqueda datos tabla usuario
        try{
            Cursor cursor= db.query(Utilidades.TABLA_CLIENTES, campos,Utilidades.CAMPO_IDCLIENTE+"=?", parametro,null,null,null);
            cursor.moveToFirst();
            campoNombreCliente.setText(cursor.getString(0));
            campoTelefono.setText(cursor.getString(1));
            campoCorreo.setText(cursor.getString(2));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "La cédula no existe", Toast.LENGTH_SHORT).show();
            limpiar();
        }

        //Busqueda datos tabla vehículo
        String[] parametro2= new String[]{campoIdCedula.getText().toString()};
        String[] campos2=new String[]{Utilidades.CAMPO_IDPLACAVEHICULO, Utilidades.CAMPO_MODELOVEHICULO, Utilidades.CAMPO_MARCAVEHICULO, Utilidades.CAMPO_COLORVEHICULO};
        try{
            Cursor cursor= db.query(Utilidades.TABLA_VEHICULOS, campos2,Utilidades.CAMPO_IDCLIENTEVEHICULO+"=?", parametro2,null,null,null);
            cursor.moveToFirst();
            campoPlaca.setText(cursor.getString(0));
            campoModelo.setText(cursor.getString(1));
            campoMarca.setText(cursor.getString(2));
            campoColor.setText(cursor.getString(3));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "La cédula no existe", Toast.LENGTH_SHORT).show();
            limpiar();
        }
    }


    //Método para limpiar los datos de las vistas
    public void limpiar(){
        campoIdCedula.setText("");
        campoNombreCliente.setText("");
        campoTelefono.setText("");
        campoCorreo.setText("");
        campoMarca.setText("");
        campoModelo.setText("");
        campoColor.setText("");
        campoPlaca.setText("");

    }


}
