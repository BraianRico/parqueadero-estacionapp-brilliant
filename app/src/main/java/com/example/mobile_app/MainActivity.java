package com.example.mobile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnentrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnentrada = (Button) findViewById(R.id.btnentrada);

        btnentrada.setOnClickListener(this);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_parqueadero",null,1);
    }


    public void onClick(View view) {
        Intent miIntent=null;
        switch (view.getId()){
            case R.id.btnentrada:
                miIntent=new Intent(MainActivity.this,RegistroEntradaActivity.class);
                break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }

    }
}