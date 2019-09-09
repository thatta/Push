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
public class Persona  implements Serializable{
    /**
     * atributos del objeto persona
     */
    private String nombre;
    private String apellido;
    private int documento;
    private boolean selected;
    
    /**
     * 
     * @param nombre
     * @param apellido
     * @param documento 
     * condtructor de cada atributo
     */

    public Persona(String nombre, String apellido, int documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
    }
    /**
     * contructor vacio
     */

    public Persona() {
        
    }
    
    /**
     * 
     * @return nombre
     * funcion get para obtener el nombre de la persona
     */

    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @param nombre 
     * funcion set para modificar el nombre de la persona
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @return 
     * funcion get para obtener el apellido de la persona
     */

    public String getApellido() {
        return apellido;
    }
    /**
     * 
     * @param apellido 
     * funcion set para modificar el apellido de la persona
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * 
     * @return 
     * funcion get para obtener el documento de la persona
     */
    public int getDocumento() {
        return documento;
    }
    /**
     * 
     * @param documento 
     * funcion set para modificar el documento de la persona
     */
    public void setDocumento(int documento) {
        this.documento = documento;
    }
    /**
     * 
     * @return 
     */
    public boolean isSelected() {
        return selected;
    }
    /**
     * 
     * @param selected 
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    
    
}

