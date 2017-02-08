
public class Caja extends Rectangulo {
	protected double alto;
	public Caja(){
		this(2.0,3.0,4.0);
	}
	public Caja(double largo, double ancho, double alto){
		super(largo,ancho);
		this.alto = alto;
	}
	public double area(){
		return 2.0*(super.area()+this.ancho*this.alto+this.largo*this.alto);
	}
	public double volumen(){
		return super.area()*this.alto;
	}
	public double perimetro(){
		return 4.0*this.largo+8.0*this.alto+2.0*this.ancho;
	}
	public String toString(){
		return "Caja de ancho = " + this.ancho + ", largo = " + this.largo + " y alto = " + this.alto;
	}
}
