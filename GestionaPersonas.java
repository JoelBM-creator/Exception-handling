package actividad11_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GestionaPersonas {
	private static int valor;
	private static ArrayList<Persona> personas = new ArrayList<Persona>();

	public static void main(String[] args) {
		// Menu para gestionar las personas
		try {
			boolean salir = false;
			System.out.println("¿Que operación deseas realizar?");
			do {
				System.out.println("1: Añadir una persona." + "\n2: Borrar persona." + "\n0: Finalizar.");
				int opciones = pideEntero();
				if (0 > opciones || opciones > 2) {
					System.out.println("Introduzca una opcion: ");
				}
				switch (opciones) {
				case 1:
					if (personas.size() == 2) {
						System.out.println(new DemasiadosObjetos().getMessage());
					} else {
						addPersona();
					}
					System.out.println("Personas almacenada correctamente");
					break;
				case 2:
					valor = 0;
					personas.forEach(persona -> {
						System.out.println("Indice tarea: " + valor++ + " Nombre: " + persona.getNombre());
					});

					System.out.println("¿Que tarea desea borrar?");
					borrarTarea();
					break;
				case 0: // Salir = True
					System.out.println("¡Nos vemos en la próxima!");
					salir = true;
				}
			} while (!salir);
		} catch (Exception e) {
			System.err.print("Exception: " + e);
			e.printStackTrace();
		}
	}

	// Metodo por el cual el usuario introduce un numero valido.
	public static int pideEntero() throws Exception {
		String numeroIndicado;
		int numero;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numeroIndicado = br.readLine();
		numero = Integer.parseInt(numeroIndicado);

		return numero;
	}

	// Metodo para borrar una persona
	public static void borrarTarea() {
		boolean comprobador = false;
		do {
			try {
				int num = pideEntero();
				if (num < 0 || num > personas.size()) {
					System.out.println(new PosicionIncorrecta().getMessage());
					comprobador = false;
				} else {
					comprobador = true;
					personas.remove(num);
				}
			} catch (Exception e) {
				System.out.println("¡No hay ningúna persona a borrar!");
			}
		} while (comprobador = false);
	}

	// Metodo por la cual el usuario introduce una frase.
	public static String pideString() throws Exception {
		String fraseEntrada;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		fraseEntrada = br.readLine();
		return fraseEntrada;
	}

	// Metodo para añadir una nueva persona.
	public static void addPersona() {
		boolean comprobador = false;

		Persona persona = new Persona();
		do {
			System.out.println("Nombre de la persona: ");
			try {
				String nombre = pideString();
				persona.setNombre(nombre);
			} catch (NombreIncorrecto e) {
				System.out.println(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if (persona.getNombre() != null) {
				comprobador = true;
			} else {
				comprobador = false;
			}
		} while (comprobador == false);

		do {
			System.out.println("Edad de la persona: (Entre 1 y 110) ");
			try {
				int edad = pideEntero();
				persona.setEdad(edad);
			} catch (EdadIncorrecta e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (persona.getEdad() == 0) {
				comprobador = false;
			} else {
				comprobador = true;
			}
		} while (comprobador == false);

		personas.add(persona);
	}
}
