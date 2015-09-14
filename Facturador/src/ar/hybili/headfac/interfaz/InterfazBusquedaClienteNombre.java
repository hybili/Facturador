package ar.hybili.headfac.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.hybili.headfac.clases.Cliente;
import ar.hybili.headfac.paneles.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazBusquedaClienteNombre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazBusquedaClienteNombre frame = new InterfazBusquedaClienteNombre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 **/
	public InterfazBusquedaClienteNombre(final InterfazABMCliente interfaz) {
		setTitle("Busqueda por nombre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[424px]", "[113px][][][][]"));

		final PanelBusqueda panelBusquedaClienteBasico = new PanelBusqueda();
		contentPane.add(panelBusquedaClienteBasico, "cell 0 0,growx,aligny top");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				interfaz.cargarCliente(panelBusquedaClienteBasico.clienteSeleccionado());			
				dispose();
			}
		});
		contentPane.add(btnAceptar, "flowx,cell 0 4,alignx right,aligny bottom");

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnCancelar, "cell 0 4,aligny bottom");
	}

}
