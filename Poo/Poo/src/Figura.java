
public class Figura {
	public double perimetro(){
		return 0.0;
	}
	public double area(){
		return 0.0;
	}
	public double volumen(){
		return 0.0;
	}
	public String toString(){
		return "Figura Abstracta";
	}
	public static void main(String[] args) {
		Figura[] figuras = new Figura[4];
		figuras[0] = new Figura();
		figuras[1] = new Rectangulo();
		figuras[2] = new Cuadrado(6.0);
		figuras[3] = new Caja();
		for(int i = 0; i < figuras.length; i++){
			System.out.println(figuras[i]);
			System.out.println("Perimetro: " + figuras[i].perimetro());
			System.out.println("Area: " + figuras[i].area());
			System.out.println("Volumen: " + figuras[i].volumen()+"\n");
		}
	}
}