import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

public class Tablero extends JFrame{

	static Casilla[][] matriz = new Casilla[9][9];

	static int ganar=0;
	public static boolean setValor(int fila, int columna, int valor){
		boolean exito=matriz[fila][columna].setValor(valor);
		int contador=0;
		inconsistencia(fila,columna);
		if(gano()){
			System.out.println("GANASTE!!!");
			if(ganar==0){
			JOptionPane.showMessageDialog(null, "GANASTE!!!");
			ganar=1;
			}
		}
		for(int x=0;x<9;x++){
			for(int y=0;y<9;y++){
				if(matriz[x][y].getValor()!=0){
					contador++;
				}
			}
		}
		PanelControlesSudoku.setPorc((contador*100)/81);
		PanelControlesSudoku.completado.setText(String.valueOf((contador*100)/81)+"%");
		//System.out.println(contador);
		return exito;
	}

	public static boolean inconsistencia(int fila, int columna){
		boolean exito=true;
		int a=0,b=0;
		for(int y=0;y<matriz[fila].length;y++){
			if((matriz[fila][columna].getValor()==matriz[fila][y].getValor())&&y!=columna){
				exito=false;
				//System.out.println("INCONSISTENCIA de fila");
				a=fila;
				b=columna;
				break;
			}
			else{
				if(!matriz[fila][columna].getInicial()){
					PanelSudoku.botones[fila][columna].setForeground(Color.BLACK);
				}
				PanelSudoku.botones[fila][columna].setBorder(new LineBorder(Color.GRAY));
			}
		}
		for(int x=0;x<matriz.length;x++){
			if(matriz[fila][columna].getValor()==matriz[x][columna].getValor()&&x!=fila){
				exito=false;
				//System.out.println("INCONSISTENCIA de columna");
				a=fila;
				b=columna;
				break;
			}
			else{
				if(!matriz[fila][columna].getInicial()){
					PanelSudoku.botones[fila][columna].setForeground(Color.BLACK);
				}
				PanelSudoku.botones[fila][columna].setBorder(new LineBorder(Color.GRAY));
			}
		}
		int tramoX=(fila/3)*3;
		int tramoY=(columna/3)*3;
		for(int x=tramoX;x<tramoX+3;x++){
			for(int y=tramoY;y<tramoY+3;y++){
				if(matriz[x][y].getValor()==matriz[fila][columna].getValor()&&(x!=fila)&&(y!=columna)){
					exito=false;
					//System.out.println("INCONSISTENCIA de grupo");
					a=fila;
					b=columna;
					break;
				}
				else{
					if(!matriz[fila][columna].getInicial()){
						PanelSudoku.botones[fila][columna].setForeground(Color.BLACK);
					}
					PanelSudoku.botones[fila][columna].setBorder(new LineBorder(Color.GRAY));
				}

			}

		}
		if((!exito)&(!PanelSudoku.botones[a][b].getText().equals(""))){
			PanelSudoku.botones[a][b].setForeground(Color.RED);
			PanelSudoku.botones[a][b].setBorder(new LineBorder(Color.RED,2));
		}
		if(matriz[fila][columna].getInicial()){
			PanelSudoku.botones[fila][columna].setForeground(Color.BLUE);
		}
		return exito;
	}

	public static boolean gano(){
		int c=0;
		for(int x=0;x<matriz.length;x++){
			for(int y=0;y<matriz[x].length;y++){
				if((matriz[x][y].getValor()==0)||(PanelSudoku.botones[x][y].getForeground()==Color.RED)){
					c++;
				}
			}
		}
		boolean exito=(c==0)?true:false;
		return exito;
	}

	public static void imprimeTablero(){
		for(int x=0;x<matriz.length;x++){
			for(int y=0;y<matriz[x].length;y++){
				if(matriz[x][y].getValor()!=0){
				System.out.print(matriz[x][y].getValor());
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public Tablero(){
		super("Sudoku");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(800,600));
		PanelControlesSudoku pcs=new PanelControlesSudoku(null);
		PanelSudoku psk = new PanelSudoku();
		this.add(pcs,BorderLayout.EAST);
		this.add(psk);
		this.pack();
		this.setVisible(true);
		for(int x=0;x<matriz.length;x++){
			for(int y=0;y<matriz[x].length;y++){
				matriz[x][y]=new Casilla();
			}
		}
	}

	public static void main(String[] args){
		PanelSudoku panel=new PanelSudoku();
		Tablero tablero=new Tablero();
		imprimeTablero();
	}
}
