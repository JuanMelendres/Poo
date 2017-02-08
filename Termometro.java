public class Termometro{
    private double temp;

    public Termometro(){
        temp= 25.0;
    }
    public Termometro(double t){
        temp=t;
    }
    public void setTemp(double t){
        temp=t;
    }
    public double getTemp(){
        return temp;
    }
}
