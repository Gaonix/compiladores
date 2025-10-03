package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import co.edu.unbosque.model.Archivos;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener, DocumentListener {
	private View app;
	private Archivos ar;

	public Controller() {
		app = new View(this);
		ar = new Archivos();
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("CARGAR ARCHIVO")) {
			app.getAux().setText(ar.LeerArchivo());
		}if(e.getActionCommand().equalsIgnoreCase("GUARDAR ARCHIVO")) {
			String nombrea=	JOptionPane.showInputDialog("Cual es el nombre del archivo");
		
			int res=ar.GuardarArchivo(nombrea, app.getAux().getText());
		if(res<0) {
			JOptionPane.showMessageDialog(app, "no ha podido guardar el archivo "+"\n"+"Intente nuevamente", "Estado ", 0);
		}else {
			JOptionPane.showMessageDialog(app, "Se guardo exitosamnete ", "Estado ", -1);			
		}
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		app.getConsola().setText("Agregando...");
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		app.getConsola().setText("Eliminando...");
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	public View getApp() {
		return app;
	}

	public void setApp(View app) {
		this.app = app;
	}

}
