/*
Autor: Juan Antonio Melendres Villa     A00369017
Nombre de la clase: TareaLibro
Fecha: 19/08/2016
Comentarios:
*/
public class TareaLibro{
    // Atributos
    private String titulo,
                   autor,
                   editorial,
                   isbn;
    // Constructores
    public TareaLibro(){
        titulo = "Don Quijote de la Mancha";
        autor = "Miguel de Cervantes Saavedra";
        editorial = "Imprenta de Juan de la Cuesta";
        isbn = "122134HSFDS1y869";
    }
    public TareaLibro(String tit, String aut, String edit, String is){
        titulo = tit;
        autor = aut;
        editorial = edit;
        isbn = is;
    }
    // Setters
    public void setTitulo(String tit){
        titulo = tit;
    }
    public void setAutor(String aut){
        autor = aut;
    }
    public void setEditorial(String edit){
        editorial = edit;
    }
    public void setIsbn(String is){
        isbn = is;
    }
    // Getters
    public String getTitulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public String getEditorial(){
        return editorial;
    }
    public String getIsbn(){
        return isbn;
    }
    public static void main(String[] args) {
        TareaLibro a = new TareaLibro();
        System.out.println(a.getAutor());
        System.out.println(a.getEditorial());
        System.out.println(a.getTitulo());
        System.out.println(a.getIsbn());
        System.out.println(" ");
        TareaLibro b = new TareaLibro("Una aventura", "Juan", "Lucios", "23h9rbhoybfpifb");
        b.setIsbn("f4oby13fl4f");
        b.setTitulo("Una aventura 2.0");
        b.setEditorial("La onda literaria");
        b.setAutor("Antonio");
        System.out.println(b.getTitulo());
        System.out.println(b.getAutor());
        System.out.println(b.getIsbn());
        System.out.println(b.getEditorial());
    }
}
