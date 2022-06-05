package com.example.ParqueaderoEstacionAppBrilliant;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ParqueaderoEstacionAppBrilliant.Adapter.AdaptadorCeldas;
import com.example.ParqueaderoEstacionAppBrilliant.utilidades.Utilidades;
import java.util.ArrayList;

public class ListarCeldaActivity extends AppCompatActivity implements  View.OnClickListener{

    Button btnRegresar;
    ArrayList<Celdas> List_Datos_Celdas;
    RecyclerView recyclerViewCeldas;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_celdas);

        conn= new ConexionSQLiteHelper(getApplicationContext(), "parqueadero_db", null,1);
        List_Datos_Celdas=new ArrayList<>();
        recyclerViewCeldas=findViewById(R.id.reciclerId);
        recyclerViewCeldas.setLayoutManager(new LinearLayoutManager(this));
        consultarListaCeldas();
        AdaptadorCeldas adapter=new AdaptadorCeldas(List_Datos_Celdas);
        recyclerViewCeldas.setAdapter(adapter);
        btnRegresar=findViewById(R.id.btnRegresarListarCelda);
        btnRegresar.setOnClickListener(this);
    }
    private void consultarListaCeldas(){
        SQLiteDatabase db=conn.getReadableDatabase();
        Celdas celda= null;
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_CELDA +" WHERE "+Utilidades.CAMPO_ESTADO +" = 0", null);
        while (cursor.moveToNext()){
            celda=new Celdas();
            celda.setIdCelda(cursor.getInt(0));
            celda.setUbicacion(cursor.getString(1));
            List_Datos_Celdas.add(celda);
        }
        if (celda==null){
            Toast.makeText(getApplicationContext(), "No hay celdas disponibles en el momento ", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnRegresarListarCelda:
                Intent i2 = new Intent(ListarCeldaActivity.this, GestionCeldasActivity.class);
                startActivity(i2);
                break;

        }

    }

}
