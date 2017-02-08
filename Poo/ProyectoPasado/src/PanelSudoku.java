import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelSudoku extends JPanel implements MouseListener, KeyListener{

	static JButton[][] botones = new JButton[9][9];

	public PanelSudoku(){
		super(new GridLayout(9,9));
		this.setPreferredSize(new Dimension(650,600));
		this.setBackground(Color.WHITE);
		for(int fila=0;fila<9;fila++){
			for(int columna=0;columna<9;columna++){
				botones[fila][columna] = new JButton();
				botones[fila][columna].setText("");
				botones[fila][columna].setName(fila+","+columna);
				botones[fila][columna].setFont(new Font(botones[fila][columna].getFont().getName(),Font.PLAIN,20));
				
				if(fila<3&&columna<3){ //Primer Cuadro
					botones[fila][columna].setBackground(Color.ORANGE);
					botones[fila][columna].setBorderPainted(true);
					botones[fila][columna].setOpaque(true);
				}
				if((fila<3&&columna>2)){  //Segundo Cuadro
					botones[fila][columna].setBackground(Color.WHITE);
					botones[fila][columna].setBorderPainted(true);
					botones[fila][columna].setOpaque(true);
				}
				if(fila<3&&columna>5){  //Tercer Cuadro
					botones[fila][columna].setBackground(Color.ORANGE);
					botones[fila][columna].setBorderPainted(true);
					botones[fila][columna].setOpaque(true);
				}
				if(fila>2&&columna<3){  //Cuarto Cuadro
					botones[fila][columna].setBackground(Color.WHITE);
					botones[fila][columna].setBorderPainted(true);
					botones[fila][columna].setOpaque(true);
				}
				if((fila>2&&columna>2)&&(fila<6&&columna<6)){ //Quinto Cuadro
					botones[fila][columna].setBackground(Color.ORANGE);
					botones[fila][columna].setBorderPainted(true);
					botones[fila][columna].setOpaque(true);
				}
				if(fila>2&&columna>5){  //Sexto Cuadro
					botones[fila][columna].setBackground(Color.WHITE);
					botones[fila][columna].setBorderPainted(true);
					botones[fila][columna].setOpaque(true);
				}
				if(fila>5&&columna<3){  //Septimo Cuadro
					botones[fila][columna].setBackground(Color.ORANGE);
					botones[fila][columna].setBorderPainted(true);
					botones[fila][columna].setOpaque(true);
				}
				if((fila>5&&columna<6)&&(columna>2)){  //Octavo Cuadro
					botones[fila][columna].setBackground(Color.WHITE);
					botones[fila][columna].setBorderPainted(true);
					botones[fila][columna].setOpaque(true);
				}
				if(fila>5&&columna>5){  //Noveno Cuadro
					botones[fila][columna].setBackground(Color.ORANGE);
					botones[fila][columna].setBorderPainted(true);
					botones[fila][columna].setOpaque(true);
				}
				botones[fila][columna].addMouseListener(this);
				botones[fila][columna].addKeyListener(this);
				this.add(botones[fila][columna]);
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println();
		System.out.println("CLICK");

		StringTokenizer string;
		String x="0", y="0";

		JButton evento = (JButton)e.getSource();
		string = new StringTokenizer(evento.getName(),",");

		x=string.nextToken();
		y=string.nextToken();

		System.out.println("x: "+x+" "+"y: "+y);
		System.out.println("getName: "+botones[Integer.valueOf(x)][Integer.valueOf(y)].getName());
		System.out.println("getText: "+botones[Integer.valueOf(x)][Integer.valueOf(y)].getText());

		System.out.println();
	}

	public void clicEvent(ActionEvent e){
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("tecla: "+e.getKeyChar());

		StringTokenizer string;
		String x="99", y="99";

		JButton evento = (JButton)e.getSource();
		string = new StringTokenizer(evento.getName(),",");

		x=string.nextToken();
		y=string.nextToken();
		if(String.valueOf(e.getKeyChar()).equals("0")&(!Tablero.matriz[Integer.parseInt(x)][Integer.parseInt(y)].getInicial())){
			botones[Integer.valueOf(x)][Integer.valueOf(y)].setText("");
			Tablero.setValor(Integer.parseInt(x),Integer.parseInt(y),0);
			Tablero.matriz[Integer.parseInt(x)][Integer.parseInt(y)].setUtilizado(false);
			Tablero.imprimeTablero();
		}
		if((String.valueOf(e.getKeyChar()).matches("[1-9]"))&(!Tablero.matriz[Integer.parseInt(x)][Integer.parseInt(y)].getInicial())){
			botones[Integer.valueOf(x)][Integer.valueOf(y)].setText(String.valueOf(e.getKeyChar()));
			Tablero.setValor(Integer.parseInt(x),Integer.parseInt(y),Integer.parseInt(String.valueOf(e.getKeyChar())));
			Tablero.matriz[Integer.parseInt(x)][Integer.parseInt(y)].setUtilizado(true);
			for(int a=0;a<9;a++){
				for(int b=0;b<9;b++){
						//if((botones[a][b].getForeground()==Color.RED)){
							Tablero.setValor(a, b, Tablero.matriz[a][b].getValor());
						//}
				}
			}
			Tablero.imprimeTablero();			
		}
	}
}