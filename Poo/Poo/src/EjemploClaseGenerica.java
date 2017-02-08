
public class EjemploClaseGenerica<T, E extends Comparable<E>> {
	
	private E[] datos;
	private T dato;
	
	public EjemploClaseGenerica(E[] datos){
		this.datos = datos;
	}
	
	public void setDato(T dato){
		this.dato = dato;
	}
	
	public T getDato(){
		return this.dato;
	}
	
	public E min(){
		E menor =this.datos[0];
		for(E n:this.datos){
			if(n.compareTo(menor) < 0){
				menor = n;
			}
		}
		return menor;
	}
	
	public static void main(String[] args) {
		Integer[] a = {1,2,3,4,5};
		Double[] b = {1.0,2.0,3.0,4.0,5.0};
		String[] c = {"Hola","Como","Estas"};
		
		EjemploClaseGenerica<String, Integer> obj1 = new EjemploClaseGenerica<>(a);
		EjemploClaseGenerica<Integer, Double> obj2 = new EjemploClaseGenerica<>(b);
		EjemploClaseGenerica<Cuadrado, String> obj3 = new EjemploClaseGenerica<>(c);
		
		System.out.println(obj1.min());
		System.out.println(obj2.min());
		System.out.println(obj3.min());
		obj3.setDato(new Cuadrado(7));
		obj1.setDato("WOW");
		String resultado = obj1.getDato();
	}

}
