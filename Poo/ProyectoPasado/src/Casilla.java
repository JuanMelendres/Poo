
public class Casilla {
	private int valor;
	private boolean inicial;
	private boolean utilizado;
	
	public Casilla(){
		this.valor=0;
		this.inicial = this.utilizado = false;
	}
	
	public Casilla(int valor, boolean utilizado){
		this.valor=valor;
		this.utilizado=true;
	}
	
	public boolean setValor(int valor){
		boolean exito=false;
		if(0<=valor && valor<=9){
			this.valor=valor;
			this.utilizado=true;
			exito=true;
		}
		else{
			exito=false;
		}
		return exito;
	}
	
	public void setInicial(boolean inicializado){
		System.out.println("setInicial");
		this.inicial=inicializado;
	}
	
	public void setUtilizado(boolean utilizado){
		this.utilizado=utilizado;
	}
	
	public int getValor(){
		return this.valor;
	}
	
	public boolean getInicial(){
		return inicial;
	}
	
	public boolean getUtilizado(){
		return this.utilizado;
	}
}
