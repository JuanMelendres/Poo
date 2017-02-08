
public class EjemploNovedadesJava {
	public static int total(int[] valores){
		int suma = 0;
		for(int valor: valores){
			suma+=valor;
		}
		return suma;
	}

	public static void main(String[] args) {
		int[] valores = {10, 20, 30, 40, 50};
		int resultado = total(valores);
		System.out.println("La suma total es igual a " + resultado);
	}

}
