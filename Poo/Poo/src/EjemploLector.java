/*
Autor: Juan Antonio Melendres Villa     A00369017
Nombre de la clase: EjemploLector
Fecha: 5/10/2016
Comentarios: 
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class EjemploLector {
	public static void main(String[] args){
		String file=JOptionPane.showInputDialog("Dame el directorio del archivo");
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String linea;
	        while((linea=br.readLine())!=null){
	            System.out.println(linea);
	        }
			br.close();
		}
		catch(FileNotFoundException e){
			System.out.println("El archivo no se localizo " + e);
		}
		catch(IOException e){
			System.out.println("El archivo no se puede leer" + e);
		}
	}
}


