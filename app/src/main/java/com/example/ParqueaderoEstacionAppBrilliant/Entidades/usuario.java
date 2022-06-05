package com.example.ParqueaderoEstacionAppBrilliant.Entidades;

import java.io.Serializable;

public class usuario implements Serializable {

    private Integer id_usuario;
    private String nombre;
    private String apellido;
    private String telefono;

    //Se define el constructor
    public usuario(Integer id_usuario, String nombre, String apellido, String telefono) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    //Getter y Setter
    public Integer getId() {return id_usuario;}
    public void setId(Integer id_usuario) {this.id_usuario = id_usuario;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}

}
