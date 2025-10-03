package co.edu.unbosque.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Archivos {
	public Archivos() {
		// TODO Auto-generated constructor stub
	}

	public String LeerArchivo() {
		try {
			JFileChooser fc = new JFileChooser();

			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Documento de texto", "txt", ".rec");
			fc.setCurrentDirectory(new File(
					"C:\\Users\\ferna\\OneDrive\\Escritorio\\Programacion\\java-proyects\\SerpientesEscalerasV2\\CompiladorIDE\\src\\docs"));
			fc.setFileFilter(filtro);
			fc.showOpenDialog(null);

			String path = fc.getSelectedFile().getPath();

			StringBuilder sb = new StringBuilder();
			FileReader fr = new FileReader(new File(path));
			BufferedReader bf = new BufferedReader(fr);
			String linea = bf.readLine();
			while (linea != null) {
				sb.append(linea + "\n");
				linea = bf.readLine();
			}
			fr.close();
			return sb.toString();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return "";
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			return "";
		}

	}

	public int GuardarArchivo(String nombre,String data) {
		try {
			FileWriter fw = new FileWriter(new File("C:\\Users\\ferna\\OneDrive\\Escritorio\\Programacion\\java-proyects\\SerpientesEscalerasV2\\CompiladorIDE\\src\\docs\\"+nombre+".txt"));
			fw.append(data);
			fw.close();
			return 0;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}

}
