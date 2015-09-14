package ar.hybili.headfac.paneles;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.border.TitledBorder;

import ar.hybili.headfac.clases.Cliente;
import ar.hybili.headfac.clases.TipoIvaCliente;
import ar.hybili.headfac.conexiones.ConectorSQLite;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelClienteBasico extends PanelBase {
	private JTextField tfId;
	private JTextField tfNombre;
	private JTextField tfRazonSocial;
	private JTextField tfRazonSocialFiscal;
	private JTextField tfCuit;
	private JTextField tfDireccion;
	private JTextField tfLocalidad;
	private JTextField tfCodigoPostal;
	private JTextField tfCodigoPostalCompleto;
	private JLabel lblCuit;

	/**
	 * Create the panel.
	 */
	public PanelClienteBasico() {
		setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		setLayout(new GridLayout(5, 2, 5, 5));

		JLabel lblCodigo = new JLabel("Codigo");
		add(lblCodigo);

		tfId = new JTextField();
		tfId.setHorizontalAlignment(SwingConstants.LEFT);
		add(tfId);
		tfId.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		add(lblNombre);

		tfNombre = new JTextField();
		add(tfNombre);
		tfNombre.setColumns(10);

		JLabel lblRazonSocial = new JLabel("Razon Social");
		add(lblRazonSocial);


		tfRazonSocial = new JTextField();
		add(tfRazonSocial);
		tfRazonSocial.setColumns(10);

		JLabel lblRazonSocialFiscal = new JLabel("Razon Social Fiscal");
		add(lblRazonSocialFiscal);

		tfRazonSocialFiscal = new JTextField();
		add(tfRazonSocialFiscal);
		tfRazonSocialFiscal.setColumns(10);

		lblCuit = new JLabel("Cuit");
		add(lblCuit);

		tfCuit = new JTextField();
		add(tfCuit);
		tfCuit.setColumns(10);

		JLabel lblDireccion = new JLabel("Direccion");
		add(lblDireccion);

		tfDireccion = new JTextField();
		add(tfDireccion);
		tfDireccion.setColumns(10);

		JLabel lblLocalidad = new JLabel("Localidad");
		add(lblLocalidad);

		tfLocalidad = new JTextField();
		add(tfLocalidad);
		tfLocalidad.setColumns(10);

		JLabel lblCodigoPostal = new JLabel("Codigo Postal");
		add(lblCodigoPostal);

		tfCodigoPostal = new JTextField();
		add(tfCodigoPostal);
		tfCodigoPostal.setColumns(10);

		JLabel lblCodigoPostalCompleto = new JLabel("Codigo Postal Completo");
		add(lblCodigoPostalCompleto);

		tfCodigoPostalCompleto = new JTextField();
		add(tfCodigoPostalCompleto);
		tfCodigoPostalCompleto.setColumns(10);

		tfId.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {	               
					//System.out.println("ENTER pressed");
					if (!tfId.getText().isEmpty()) {
						buscarCliente(Integer.parseInt(tfId.getText()));
					}
				}
			}
		});

	}

	public Cliente obtenerCliente() {
		TipoIvaCliente tipoIvaAux = TipoIvaCliente.INSCRIPTO;
		Cliente clienteAux = new Cliente(Integer.parseInt(tfId.getText()), tfNombre.getText(), tfRazonSocial.getText(), tfRazonSocialFiscal.getText(), Double.parseDouble(tfCuit.getText()),tfDireccion.getText(),tfLocalidad.getText(),Integer.parseInt(tfCodigoPostal.getText()), tfCodigoPostalCompleto.getText(),tipoIvaAux);

		return clienteAux;

	}

	public Cliente buscarCliente(int id){

		Cliente clienteAux = null;

		if (id>0){
			ConectorSQLite con = new ConectorSQLite();
			con.connect();
			clienteAux = con.findCliente(id);
			con.close(); 

			if (clienteAux != null) { 
				System.out.println(clienteAux.toString());	
				cargarCliente(clienteAux);						
			} else {
				JOptionPane.showMessageDialog(null, "No existe el cliente");
			}
		}
		return clienteAux;
	}

	public void cargarCliente(Cliente cliente){
		tfId.setText(Integer.toString(cliente.get_id()));
		tfNombre.setText(cliente.get_nombre());
		tfRazonSocial.setText(cliente.get_nombre());
		tfRazonSocialFiscal.setText(cliente.get_razonSocialFiscal());
		tfCuit.setText(Double.toString(cliente.get_cuit()));
		tfDireccion.setText(cliente.get_direccion());
		tfLocalidad.setText(cliente.get_localidad());
		tfCodigoPostal.setText(Integer.toString(cliente.get_codigoPostal()));
		tfCodigoPostalCompleto.setText(cliente.get_codigoPostalCompleto());	
		tfId.enable(false);		
	}

}

