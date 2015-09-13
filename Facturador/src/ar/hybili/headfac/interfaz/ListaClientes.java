package ar.hybili.headfac.interfaz;

import java.util.ArrayList;

import ar.hybili.headfac.conexiones.*;
import ar.hybili.headfac.clases.*;

public class ListaClientes {
	
	
	
	
	public static void main(String[] args){
		
		ArrayList<Cliente> listaClientes;
		ConectorSQLite con = new ConectorSQLite();
		
		con.connect();	 
		listaClientes = con.listaDeCliente();
	    con.close();
	    
	    for (int i=0;i<listaClientes.size();i++){
	    	System.out.println(listaClientes.get(i).toString());
	    }
	    
	}
    
	
}
