package ar.hybili.headfac.test;

import ar.hybili.headfac.conexiones.*;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConectorSQLite con = new ConectorSQLite();
		con.setUrl("C:/Users/maria_000/Documents/SQLite/Facturador/Clientes.sqlite");
		con.connect();
		con.close();
	}

}
