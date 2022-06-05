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

    EditText campoIDU, campoIDUC, campoNombre, campoApellido, campoTelefono, campoCorreo, campoPlaca, campoModelo, campoMarca, campoColor, campoIdCliente;
    Button btnRegresar, btnGuardar, btnConsultar, btnEliminar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_editar_cliente);

        campoIDU= findViewById(R.id.campoIdCedula);
        campoIdCliente= findViewById(R.id.campoIdCliente);
        campoIDUC= findViewById(R.id.campoIdCedula);
        campoNombre=findViewById(R.id.campoIdNombre);
        campoApellido=findViewById(R.id.campoIdApellido);
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

        //Editar Usuario
        String[] parametro= new String[]{campoIDU.getText().toString()};
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDO,campoApellido.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());
        Long idresultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_IDU,values);
        db.update(Utilidades.TABLA_USUARIO, values, Utilidades.CAMPO_IDU+"=?",parametro);
        Toast.makeText(getApplicationContext(), "Se ha actualizado la celda", Toast.LENGTH_SHORT).show();

        //Editar Cliente
        String[] parametro1= new String[]{campoIdCliente.getText().toString()};
        ContentValues values1 = new ContentValues();
        values1.put(Utilidades.CAMPO_IDUC,campoIDU.getText().toString());
        values1.put(Utilidades.CAMPO_CORREO,campoCorreo.getText().toString());
        Long idresultante1=db.insert(Utilidades.TABLA_CLIENTE,Utilidades.CAMPO_ID_CLIENTE,values1);
        db.update(Utilidades.TABLA_CLIENTE, values1, Utilidades.CAMPO_ID_CLIENTE+"=?",parametro1);

        //Editar Vehículo
        String[] parametro2= new String[]{campoPlaca.getText().toString()};
        ContentValues values2= new ContentValues();
        values2.put(Utilidades.CAMPO_MARCA,campoMarca.getText().toString());
        values2.put(Utilidades.CAMPO_MODELO,campoModelo.getText().toString());
        values2.put(Utilidades.CAMPO_COLOR,campoColor.getText().toString());
        Long idresultante2=db.insert(Utilidades.TABLA_VEHICULO,Utilidades.CAMPO_ID_PLACA,values2);
        db.update(Utilidades.TABLA_VEHICULO, values2, Utilidades.CAMPO_ID_PLACA+"=?",parametro2);
        limpiar();
    }

    public void eliminarCliente(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        String[] parametro1= new String[]{campoIdCliente.getText().toString()};
        db.delete(Utilidades.TABLA_CLIENTE,Utilidades.CAMPO_ID_CLIENTE+"=?", parametro1);
        Toast.makeText(getApplicationContext(), "Se ha eliminado el cliente", Toast.LENGTH_SHORT).show();
        limpiar();
    }

    private void consultar(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();
        String[] parametro= new String[]{campoIDU.getText().toString()};
        String[] campos=new String[]{Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_APELLIDO, Utilidades.CAMPO_TELEFONO};
        //Busqueda datos tabla usuario
        try{
            Cursor cursor= db.query(Utilidades.TABLA_USUARIO, campos,Utilidades.CAMPO_IDU+"=?", parametro,null,null,null);
            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoApellido.setText(cursor.getString(1));
            campoTelefono.setText(cursor.getString(2));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "La cédula no existe", Toast.LENGTH_SHORT).show();
            limpiar();
        }
        //Busqueda datos tabla cliente
        String[] parametro1= new String[]{campoIDUC.getText().toString()};
        String[] campos1=new String[]{Utilidades.CAMPO_ID_CLIENTE, Utilidades.CAMPO_CORREO};

        try{
            Cursor cursor= db.query(Utilidades.TABLA_CLIENTE, campos1,Utilidades.CAMPO_IDUC+"=?", parametro1,null,null,null);
            cursor.moveToFirst();
            campoIdCliente.setText(cursor.getString(0));
            campoCorreo.setText(cursor.getString(1));

            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "La cédula no existe", Toast.LENGTH_SHORT).show();
            limpiar();
        }

        //Busqueda datos tabla vehículo
        String[] parametro2= new String[]{campoIdCliente.getText().toString()};
        String[] campos2=new String[]{Utilidades.CAMPO_ID_PLACA, Utilidades.CAMPO_MODELO, Utilidades.CAMPO_MARCA, Utilidades.CAMPO_COLOR};
        try{
            Cursor cursor= db.query(Utilidades.TABLA_VEHICULO, campos2,Utilidades.CAMPO_IDC+"=?", parametro2,null,null,null);
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
        campoIDU.setText("");
        campoNombre.setText("");
        campoApellido.setText("");
        campoTelefono.setText("");
        campoCorreo.setText("");
        campoMarca.setText("");
        campoModelo.setText("");
        campoColor.setText("");
        campoPlaca.setText("");
        campoIdCliente.setText("");
    }


}
