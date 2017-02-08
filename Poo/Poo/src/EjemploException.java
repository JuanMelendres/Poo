
public class EjemploException {
	public void metodoD(){
		throw new MyException("Error en metodo D, no se puede realizar la operacion");
	}
	public void metodoC(){
		metodoD();
	}
	public void metodoB(){
		metodoC();
	}
	public void metodoA(){
		metodoB();
	}
	public static void main(String[] args) {
		try{
			EjemploException ee = new EjemploException();
			ee.metodoA();
		}
		catch(MyException e){
			System.out.println("Ocurrio un error " + e);
		}
	}

}
