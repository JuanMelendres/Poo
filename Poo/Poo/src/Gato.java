import java.io.*;
public class Gato {

	public static void main(String[] args)throws IOException {
		BufferedReader recibir=new BufferedReader (new InputStreamReader(System.in));
		String juego[][];
		juego = new String[3][3];//matrices
		int n=0;
		int fila;
		int columna;
		for (int a=0; a<=2; a=a+1) {
			for (int b=0; b<=2; b=b+1) {
				juego[a][b]="?";
				int dato;
				int dato1;
				int datob;
				int datob2;
			}

		}

		//tablero
		System.out.println(" 0   1   2");
		System.out.println("0 "+juego[0][0]+" | "+juego[0][1]+" | "+juego[0][2]);
		System.out.println("  __________");
		System.out.println("2 "+juego[1][0]+" | "+juego[1][1]+" | "+juego[1][2]);
		System.out.println("  __________");
		System.out.println("3 " +juego[2][0]+" | "+juego[2][1]+" | "+juego[2][2]);

		while (n<10) { //ciclo

			//jugador 'x'
			System.out.println("Es el turno del jugador X.");
			System.out.println(" fila.");
			int dato=Integer.parseInt(recibir.readLine());
			System.out.println(" columna.");
			int dato1=Integer.parseInt(recibir.readLine());
			//comprobar si la jugada existe
			while (juego[dato][dato1]== "X" || juego[dato][dato1]== "O" ) { //comparacion
				System.out.println("A ingresado una jugada en donde YA existia una anteriormente");
				System.out.println("Ingrese una fila.");
				dato=Integer.parseInt(recibir.readLine());
				System.out.println("Ingrese una columna.");
				dato1=Integer.parseInt(recibir.readLine());
			}
			juego[dato][dato1] = "X";
			//jugador X

			//tablero
			System.out.println(" 0   1   2");
			System.out.println("0 "+juego[0][0]+" | "+juego[0][1]+" | "+juego[0][2]);
			System.out.println("  ___________");
			System.out.println("1 "+juego[1][0]+" | "+juego[1][1]+" | "+juego[1][2]);
			System.out.println("  ___________");
			System.out.println("2 "+juego[2][0]+" | "+juego[2][1]+" | "+juego[2][2]);

			n=n+1;


			if (juego[0][0]== "X" && juego[0][1]== "X" && juego [0][2]== "X") {
				System.out.println("El ganador es el jugador 'x'.");
				break;
			}
			if (juego[1][0]== "X" && juego[1][1]== "X" && juego [1][2]== "X") {
				System.out.println("El ganador es el jugador 'x'.");
				break;
			}
			else if (juego[2][0]== "X" && juego[2][1]== "X" && juego [2][2]== "X") {
				System.out.println("El ganador es el jugador X.");
				break;
			}
			if (juego[0][0]== "X" && juego[1][0]== "X" && juego [2][0]== "X") {
				System.out.println("El ganador es el jugador X.");
				break;
			}
			if (juego[0][1]== "X" && juego[1][1]== "X" && juego [2][1]== "X") {
				System.out.println("El ganador es el jugador X.");
				break;
			}
			if (juego[0][2]== "X" && juego[1][2]== "X" && juego [2][2]== "X") {
				System.out.println("El ganador es el jugador 'X'.");
				break;
			}
			//diagonales faltan
			if (juego[0][0]== "X" && juego[1][1]== "X" && juego [2][2]== "X") {
				System.out.println("El ganador es el jugador X.");
				break;
			}
			if (juego[0][2]== "X" && juego[1][1]== "X" && juego [2][0]== "X") {
				System.out.println("El ganador es el jugador X.");
				break;
			}
			//condiciones victoria

			if (n==9) {
				break;
			}

			//jugador 0
			System.out.println("Es el turno del la Maquina");
			System.out.println(" fila.");
			int datob;
			datob = (int)(Math.random()*3)+0;
			System.out.println("columna.");
			int datob2;
			datob2 = (int)(Math.random()*3)+0;
			System.out.println("numeros elegidos"+datob+"segundo"+datob2);
			//comprobar si la jugada existe
			while (juego[datob][datob2]== "O" || juego[datob][datob2]== "X" ) {
				System.out.println("maquina");
				datob = (int)(Math.random()*3)+0;
				datob2 = (int)(Math.random()*3)+0;
				System.out.println("numeros elegidos"+datob+"segundo"+datob2);
			}
			juego[datob][datob2] = "O";
			// jugador O

			//tablero
			System.out.println(" 0   1   2");
			System.out.println("0 "+juego[0][0]+" | "+juego[0][1]+" | "+juego[0][2]);
			System.out.println("  ____________");
			System.out.println("1 "+juego[1][0]+" | "+juego[1][1]+" | "+juego[1][2]);
			System.out.println("  ____________");
			System.out.println("2 "+juego[2][0]+" | "+juego[2][1]+" | "+juego[2][2]);

			n=n+1;//cantidad de jugadas permitidas

			if (juego[0][0]== "O" && juego[0][1]== "O" && juego [0][2]== "O") {
				System.out.println("el ganador es la maquina");
				break;
			}
			if (juego[1][0]== "O" && juego[1][1]== "O" && juego [1][2]== "O") {
				System.out.println("El ganador es la maquina");
				break;
			}
			if (juego[2][0]== "O" && juego[2][1]== "O" && juego [2][2]== "O") {
				System.out.println("El ganador es la maquina.");
				break;
			}
			if (juego[0][0]== "O" && juego[1][0]== "O" && juego [2][0]== "O") {
				System.out.println("El ganador es la maquina");
				break;
			}
			if (juego[0][1]== "O" && juego[1][1]== "O" && juego [2][1]== "O") {
				System.out.println("El ganador es la maquina");
				break;
			}
			if (juego[0][2]== "O" && juego[1][2]== "O" && juego [2][2]== "O") {
				System.out.println("El ganador es la maquina");
				break;
			}
			//diagonales faltan
			if (juego[0][0]== "O" && juego[1][1]== "O" && juego [2][2]== "O") {
				System.out.println("El ganador es la maquina.");
				break;
			}
			if (juego[0][2]== "O" && juego[1][1]== "O" && juego [2][0]== "O") {
				System.out.println("El ganador es la maquina");
				break;
			}
			//condiciones victoria

			if (n==9) {
				break;
			}

		}

	}
}
