import javax.swing.*;

public class IntroJava{
     public static void saluda(){
         String nombre = JOptionPane.showInputDialog("Dime tu nombre");
         System.out.println("Hola " + nombre);
     }
     public static void calificacion(){
         String sNota = JOptionPane.showInputDialog("Dime tu nota");
         int nota = Integer.parseInt(sNota);
         if(nota>=70){
             System.out.println("Aprobado " + nota);
         }
         else{
             System.out.println("Reprobado " + nota);
         }
     }
     public static void numeros1al100(){
         for(int i = 0; i < 100; i++){
             System.out.println(i+1);
         }
     }
     public static void serie(int n){
        //  int res=0;
         for(int i = 0; i < 50; i++){
            //  res=i*n;
             System.out.println((i+1)*n);
         }
     }
     public static int calorias(){
         int comidas = Integer.parseInt(JOptionPane.showInputDialog("Dime cuantas comidas haz realizado en el dia: "));
         int cal,
             total = 0;
         for(int i = 0; i < comidas; i++){
              cal = Integer.parseInt(JOptionPane.showInputDialog("Dime cuantas calorias consumiste en cada comida: "));
             total+=cal;
         }
         return total;
        //  JOptionPane.showMessageDialog(null,"Tu total de calorias consumidas es: "+total);
     }
     public static int mayor(int a, int b, int c){
         if(a>b){
             if(a>c){
                 return a;
             }
             else{
                 return c;
             }
         }
         else{
             if(b>c){
                 return b;
             }
             else{
                 return c;
             }
         }

     }
     public static void main(String[] args) {
         saluda();
         System.out.println(" ");

         calificacion();
         System.out.println(" ");
         numeros1al100();
         System.out.println(" ");
         int num = Integer.parseInt(JOptionPane.showInputDialog("Dime un numero"));
         serie(num);
         int calo=calorias();
         JOptionPane.showMessageDialog(null,"Tu total de calorias consumidas es: "+calo);
         System.out.println(" ");
         int x= Integer.parseInt(JOptionPane.showInputDialog("Dime un numero"));
         int y = Integer.parseInt(JOptionPane.showInputDialog("Dime otro numero"));
         int z = Integer.parseInt(JOptionPane.showInputDialog("Dime otro numero"));
         JOptionPane.showMessageDialog(null,"El mayor es: "+mayor(x,y,x));
     }
}


// import javax.swing.*;
//
// public class TareaCiclos{
//     public static int factores(int num){
//         if(num <= 1){
//             return 1;
//         }
//         else{
//             return (num*factores(num-1));
//         }
//     }
//     public static void main(String[] args) {
//         int x = Integer.parseInt(JOptionPane.showInputDialog("Dime un numero"));
//         System.out.println("El factorial del "+ x + " es: " + factores(x));
//         // JOptionPane.showMessageDialog(null,"El factorial del "+ x + " es: " + factores(x));
//     }
// }
