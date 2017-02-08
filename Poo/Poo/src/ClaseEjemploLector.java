import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ClaseEjemploLector {
	public static void main(String[] args){
		try{
			BufferedReader br = new BufferedReader(new FileReader("/Users/juanantoniomelendresvilla/Desktop/ejemplo.txt"));
		//System.out.println(br.readLine());
			String linea;
	        while((linea=br.readLine())!=null){
	            System.out.println(linea);
	        }
			br.close();
		}
		catch(FileNotFoundException e){
			System.out.println("El archivo no se localizo " + e);
		}
		catch(IOException e){
			System.out.println("El archivo no se puede leer" + e);
		}
	}
}
