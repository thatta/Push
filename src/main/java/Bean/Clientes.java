/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Modelo.Accion;
import Modelo.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringEscapeUtils;
import org.primefaces.event.RowEditEvent;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

/**
 *
 * @author USER
 */
@ManagedBean
@RequestScoped
public class Clientes implements Serializable{
    
    /**
     * 
     */
    
    private String nombre;
    private String apellido;
    private int documento;
    
    
    /**
     *  construcctor vacio
     */
    public Clientes(){
 
    }
    /**
     * 
     */
    @ManagedProperty("#{clientesSession}") 
    private ClientesSession clientesSession; 
    
    @ManagedProperty("#{administrador}")
    private Administrador administrador;
    
    
    /**
     * 
     * @return 
     */
    public ClientesSession getClientesSession() {
        return clientesSession;
    }
    /**
     * 
     * @param clientesSession 
     */
    public void setClientesSession(ClientesSession clientesSession) {
        this.clientesSession = clientesSession;
    }
    /**
     * 
     * @return 
     */

    public Administrador getAdministrador() {
        return administrador;
    }
    /**
     * 
     * @param administrador 
     */

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    
    

    /**
     * 
     * @return nombre
     * funcion get para obtener el nombre del candidato
     */

    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @param nombre 
     * funcion set para modificar el nombre del candidato
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * @return 
     * funcion get para obtener el apellido del candidato
     */

    public String getApellido() {
        return apellido;
    }
    /**
     * 
     * @param apellido 
     * funcion set para modificar el apellido del candidato
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * 
     * @return 
     * funcion get para obtener la cedula del candidato
     */
    public int getDocumento() {
        return documento;
    }
    /**
     * 
     * @param documento 
     * funcion set para modificar la cedula del candidato
     */
    public void setDocumento(int documento) {
        this.documento = documento;
    }
    
    
    FacesContext fCtx = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
    String sessionId = session.getId();
    
    
    /**
     * metodo para agregae una nueva persona a la lista, hacer la notificacion y mostrar la accion en la tabla del administrador
     */
    
    public void agregar(){
        clientesSession.getListaPersona().add(new Persona(nombre, apellido, documento));
        FacesContext context = FacesContext.getCurrentInstance();         
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", 
                "Persona agregada"));   
        notificarPush("Nuevo Registro", "El cliente " + sessionId + " ha agregado a " + nombre + " " + apellido);
        administrador.getListaAcciones().add(new Accion("Nuevo Registro", "El cliente " + sessionId + " ha agregado a " + nombre + " " + apellido));
    }
    /**
     * 
     * @param event 
     * evento para editar los campos de la persona seleccionada, hacer la notificacion y mostrar la accion en la tabla del administrador
     */
    
    public void onRowEdit(RowEditEvent event) {
        Persona persona = ((Persona) event.getObject());
        FacesMessage msg = new FacesMessage("Persona Editada", ((Persona) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        notificarPush("Registro Actualizado", "El cliente " + sessionId + " ha modificado los datos de " + persona.getNombre()  + " " + persona.getApellido());
         administrador.getListaAcciones().add(new Accion("Registro Actualizado", "El cliente " + sessionId + " ha modificado los datos de " + persona.getNombre() + " " + persona.getApellido()));
    }
     /**
      * 
      * @param event 
      * evento para cancelar la edicion de los datos de la persona seleccionada, hacer la notificacion y mostrar la accion en la tabla del administrador
      */
    public void onRowCancel(RowEditEvent event) {
        Persona persona = ((Persona) event.getObject());
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Persona) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        notificarPush("Registro Actualizado", "El cliente " + sessionId + " ha cancelado la modificacion de los datos de " + persona.getNombre()  + " " + persona.getApellido());
         administrador.getListaAcciones().add(new Accion("Registro Cancelado", "El cliente " + sessionId + " ha cancelado la modificacon de  los datos de " + persona.getNombre() + " " + persona.getApellido()));
    }
    
    /**
     * metodo para eliminar una persona de la lista, hacer la notificacion y mostrar la accion en la tabla del administrador
     */
    public void eliminar(Persona persona){
        clientesSession.getListaPersona().remove(persona);
        notificarPush("Registro Eliminado", "El cliente " + sessionId + " ha eliminado el usuario " + persona.getNombre() + " " + persona.getApellido());
        administrador.getListaAcciones().add(new Accion("Registro Eliminado", "El cliente " + sessionId + " ha eliminado el usuario " + persona.getNombre() + " " + persona.getApellido()));
    }
    /**
     * 
     * @param titulo
     * @param detalle 
     * metodo para mostrar que accion se hizo en la tabla sobre una persona
     */
    
    public void notificarPush(String titulo, String detalle) {
        String canal = "/notificacion";
        EventBus eventBus = EventBusFactory.getDefault().eventBus();
        eventBus.publish(canal, new FacesMessage(FacesMessage.SEVERITY_ERROR, StringEscapeUtils.escapeHtml3(titulo), StringEscapeUtils.escapeHtml3(detalle)));
    }
}
