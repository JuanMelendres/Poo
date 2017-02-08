public class UsaClock{
    public static void main(String[] args) {
        Clock la = new Clock();
        Clock gdl = new Clock(-8,55436,4545113);
        Clock ny = new Clock(23,59,59);
        la.printTime();
        System.out.println(" ");
        gdl.printTime();
        System.out.println(" ");
        ny.printTime();

        System.out.println(" ");
        la.setTime(10,56,45);
        gdl.setTime(13,13,34254654);
        ny.incrementSeconds();

        la.printTime();
        System.out.println(" ");
        gdl.printTime();
        System.out.println(" ");
        ny.printTime();

        Clock tij=la.getCopy();
    }
}
