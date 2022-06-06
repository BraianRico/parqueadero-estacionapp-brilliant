package com.example.ParqueaderoEstacionAppBrilliant.Entidades;

import java.io.Serializable;

public class clientes implements Serializable {


    private String idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String telefonoCliente;
    private String correoCliente;

    //Se define el constructor
    public clientes(
            Integer id,
            String idCliente,
            String nombreCliente,
            String apellidoCliente,
            String telefonoCliente,
            String correoCliente

    ) {

        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.telefonoCliente = telefonoCliente;
        this.correoCliente = correoCliente;
    }

    //Getter y Setters

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }
}