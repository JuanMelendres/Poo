
public class Rectangulo extends Figura{
	protected double largo, 
					ancho;
	public Rectangulo(){
		this(5.0,7.0);
	}
	public Rectangulo(double base, double altura){
		this.largo = base;
		this.ancho = altura;
	}
	public double perimetro(){
		return 2.0*this.largo+2.0*this.ancho;
	}
	public double area(){
		return this.largo*this.ancho;
	}
	public String toString(){
		return "Rectangulo con base = "+ this.largo + " y altura = " + this.ancho;
	}
}
