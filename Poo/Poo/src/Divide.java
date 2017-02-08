/*
Autor: Juan Antonio Melendres Villa     A00369017
Nombre de la clase: EjemploLector
Fecha: 5/10/2016
Comentarios: 
 */
import javax.swing.JOptionPane;

public class Divide {
	public static int divisionEntera(int numerador, int denominador){
		return numerador/denominador;
	}

	public static void main(String[] args){
		boolean correcto = true;
		do{
			try{
				int num = Integer.parseInt(JOptionPane.showInputDialog("Escribe el numerador"));
				int den = Integer.parseInt(JOptionPane.showInputDialog("Escribe el denominador"));
				JOptionPane.showMessageDialog(null, "El resultado de dividir " + num + "/" + den + " es:" + divisionEntera(num,den));
				correcto = true;
			}
			catch(ArithmeticException e){
				int den = Integer.parseInt(JOptionPane.showInputDialog("Error, escribe otra vez el denominador"));	
				correcto = false;
			}
			catch(NumberFormatException e){
				int num = Integer.parseInt(JOptionPane.showInputDialog("Escribe el numerador"));
				int den = Integer.parseInt(JOptionPane.showInputDialog("Escribe el denominador"));
				correcto = false;
			}
		}
		while(!correcto);
	}
}
