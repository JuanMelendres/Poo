import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PanelControles extends JPanel implements MouseListener, ChangeListener{
	private JTextField tfNombre;
	private JButton bAceptar,
	bCambiarColor,
	bArchivo; 
	private JRadioButton rbAzul,
	rbRojo,
	rbVerde;
	private PanelDibujo pd;
	private JPanel panelColor;
	private JSlider slider;
	private JFileChooser jfc;

	public PanelControles(PanelDibujo pd){
		super();
		this.pd=pd;
		this.jfc = new JFileChooser();
		this.setPreferredSize(new Dimension(150,600));
		this.panelColor = new JPanel();
		this.panelColor.setPreferredSize(new Dimension(90, 90));
		this.panelColor.setBackground(Color.DARK_GRAY);
		this.panelColor.addMouseListener(this);
		this.tfNombre = new JTextField(10);
		this.bAceptar = new JButton("Aceptar");
		this.bArchivo = new JButton("Cambiar nombre");

		this.rbAzul = new JRadioButton("Color Azul");
		this.rbAzul.setSelected(true);
		this.rbRojo = new JRadioButton("Color Rojo");
		this.rbVerde = new JRadioButton("Color Verde");
		this.bCambiarColor = new JButton("Cambiar Color");

		this.slider = new JSlider(JSlider.VERTICAL, 0, 500, 0);
		this.slider.setMajorTickSpacing(100);
		this.slider.setMinorTickSpacing(50);
		this.slider.setPaintTicks(true);
		this.slider.setPaintLabels(true);

		ButtonGroup bg = new ButtonGroup();
		bg.add(this.rbAzul);
		bg.add(this.rbRojo);
		bg.add(this.rbVerde);

		this.add(this.tfNombre);
		this.add(this.bAceptar);
		this.add(this.rbAzul);
		this.add(this.rbRojo);
		this.add(this.rbVerde);
		this.add(this.bCambiarColor);
		this.add(this.panelColor);
		this.add(this.slider);
		this.add(this.bArchivo);

		this.bAceptar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				pd.setTexto(tfNombre.getText());
			}
		});
		this.bCambiarColor.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Color fondo;
				if(rbAzul.isSelected()){
					fondo = Color.BLUE;
				}
				else if(rbRojo.isSelected()){
					fondo = Color.RED;
				}
				else{
					fondo = Color.GREEN;
				}
				PanelControles.this.setBackground(fondo);
			}		
		});
		this.bArchivo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					int respuesta = jfc.showOpenDialog(PanelControles.this);
					if(respuesta == jfc.APPROVE_OPTION){
						String archivo = jfc.getSelectedFile().toString();
						BufferedReader br = new BufferedReader(new FileReader(archivo));
						pd.setTexto(br.readLine());
						br.close();
						System.out.println("Seleecionaste el archivo" + archivo);
					}
					else{
						System.out.println("Se cancelo el archivo");
					}
				}
				catch(IOException e1){
					System.out.println("Error" + e1);
				}
			}			
		});
		this.slider.addChangeListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Color colorFondo = JColorChooser.showDialog(this.pd, "Seleciona el color de fondo", this.panelColor.getBackground());
		this.panelColor.setBackground(colorFondo);
		this.setBackground(colorFondo);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {	
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		this.pd.setY(this.slider.getValue());
	}
}
