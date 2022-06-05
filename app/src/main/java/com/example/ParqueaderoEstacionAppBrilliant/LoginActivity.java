package com.example.ParqueaderoEstacionAppBrilliant;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.ParqueaderoEstacionAppBrilliant.utilidades.Utilidades;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText campoNusuario, campoPWD;
    Button btnRegistrar, btnIniciar;
    String u, p;
    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.activity_login);
        campoNusuario = findViewById(R.id.campoNusuario); //Enlazar mi variable con la vista
        campoPWD = findViewById(R.id.campoPWD);
        btnIniciar = findViewById(R.id.btnIniciar); //Enlazarme con el botón
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnIniciar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);

        conn=new ConexionSQLiteHelper(getApplicationContext(), "parqueadero_db",null,1);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnIniciar:

                login();
                break;
            case R.id.btnRegistrar:
                Intent i5 = new Intent(LoginActivity.this, RegistroEmpleadosActivity.class);
                startActivity(i5);
                break;
            default:
                Toast.makeText(getApplicationContext(), "boton default", Toast.LENGTH_LONG).show();
        }
    }

    private void login() {

        SQLiteDatabase db= conn.getReadableDatabase();
        u = campoNusuario.getText().toString();
        String[] parametro= new String[] {u};
        p= campoPWD.getText().toString();
        String[] campos={Utilidades.CAMPO_USR,Utilidades.CAMPO_PASSWORD};

        try {

            Cursor cursor =db.query(Utilidades.TABLA_EMPLEADO,campos,Utilidades.CAMPO_USR+"=?",parametro,null,null,null);
            cursor.moveToFirst();
            String usr= cursor.getString(0);
            String pass= cursor.getString(1);
            cursor.close();

            if(u.equals(usr)&&p.equals(pass)){
                //Toast.makeText(getApplicationContext(), "pass "+ pass, Toast.LENGTH_SHORT).show();
                Intent i3 = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(i3);
            }else {
                Toast.makeText(getApplicationContext(),"El usuario o contraseña no existe ",Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
                Toast.makeText(getApplicationContext(),"El usuario o contraseña no existe",Toast.LENGTH_SHORT).show();

        }
    }
}
