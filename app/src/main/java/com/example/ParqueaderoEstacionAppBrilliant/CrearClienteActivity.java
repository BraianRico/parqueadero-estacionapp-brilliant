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

    EditText camposIdCliente, campoNombre,  campoTelefono, campoCorreo, campoPlaca, campoModelo, campoMarca, campoColor, campoc;
    Button btnRegresar, btnGuardar;
    Cursor tempIdCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cliente);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        camposIdCliente= findViewById(R.id.txtcampoIdcliente);
        campoNombre=findViewById(R.id.txtcampoNombre);
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

        //Datos de CLIENTES
        ContentValues values= new ContentValues();
        values.put(Utilidades.CAMPO_IDCLIENTE,camposIdCliente.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRECLIENTE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONOCLIENTE,campoTelefono.getText().toString());
        values.put(Utilidades.CAMPO_CORREOCLIENTE,campoCorreo.getText().toString());

        Long idresultante=db.insert(Utilidades.TABLA_CLIENTES,Utilidades.CAMPO_IDCLIENTE,values);

        //Datos de VEHICULOS
        ContentValues values1= new ContentValues();
        values1.put(Utilidades.CAMPO_IDPLACAVEHICULO,campoPlaca.getText().toString());
        values1.put(Utilidades.CAMPO_MARCAVEHICULO,campoMarca.getText().toString());
        values1.put(Utilidades.CAMPO_MODELOVEHICULO,campoModelo.getText().toString());
        values1.put(Utilidades.CAMPO_COLORVEHICULO,campoColor.getText().toString());
        values1.put(Utilidades.CAMPO_IDCLIENTEVEHICULO,camposIdCliente.getText().toString());
        values1.put(Utilidades.CAMPO_NOMBRECLIENTEVEHICULO,campoNombre.getText().toString());
        Long idresultante1=db.insert(Utilidades.TABLA_VEHICULOS,Utilidades.CAMPO_IDPLACAVEHICULO,values1);

        limpiar();
        Toast.makeText(getApplicationContext(), "Se ha creado el cliente  ", Toast.LENGTH_LONG).show();
    }

    //Método para limpiar los datos de las vistas
    public void limpiar(){
        camposIdCliente.setText("");
        campoNombre.setText("");
        campoTelefono.setText("");
        campoCorreo.setText("");
        campoPlaca.setText("");
        campoModelo.setText("");
        campoMarca.setText("");
        campoColor.setText("");
    }

}
