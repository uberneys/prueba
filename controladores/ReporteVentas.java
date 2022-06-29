/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Venta;
import facades.VentaFacade;
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
@Named(value = "reporteVentas")
@SessionScoped
public class ReporteVentas implements Serializable {

    /**
     * Creates a new instance of ReporteVentas
     */
    public ReporteVentas() {
    }
    @EJB
    VentaFacade ventafacade;
     
    List<Venta> ListaVentas;
     @PostConstruct
     public void init(){
         ListaVentas = new ArrayList();
     }

    public List<Venta> getListaVentas() {
        return ListaVentas;
    }

    public void setListaVentas(List<Venta> ListaVentas) {
        this.ListaVentas = ListaVentas;
    }
public List<Venta> ConsultarVentas(){
    ventafacade.findAll();//aca esta el error :)
    return ListaVentas;
}
 public void PDF(ActionEvent actionEvent) throws JRException, IOException{
        
    JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(ListaVentas);
    String ruta=FacesContext.getCurrentInstance().getExternalContext().getRealPath("//reportes//");
        JasperPrint jasperPrint = JasperFillManager.fillReport(ruta+"//ReporteVentas.jasper", new HashMap(),beanCollectionDataSource);
    HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
    httpServletResponse.addHeader("Content-disposition", "attachment; filename=Reporteventas.pdf");
    ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    FacesContext.getCurrentInstance().responseComplete();
       
   
   }
}
