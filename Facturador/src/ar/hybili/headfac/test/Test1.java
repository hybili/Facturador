package ar.hybili.headfac.test;

import ar.hybili.headfac.conexiones.*;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConectorSQLite con = new ConectorSQLite();		
		con.connect();
		con.close();
	}

}
