package com.example.ParqueaderoEstacionAppBrilliant.Entidades;

import java.io.Serializable;

//se define los campos de la table
public class Registro implements Serializable {

    private Integer id_registro;
    private String fecha_hora;
    private String movimiento;
    private String novedad;
    private String placa_id;

    //Se define el constructor
    public Registro(Integer id_registro, String fecha_hora, String movimiento, String novedad, String placa_id) {
        this.id_registro = id_registro;
        this.placa_id = placa_id;
        this.movimiento = movimiento;
        this.novedad=novedad;
        this.fecha_hora = fecha_hora;
    }

    //getter y setter
    public Integer getId_registro() {return id_registro;}
    public void setId_registro(Integer id_registro) {this.id_registro = id_registro;}
    public String getFecha_hora() {return fecha_hora;}
    public void setFecha_hora(String fecha_hora) {this.fecha_hora = fecha_hora;}
    public String getPlaca_id() {return placa_id;}
    public void setPlaca_id(String placa_id) {this.placa_id = placa_id;}
    public String getMovimiento() {return movimiento;}
    public void setMovimiento(String movimiento) {this.movimiento = movimiento;}
    public String getNovedad() {return novedad;}
    public void setNovedad(String novedad) {this.novedad = novedad;}


    }

