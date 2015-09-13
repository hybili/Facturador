package ar.hybili.headfac.interfaz;

import java.io.File;
import java.util.ArrayList;

import ar.hybili.headfac.conexiones.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import ar.hybili.headfac.clases.*;

public class ListaClientes {
	
	public static void main(String[] args){
		
		ArrayList<Cliente> listaClientes;
		ConectorSQLite con = new ConectorSQLite();
		
		con.connect();	 
		listaClientes = con.listaDeCliente();
	    con.close();
	   /** JasperReport reporte;
	    reporte = (JasperReport) JRLoader.loadObject(new File("ClientesBase.jrxml"));
	    JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(listaClientes));

	    **/
	    for (int i=0;i<listaClientes.size();i++){
	    	System.out.println(listaClientes.get(i).toString());
	    }
	    
	}
    
	
}
