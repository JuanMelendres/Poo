public class PruebaArreglos{
    public int suma(int[] arreglo){
        int resultado = 0;
        for(int i = 0; i<arreglo.length; i++){
            resultado+=arreglo[i];
        }
        return resultado;
    }
    public int maximo(int[] arreglo){
        int max = arreglo[0];
        for(int i = 1; i<arreglo.length; i++){
            if(arreglo[i]>max){
                max = arreglo[i];
            }
        }
        return max;
    }
    public void imprimeArreglo(String[][] palabras){
        for(int i = 0; i < palabras.length; i++){
            for(int j = 0; j < palabras[i].length; j++){
                System.out.print(palabras[i][j] +" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        PruebaArreglos obj = new PruebaArreglos();
        int[] valores = {3,10,5,2,1,20,7,4};
        int[] valores2 = {};
        String[][] letras = {{"a","c","e","g","i","k"} , {"b","d"} , {"t","u"}, {"w","q","r","p"}};
        System.out.println("La suma es: " + obj.suma(valores));
        System.out.println("El mayor es: " + obj.maximo(valores));

        int c = 2;
        int filas = Integer.parseInt(args[0]);
        int columnas = Integer.parseInt(args[1]);
        String[][] palabras2 = new String[filas][columnas];

        for(int i = 0; i < filas; i++){
            for(int j = 0; j < columnas; j++){
                palabras2[i][j] = args[c++];
            }
        }
        System.out.print(palabras2[0][0].toUpperCase());
    }
}
