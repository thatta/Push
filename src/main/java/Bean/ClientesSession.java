/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Modelo.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author USER
 */
@ManagedBean
@SessionScoped
public class ClientesSession  implements Serializable{
    
    /**
     * 
     */

    private List<Persona> listaPersona;
    
    /**
     * 
     */
     public ClientesSession() {
        listaPersona = new ArrayList<>();
    }
     /**
      * 
      * @return 
      */
    public List<Persona> getListaPersona() {
        return listaPersona;
    }
    /**
     * 
     * @param listaPersona 
     */
    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }


}
