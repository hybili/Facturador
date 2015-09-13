package ar.hybili.headfac.clases;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class ClienteBaseListModel extends AbstractListModel{
	
	private ArrayList<Cliente> listaCliente;
	
	public ClienteBaseListModel(){
		listaCliente = new ArrayList<Cliente>();
	}
	
	public ClienteBaseListModel(ArrayList<Cliente> lista){
		listaCliente = lista;
	}
	
	@Override
	public int getSize() {
		return listaCliente.size();
	}

	@Override
	public Object getElementAt(int index) {
		Cliente clienteAux = listaCliente.get(index);
		return clienteAux.get_nombre();
	}
	
	public void addCliente(Cliente cliente){
		listaCliente.add(cliente);
		this.fireIntervalAdded(this, getSize(), getSize()+1);
	}
	
	public void eleminarCliente(int index){
		listaCliente.remove(index);
		this.fireIntervalRemoved(this, getSize(), getSize()+1);
	}
	
	public Cliente getCliente(int index){
		return listaCliente.get(index);
	}

}
