import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;



public class SpiralPanel extends JPanel{
	private int sides,
				lines,
				lfl;
	
	private int[] xs,
				  ys;
	
	public SpiralPanel(){
		super();
		this.lfl=50; //Longitud linea
		this.lines=20; //cuantas lienas
		this.sides=6;  //amplitud
		this.setPreferredSize(new Dimension(1000,1000));
	    this.xs =new int[this.lines+1];
	    this.ys =new int[this.lines+1];
	    
	    this.xs[0]=500; // centro de la espiral
	    this.ys[0]=500; // centro de la espiral
	    
	    System.out.println((Math.cos(Math.toRadians(360/this.sides))));

	    
	    for(int i=0; i<this.lines; i++){
	    	this.xs[i+1]=(int)(this.xs[i]+Math.cos(Math.toRadians(360/this.sides*i+1))*this.lfl);
	    	this.ys[i+1]=(int)(this.ys[i]+Math.sin(Math.toRadians(360/this.sides*i+1))*this.lfl);
	    	this.lfl+=25*sides*.1;
	    }

	}
	
	public void paint(Graphics g){
		super.paintComponent(g);
		g.drawPolyline(xs, ys, this.lines+1);
	}

}
