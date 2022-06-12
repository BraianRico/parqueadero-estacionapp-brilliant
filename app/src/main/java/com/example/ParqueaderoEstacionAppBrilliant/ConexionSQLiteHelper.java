package com.example.ParqueaderoEstacionAppBrilliant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.ParqueaderoEstacionAppBrilliant.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    //constructor de SQLite
    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //metodos create y upgrade de SQLite
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_CLIENTES);
        db.execSQL(Utilidades.CREAR_TABLA_VEHICULOS);
        db.execSQL(Utilidades.CREAR_TABLA_EMPLEADO);
        db.execSQL(Utilidades.CREAR_TABLA_CELDA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CLIENTES);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_VEHICULOS);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CELDA);
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_EMPLEADO);
        onCreate(db);
    }
}
