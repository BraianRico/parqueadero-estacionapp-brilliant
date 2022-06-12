package com.example.ParqueaderoEstacionAppBrilliant.utilidades;

public class Utilidades {

    //constantes de tabla empleado
    public static final String TABLA_EMPLEADO="empleado";
    public static final String CAMPO_ID_EMPLEADO="id_empleado";
    public static final String CAMPO_USR="usr";
    public static final String CAMPO_PASSWORD="password";

    //constantes de tabla celda
    public static final String TABLA_CELDA="celda";
    public static final String CAMPO_CELDA="id_celda";
    public static final String CAMPO_UBICACION="ubicacion";
    public static final String CAMPO_ESTADO="estado";
    public static final String CAMPO_IDPLACAVEHICULOC="placa_id";

    // constantes de tabla CLIENTES
    public static final String TABLA_CLIENTES="clientes";
    public static final String CAMPO_IDCLIENTE="idCliente";
    public static final String CAMPO_NOMBRECLIENTE="nombreCliente";
    public static final String CAMPO_TELEFONOCLIENTE="telefonoCliente";
    public static final String CAMPO_CORREOCLIENTE="correoCliente";

    // constantes de tabla VEHICULOS
    public static final String TABLA_VEHICULOS="vehiculos";
    public static final String CAMPO_IDPLACAVEHICULO="idPlacavehiculo";
    public static final String CAMPO_MODELOVEHICULO="modelovehiculo";
    public static final String CAMPO_MARCAVEHICULO="marcavehiculo";
    public static final String CAMPO_COLORVEHICULO="colorvehiculo";
    public static final String CAMPO_IDCLIENTEVEHICULO="clienteIdVehiculo";
    public static final String CAMPO_NOMBRECLIENTEVEHICULO="clienteNombreVehiculo";
    public static final String CAMPO_HORAINGRESO="horaIngreso";
    public static final String CAMPO_HORASALIDA="horaSalida";
    public static final String CAMPO_CELDAVEHICULO="celdaVehiculo";
    public static final String CAMPO_COSTOTOTAL="celdaCostoTotal";
    public static final String CAMPO_ESTADOPAGO="celdaEstadoPago";


    // Creación de la tabla empleado
    public static final String CREAR_TABLA_EMPLEADO=
            "CREATE TABLE "+TABLA_EMPLEADO+" ("+CAMPO_ID_EMPLEADO+" TEXT PRIMARY KEY UNIQUE , "+CAMPO_USR+" TEXT, "+CAMPO_PASSWORD+" TEXT)";


    //Creación de la tabla CLIENTES
    public static  final String CREAR_TABLA_CLIENTES=
            "CREATE TABLE "+TABLA_CLIENTES+" ("+CAMPO_IDCLIENTE+" TEXT PRIMARY KEY UNIQUE, "+
                    CAMPO_NOMBRECLIENTE+" TEXT, "+CAMPO_TELEFONOCLIENTE+" TEXT, "+CAMPO_CORREOCLIENTE+" TEXT)";

    //Creación de la tabla VEHICULOS
    public static  final String CREAR_TABLA_VEHICULOS=
            "CREATE TABLE "+TABLA_VEHICULOS+" ("+CAMPO_IDPLACAVEHICULO+" TEXT PRIMARY KEY UNIQUE, "+CAMPO_MODELOVEHICULO+" TEXT, "+CAMPO_MARCAVEHICULO+" TEXT, "+
                    CAMPO_COLORVEHICULO+" TEXT, "+CAMPO_IDCLIENTEVEHICULO+" TEXT, "+CAMPO_NOMBRECLIENTEVEHICULO+" TEXT,"+CAMPO_HORAINGRESO+" TEXT, "+CAMPO_HORASALIDA+
                    " TEXT, "+CAMPO_CELDAVEHICULO+" TEXT, "+CAMPO_COSTOTOTAL+" TEXT, "+CAMPO_ESTADOPAGO+" TEXT)";


    //Creación de la tabla celda
    public static final String CREAR_TABLA_CELDA=
            "CREATE TABLE "+TABLA_CELDA+" ("+CAMPO_CELDA+" INTEGER PRIMARY KEY, "+CAMPO_UBICACION+" TEXT, "+CAMPO_ESTADO+" INTEGER, "+
                    CAMPO_IDPLACAVEHICULOC+" TEXT, FOREIGN KEY ("+CAMPO_IDPLACAVEHICULOC+" ) REFERENCES "+TABLA_VEHICULOS+" ("+CAMPO_IDPLACAVEHICULO+"))";


}
