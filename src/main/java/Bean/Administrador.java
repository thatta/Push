/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Modelo.Accion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Tatiana Almansa
 * @author Brayan Aldana
 */

@ManagedBean
@ApplicationScoped
public class Administrador implements Serializable{
    
    /**
     * 
     */

    private List<Accion> listaAcciones;
    /**
     * 
     */
    
    public Administrador() {
        listaAcciones = new ArrayList();
    }
    /**
     * 
     * @return 
     */
    public List<Accion> getListaAcciones() {
        return listaAcciones;
    }
    /**
     * 
     * @param listaAcciones 
     */

    public void setListaAcciones(List<Accion> listaAcciones) {
        this.listaAcciones = listaAcciones;
    }
}
