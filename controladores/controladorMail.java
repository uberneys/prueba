/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controladores.Mailer;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author NelsonHernan
 */
@ManagedBean
@SessionScoped
public class controladorMail {

    /**
     * Creates a new instance of controladorMail
     */
    public controladorMail() {
    }
    String asunto="";
    String destinatario="";
    String mensaje="";
    

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public void enviarCorreo() throws UnsupportedEncodingException{
       

            
            Mailer.send(destinatario,asunto,mensajeConEstilo());
            
            
    }
    public String mensajeConEstilo()
    {
        return "<h1 style=\"font-size: 20px; color:#0C0; font-weight: bold; text-transform: uppercase ; \">Mensaje Javamail" + "</h1>" + "<img src='https://pbs.twimg.com/media/FPgf3nzXoAc1cQs?format=jpg&name=medium' style=\"float: left; height: 80px; width: 100px;\"><p>" + mensaje+ "<br>\n"
                    + "<br>\n"
                    + "<p style=\"color:#0C0;font-weight: bold;\" > GRACIAS POR SU MENSAJE NOS PONDREMOS EN CONTACTO</p> ";
    
    }
}
