package com.example.ParqueaderoEstacionAppBrilliant;

//se define los campos de la table
public class Registro {
    private Integer id_registro;
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String fecha;

    @Override
    public String toString() {
        return "Registro{" +
                "id_registro=" + id_registro +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }

    //se define el constructor
    public Registro(Integer id_registro, String placa, String marca, String modelo, String color, String fecha) {
        this.id_registro = id_registro;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.fecha = fecha;
    }

    //getter y setter
    public Integer getId_registro() {
        return id_registro;
    }

    public void setId_registro(Integer id_registro) {
        this.id_registro = id_registro;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
