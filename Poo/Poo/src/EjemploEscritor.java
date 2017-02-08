import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EjemploEscritor {
	public static void main(String[] args){
		FileWriter fw;
		try{
			fw = new FileWriter("/Users/juanantoniomelendresvilla/Desktop/salida.txt");
			PrintWriter pw = new PrintWriter(fw); 
			pw.println("Hola como estas espero que bien");
			pw.println("Esta es la segunda linea");
			pw.println("Ya se acabo");
			pw.close();
		}
		catch(IOException e){
			System.out.print("No se pudo crear el archivo " + e);
		}
	}
}
