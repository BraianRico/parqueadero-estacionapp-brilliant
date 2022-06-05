package com.example.ParqueaderoEstacionAppBrilliant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroCeldasActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnceregresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aaaactivity_registro_celdas);

        btnceregresar = (Button) findViewById(R.id.btnceregresar);

        btnceregresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnceregresar:
                Intent i = new Intent(RegistroCeldasActivity.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}