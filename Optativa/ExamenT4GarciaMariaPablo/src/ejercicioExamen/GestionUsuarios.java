package ejercicioExamen;

import java.util.List;

public class GestionUsuarios {

	private List<Usuario> usuarios;
	
	public GestionUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public static String validarNombre(String nombre, int minCaracter) throws TextoInvalidoException, CalculoInvalidoException {
		
		if (nombre.isBlank())
			throw new TextoInvalidoException("You inserted a blank name, without any characters...");
		
		if (nombre.length() < minCaracter)
			throw new CalculoInvalidoException("You inserted a name with less than " + minCaracter + " characters...");
		
		return nombre;
	}
	
	public static String validarEmail(String email, String caracteresMin) throws TextoInvalidoException  {
		
		if (!email.contains(caracteresMin))
			throw new TextoInvalidoException("You inserted an invalid email, every email needs the following characters: " + caracteresMin);
		
		return email;
	}
	
	public static int validarEdad(int edad, int mindEdad) throws CalculoInvalidoException {
		
		if (edad < mindEdad)
			throw new CalculoInvalidoException("The age that you inserted is below the minimun for registration wich is: " + mindEdad);
		
		return edad;
	}

	public void listarUsuarios() {
		usuarios.forEach(System.out::println);
	}

	
}
