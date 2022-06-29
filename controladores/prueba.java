
import controladores.Mailer;
import java.io.UnsupportedEncodingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NelsonHernan
 */
public class prueba {
     public static void main(String[] args) throws UnsupportedEncodingException {
     Mailer.send("castlestand01@outlook.com", "Correo", "Envio un correo de prueba");
     
     }
     
}
