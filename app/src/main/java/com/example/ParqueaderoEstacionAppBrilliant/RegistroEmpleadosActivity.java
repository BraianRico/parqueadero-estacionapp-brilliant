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

    EditText campoIDU, campoNombre, campoApellido, campoTelefono, campoNusuario, campoPWD;
    Button btnregistrar, btnregresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_empleado);

        campoIDU = findViewById(R.id.txtcampoIDU); //Enlazar mi variable con la vista
        campoNombre = findViewById(R.id.txtcampoNombre); //Enlazar mi variable con la vista
        campoApellido = findViewById(R.id.txtcampoApellido);
        campoTelefono = findViewById(R.id.txtcampotelefono);
        campoNusuario= findViewById(R.id.txtcampoNusuario);
        campoPWD = findViewById(R.id.txtCampoPWD);
        btnregistrar = findViewById(R.id.btnRegistrar); //Enlazarme con el botón
        btnregresar =findViewById(R.id.btnRegresar);
        btnregistrar.setOnClickListener(this);
        btnregresar.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegistrar:
                registrarUsuarios();
                break;
            case R.id.btnRegresar:
                Intent i2 = new Intent(RegistroEmpleadosActivity.this,LoginActivity.class);
                startActivity(i2);
                break;
        }
    }

    public void registrarUsuarios(){

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this, "parqueadero_db", null, 1);
        SQLiteDatabase db= conn.getWritableDatabase();

        //Creando datos en la tabla usuario
        ContentValues values= new ContentValues();
        values.put(Utilidades.CAMPO_IDU,campoIDU.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDO,campoApellido.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());
        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_IDU,values);


        //creando datos en la tabla empleado
        ContentValues values1= new ContentValues();
        values1.put(Utilidades.CAMPO_IDUE,campoIDU.getText().toString());
        values1.put(Utilidades.CAMPO_USR,campoNusuario.getText().toString());
        values1.put(Utilidades.CAMPO_PASSWORD,campoPWD.getText().toString());
        Long idResultante2=db.insert(Utilidades.TABLA_EMPLEADO,Utilidades.CAMPO_ID_EMPLEADO,values1);
        Toast.makeText(getApplicationContext(), "Se ha creado el empleado ", Toast.LENGTH_SHORT).show();
        limpiar();
        Intent i2 = new Intent(RegistroEmpleadosActivity.this,LoginActivity.class);


            }

    //Método para limpiar los datos de las vistas
    public void limpiar(){
                campoIDU.setText("");
                campoNombre.setText("");
                campoApellido.setText("");
                campoTelefono.setText("");
                campoNusuario.setText("");
                campoPWD.setText("");
            }


}