package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;

import co.edu.unbosque.controller.Controller;

public class View extends JFrame {

	public static String cargar = "CARGAR ARCHIVO";
	public static String guardar = "GUARDAR ARCHIVO";
	private Button bCargar,BGuardar;
	private JScrollPane pConsola, pAux;
	private JTextArea Consola, Aux;
	private Font fuente;
	private Controller control;

	public View(Controller controller) {
		this.control = controller;
		fuente = new Font("SansSerif", Font.BOLD, 20);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("IDE");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		BGuardar = new Button(guardar);
		BGuardar.addActionListener(controller);
	
		
		bCargar = new Button(cargar);
		bCargar.addActionListener(control);
		pAux = CrearPanelAux();
		pConsola = Crearconsola();
		JToolBar jbarra = new JToolBar();
		jbarra.add(bCargar);
		jbarra.add(BGuardar);
		add(jbarra, BorderLayout.PAGE_START);

		JSplitPane jsplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pAux, pConsola);
		jsplit.setResizeWeight(0.6);
		add(jsplit);
		setVisible(true);

	}

	public JScrollPane Crearconsola() {
		Consola = new JTextArea();
		JScrollPane scroll = new JScrollPane(Consola);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Consola.setBackground(Color.black);
		Consola.setForeground(Color.green);
		Consola.setFont(fuente);
		return scroll;
	}

	public JScrollPane CrearPanelAux() {
		Aux = new JTextArea();
		JScrollPane scroll = new JScrollPane(Aux);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Aux.setBackground(Color.lightGray);
		Aux.getDocument().addDocumentListener(control);
		Aux.setFont(new Font("Monospaced", Font.BOLD, 30));
		Aux.setForeground(Color.BLUE);
		return scroll;
	}

	public static String getCargar() {
		return cargar;
	}

	public static void setCargar(String cargar) {
		View.cargar = cargar;
	}

	public Button getbCargar() {
		return bCargar;
	}

	public void setbCargar(Button bCargar) {
		this.bCargar = bCargar;
	}

	public JScrollPane getpConsola() {
		return pConsola;
	}

	public void setpConsola(JScrollPane pConsola) {
		this.pConsola = pConsola;
	}

	public JScrollPane getpAux() {
		return pAux;
	}

	public void setpAux(JScrollPane pAux) {
		this.pAux = pAux;
	}

	public JTextArea getConsola() {
		return Consola;
	}

	public void setConsola(JTextArea consola) {
		Consola = consola;
	}

	public JTextArea getAux() {
		return Aux;
	}

	public void setAux(JTextArea aux) {
		Aux = aux;
	}

	public Font getFuente() {
		return fuente;
	}

	public void setFuente(Font fuente) {
		this.fuente = fuente;
	}

	public Controller getControl() {
		return control;
	}

	public void setControl(Controller control) {
		this.control = control;
	}

}
