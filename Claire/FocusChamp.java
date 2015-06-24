import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.text.JTextComponent;


public class FocusChamp implements FocusListener {
	static String proprietaire="";
	String nom;

	public FocusChamp(String _nom) {
		this.nom=_nom;
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		if (proprietaire==this.nom)
			proprietaire="";
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		if (proprietaire==""){
				String f= ((JTextComponent) arg0.getSource()).getText();
		}
	}
}
