public class UsaClock{
    public static void main(String args[]){
        Clock GDL = new Clock(11,54,0);
        Clock NY = new Clock();

        GDL.printTime();
        NY.makeCopy(GDL);

        NY.printTime();
    }
}