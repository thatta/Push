/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package push;

import javax.faces.application.FacesMessage;
import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.impl.JSONEncoder;

/**
 *
 * @author USER
 */
@PushEndpoint("/notificacion")
public class Notificacion {

    /**
     * Creates a new instance of Notificacion
     */
    public Notificacion() {
    }
    
    @OnMessage(encoders = {JSONEncoder.class})
    public FacesMessage mensaje(FacesMessage mensajeNotificacion){
        return mensajeNotificacion;
    }
}
