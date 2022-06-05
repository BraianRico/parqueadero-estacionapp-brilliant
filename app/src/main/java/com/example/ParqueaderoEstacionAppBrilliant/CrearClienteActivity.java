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

public class CrearClienteActivity extends AppCompatActivity implements View.OnClickListener{

    EditText campoIDU, campoNombre, campoApellido, campoTelefono, campoCorreo, campoPlaca, campoModelo, campoMarca, campoColor;
    Button btnRegresar, btnGuardar;
    Cursor tempIdCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cliente);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        campoIDU= findViewById(R.id.txtcampoIDU);
        campoNombre=findViewById(R.id.txtcampoNombre);
        campoApellido=findViewById(R.id.txtcampoApellido);
        campoTelefono=findViewById(R.id.txtcampotelefono);
        campoCorreo=findViewById(R.id.txtcampoCorreo);
        campoPlaca=findViewById(R.id.txtcampoPlaca);
        campoModelo=findViewById(R.id.txtcampoModelo);
        campoMarca=findViewById(R.id.txtcampoMarca);
        campoColor=findViewById(R.id.txtcampoColor);
        btnRegresar=findViewById(R.id.btnRegresar);
        btnGuardar=findViewById(R.id.btnActualizarCliente);
        btnRegresar.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);

    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnActualizarCliente:
                registrarCliente();
                Intent i2 = new Intent(CrearClienteActivity.this,GestionClienteActivity.class);
                startActivity(i2);
                break;
            case R.id.btnRegresar:
                Intent i3 = new Intent(CrearClienteActivity.this,GestionClienteActivity.class);
                startActivity(i3);
                break;
        }
    }

    public void registrarCliente(){
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();

        //Datos de Usuario
        ContentValues values= new ContentValues();
        values.put(Utilidades.CAMPO_IDU,campoIDU.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDO,campoApellido.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());
        Long idresultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_IDU,values);

        //Datos de cliente
        ContentValues values1= new ContentValues();
        values1.put(Utilidades.CAMPO_IDUC,campoIDU.getText().toString());
        values1.put(Utilidades.CAMPO_CORREO,campoCorreo.getText().toString());
        Long idresultante2=db.insert(Utilidades.TABLA_CLIENTE,Utilidades.CAMPO_ID_CLIENTE,values1);

        //Colocar el campo suscripcion_id en la misma tabla de cliente
        String[] parametros= {idresultante2.toString()};
        ContentValues values4= new ContentValues();
        values4.put(Utilidades.CAMPO_SUSCRIPCION_IDC, idresultante2.toString());
        db.update(Utilidades.TABLA_CLIENTE, values4, Utilidades.CAMPO_ID_CLIENTE+"=?", parametros);

        //Datos de vehículo
        ContentValues values2= new ContentValues();
        values2.put(Utilidades.CAMPO_MARCA,campoMarca.getText().toString());
        values2.put(Utilidades.CAMPO_MODELO,campoModelo.getText().toString());
        values2.put(Utilidades.CAMPO_ID_PLACA,campoPlaca.getText().toString());
        values2.put(Utilidades.CAMPO_COLOR,campoColor.getText().toString());
        values2.put(Utilidades.CAMPO_IDC,idresultante2.toString());
        Long idresultante3=db.insert(Utilidades.TABLA_VEHICULO,Utilidades.CAMPO_ID_PLACA,values2);

        //Datos de suscripción
        ContentValues values3= new ContentValues();
        values3.put(Utilidades.CAMPO_ESTADO_SUSCRIPCION, "0");
        Long idresultante4=db.insert(Utilidades.TABLA_SUSCRIPCION,Utilidades.CAMPO_SUSCRIPCION, values3);

        limpiar();
        Toast.makeText(getApplicationContext(), "Se ha creado el cliente  ", Toast.LENGTH_LONG).show();
    }

    //Método para limpiar los datos de las vistas
    public void limpiar(){
        campoIDU.setText("");
        campoNombre.setText("");
        campoApellido.setText("");
        campoTelefono.setText("");
        campoCorreo.setText("");
        campoPlaca.setText("");
        campoModelo.setText("");
        campoMarca.setText("");
        campoColor.setText("");
    }

}
