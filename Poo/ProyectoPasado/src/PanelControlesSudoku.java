import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelControlesSudoku extends JPanel{

	private JButton bReset,bGuardarPartida, bAbrirPartida, bResolver, bPartida;
	static JLabel completado, texto;
	static double porc=0.0;

	private PanelSudoku psc;


	public PanelControlesSudoku(PanelSudoku psc){

		super();
		this.psc = psc;
		this.setPreferredSize(new Dimension(150,600));
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new FlowLayout(8));

		
		this.bPartida = new JButton("PRUEBA");
		this.bPartida.setBackground(Color.ORANGE);
		this.bPartida.setBorderPainted(true);
		this.bPartida.setOpaque(true);
		this.bPartida.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int op = fc.showOpenDialog(PanelControlesSudoku.this.psc);
				if(op == JFileChooser.APPROVE_OPTION){
					JOptionPane.showMessageDialog(PanelControlesSudoku.this.psc, "El archivo seleccionado es "+ fc.getSelectedFile());
				try{
					Reset();
					BufferedReader br = new BufferedReader(new FileReader(fc.getSelectedFile()));
					String linea;
					StringTokenizer st;
					String valor = "";
					while((linea = br.readLine()) !=null){
						st = new StringTokenizer(linea,",");
						for(int x=0;x<9;x++){
							for(int y=0;y<9;y++){
								valor=st.nextToken();
								if(Integer.parseInt(valor) !=0){
									PanelSudoku.botones[x][y].setText(valor);
									Tablero.setValor(x, y, Integer.parseInt(valor));
									Tablero.matriz[x][y].setInicial(true);
									//if(Tablero.matriz[x][y].getInicial()){
										PanelSudoku.botones[x][y].setForeground(Color.BLUE);
										Font font=new Font(PanelSudoku.botones[x][y].getFont().getName(),Font.ITALIC+Font.BOLD,PanelSudoku.botones[0][0].getFont().getSize());
										PanelSudoku.botones[x][y].setFont(font);
									//}
								}
							}
						}

					}
					Tablero.imprimeTablero();
					br.close();
					//JOptionPane.showMessageDialog(null,"Ya termine!!!!");
				}
				catch(FileNotFoundException e1){
					JOptionPane.showMessageDialog(null,"El archivo no existe " + e1);
				}
				catch(IOException e1){
					JOptionPane.showMessageDialog(null,"Error de I/O " + e1);
				}
			}
				else if (op == JFileChooser.CANCEL_OPTION) {
					//JOptionPane.showMessageDialog(null,"canceled");
				}
			}

		});
		this.add(this.bPartida);
		
		
		this.bReset = new JButton("Reset");
		this.bReset.setBackground(Color.YELLOW);
		this.bReset.setBorderPainted(true);
		this.bReset.setOpaque(true);
		this.bReset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Reset();
			}});

		this.add(bReset);

		/*
		this.bResolver = new JButton("Resolver");
		this.bResolver.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//while(!Tablero.gano()){
				for(int x=0;x<9;x++){
					for(int y=0;y<9;y++){
						for(int valor=0;valor<10;valor++){
							if(Tablero.setValor(x,y,valor)&Tablero.matriz[x][y].getUtilizado()){
								PanelSudoku.botones[Integer.valueOf(x)][Integer.valueOf(y)].setText(String.valueOf(valor));
								Tablero.setValor(x,y,valor);
								Tablero.matriz[x][y].setUtilizado(true);
								//Tablero.gano();
							}
						}
					}
				}
				Tablero.imprimeTablero();
				//}
			}

		});

		this.add(bResolver);
		*/

		this.bGuardarPartida = new JButton("Guardar Partida");
		this.bGuardarPartida.setBackground(Color.ORANGE);
		this.bGuardarPartida.setBorderPainted(true);
		this.bGuardarPartida.setOpaque(true);
		this.bGuardarPartida.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				File archivo;
				PrintWriter archivoFinal;
				int op = fc.showSaveDialog(PanelControlesSudoku.this.psc);
				File nombreArchivo = fc.getSelectedFile();
				if(op == JFileChooser.APPROVE_OPTION){
					JOptionPane.showMessageDialog(PanelControlesSudoku.this.psc, "El archivo Guardado es "+ nombreArchivo);
					try{
						archivo=nombreArchivo; 
						archivo.createNewFile();
						archivoFinal=new PrintWriter(archivo);
						for(int fila=0; fila<9;fila++){
							for(int columna=0; columna<9;columna++){
								if(Tablero.matriz[fila][columna].getUtilizado()==true){
									archivoFinal.println(fila+","+columna+","+PanelSudoku.botones[fila][columna].getText()+","+Tablero.matriz[fila][columna].getInicial());
								}
							}
						}
						archivoFinal.close();
						//JOptionPane.showMessageDialog(null,"Listo!!!!");
					}
					catch(IOException e1){
						JOptionPane.showMessageDialog(null,"Error de I/O " + e1);
					}
				}
				else if (op == JFileChooser.CANCEL_OPTION) {
					//JOptionPane.showMessageDialog(null,"canceled");
				}
			}
		});
		this.add(this.bGuardarPartida);

		this.bAbrirPartida = new JButton("Recuperar Partida");
		this.bAbrirPartida.setBackground(Color.YELLOW);
		this.bAbrirPartida.setBorderPainted(true);
		this.bAbrirPartida.setOpaque(true);
		this.bAbrirPartida.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int op = fc.showOpenDialog(PanelControlesSudoku.this.psc);
				if(op == JFileChooser.APPROVE_OPTION){
					JOptionPane.showMessageDialog(PanelControlesSudoku.this.psc, "El archivo seleccionado es "+ fc.getSelectedFile());
					try{
						Reset();
						BufferedReader br = new BufferedReader(new FileReader(fc.getSelectedFile()));
						String linea;
						StringTokenizer st;
						int x,y;
						String valor;
						boolean inicial;
						while((linea = br.readLine()) !=null){
							st = new StringTokenizer(linea,",");
							x=Integer.parseInt(st.nextToken());
							y=Integer.parseInt(st.nextToken());
							valor=st.nextToken();
							inicial=Boolean.parseBoolean(st.nextToken());
							PanelSudoku.botones[x][y].setText(valor);
							Tablero.setValor(x, y, Integer.parseInt(valor));
							Tablero.matriz[x][y].setInicial(inicial);
							if(Tablero.matriz[x][y].getInicial()){
								PanelSudoku.botones[x][y].setForeground(Color.BLUE);
								Font font=new Font(PanelSudoku.botones[x][y].getFont().getName(),Font.ITALIC+Font.BOLD,PanelSudoku.botones[0][0].getFont().getSize());
								PanelSudoku.botones[x][y].setFont(font);
							}

						}
						Tablero.imprimeTablero();
						br.close();
						//JOptionPane.showMessageDialog(null,"Ya termine!!!!");
					}
					catch(FileNotFoundException e1){
						JOptionPane.showMessageDialog(null,"El archivo no existe " + e1);
					}
					catch(IOException e1){
						JOptionPane.showMessageDialog(null,"Error de I/O " + e1);
					}
				}
				else if (op == JFileChooser.CANCEL_OPTION) {
					//JOptionPane.showMessageDialog(null,"canceled");
				}
			}

		});
	this.add(this.bAbrirPartida);
	
	texto=new JLabel("completado:",JLabel.CENTER);
	texto.setFont(new Font("SERIF", Font.PLAIN, 20));
	texto.setForeground(Color.WHITE);
	this.add(texto);
	
	completado=new JLabel(String.valueOf((int)porc)+"%",JLabel.CENTER);
	completado.setFont(new Font("SERIF", Font.PLAIN, 60));
	completado.setForeground(Color.WHITE);
	this.add(completado);

	}
	
	public static void setPorc(double porce){
		porc=porce;
	}
		
	public void Reset(){
		for(int x=0;x<9;x++){
			for(int y=0;y<9;y++){
				PanelSudoku.botones[Integer.valueOf(x)][Integer.valueOf(y)].setText("");
				Tablero.ganar=0;
				Tablero.setValor(x,y,0);
				Tablero.matriz[x][y].setUtilizado(false);
				Tablero.imprimeTablero();
			}
		}
	}

}


