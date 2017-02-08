import javax.swing.*;

public class Arreglo{
    public static void main(String args[]){
        int[] arreglo1 = new int[10];
        for(int i = 0; i < arreglo1.length; i++){
            int suma = 0;
            suma += i;
            System.out.println(arreglo1[i] + suma);
        }
        JOptionPane.showMessageDialog(null, "Que pedo!!!");
    }
}