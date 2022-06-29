/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Compra;
import entidades.Credito;
import entidades.Inventario;
import entidades.Pedido;
import entidades.Proveedor;
import entidades.Usuario;
import entidades.Venta;
import facades.CompraFacade;
import facades.CreditoFacade;
import facades.InventarioFacade;
import facades.PedidoFacade;
import facades.ProveedorFacade;
import facades.UsuarioFacade;
import facades.VentaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Family
 */
@Named(value = "creditoControlador")
@SessionScoped
public class creditoControlador implements Serializable {

    /**
     * Creates a new instance of creditoControlador
     */
    public creditoControlador() {
    }
    private Usuario usuario;
    private Credito credito;
    private Compra compra;
    private Venta venta;
    private Pedido pedido;
    private Inventario inventario;
    private Proveedor proveedor;
    private List<Proveedor> consultarProveedor;
    private List<Pedido> consultarPedido;
    private List<Venta> consultarVenta;
    private List<Credito> consultarCredito;
    private List<Compra> consultarCompra;
    private List<Inventario> consultarInventario;

    @EJB
    CreditoFacade creditoFacade;
    @EJB
    UsuarioFacade usuarioFacade;
    @EJB
    CompraFacade compraFacade;
    @EJB
    VentaFacade ventaFacade;
    @EJB
    PedidoFacade pedidoFacade;
    @EJB
    InventarioFacade inventarioFacade;
    @EJB
    ProveedorFacade proveedorFacade;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        credito = new Credito();
        compra = new Compra();
        venta = new Venta();
        proveedor = new Proveedor();
        consultarProveedor = new ArrayList();
        consultarCredito = new ArrayList();
        consultarCompra = new ArrayList();
        consultarVenta = new ArrayList();
        consultarPedido = new ArrayList();
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Credito> ConsultarCreditos() {
        return creditoFacade.findAll();
    }

    public void RegistrarCredito() throws UnsupportedEncodingException {
        credito.setNumCredito(1);
        credito.setIdVenta(0);
        creditoFacade.create(credito);
    }

    public String validar() {

        if ("12345".equals(usuario.getIdentificacion()) && "Juan123".equals(usuario.getClave())) {
            return "InicioSesion";
        } else {
            return "AdminP";
        }
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public List<Compra> getConsultarCompra() {
        return consultarCompra;
    }

    public void setConsultarCompra(List<Compra> consultarCompra) {
        this.consultarCompra = consultarCompra;
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

    public void RegistrarCompra() throws UnsupportedEncodingException {
        compra.setIdCompras(1);
        compra.setEstado(null);
        compra.setTotal(compra.getPrecio() * compra.getCantidad());
        compraFacade.create(compra);
    }

    public List<Compra> ConsultarCompras() {
        return compraFacade.findAll();
    }

    public void RegistrarVenta() throws UnsupportedEncodingException {
        venta.setIdVenta(1);
        venta.setIdPedido(0);
        venta.setIva((int) (venta.getSubtotal() * 0.19));
        venta.setTotal(venta.getSubtotal() + venta.getIva());
        venta.setEstado(0);
        ventaFacade.create(venta);
    }

    public List<Venta> ConsultarVentas() {
        return ventaFacade.findAll();
    }

    public void eliminarCredito(Credito credito) {
        creditoFacade.remove(credito);
    }

    public void eliminarCompra(Compra compra) {
        compraFacade.remove(compra);
    }

    public void eliminarVenta(Venta venta) {
        ventaFacade.remove(venta);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> getConsultarPedido() {
        return consultarPedido;
    }

    public void setConsultarPedido(List<Pedido> consultarPedido) {
        this.consultarPedido = consultarPedido;
    }

    public List<Pedido> consultarPedidos() {
        return pedidoFacade.findAll();
    }

    public void eliminarPedido(Pedido pedido) {
        pedidoFacade.remove(pedido);
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public List<Inventario> getConsultarInventario() {
        return consultarInventario;
    }

    public void setConsultarInventario(List<Inventario> consultarInventario) {
        this.consultarInventario = consultarInventario;
    }

    public List<Inventario> consultarInventarios() {
        return inventarioFacade.findAll();
    }

    public void eliminarInventario(Inventario inventario) {
        inventarioFacade.remove(inventario);
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Proveedor> getConsultarProveedor() {
        return consultarProveedor;
    }

    public void setConsultarProveedor(List<Proveedor> consultarProveedor) {
        this.consultarProveedor = consultarProveedor;
    }

    public void RegistrarProveedor() throws UnsupportedEncodingException {
        proveedor.setIdCompras(1);
        proveedor.setIdProveedor(1);
        proveedorFacade.create(proveedor);
    }

    public List<Proveedor> consultarProveedor() {
        return proveedorFacade.findAll();
    }

    public void eliminarProveedor(Proveedor proveedor) {
        proveedorFacade.remove(proveedor);
    }
}
