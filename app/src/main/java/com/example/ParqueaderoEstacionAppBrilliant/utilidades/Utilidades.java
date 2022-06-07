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

    //Constantes de la tabla factura
    public static final String TABLA_FACTURA="factura";
    public static final String CAMPO_FACTURA="id_factura";
    public static final String CAMPO_FECHA_FACTURA="fecha_factura";
    public static final String CAMPO_VALOR="valor";
    public static final String CAMPO_MESES="meses";
    public static final String CAMPO_SUSCRIPCION_IDF="suscripcion_id";

    //constantes de tabla registro
    public static final String TABLA_REGISTRO="registro";
    public static final String CAMPO_ID_REGISTRO="id_registro";
    public static final String CAMPO_FECHA_HORA="fecha_hora";
    public static final String CAMPO_MOVIMIENTO="movimiento";
    public static final String CAMPO_NOVEDAD="novedad";
    public static final String CAMPO_IDPLACAVEHICULOR="placa_id";

    // constantes de tabla CLIENTES
    public static final String TABLA_CLIENTES="clientes";
    public static final String CAMPO_IDCLIENTE="idCliente";
    public static final String CAMPO_NOMBRECLIENTE="nombreCliente";
    public static final String CAMPO_TELEFONOCLIENTE="telefonoCliente";
    public static final String CAMPO_CORREOCLIENTE="correoCliente";
// constantes de tabla CLIENTES


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
                    CAMPO_COLORVEHICULO+" TEXT, "+CAMPO_IDCLIENTEVEHICULO+" TEXT, "+CAMPO_NOMBRECLIENTEVEHICULO+" TEXT,"+CAMPO_HORAINGRESO+" TEXT, "+CAMPO_HORASALIDA+" TEXT )";


    //Creación de la tabla celda
    public static final String CREAR_TABLA_CELDA=
            "CREATE TABLE "+TABLA_CELDA+" ("+CAMPO_CELDA+" INTEGER PRIMARY KEY, "+CAMPO_UBICACION+" TEXT, "+CAMPO_ESTADO+" INTEGER, "+CAMPO_IDPLACAVEHICULOC+" TEXT, FOREIGN KEY ("+CAMPO_IDPLACAVEHICULOC+" ) REFERENCES "+TABLA_VEHICULOS+" ("+CAMPO_IDPLACAVEHICULO+"))";

    //Creación de la tabla factura
    public static final String CREAR_TABLA_FACTURA=
            "CREATE TABLE "+TABLA_FACTURA+" ("+CAMPO_FACTURA+" INTEGER PRIMARY KEY, "+CAMPO_FECHA_FACTURA+" TEXT, "+CAMPO_VALOR+" INTEGER, "+CAMPO_MESES+" INTEGER, "+CAMPO_SUSCRIPCION_IDF+" INTEGER)";

    //Creación de la tabla registro
    public static final String CREAR_TABLA_REGISTRO =
            "CREATE TABLE "+TABLA_REGISTRO+" ("+CAMPO_ID_REGISTRO+" INTEGER PRIMARY KEY, "+CAMPO_FECHA_HORA+" TEXT, "+CAMPO_MOVIMIENTO+" TEXT, "+CAMPO_NOVEDAD+" TEXT,  "+CAMPO_IDPLACAVEHICULOR+" TEXT, FOREIGN KEY ("+CAMPO_IDPLACAVEHICULOR+" ) REFERENCES "+TABLA_VEHICULOS+" ("+CAMPO_IDPLACAVEHICULO+"))";


}
