import java.util.ArrayList;

public class EjemploWildcards {

	public static double suma(ArrayList<? extends Number> valores){
		double resultado=0.0;
		for(Number valor:valores){
			resultado+=valor.doubleValue();
			//r+=valores.get(i).doubleValue(); for normal
		}
		return resultado;
	}
	
	public static void main(String[] args) {
//		valor(new Integer(8));
		ArrayList<Number> numeros1=new ArrayList<>();
		numeros1.add(1);
		numeros1.add(3.5);
		numeros1.add(10L);
		numeros1.add(5.3f);
		double res=suma(numeros1);
		System.out.println("El resultado es: "+res);
		
		ArrayList<Number> numeros2=new ArrayList<>();
		numeros2.add(1);
		numeros2.add(3);
		numeros2.add(10);
		numeros2.add(5);
		res=suma(numeros2);
		System.out.println("El resultado es: "+res);
	}

}	
