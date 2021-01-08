package actividad11_3;

public class DemasiadosObjetos extends Exception {
	private static final long serialVersionUID = -7490369223302999976L;
	
	public DemasiadosObjetos() {
		super("Demasiados objetos dentro de la BD, por favor borre personas.");
	}
}
