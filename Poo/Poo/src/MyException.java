
public class MyException extends RuntimeException {
	public MyException(){
		super("Ocurrio un error!!!!");
	}
	public MyException(String msj){
		super(msj);
	}
}
