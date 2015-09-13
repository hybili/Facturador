package ar.hybili.headfac.paneles;

import java.awt.Component;

import javax.swing.InputVerifier;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBase extends JPanel {
	
	public void limpiarPanel() {
		JPanel panel = this;
        if (panel != null) {
            for (Component item : panel.getComponents()) {

                if (item instanceof JTextField) {
                    ((JTextField) item).setText(null);
                } else if (item instanceof JCheckBox) {
                    ((JCheckBox) item).setSelected(false);
                } else if (item instanceof JComboBox) {
                    ((JComboBox) item).setSelectedIndex(0);
                } else if (item instanceof JFormattedTextField) {
                    JFormattedTextField jftf = (JFormattedTextField) item;

                    InputVerifier verificador = jftf.getInputVerifier();
                    jftf.setInputVerifier(null);
                    jftf.setText(null);
                    jftf.setValue(null);
                    jftf.setInputVerifier(verificador);
                } else if (item instanceof JCheckBox) {
                    ((JCheckBox) item).setSelected(false);
                }
            }
        }
    }
}
