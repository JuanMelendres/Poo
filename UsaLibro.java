public class UsaLibro{
    public static void main(String[] args) {
        TareaLibro a = new TareaLibro();
        System.out.println(a.getAutor());
        System.out.println(a.getEditorial());
        System.out.println(a.getTitulo());
        System.out.println(a.getIsbn());
        TareaLibro b = new TareaLibro("Una aventura", "Juan", "Lucios", "23h9rbhoybfpifb");
        System.out.println(b.getAutor());
        System.out.println(b.getTitulo());
    }
}
