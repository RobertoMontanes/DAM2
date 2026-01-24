package ejercicio06b;

public class Empleado {
	//id, nombre, departamento, salario, activo y años de antigüedad
	
	private int id;
	private String nombre;
	private String departamento;
	private double salario;
	private boolean activo;
	private int antiguedad;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public Empleado(int id, String nombre, String departamento, double salario, boolean activo, int antiguedad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.departamento = departamento;
		this.salario = salario;
		this.activo = activo;
		this.antiguedad = antiguedad;
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", departamento=" + departamento + ", salario=" + salario
				+ ", activo=" + activo + ", antiguedad=" + antiguedad + "]";
	}
	
	
	

}
