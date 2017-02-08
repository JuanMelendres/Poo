//Proyecto POO sedundo parcial Floreth Gonz·les y Juan Melendres
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
public class Tablero {
	private Casilla[][][] casilla;
	private boolean turno; //true = X false = O
	private int i=0;
	private int j=0;
	private int k=0;
	private boolean ganaste=false;
	private int n=0;

	public Tablero(){
		this.casilla = new Casilla[3][3][3];
		this.turno = true;
		for(int i = 0; i < casilla.length; i++){
			for(int j = 0; j < casilla.length; j++){
				for(int k = 0; k < casilla.length; k++){
					casilla[i][j][k] = new Casilla();
				}
			}
		}
		System.out.println("Bienvenido al juego!!!!");
		System.out.println(" | | \n"+"----- \n"+" | | \n"+"----- \n"+" | | \n");
		System.out.println(" | | \n"+"----- \n"+" | | \n"+"----- \n"+" | | \n");
		System.out.println(" | | \n"+"----- \n"+" | | \n"+"----- \n"+" | | \n");
		System.out.println("---------------------");
	}

	public void pintarTablero(){
		for(int a = 0; a < casilla.length; a++){
			for(int b = 0; b < casilla.length; b++){
				for(int c = 0; c < casilla.length; c++){
					if(c==1){
						System.out.print("|"+this.casilla[c][b][a].toString()+"|");
					}else{
						System.out.print(this.casilla[c][b][a].toString());
					}
				}
				System.out.println();
				if(b!=2){
					System.out.println("-----");
				}
			}
			System.out.println();
		}
		System.out.println("---------------------");
	}

	public void pedirCoordenada(){

		String signo= "X";
		if(this.turno==false){
			signo="O";
		}
		try{		
			String coordenada = JOptionPane.showInputDialog(null, "Ingresa la coordenada (X Y Z): ",  "Turno de " + signo, JOptionPane.QUESTION_MESSAGE);
			StringTokenizer st  = new StringTokenizer(coordenada);
			while(st.hasMoreTokens()){
				this.i = Integer.parseInt(st.nextToken())-1;
				this.j = Integer.parseInt(st.nextToken())-1;
				this.k = Integer.parseInt(st.nextToken())-1;
				if(i < 0 || i > 3 ){
					IOException e = new IOException();
					throw e;
				}
				else if(j < 0 || j > 3 ){
					IOException e = new IOException();
					throw e;
				}
				else if(k < 0 || k > 3 ){
					IOException e = new IOException();
					throw e;
				}
			}

			if(this.casilla[i][j][k].getDisponible() == true){
				this.casilla[i][j][k].setValor(this.turno);
				this.casilla[i][j][k].setDisponible(false);
				pintarTablero();
				this.n=this.n+1;
				if(gano()==true){
					pintarTablero();
					JOptionPane.showMessageDialog(null, "Haz ganado " + signo + "!!!");
					System.exit(0);
				}
				if(empate()==true){
					pintarTablero();
					JOptionPane.showMessageDialog(null, "Han empatado!");
					System.exit(0);
				}
				cambiarTurno();
			}
			else{
				System.out.println("esta ocupada");
				pedirCoordenada();
			}				
		}
		catch(NumberFormatException e){
			pedirCoordenada();
		}
		catch(NoSuchElementException e){
			pedirCoordenada();
		}
		catch(NullPointerException e){
		}
		catch(IOException e){
			pedirCoordenada();
		}

	}

