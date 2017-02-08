package Fisica;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	public Ventana() {
		super("Calculadora de cargas");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(new Panel());
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Ventana ven = new Ventana();
	}
}