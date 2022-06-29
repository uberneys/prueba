/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Pedido;
import facades.PedidoFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author maech
 */
@Named(value = "reportePedido")
@SessionScoped
public class ReportePedido implements Serializable {

    /**
     * Creates a new instance of ReportePedido
     */
    public ReportePedido() {
    }
    @EJB
    PedidoFacade pedidofacade;
    List<Pedido> ListaPedidos;
    
    @PostConstruct
    public void init(){
        ListaPedidos = new ArrayList();
            
        }
                
    public List<Pedido> getListarPedidos() {
        return ListaPedidos;
    }

    public void setListaPedidos(List<Pedido> ListaPedidos) {
        this.ListaPedidos = ListaPedidos;
    }
    public List<Pedido> ConsultarPedidos(){
       pedidofacade.findAll();
        return ListaPedidos;
    }
     public void PDF(ActionEvent actionEvent) throws JRException, IOException{
        
    JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(ListaPedidos);
    String ruta=FacesContext.getCurrentInstance().getExternalContext().getRealPath("//reportes//");
        JasperPrint jasperPrint = JasperFillManager.fillReport(ruta+"//ReportePedidos.jasper", new HashMap(),beanCollectionDataSource);
    HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
    httpServletResponse.addHeader("Content-disposition", "attachment; filename=ReportePedidos.pdf");
    ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    FacesContext.getCurrentInstance().responseComplete();
       
   
   }
}
