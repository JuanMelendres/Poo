package ProyectoFinal;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;

public class CambioImagen {
	
	static int contador=0;

	public static void main(String[] args) {
		int velocidad=2; //segundos
		
		Timer timer;
		TimerTask tarea;
		
		int velmil=velocidad*1000;
		
		Ventana ventana = new Ventana();
		
		tarea=new TimerTask() {
			
			public void run(){
				Image bebe;
				
				switch(contador){
					case 0: 
						contador=1;
						bebe=new ImageIcon("bebe.jpg").getImage();
						ventana.setIconImage(bebe);
						break;
					case 2:
						contador=2;
						bebe=new ImageIcon("bebe2.jpg").getImage();
						ventana.setIconImage(bebe);
						break;
				}
			}
		};
		
		timer = new Timer();
		timer.scheduleAtFixedRate(tarea, velmil, velmil);
	}

}
