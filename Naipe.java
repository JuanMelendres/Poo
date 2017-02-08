public class Naipe{
	private int valor, //0->As, 1->2, ...10->J, 11->Q, 12->K
		        palo;  //0->espadas, 1->corazones, 2->trÈboles, 3->diamantes.

	private static final String[] sValor={"as","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez","joto","reina","rey"};
	private static final String[] sPalo={"espadas","corazones","treboles","diamantes"};

	public Naipe(int valor, int palo){
		this.valor=valor;
		this.palo=palo;
	}

	public String toString(){
			return this.sValor[this.valor]+" de "+this.sPalo[this.palo];
	}

	public static void main(String[] args){
		Baraja baraja=new Baraja();
		System.out.println(baraja);

		System.out.println("-------------Se mezclan las cartas--------");
		baraja.mezclar();
		System.out.println(baraja);

	}

}
