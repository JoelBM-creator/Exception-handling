package actividad11_3;

public class EdadIncorrecta extends Exception{
	private static final long serialVersionUID = 4484203590320980415L;
	
	public EdadIncorrecta() {
		super("La edad no puede ser menor a 1 ni mayor a 110");
	}
}
