public class UsaTermometro{
    public static void main(String[] args) {
        Termometro a = new Termometro();
        Termometro b = new Termometro(30.0);
        a.setTemp(27.0);
        System.out.println("La temperatura es "+a.getTemp());
        System.out.println("La temperatura es "+b.getTemp());
    }
}
