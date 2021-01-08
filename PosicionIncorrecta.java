package actividad11_3;

public class PosicionIncorrecta extends Exception {
	private static final long serialVersionUID = -5787258275872970023L;
	
	public PosicionIncorrecta() {
		super("¡Error el indice que ha insertado, no esta asociado a ninguna persona!");
	}
}
