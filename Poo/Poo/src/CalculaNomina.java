import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class CalculaNomina {
	public static void main(String[] args) {
		try{
			String linea,
					nombre,
					paterno;
			int horas;
			double tabulador;
			StringTokenizer st;
			BufferedReader br = new BufferedReader(new FileReader("/Users/juanantoniomelendresvilla/Desktop/horasTrabajadas.txt")); 
			PrintWriter pw = new PrintWriter(new FileWriter("/Users/juanantoniomelendresvilla/Desktop/nomina.txt"));
			pw.print("Nombre Completo,Total a pagar");
			br.readLine();
			while((linea=br.readLine()) !=null){
				st = new StringTokenizer(linea);
				nombre = st.nextToken();
				paterno = st.nextToken();
				horas = Integer.parseInt(st.nextToken());
				tabulador = Double.parseDouble(st.nextToken());
				pw.println(nombre+" "+paterno+","+horas*tabulador);
			}
			br.close();
			pw.close();
			JOptionPane.showMessageDialog(null,"Programa finalizado");
		}
		catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null,"No se encontro el archivo " + e);
		}
		catch(IOException e){
			JOptionPane.showMessageDialog(null,"Error de I/O " + e);
		}
	}
}
