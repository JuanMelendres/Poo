public class EjemploArregloStrings{
	private String[] palabras;

	public EjemploArregloStrings(String[] palabras){
		this.palabras=palabras;

		/*this.palabras=new String[palabras.length];
		for(int i=0;i<this.palabras.length;i++){
			this.palabras[i]="Hola "+i;
		}*/
	}

	public int totalLetras(){
		int total=0;
		for(int i=0;i<this.palabras.length;i++){
			total+=palabras[i].length();
		}
		return total;
	}

	public void remplazar(String old,String nueva){
		for(int i=0;i<this.palabras.length;i++){
			this.palabras[i]=this.palabras[i].replaceAll(old,nueva);
		}
	}

	public String toString(){
		String res="";
		for(int i=0;i<this.palabras.length;i++){
			res+=(this.palabras[i]+", ");
		}
		return res;
	}

	public static void main(String[] args){
		EjemploArregloStrings eas=new EjemploArregloStrings(args);
		System.out.println("El total de letras es: "+"holaquehace".length());
		System.out.println("El total de letras es: "+eas.totalLetras());
		System.out.println(eas);

		eas.remplazar("a","c");
		System.out.println(eas);
	}
}
