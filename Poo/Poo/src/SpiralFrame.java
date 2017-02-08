import javax.swing.JFrame;

public class SpiralFrame extends JFrame{
	public SpiralFrame(){
		super("Espiral");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.add(new SpiralPanel());
	    this.pack();
	    this.setVisible(true);
	}
	
	public static void main(String[] a) {
		SpiralFrame window=new SpiralFrame();
	}

}

