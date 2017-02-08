/*
Autor: Juan Antonio Melendres Villa     A00369017
Nombre de la clase: Espiral
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Espiral extends JFrame{

	private int lonLin=20, //Longitud de Lineas
				amp=6, //amplitud
				lin=18; //Lineas por hacer para la espiral

	//Arreglo contenedores de posiciones
	private int[] xEsp,
				  yEsp;

	public Espiral(){
		
		super("Espiral");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(800,600));
		this.setBackground(Color.WHITE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		
		//inicializa los arreglos
		this.xEsp=new int[this.lin+1];
		this.yEsp=new int[this.lin+1];

		// comienzo de la espiral 
		this.xEsp[0]=350;
		this.yEsp[0]=350; 

		for(int i=0; i<this.lin; i++){
			this.xEsp[i+1]=(int)(this.xEsp[i]+Math.cos(Math.toRadians(360/this.amp*i+1))*this.lonLin);
			this.yEsp[i+1]=(int)(this.yEsp[i]+Math.sin(Math.toRadians(360/this.amp*i+1))*this.lonLin);
			this.lonLin+=25*this.amp*.1; 
		}
		
		this.setLocation((width-this.getWidth())/2, (height-this.getHeight())/2);
		this.setVisible(true);
	}

	public void paint(Graphics g){
		super.paintComponents(g);
		g.drawPolyline(xEsp, yEsp, this.lin+1);
	}

	public static void main(String[] args) {
		Espiral ventana=new Espiral();
	}

}