	public void cambiarTurno(){
			if(this.turno == true){
				this.turno = false;
				pedirCoordenada();

			}
			else{
				this.turno = true;
				pedirCoordenada();

			}
	}
	public boolean gano(){
		for(int a=0; a<casilla.length; a++){
			for(int b=0; b<casilla.length; b++){
				if(casilla[0][a][b].getDisponible()==false && casilla[1][a][b].getDisponible()==false && casilla[2][a][b].getDisponible()==false){
					if((casilla[0][a][b].getValor()==true && casilla[1][a][b].getValor()==true && casilla[2][a][b].getValor()==true) || 
							(casilla[0][a][b].getValor()==false && casilla[1][a][b].getValor()==false && casilla[2][a][b].getValor()==false)){
						this.ganaste = true;
						break;
					}
				}
				if(casilla[a][0][b].getDisponible()==false && casilla[a][1][b].getDisponible()==false && casilla[a][2][b].getDisponible()==false){
					if((casilla[a][0][b].getValor()==true && casilla[a][1][b].getValor()==true && casilla[a][2][b].getValor()==true) || 
							(casilla[a][0][b].getValor()==false && casilla[a][1][b].getValor()==false && casilla[a][2][b].getValor()==false)){
						this.ganaste = true;
						break;
					}
				}
				if(casilla[0][0][a].getDisponible()==false && casilla[1][1][a].getDisponible()==false && casilla[2][2][a].getDisponible()==false){
					if((casilla[0][0][a].getValor()==true && casilla[1][1][a].getValor()==true && casilla[2][2][a].getValor()==true) ||
							(casilla[0][0][a].getValor()==false && casilla[1][1][a].getValor()==false && casilla[2][2][a].getValor()==false)){
						this.ganaste = true;
						break;
					}
				}
			}
			if(casilla[2][0][a].getDisponible()==false && casilla[1][1][a].getDisponible()==false && casilla[0][2][a].getDisponible()==false){
				if((casilla[2][0][a].getValor()==true && casilla[1][1][a].getValor()==true && casilla[0][2][a].getValor()==true) ||
						(casilla[2][0][a].getValor()==false && casilla[1][1][a].getValor()==false && casilla[0][2][a].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			if(casilla[0][0][0].getDisponible()==false && casilla[0][1][1].getDisponible()==false && casilla[0][2][2].getDisponible()==false){
				if((casilla[0][0][0].getValor()==true && casilla[0][1][1].getValor() ==true && casilla[0][2][2].getValor() ==true)||
						(casilla[0][0][0].getValor()==false && casilla[0][1][1].getValor()==false && casilla[0][2][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			else if(casilla[1][0][0].getDisponible()==false && casilla[1][1][1].getDisponible()==false && casilla[1][2][2].getDisponible()==false){
				if((casilla[1][0][0].getValor()==true && casilla[1][1][1].getValor()==true && casilla[1][2][2].getValor()==true)||
						(casilla[1][0][0].getValor()==false && casilla[1][1][1].getValor()==false && casilla[1][2][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			else if(casilla[2][0][0].getDisponible()==false && casilla[2][1][1].getDisponible()==false && casilla[2][2][2].getDisponible()==false){
				if((casilla[2][0][0].getValor()==true && casilla[2][1][1].getValor() ==true && casilla[2][2][2].getValor() ==true)||
						(casilla[2][0][0].getValor()==false && casilla[2][1][1].getValor()==false && casilla[2][2][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			else if(casilla[0][0][0].getDisponible()==false && casilla[1][0][1].getDisponible()==false && casilla[2][0][2].getDisponible()==false){
				if((casilla[0][0][0].getValor()==true && casilla[1][0][1].getValor()==true && this.casilla[2][0][2].getValor()==true)||
						(casilla[0][0][0].getValor()==false && casilla[1][0][1].getValor()==false && casilla[2][0][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			else if(casilla[0][1][0].getDisponible()==false && casilla[1][1][1].getDisponible()==false && casilla[2][1][2].getDisponible()==false){
				if((this.casilla[0][1][0].getValor()==true && this.casilla[1][1][1].getValor()==true && this.casilla[2][1][2].getValor()==true)||
						(casilla[0][1][0].getValor()==false && casilla[1][1][1].getValor()==false && casilla[2][1][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			else if(casilla[0][2][0].getDisponible()==false && casilla[1][2][1].getDisponible()==false && casilla[2][2][2].getDisponible()==false){
				if((this.casilla[0][2][0].getValor()==true && this.casilla[1][2][1].getValor()==true && this.casilla[2][2][2].getValor()==true)||
						(casilla[0][2][0].getValor()==false && casilla[1][2][1].getValor()==false && casilla[2][2][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			else if(casilla[0][0][0].getDisponible()==false && casilla[1][1][1].getDisponible()==false && casilla[2][2][2].getDisponible()==false){
				if((this.casilla[0][0][0].getValor()==true && this.casilla[1][1][1].getValor()==true && this.casilla[2][2][2].getValor()==true)||
						(casilla[0][0][0].getValor()==false && casilla[1][1][1].getValor()==false && casilla[2][2][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			else if(casilla[0][2][0].getDisponible()==false && casilla[1][1][1].getDisponible()==false && casilla[2][0][2].getDisponible()==false){
				if((this.casilla[0][2][0].getValor()==true && this.casilla[1][1][1].getValor()==true && this.casilla[2][0][2].getValor()==true)||
						(casilla[0][2][0].getValor()==false && casilla[1][1][1].getValor()==false && casilla[2][0][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			else if(casilla[0][0][0].getDisponible()==false && casilla[0][0][1].getDisponible()==false && casilla[0][0][2].getDisponible()==false){
				if((this.casilla[0][0][0].getValor()==true && this.casilla[0][0][1].getValor()==true && this.casilla[0][0][2].getValor()==true)||
						(casilla[0][0][0].getValor()==false && casilla[0][0][1].getValor()==false && casilla[0][0][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			else if(casilla[1][0][0].getDisponible()==false && casilla[1][0][1].getDisponible()==false && casilla[1][0][2].getDisponible()==false){
				if((this.casilla[1][0][0].getValor()==true && this.casilla[1][0][1].getValor()==true && this.casilla[1][0][2].getValor()==true)||
						(casilla[1][0][0].getValor()==false && casilla[1][0][1].getValor()==false && casilla[1][0][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			else if(casilla[2][0][0].getDisponible()==false && casilla[2][0][1].getDisponible()==false && casilla[2][0][2].getDisponible()==false){
				if((this.casilla[2][0][0].getValor()==true && this.casilla[2][0][1].getValor()==true && this.casilla[2][0][2].getValor()==true)||
						(casilla[2][0][0].getValor()==false && casilla[2][0][1].getValor()==false && casilla[2][0][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			else if(casilla[0][1][0].getDisponible()==false && casilla[0][1][1].getDisponible()==false && casilla[0][1][2].getDisponible()==false){
				if((this.casilla[0][1][0].getValor()==true && this.casilla[0][1][1].getValor()==true && this.casilla[0][1][2].getValor()==true)||
						(casilla[0][1][0].getValor()==false && casilla[0][1][1].getValor()==false && casilla[0][1][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			else if(casilla[1][1][0].getDisponible()==false && casilla[1][1][1].getDisponible()==false && casilla[1][1][2].getDisponible()==false){
				if((this.casilla[1][1][0].getValor()==true && this.casilla[1][1][1].getValor()==true && this.casilla[1][1][2].getValor()==true)||
						(casilla[1][1][0].getValor()==false && casilla[1][1][1].getValor()==false && casilla[1][1][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			else if(casilla[2][1][0].getDisponible()==false && casilla[2][1][1].getDisponible()==false && casilla[2][1][2].getDisponible()==false){
				if((this.casilla[2][1][0].getValor()==true && this.casilla[2][1][1].getValor()==true && this.casilla[2][1][2].getValor()==true)||
						(casilla[2][1][0].getValor()==false && casilla[2][1][1].getValor()==false && casilla[2][1][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			else if(casilla[0][2][0].getDisponible()==false && casilla[0][2][1].getDisponible()==false && casilla[0][2][2].getDisponible()==false){
				if((this.casilla[0][2][0].getValor()==true && this.casilla[0][2][1].getValor()==true && this.casilla[0][2][2].getValor()==true)||
						(casilla[0][2][0].getValor()==false && casilla[0][2][1].getValor()==false && casilla[0][2][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			else if(casilla[1][2][0].getDisponible()==false && casilla[1][2][1].getDisponible()==false && casilla[1][2][2].getDisponible()==false){
				if((this.casilla[1][2][0].getValor()==true && this.casilla[1][2][1].getValor()==true && this.casilla[1][2][2].getValor()==true)||
						(casilla[1][2][0].getValor()==false && casilla[1][2][1].getValor()==false && casilla[1][2][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
			else if(casilla[2][2][0].getDisponible()==false && casilla[2][2][1].getDisponible()==false && casilla[2][2][2].getDisponible()==false){
				if((this.casilla[2][2][0].getValor()==true && this.casilla[2][2][1].getValor()==true && this.casilla[2][2][2].getValor()==true)||
						(casilla[2][2][0].getValor()==false && casilla[2][2][1].getValor()==false && casilla[2][2][2].getValor()==false)){
					this.ganaste = true;
					break;
				}
			}
		}
		return this.ganaste;
	}
	public boolean empate(){
		boolean empate = false;
		if(this.n == 23){
			empate = true;
		}
		return empate;
	}
	public static void main(String[] args) {
		Tablero obj = new Tablero();
		obj.pedirCoordenada();
	}

}