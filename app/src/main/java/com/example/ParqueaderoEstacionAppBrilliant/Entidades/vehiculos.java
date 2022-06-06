package com.example.ParqueaderoEstacionAppBrilliant.Entidades;

import java.io.Serializable;

public class vehiculos implements Serializable {

    private String idPlacaVechiculo;
    private String modeloVehiculo;
    private String marcaVehiculo;
    private String colorVehiculo;
    private String clienteIdVehiculo;
    private String clienteNombreVehiculo;
    private int horaIngreso;
    private int horaSalida;


    //Se define el constructor
    public vehiculos(
            String idPlacaVechiculo,
            String modeloVehiculo,
            String marcaVehiculo,
            String colorVehiculo,
            String clienteIdVehiculo,
            String clienteNombreVehiculo,
            int horaIngreso,
            int horaSalida)
    {
        this.idPlacaVechiculo = idPlacaVechiculo;
        this.modeloVehiculo = modeloVehiculo;
        this.marcaVehiculo = marcaVehiculo;
        this.colorVehiculo = colorVehiculo;
        this.clienteIdVehiculo = clienteIdVehiculo;
        this.clienteNombreVehiculo = clienteNombreVehiculo;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
    }

    //Getter y Setter


    public String getIdPlaca() {
        return idPlacaVechiculo;
    }

    public void setIdPlaca(String idPlacaVechiculo) {
        this.idPlacaVechiculo = idPlacaVechiculo;
    }

    public String getModelo() {
        return modeloVehiculo;
    }

    public void setModelo(String modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
    }

    public String getMarca() {
        return marcaVehiculo;
    }

    public void setMarca(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public String getColor() {
        return colorVehiculo;
    }

    public void setColor(String colorVehiculo) {
        this.colorVehiculo = colorVehiculo;
    }

    public String getClienteId() {
        return clienteIdVehiculo;
    }

    public void setClienteId(String clienteIdVehiculo) {
        this.clienteIdVehiculo = clienteIdVehiculo;
    }

    public String getClienteNombre() {
        return clienteNombreVehiculo;
    }

    public void setClienteNombre(String clienteNombreVehiculo) {
        this.clienteNombreVehiculo = clienteNombreVehiculo;
    }

    public int getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(int horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }
}
