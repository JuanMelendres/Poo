import java.util.*;

public class Baraja{
	private Naipe[] cartas;

	public Baraja(){
		this.cartas=new Naipe[52];
		int c=0;
		for(int i=0;i<4;i++){
			for(int j=0;j<13;j++){
				this.cartas[c++]=new Naipe(j,i);
			}
		}
	}

	public void mezclar(){
		Random rdm=new Random();
		Naipe tmp;
		int iRdm;
		for(int i=0;i<this.cartas.length;i++){
			iRdm=rdm.nextInt(52);
			tmp=this.cartas[i];
			this.cartas[i]=this.cartas[iRdm];
			this.cartas[iRdm]=tmp;
		}
	}

	public String toString(){
		String resultado="";
		for(int i=0;i<this.cartas.length;i++){
			resultado+=this.cartas[i]+"\n";
		}
		return resultado;
	}
}
