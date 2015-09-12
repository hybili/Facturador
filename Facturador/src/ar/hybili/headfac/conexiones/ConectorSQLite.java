package ar.hybili.headfac.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectorSQLite {

	private String url;
	private Connection connect;

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
