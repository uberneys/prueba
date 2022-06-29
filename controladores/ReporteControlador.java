/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Credito;
import facades.CreditoFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
@Named(value = "reporteControlador")
@SessionScoped
public class ReporteControlador implements Serializable {

    /**
     * Creates a new instance of ReporteControlador
     */
    public ReporteControlador() {
    }
    @EJB
    CreditoFacade creditofacade;
    
    List<Credito> ListaCreditos;
    
    @PostConstruct
    public void init(){
      ListaCreditos = new ArrayList();  
        
    }

    public List<Credito> getListaCreditos() {
        return ListaCreditos;
    }

    public void setListaCreditos(List<Credito> ListaCreditos) {
        this.ListaCreditos = ListaCreditos;
    }
    
    public List<Credito> ConsultarCreditos(){
       ListaCreditos =creditofacade.findAll();
       return ListaCreditos;
    }
     public void PDF(ActionEvent actionEvent) throws JRException, IOException{
        
    JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(ListaCreditos);
    String ruta=FacesContext.getCurrentInstance().getExternalContext().getRealPath("//reportes//");
        JasperPrint jasperPrint = JasperFillManager.fillReport(ruta+"//ReporteCredito.jasper", new HashMap(),beanCollectionDataSource);
    HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
    httpServletResponse.addHeader("Content-disposition", "attachment; filename=ReporteCredito.pdf");
    ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    FacesContext.getCurrentInstance().responseComplete();
       
   
   }
    
}
