/*
Autor: Juan Antonio Melendres Villa     A00369017
Nombre de la clase: TareaCiclos
Fecha: 17/08/2016
Comentarios: al principio tuve problemas por que entendi mal la tarea ya que yo estaba entendiendo que era el factorial
, hasta que lei y vi que decia factores
*/
import javax.swing.*;

public class TareaCiclos{
    public static void factores(int num){
        for (int factor = 2; factor <= num; factor++){
            while(num % factor == 0){
                System.out.print(factor + ",");
                num/=factor;
            }
        }
    }
    public static void main(String[] args) {
        int x = Integer.parseInt(JOptionPane.showInputDialog("Dime un numero"));
        System.out.print("Los foctores son del numero " + x + " son: " );
        factores(x);
    }
}
