package ar.hybili.headfac.interfaz;

import java.io.File;
import java.util.ArrayList;

import ar.hybili.headfac.conexiones.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import ar.hybili.headfac.clases.*;

public class ListaClientes {

	public static void main(String[] args){

		ArrayList<Cliente> listaClientes;
		ConectorSQLite con = new ConectorSQLite();

		con.connect();	 
		listaClientes = con.listaDeCliente("");

		try {
			JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("C:/Users/maria_000/Google Drive/Programacion/GitHub Facturador/Facturador/ReporteCienteBse.jasper");
			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, con.obtenerConexion());
			JasperViewer jasperViewer = new JasperViewer(jasperPrint);
			jasperViewer.setVisible(true);
		} catch (JRException ex) {
			ex.printStackTrace();	    	
		}
		
		con.close();
		
		for (int i=0;i<listaClientes.size();i++){
			System.out.println(listaClientes.get(i).toString());
		}

	}


}
