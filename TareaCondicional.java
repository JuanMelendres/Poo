/*
Autor: Juan Antonio Melendres Villa     A00369017
Nombre de la clase: TareaCondicional
Fecha: 14/08/2016
Comentarios:
*/
import javax.swing.*;

public class TareaCondicional{

    public static void calculador(){
        String sTab = JOptionPane.showInputDialog("¿Cual es tu tabulador?");
        String sHoras = JOptionPane.showInputDialog("¿Cuales son tus horas trabajadas?");
        int horas = Integer.parseInt(sHoras);
        int tab = Integer.parseInt(sTab);
        if(tab <= 5000){
            int mul = 0;
            mul = (tab*horas);
            double imp = 0;
            imp = (0.08*mul);
            double total = 0;
            total = (mul - imp);
            System.out.println("De acuerdo con los datos ingresados");
            System.out.println("El tabulador es "+tab+" y las horas trabajadas son "+horas);
            System.out.println("El total a pagar es de " + total);
        }
        else if(tab>=5001 && tab<=10000){
            int mul = 0;
            mul = (tab*horas);
            double imp = 0;
            imp = (0.15*mul);
            double total = 0;
            total = (mul - imp);
            System.out.println("De acuerdo con los datos ingresados");
            System.out.println("El tabulador es "+tab+" y las horas trabajadas son "+horas);
            System.out.println("El total a pagar es de " + total);
        }
        else if(tab>=10001 && tab<=17000){
            int mul = 0;
            mul = (tab*horas);
            double imp = 0;
            imp = (0.23*mul);
            double total = 0;
            total = (mul - imp);
            System.out.println("De acuerdo con los datos ingresados");
            System.out.println("El tabulador es "+tab+" y las horas trabajadas son "+horas);
            System.out.println("El total a pagar es de " + total);
        }
        else if(tab >= 17001){
            int mul = 0;
            mul = (tab*horas);
            double imp = 0;
            imp = (0.3*mul);
            double total = 0;
            total = (mul - imp);
            System.out.println("De acuerdo con los datos ingresados");
            System.out.println("El tabulador es "+tab+" y las horas trabajadas son "+horas);
            System.out.println("El total a pagar es de " + total);
        }
    }
    public static void main(String[] args) {
        calculador();
    }
}
