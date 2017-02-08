//Proyecto POO sedundo parcial Floreth Gonz·les y Juan Melendres
public class Casilla { 
	private boolean disponible, valor; 
	public static final boolean X = true; 
	public static final boolean O = false; 
	public Casilla(){ 
		this.valor = X; 
		this.disponible = true; 
	} 
	public boolean getValor(){ 
		return this.valor; 
	} 
	public void setValor(boolean signo){ 
		boolean tmp; 
		if(signo == true){ 
			tmp = this.X; 
		} 
		else{ 
			tmp = this.O; 
		} 
		this.valor=tmp; 
	} 
	public void setDisponible(boolean disponible){ 
		this.disponible = disponible; 
	} 
	public boolean getDisponible(){ 
		return this.disponible; 
	} 
	public String toString(){ 
		String jugador = " "; 
		if(this.valor == X && this.disponible == false){ 
			jugador = "X";
		} 
		else if(this.valor == O && this.disponible == false){ 
			jugador = "O"; 
		} 
		return jugador; 
	} 
}