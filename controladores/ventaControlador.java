/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Venta;
import facades.VentaFacade;
import javax.inject.Named;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
//import javax.faces.bean.SessionScoped;

/**
 *
 * @author LENOVO
 */
@Named(value = "ventaControlador")
@SessionScoped
public class ventaControlador implements Serializable {

    /**
     * Creates a new instance of ventaControlador
     */
    public ventaControlador() {    
}
        private Venta venta;
        private List<Venta> consultarVenta;
        
        @EJB
        VentaFacade ventaFacade;
        @PostConstruct
        public void init(){
            venta= new Venta();
            consultarVenta= new ArrayList();
        }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<Venta> getConsultarVenta() {
        return consultarVenta;
    }

    public void setConsultarVenta(List<Venta> consultarVenta) {
        this.consultarVenta = consultarVenta;
    }
    
    public List<Venta>consultarVenta(){
        return ventaFacade.findAll();
    }
    public void RegistrarVenta() throws UnsupportedEncodingException{
        venta.setIdVenta(1);
        venta.setIdPedido(0);
        venta.setIva((int) (venta.getSubtotal()*0.19));
        venta.setTotal(venta.getSubtotal()+venta.getIva());
        venta.setEstado(0);
        ventaFacade.create(venta);
    }
        
        
}
