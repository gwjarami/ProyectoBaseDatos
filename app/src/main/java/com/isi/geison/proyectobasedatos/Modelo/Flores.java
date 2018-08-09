package com.isi.geison.proyectobasedatos.Modelo;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class Flores implements Serializable{

    private String codigo;
    private String altura;
    private String Caracteristica;
    private String nombre;
    private String precio;
    private String significado;

    public Flores() {
    }

    public Flores(String altura, String caracteristica, String nombre, String precio, String significado) {
        this.altura = altura;
        Caracteristica = caracteristica;
        this.nombre = nombre;
        this.precio = precio;
        this.significado = significado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getCaracteristica() {
        return Caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        Caracteristica = caracteristica;
    }

    public String getSignificado() {
        return significado;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    @Override
    public String toString() {
        return "Flores{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio='" + precio + '\'' +
                ", altura='" + altura + '\'' +
                ", Caracteristica='" + Caracteristica + '\'' +
                ", significado='" + significado + '\'' +
                '}';
    }
}
