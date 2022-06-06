package com.example.ParqueaderoEstacionAppBrilliant;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ParqueaderoEstacionAppBrilliant.utilidades.Utilidades;

public class RegistroEmpleadosActivity extends AppCompatActivity implements View.OnClickListener{

    EditText campoIdEmpleado, campoNombre, campoApellido, campoTelefono, campoNusuario, campoPWD;
    Button btnregistrar, btnregresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_empleado);

        campoIdEmpleado = findViewById(R.id.txtcampoIDEmpleado);
        campoNombre = findViewById(R.id.txtcampoNombre);
        campoApellido = findViewById(R.id.txtcampoApellido);
        campoTelefono = findViewById(R.id.txtcampotelefono);
        campoNusuario= findViewById(R.id.txtcampoNusuario);
        campoPWD = findViewById(R.id.txtCampoPWD);
        btnregistrar = findViewById(R.id.btnRegistrar);
        btnregresar =findViewById(R.id.btnRegresar);
        btnregistrar.setOnClickListener(this);
        btnregresar.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegistrar:
                registrarEmpleado();
                Intent i1 = new Intent(RegistroEmpleadosActivity.this,LoginActivity.class);
                startActivity(i1);
                break;
            case R.id.btnRegresar:
                Intent i2 = new Intent(RegistroEmpleadosActivity.this,LoginActivity.class);
                startActivity(i2);
                break;
        }
    }

    public void registrarEmpleado(){

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();


        //creando datos en la tabla empleado
        ContentValues values= new ContentValues();
        values.put(Utilidades.CAMPO_ID_EMPLEADO,campoIdEmpleado.getText().toString());
        values.put(Utilidades.CAMPO_USR,campoNusuario.getText().toString());
        values.put(Utilidades.CAMPO_PASSWORD,campoPWD.getText().toString());
        Long idResultante=db.insert(Utilidades.TABLA_EMPLEADO,Utilidades.CAMPO_ID_EMPLEADO,values);
        Toast.makeText(getApplicationContext(), "Se ha creado el empleado ", Toast.LENGTH_SHORT).show();
        limpiar();
        Intent i2 = new Intent(RegistroEmpleadosActivity.this,LoginActivity.class);


            }

    //Método para limpiar los datos de las vistas
    public void limpiar(){
                campoIdEmpleado.setText("");
                campoNombre.setText("");
                campoApellido.setText("");
                campoTelefono.setText("");
                campoNusuario.setText("");
                campoPWD.setText("");
            }


}