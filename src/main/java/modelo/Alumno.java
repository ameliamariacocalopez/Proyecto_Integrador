package modelo;

public class Alumno {

	private int numExpediente;
	private int codigo;
	private String nombre;
	private String apellidos;
	private int idProyecto;
	
	public void datosAlumno (int numExpediente, int codigo, String nombre,String apellidos, int idProyecto) {
		this.numExpediente = numExpediente;
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.idProyecto = idProyecto;
	}

	public int getNumExpediente() {
		return numExpediente;
	}

	public void setNumExpediente(int numExpediente) {
		this.numExpediente = numExpediente;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}
	
//	public String toString() {
//		return "Nombre: "+ nombreProyecto + " - "+ idProyecto + " - " + areaCorrespondiente;
//	}	
}
