/*
Autor: Juan Antonio Melendres Villa     A00369017
Nombre de la clase: Tarea Complejo
Fecha: 28/08/2016
Comentarios: no comprendi como era la forma del conjudado y
me confundi un poco mas a la hora de realizarlo como lo puso en la imagen,
se me hizo mas facil identificarlo con los getters
*/
public class Complejo{
    private double numReal,
                   numImaginario;
    public Complejo(){
        this.numReal = 0.0;
        this.numImaginario = 0.0;
    }
    public Complejo(double numReal, double numImaginario){
        this.numReal = numReal;
        this.numImaginario = numImaginario;
    }
    public void establecer(double real, double imaginario){
        this.numReal = real;
        this.numImaginario = imaginario;
    }
    public void imprime(){
        System.out.println(this.numReal + ","+ this.numImaginario + "i");
    }
    public Complejo agregar(Complejo a){
        Complejo complejo = new Complejo();
        return complejo;
    }
    public double getReal(){
        return this.numReal;
    }
    public double getImaginario(){
        return this.numImaginario;
    }
    public Complejo suma(Complejo suma){
        Complejo resultado = new Complejo();
        resultado.establecer((this.numReal + suma.getReal()) , (this.numImaginario + suma.getImaginario()));
        return resultado;
    }
    public Complejo resta(Complejo resta){
        Complejo resultado = new Complejo();
        resultado.establecer((this.numReal - resta.getReal()) , (this.numImaginario - resta.getImaginario()));
        return resultado;
    }
    public Complejo multiplicacion(Complejo multi){
        Complejo resultado = new Complejo();
        resultado.establecer(((this.numReal * multi.getReal()) - (this.numImaginario * multi.getImaginario())), ((this.numReal * multi.getImaginario()) + (this.numImaginario * multi.getReal())));
        return resultado;
    }
}
