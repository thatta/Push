/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Tatiana Almansa
 * @author Brayan Aldana
 */

public class Accion implements Serializable{
    /**
     * atributos que tendran la accion que hada cada cliente
     */
    private String titulo;
    private String accion;
    
    /**
     * 
     * @param titulo
     * @param accion 
     * contructor de cada atributo
     */
    public Accion(String titulo, String accion) {
        this.titulo = titulo;
        this.accion = accion;
    }
    /**
     * 
     * @return 
     * funcion get para obtener el titulo de la accion
     */

    public String getTitulo() {
        return titulo;
    }
    /**
     * 
     * @param titulo 
     * funcion set para modificar el titulo de la accion
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * 
     * @return 
     * funcion get para obtener el tipo de  accion
     */
    public String getAccion() {
        return accion;
    }
    /**
     * 
     * @param accion 
     * funcion set para modificar el tipo de  accion
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    
}
