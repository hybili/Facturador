package ar.hybili.headfac.clases;

import ar.hybili.headfac.conexiones.ConectorSQLite;

public class Producto {
	private int id;
	private String	nombre;
	private String	descripcion;
	private int		rubro;
	private int		subrubro;
	private int		caracteristica_1;
	private int		caracteristica_2;
	private String	estado;
	private double	precioVentas;
	private double 	precioCompra;
	private float 	stock;
	private int 	codigoBarras;

	public Producto(){
		id = 0;
		nombre = "";
		descripcion = "";
		rubro = 0;
		subrubro = 0;
		caracteristica_1 = 0;
		caracteristica_2 = 0;
		estado = "A";		
	}

	public Producto(int id, String nombre, String descripcion, double precioVentas, double precioCompra, float stock,
			int codigoBarras) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioVentas = precioVentas;
		this.precioCompra = precioCompra;
		this.stock = stock;
		this.codigoBarras = codigoBarras;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getRubro() {
		return rubro;
	}
	public void setRubro(int rubro) {
		this.rubro = rubro;
	}
	public int getSubrubro() {
		return subrubro;
	}
	public void setSubrubro(int subrubro) {
		this.subrubro = subrubro;
	}
	public int getCaracteristica_1() {
		return caracteristica_1;
	}
	public void setCaracteristica_1(int caracteristica_1) {
		this.caracteristica_1 = caracteristica_1;
	}
	public int getCaracteristica_2() {
		return caracteristica_2;
	}
	public void setCaracteristica_2(int caracteristica_2) {
		this.caracteristica_2 = caracteristica_2;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double getPrecioVentas() {
		return precioVentas;
	}
	public void setPrecioVentas(double precioVentas) {
		this.precioVentas = precioVentas;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public float getStock() {
		return stock;
	}
	public void setStock(float stock) {
		this.stock = stock;
	}
	public int getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(int codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", rubro=" + rubro
				+ ", subrubro=" + subrubro + ", caracteristica_1=" + caracteristica_1 + ", caracteristica_2="
				+ caracteristica_2 + ", estado=" + estado + ", precioVentas=" + precioVentas + ", precioCompra="
				+ precioCompra + ", stock=" + stock + ", codigoBarras=" + codigoBarras + "]";
	}

	public void save(){
        ConectorSQLite con = new ConectorSQLite();        
        con.connect();
        con.saveProductoBase(this);
        con.close();
    }



}
