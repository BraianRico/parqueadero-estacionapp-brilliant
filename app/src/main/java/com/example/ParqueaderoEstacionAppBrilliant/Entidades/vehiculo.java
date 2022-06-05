package com.example.ParqueaderoEstacionAppBrilliant.Entidades;

import java.io.Serializable;

public class vehiculo implements Serializable {

    private String id_placa;
    private String modelo;
    private String marca;
    private String color;
    private Integer cliente_id;

    //Se define el constructor
    public vehiculo(Integer cliente_id, String id_placa, String modelo, String marca, String color) {
        this.cliente_id = cliente_id;
        this.id_placa = id_placa;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
    }

    //Getter y Setter
    public Integer getCliente_id() {return cliente_id;}
    public void setCliente_id(Integer cliente_id) {this.cliente_id = cliente_id;}
    public String getId_placa() {return id_placa;}
    public void setId_placa(String id_placa) {this.id_placa = id_placa;}
    public String getModelo() {return modelo;}
    public void setModelo(String modelo) {this.modelo = modelo;}
    public String getMarca() {return marca;}
    public void setMarca(String marca) {this.marca = marca;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
}
