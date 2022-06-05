package com.example.ParqueaderoEstacionAppBrilliant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroUsuariosActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnusregresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aaaactivity_registro_usuarios);

        btnusregresar = (Button) findViewById(R.id.btnusregresar);

        btnusregresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnusregresar:
                Intent i = new Intent(RegistroUsuariosActivity.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}