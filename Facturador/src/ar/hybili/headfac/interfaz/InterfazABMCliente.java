package ar.hybili.headfac.interfaz;

import ar.hybili.headfac.clases.*;
import ar.hybili.headfac.paneles.PanelClienteBasico;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSplitPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class InterfazABMCliente extends JFrame {

	private JPanel contentPane;

	ArrayList<Cliente> _listaClientes = new ArrayList<Cliente>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazABMCliente frame = new InterfazABMCliente();
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
	public InterfazABMCliente() {
		setTitle("ABM Clientes");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		final PanelClienteBasico panelClienteBasico = new PanelClienteBasico();
		contentPane.add(panelClienteBasico, BorderLayout.NORTH);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane, BorderLayout.SOUTH);

		JButton btnAgregar = new JButton("Agregar");
		splitPane.setLeftComponent(btnAgregar);

		JButton btnSalir = new JButton("Salir");
		splitPane.setRightComponent(btnSalir);

		btnAgregar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {							
				panelClienteBasico.obtenerCliente().save();
				panelClienteBasico.limpiarPanel();						
			}

		});

		btnSalir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {							
				System.exit(0);				
			}

		});
	}

}
