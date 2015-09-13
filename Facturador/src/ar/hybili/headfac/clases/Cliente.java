package ar.hybili.headfac.clases;

import ar.hybili.headfac.conexiones.*;
import java.util.ArrayList;

//import ar.hybili.headfac.clases.*;

public class Cliente {
	
	int _id;
	int _orden;
	int _radio;
	int _codigoPostal;
	
	double _cuit;
	double _nroIIBB;
	double _saldo;
	
	String _nombre;
	String _razonSocial;
	String _razonSocialFiscal;	
	String _contacto;
	String _direccion;
	String _localidad;	
	String _codigoPostalCompleto;

	TipoIvaCliente _tipoIvaCliente;
	//Telefono _telefono;
	ArrayList<Telefono> _listaTelefonos = new ArrayList<Telefono>();	
	
	public void agregarTelefono(Telefono tel){
		_listaTelefonos.add(tel);
	}
	
	public Cliente(){
		this._id = 0;
		this._nombre = "";
		this._razonSocial = "";
		this._razonSocialFiscal = "";
		this._cuit = 0;
		this._direccion = "";
		this._localidad = "";
		this._codigoPostal = 0;
		this._codigoPostalCompleto = "";
		this._tipoIvaCliente = TipoIvaCliente.INSCRIPTO;		
	}
	
	public Cliente(int _id, String _nombre, String _razonSocial,
			String _razonSocialFiscal, double _cuit, String _direccion,
			String _localidad, int _codigoPostal, String _codigoPostalCompleto,
			TipoIvaCliente _tipoIvaCliente) {

		this._id = _id;
		this._nombre = _nombre;
		this._razonSocial = _razonSocial;
		this._razonSocialFiscal = _razonSocialFiscal;
		this._cuit = _cuit;
		this._direccion = _direccion;
		this._localidad = _localidad;
		this._codigoPostal = _codigoPostal;
		this._codigoPostalCompleto = _codigoPostalCompleto;
		this._tipoIvaCliente = _tipoIvaCliente;
	}

	@Override
	public String toString() {
		return "Cliente [_id=" + _id + ", _orden=" + _orden + ", _radio="
				+ _radio + ", _codigoPostal=" + _codigoPostal + ", _cuit="
				+ _cuit + ", _nroIIBB=" + _nroIIBB + ", _saldo=" + _saldo
				+ ", _nombre=" + _nombre + ", _razonSocial=" + _razonSocial
				+ ", _razonSocialFiscal=" + _razonSocialFiscal + ", _contacto="
				+ _contacto + ", _direccion=" + _direccion + ", _localidad="
				+ _localidad + ", _codigoPostalCompleto="
				+ _codigoPostalCompleto + ", _tipoIvaCliente="
				+ _tipoIvaCliente + ", _listaTelefonos=" + _listaTelefonos
				+ "]";
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public int get_orden() {
		return _orden;
	}

	public void set_orden(int _orden) {
		this._orden = _orden;
	}

	public int get_radio() {
		return _radio;
	}

	public void set_radio(int _radio) {
		this._radio = _radio;
	}

	public int get_codigoPostal() {
		return _codigoPostal;
	}

	public void set_codigoPostal(int _codigoPostal) {
		this._codigoPostal = _codigoPostal;
	}

	public double get_cuit() {
		return _cuit;
	}

	public void set_cuit(double _cuit) {
		this._cuit = _cuit;
	}

	public double get_nroIIBB() {
		return _nroIIBB;
	}

	public void set_nroIIBB(double _nroIIBB) {
		this._nroIIBB = _nroIIBB;
	}

	public double get_saldo() {
		return _saldo;
	}

	public void set_saldo(double _saldo) {
		this._saldo = _saldo;
	}

	public String get_nombre() {
		return _nombre;
	}

	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}

	public String get_razonSocial() {
		return _razonSocial;
	}

	public void set_razonSocial(String _razonSocial) {
		this._razonSocial = _razonSocial;
	}

	public String get_razonSocialFiscal() {
		return _razonSocialFiscal;
	}

	public void set_razonSocialFiscal(String _razonSocialFiscal) {
		this._razonSocialFiscal = _razonSocialFiscal;
	}

	public String get_contacto() {
		return _contacto;
	}

	public void set_contacto(String _contacto) {
		this._contacto = _contacto;
	}

	public String get_direccion() {
		return _direccion;
	}

	public void set_direccion(String _direccion) {
		this._direccion = _direccion;
	}

	public String get_localidad() {
		return _localidad;
	}

	public void set_localidad(String _localidad) {
		this._localidad = _localidad;
	}

	public String get_codigoPostalCompleto() {
		return _codigoPostalCompleto;
	}

	public void set_codigoPostalCompleto(String _codigoPostalCompleto) {
		this._codigoPostalCompleto = _codigoPostalCompleto;
	}

	public TipoIvaCliente get_tipoIvaCliente() {
		return _tipoIvaCliente;
	}

	public void set_tipoIvaCliente(TipoIvaCliente _tipoIvaCliente) {
		this._tipoIvaCliente = _tipoIvaCliente;
	}

	public ArrayList<Telefono> get_listaTelefonos() {
		return _listaTelefonos;
	}

	public void set_listaTelefonos(ArrayList<Telefono> _listaTelefonos) {
		this._listaTelefonos = _listaTelefonos;
	}

	public void save(){
        ConectorSQLite con = new ConectorSQLite();        
        con.connect();
        con.saveClienteBase(this);
        con.close();
    }	
	
}
