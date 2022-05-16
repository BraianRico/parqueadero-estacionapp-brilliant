package com.example.mobile_app;

public class Utilidades {

    //constantes tabla registros
    public static final String TABLA_REGISTRO="registros";
    public static final String CAMPO_ID="id_registro";
    public static final String CAMPO_PLACA="placa";
    public static final String CAMPO_MARCA="marca";
    public static final String CAMPO_MODELO="modelo";
    public static final String CAMPO_COLOR="color";
    public static final String CAMPO_FECHA="fecha";


    public static final String CREAR_TABLA_REGISTRO = "CREATE TABLE " +
            ""+TABLA_REGISTRO+" ("+CAMPO_ID+" INTEGER, " +
            ""+CAMPO_PLACA+" TEXT, "+CAMPO_MARCA+" TEXT, " +
            ""+CAMPO_MODELO+" TEXT, "+CAMPO_COLOR+" TEXT, "+CAMPO_FECHA+" TEXT)";
}
