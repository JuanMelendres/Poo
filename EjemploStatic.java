public class EjemploStatic{
    private static int x;
    private int y;

    public static void main(String[] args) {
        EjemploStatic obj = new EjemploStatic();
        obj.x = 100;
        obj.y = 10;

        EjemploStatic obj2 = new EjemploStatic();
        obj2.x = 200;
        obj2.y = 20;
        System.out.println(obj.x);
        System.out.println(obj.y);
        System.out.println(obj2.x);
        System.out.println(obj2.y);
    }
}
