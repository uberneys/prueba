/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Credito;
import facades.CreditoFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author usuario
 */
@Named(value = "graficoControlador")
@RequestScoped
public class GraficoControlador {

    /**
     * Creates a new instance of GraficoControlador
     */
    public GraficoControlador() {
    }
    private BarChartModel barModel;
    private PieChartModel pieModel;
    private Credito credito;
    private List<Credito> consultarCredito;
    
    @EJB
    CreditoFacade creditoFacade;
    
    @PostConstruct
    public void init() {
        createBarModels();
        
    }
    
    public BarChartModel getBarModel() {
        return barModel;
    }
    
    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
    
    private void createBarModels() {
        barModel = new BarChartModel();
        
        ChartSeries productos = new ChartSeries();
        productos.setLabel("Producto");
//        List<Object[]> listaProductos=productoFacade.consultarTotales();
//        for (Object[] producto : listaProductos) {
//            productos.set(producto[0].toString(),Integer.parseInt(producto[1].toString()));
//        }
        List<Credito> listaProductos = creditoFacade.findAll();
        for (Credito producto : listaProductos) {
            productos.set(producto.getNumCredito(), producto.getCupoCredito());
        }
        
        barModel.addSeries(productos);
        
        barModel.setTitle("Total Productos");
        barModel.setLegendPosition("ne");
        
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Producto");
        
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Total");
        yAxis.setMin(0);
        yAxis.setMax(2500000);
    }
    
    
    public PieChartModel getPieModel() {
        return pieModel;
    }
    
    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
    
    public Credito getCredito() {
        return credito;
    }
    
    public void setCredito(Credito credito) {
        this.credito = credito;
    }
    
    public List<Credito> getConsultarCredito() {
        return consultarCredito;
    }
    
    public void setConsultarCredito(List<Credito> consultarCredito) {
        this.consultarCredito = consultarCredito;
    }
    
}
