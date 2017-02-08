package Fisica;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Panel extends JPanel implements ActionListener{

	private JRadioButton b1,
					b2,
					b3,
					b4,
					b5,
					b6,
					b7,
					b8,
					b9;
	private double d1,
					d2,
					d3;
	

	private static final double cargaele = -1.602e-19, 
								cargaepro = 1.602e-19, 
								masaele = 9.1095e-31,
								masapro = 1.6762e-27, 
								k = 9e9;

	public Panel() {
		super();
		this.setPreferredSize(new Dimension(350, 200));
		this.b1=new JRadioButton("Fuerza Electrica (Q1,Q2 & R)");
		this.b2=new JRadioButton("Fuerza Electrica (Q & E)");
		this.b3=new JRadioButton("Carga (Q, F & R)");
		this.b4=new JRadioButton("Radio (Q1, Q2 & F)");
		this.b5=new JRadioButton("Campo electrico (F & Q)");
		this.b6=new JRadioButton("Trabajo (Q1, Q2 & D)");
		this.b7=new JRadioButton("Trabajo (V1 & V2)");
		this.b8=new JRadioButton("Potencial (Q & V)");
		this.b9=new JRadioButton("Voltaje (E & D)");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(this.b1);
		bg.add(this.b2);
		bg.add(this.b3);
		bg.add(this.b4);
		bg.add(this.b5);
		bg.add(this.b6);
		bg.add(this.b7);
		bg.add(this.b8);
		bg.add(this.b9);
		
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		this.add(b6);
		this.add(b7);
		this.add(b8);
		this.add(b9);
		
		this.b1.addActionListener(this);
		this.b2.addActionListener(this);
		this.b3.addActionListener(this);
		this.b4.addActionListener(this);
		this.b5.addActionListener(this);
		this.b6.addActionListener(this);
		this.b7.addActionListener(this);
		this.b8.addActionListener(this);
		this.b9.addActionListener(this);
	}

	public double fuerzaelectrica(double q1, double q2, double radio) {
		return (this.k * ((q1 * q2) / (radio * radio)));
	}

	public double fuerzaelectrica(double q, double campoele) {
		return (q * campoele);
	}

	public double carga(double q, double fuerza, double radio) {
		return ((fuerza * (radio * radio)) / (q * this.k));
	}

	public double radio(double q1, double q2, double fuerza) {
		return Math.sqrt(((this.k * q1 * q2) / fuerza));
	}

	public double campoelec(double fuerza, double q) {
		return (fuerza / q);
	}

	/*
	 * public double campoelec(double radio, double q){ return
	 * ((q*this.k)/(radio*radio)); }
	 */

	public double trabajo(double q, double campoele, double d) {
		return q * campoele * d;
	}

	public double trabajo(double V1, double V2) {
		return V2 - V1;
	}

	public double potencial(double q, double V) {
		return q * V;
	}

	public double voltaje(double E, double d) {
		return E * d;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(this.b1.isSelected()){
				this.d1=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Q1"));
				this.d2=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Q2"));
				this.d3=Double.parseDouble(JOptionPane.showInputDialog("Ingrese R"));
				JOptionPane.showMessageDialog(null, "Resultado: "+fuerzaelectrica(this.d1,this.d2,this.d3));
			}
			else if(this.b2.isSelected()){
				this.d1=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Q"));
				this.d2=Double.parseDouble(JOptionPane.showInputDialog("Ingrese E"));
				JOptionPane.showMessageDialog(null, "Resultado: "+fuerzaelectrica(this.d1,this.d2));
			}
			else if(this.b3.isSelected()){
				this.d1=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Q"));
				this.d2=Double.parseDouble(JOptionPane.showInputDialog("Ingrese F"));
				this.d3=Double.parseDouble(JOptionPane.showInputDialog("Ingrese R"));
				JOptionPane.showMessageDialog(null, "Resultado: "+carga(this.d1,this.d2,this.d3));
			}
			else if(this.b4.isSelected()){
				this.d1=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Q1"));
				this.d2=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Q2"));
				this.d3=Double.parseDouble(JOptionPane.showInputDialog("Ingrese F"));
				JOptionPane.showMessageDialog(null, "Resultado: "+radio(this.d1,this.d2,this.d3));
			}
			else if(this.b5.isSelected()){
				this.d1=Double.parseDouble(JOptionPane.showInputDialog("Ingrese F"));
				this.d2=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Q"));
				JOptionPane.showMessageDialog(null, "Resultado: "+campoelec(this.d1,this.d2));
			}
			else if(this.b6.isSelected()){
				this.d1=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Q1"));
				this.d2=Double.parseDouble(JOptionPane.showInputDialog("Ingrese E"));
				this.d3=Double.parseDouble(JOptionPane.showInputDialog("Ingrese D"));
				JOptionPane.showMessageDialog(null, "Resultado: "+trabajo(this.d1,this.d2,this.d3));
			}
			else if(this.b7.isSelected()){
				this.d1=Double.parseDouble(JOptionPane.showInputDialog("Ingrese V1"));
				this.d2=Double.parseDouble(JOptionPane.showInputDialog("Ingrese V2"));
				JOptionPane.showMessageDialog(null, "Resultado: "+trabajo(this.d1,this.d2));
			}
			else if(this.b8.isSelected()){
				this.d1=Double.parseDouble(JOptionPane.showInputDialog("Ingrese Q"));
				this.d2=Double.parseDouble(JOptionPane.showInputDialog("Ingrese V"));
				JOptionPane.showMessageDialog(null, "Resultado: "+potencial(this.d1,this.d2));
			}
			else if(this.b9.isSelected()){
				this.d1=Double.parseDouble(JOptionPane.showInputDialog("Ingrese E"));
				this.d2=Double.parseDouble(JOptionPane.showInputDialog("Ingrese D"));
				JOptionPane.showMessageDialog(null, "Resultado: "+voltaje(this.d1,this.d2));
			}
		}
		catch(NumberFormatException e1){
			JOptionPane.showMessageDialog(null, "Error!!!!");
			System.exit(0);
		}
		catch(NullPointerException e1){	
		}
	}


	/*
	 * public double voltaje(double q, double r){ return E*d; }
	 */
	
}
