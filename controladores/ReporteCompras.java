/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Compra;
import facades.CompraFacade;
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
@Named(value = "reporteCompras")
@SessionScoped
public class ReporteCompras implements Serializable {

    /**
     * Creates a new instance of ReporteCompras
     */
    public ReporteCompras() {
    }
    @EJB 
    CompraFacade comprafacade;
    
    List<Compra> ListaCompras;
   @PostConstruct
    public void init(){
        ListaCompras = new ArrayList();
    }

    public List<Compra> getListaCompras() {
        return ListaCompras;
    }

    public void setListaCompras(List<Compra> ListaCompras) {
        this.ListaCompras = ListaCompras;
    }
    public List<Compra> ConsultarCompras(){
        ListaCompras =comprafacade.findAll();
        return ListaCompras;
    }
     public void PDF(ActionEvent actionEvent) throws JRException, IOException{
        
    JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(ListaCompras);
    String ruta=FacesContext.getCurrentInstance().getExternalContext().getRealPath("//reportes//");
        JasperPrint jasperPrint = JasperFillManager.fillReport(ruta+"//ReporteCompra.jasper", new HashMap(),beanCollectionDataSource);
    HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
    httpServletResponse.addHeader("Content-disposition", "attachment; filename=ReporteCompra.pdf");
    ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    FacesContext.getCurrentInstance().responseComplete();
       
   
   }
}
