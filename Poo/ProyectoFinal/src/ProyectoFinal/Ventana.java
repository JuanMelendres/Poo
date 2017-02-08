package ProyectoFinal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Ventana extends JFrame{
	public Ventana(){
		super("Proyecto Final POO");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
//		Animacion a=new Animacion();
//		this.add(a);
//		Board b = new Board();
//		this.add(b);
		this.pack();
		this.setLocation((width-this.getWidth())/2, (height-this.getHeight())/2);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Ventana ventana=new Ventana();
	}
}
