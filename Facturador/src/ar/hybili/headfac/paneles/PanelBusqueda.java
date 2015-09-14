package ar.hybili.headfac.paneles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.batik.dom.util.ListNodeList;

import ar.hybili.headfac.clases.Cliente;
import ar.hybili.headfac.clases.ClienteBaseListModel;
import ar.hybili.headfac.conexiones.ConectorSQLite;

import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PanelBusqueda extends PanelBase {

	private JPanel contentPane;
	private JTextField tfNombre;
	JList listBusqueda;
	ClienteBaseListModel list_model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelBusqueda frame = new PanelBusqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PanelBusqueda() {

		setLayout(new MigLayout("", "[grow][grow]", "[][grow][]"));
		JLabel lblNombre = new JLabel("Buscar");
		add(lblNombre, "cell 0 0,alignx left");

		tfNombre = new JTextField();
		add(tfNombre, "cell 1 0,growx");
		tfNombre.setColumns(10);

		cargarLista();

		listBusqueda = new JList();
		listBusqueda.setModel(list_model);	
		add(listBusqueda, "cell 0 1 2 1,grow");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

	}

	private void cargarLista(){
		ConectorSQLite con = new ConectorSQLite();
		con.connect();
		list_model = new ClienteBaseListModel(con.listaDeCliente("Select * from base order by nombre"));
		con.close();
	}
	
	public Cliente clienteSeleccionado() {
		Cliente clienteAux = null;
		
		int seleccion = listBusqueda.getSelectedIndex();
		
		if (seleccion!=-1){
			clienteAux = list_model.getCliente(seleccion);
		}
		
		return clienteAux;
	}

}
