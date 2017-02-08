
public class EjemploMetodoGenerico {
	
	public static <E>E imprimeArreglo(E[] array){
		for(E n:array){
			System.out.print(n+", ");
		}
		System.out.println();
		return array[array.length-1];
	}

	public static void main(String[] args) {
		Integer[] a = {1,2,3,4,5};
		imprimeArreglo(a);
		Double[] b = {1.0,2.0,3.0,4.0,5.0};
		imprimeArreglo(b);
		String[] c = {"Hola","Como","Estas"};
		imprimeArreglo(c);
	}

}
