package actividad11_3;

import java.util.regex.Pattern;

public class Persona {
	private String nombre;
	private int edad;
	
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public Persona() {
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) throws NombreIncorrecto {
		if(nombre.length() < 3) {
			throw new NombreIncorrecto("El nombre debe tener mínimo 3 letras");
		} else if((Pattern.matches("[a-zA-Z]+",nombre))) {
			this.nombre = nombre;
		} else {
			throw new NombreIncorrecto("El nombre no puede tener dígitos.");
		}
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) throws EdadIncorrecta {
		if(edad<0 || edad>110) {
			throw new EdadIncorrecta();
		} else {
			this.edad = edad;
		}
	}
	
}

