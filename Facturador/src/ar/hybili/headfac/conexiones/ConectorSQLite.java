package ar.hybili.headfac.conexiones;

import ar.hybili.headfac.clases.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectorSQLite {

	private String url;
	private Connection connect;

	public ConectorSQLite(){
		url = "C:/Users/maria_000/Documents/SQLite/Facturador/Clientes.sqlite";
	}

	public void connect(){
		try {
			connect = DriverManager.getConnection("jdbc:sqlite:"+url);
			if (connect!=null) {
				System.out.println("Conectado");
			}
		}catch (SQLException ex) {
			System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
		}
	}

	public void close(){
		try {
			connect.close();
		} catch (SQLException ex) {
			Logger.getLogger(ConectorSQLite.class.getName()).log(Level.SEVERE, null, ex);
		}		
	}

	public void saveClienteBase(Cliente cliente){
		try {
			PreparedStatement st = connect.prepareStatement("insert into base (orden, radio, codigoPostal, cuit, nroIIBB, saldo, nombre, razonSocial, razonSocialFiscal, contacto, direccion, localidad, codigoPostalCompleto) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");

			st.setInt(1, cliente.get_orden());
			st.setInt(2, cliente.get_radio());
			st.setInt(3, cliente.get_codigoPostal());

			st.setDouble(4, cliente.get_cuit());
			st.setDouble(5, cliente.get_nroIIBB());
			st.setDouble(6, cliente.get_cuit());

			st.setString(7, cliente.get_nombre());
			st.setString(8, cliente.get_razonSocial());
			st.setString(9, cliente.get_razonSocialFiscal());
			st.setString(10, cliente.get_contacto());
			st.setString(11, cliente.get_direccion());
			st.setString(12, cliente.get_localidad());
			st.setString(13, cliente.get_codigoPostalCompleto());						

			st.execute();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

	}

	public Cliente findCliente(int id) {
		ResultSet result = null;
		Cliente clienteAux = null;

		try {
			PreparedStatement st = connect.prepareStatement("select * from base where id=" + id);
			result = st.executeQuery();
			if (result != null) {
				while (result.next()) {
					System.out.print("ID: ");
					System.out.println(result.getInt("id"));

					System.out.print("Nombre: ");
					System.out.println(result.getString("nombre"));

					System.out.print("Razon: ");
					System.out.println(result.getString("razonSocial"));

					System.out.println("=======================");

				}
			} else {
				System.out.println("No hay registros");
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}

		return clienteAux;
	}


	@Override
	public String toString() {
		return "ConectorSQLite [url=" + url + ", connect=" + connect + "]";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
