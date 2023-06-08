package modelo;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class AccesoBBDD {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/ProyectoIntegrador";
	private String user = "root";
	private String pwd = "rootroot";

	// s_consulProyect y consulProyect.java
	private String userAlumno, usrname, resultado;
	private String password = "";
	private boolean check;
	int r;

	// addProyect.java
	private String id, nombre, urlP, nota, fecha, curso, grupo;
	private int area;

	Connection conexion = null;

	/**
	 * Obtiene una conexiÃ³n a la base de datos.
	 * 
	 * @return La conexiÃ³n establecida.
	 */
	public Connection getConexion() {
		conexion = null;

		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, user, pwd);
			System.out.println("Conexión conseguida");
		} catch (SQLException a) {
			System.out.println("Error!");
		} catch (Exception e) {
			System.out.println("Error!");
		}
		return conexion;
	}

	/**
	 * Comprueba si existe un usuario con el nombre especificado en la base de
	 * datos.
	 * 
	 * @return true si el nombre existe, false en caso contrario.
	 */
	public boolean comprobarNombre() {
		check = false;

		try {
			Statement statement = conexion.createStatement();
			String query = "SELECT * FROM administrado WHERE username='" + usrname.trim() + "'";
			ResultSet resultados = statement.executeQuery(query);
			if (resultados.next()) {
				check = true;

			} else {
				check = false;

			}
		} catch (SQLException a) {

		} catch (Exception e) {

		}
		return check;
	}

	/**
	 * Registra un nuevo usuario en la base de datos.
	 */
	public void register() {
		try {
			conexion = DriverManager.getConnection(url, user, pwd);
			String query = "INSERT INTO administrado VALUES('" + usrname.trim() + "','" + password.trim() + "')";
			Statement statement = conexion.createStatement();
			r = statement.executeUpdate(query);
		} catch (SQLException a) {
			System.out.println("No se ha podido insertar");
			a.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error de aplicación");
			e.printStackTrace();
		}
	}

	/**
	 * Realiza el proceso de inicio de sesiÃ³n.
	 * 
	 * @return true si el inicio de sesiÃ³n es exitoso, false en caso contrario.
	 */
	public boolean login() {
		boolean check = false;
		try {
			Statement statement = conexion.createStatement();
			String query = "SELECT username FROM administrado WHERE username='" + usrname.trim() + "'";
			ResultSet resultados = statement.executeQuery(query);

			if (resultados.next()) {
				if (resultados.getString("username").equals(usrname.trim())) {
					query = "SELECT pass FROM administrado WHERE username='" + usrname.trim() + "'";
					resultados = statement.executeQuery(query);
					resultados.next();
					if (password.trim().equals(resultados.getString("pass"))) {
						check = true;

					} else {
						check = false;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error al intentar el login");
			e.printStackTrace();
		}

		try {
			Statement statement = conexion.createStatement();
			String query = "SELECT numExpediente FROM alumno WHERE numExpediente='" + userAlumno.trim() + "'";
			ResultSet resultados = statement.executeQuery(query);

			if (resultados.next()) {
				if (resultados.getString("numExpediente").equals(userAlumno.trim())) {
					resultados.next();
					System.out.println("Número de expediente válido");
					check = true;

				} else {
					System.out.println("Número de expediente incorrecto");
					check = false;
				}
			}
		} catch (Exception e) {
			System.out.println("Error al intentar el login");
			e.printStackTrace();
		}
		return check;
	}

	// Consultar project page
	/**
	 * Carga los proyectos integradores que coinciden con el criterio de bÃºsqueda
	 * especificado.
	 * 
	 * @param buscar Criterio de bÃºsqueda para los proyectos.
	 * @return Una lista de proyectos integradores que coinciden con el criterio de
	 *         bÃºsqueda.
	 */
	public ArrayList<ProyectoIntegrador> cargarProyectos(String buscar) {
		ArrayList<ProyectoIntegrador> proyectos = new ArrayList<>();
		try {
			// Crear una sentencia
			Statement statement = conexion.createStatement();

			// Construir la consulta SQL
			String query = buscar;

			// Ejecutar la consulta y obtener los resultados
			ResultSet resultados = statement.executeQuery(query);

			// Recorrer los resultados y crear objetos ProyectoIntegrador
			while (resultados.next()) {
				String idProyecto = resultados.getString("idProyecto");
				String nombre = resultados.getString("nombreProyecto");
				String urlProy = resultados.getString("urlProyecto");
				String notaP = resultados.getString("nota");
				String fechaP = resultados.getString("fecha");
				String cursoP = resultados.getString("curso");
				String grupoP = resultados.getString("grupo");

				// meter aqui algo para consultar un select para meter el area de 1-DAW 2-DAM
				// 3-ASIR
				String areaP = "areaCorrespondiente";
//	            String areaP= resultados.getString("areaCorrespondiente");
//	            int areaCorrespondiente = resultados.getInt("areaCorrespondiente");
//	            String areaP = "";

				// No entiendo porque no lo coge de la Base de datos
				int codigoArea = resultados.getInt("areaCorrespondiente");
				PreparedStatement areaStatement = conexion
						.prepareStatement("SELECT nombre FROM areas WHERE codigo = ?");
				areaStatement.setInt(1, codigoArea);
				ResultSet areaResultados = areaStatement.executeQuery();
				if (areaResultados.next()) {
					areaP = areaResultados.getString("nombre");
				}

				ProyectoIntegrador proyecto = new ProyectoIntegrador(idProyecto, nombre, urlProy, notaP, fechaP, cursoP,
						areaP);
				proyectos.add(proyecto);
			}
		} catch (SQLException e) {
			// Manejar la excepciÃ³n de SQL
			e.printStackTrace();
		} catch (Exception e) {
			// Manejar otras excepciones
			e.printStackTrace();
		}
		return proyectos;
	}

	public ProyectoIntegrador obtenerDatosProyectoDesdeBD(String idProyecto) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ProyectoIntegrador proyecto = new ProyectoIntegrador();

		try {
			// Preparar la consulta SQL
			String sql = "SELECT * FROM proyectointegrador WHERE idProyecto = ?";
			stmt = conexion.prepareStatement(sql);
			stmt.setString(1, idProyecto); // Usar el nombre del proyecto que deseas consultar

			// Ejecutar la consulta
			rs = stmt.executeQuery();

			// Obtener los resultados
			if (rs.next()) {
				// int id = rs.getInt("idproyecto");
				String nom = rs.getString("nombreproyecto");
				String url = rs.getString("urlproyecto");
				int nota = rs.getInt("nota");
				int area = rs.getInt("areaCorrespondiente");
				String curso = rs.getString("curso");
				String fecha = rs.getString("fecha");

				// Obtener los demÃ¡s campos del proyecto
				proyecto.setIdProyecto(idProyecto);
				proyecto.setNombreProyecto(nom);
				proyecto.setUrlProyecto(url);
				proyecto.setNota(String.valueOf(nota));
				proyecto.setCurso(String.valueOf(curso));
				proyecto.setAreaCorrespondiente(String.valueOf(area));
				proyecto.setFecha(fecha);
				;

			} else {
				// El proyecto no existe en la base de datos
				JOptionPane.showMessageDialog(null, this, "El proyecto no existe", area);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar las conexiones, declaraciones y resultados
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return proyecto;
	}

	public boolean guardarCambiosProyecto(ProyectoIntegrador selectedProject) {
		PreparedStatement stmt = null;
		boolean resultado = false;

		try {
			// Preparar la consulta SQL para actualizar el proyecto
			String sql = "UPDATE proyectointegrador SET nombreproyecto = ?, urlproyecto = ?, nota = ?, areaCorrespondiente = ?, curso = ?, fecha = ? WHERE idproyecto = ?";
			stmt = conexion.prepareStatement(sql);
			stmt.setString(1, selectedProject.getNombreProyecto());
			stmt.setString(2, selectedProject.getUrlProyecto());
			stmt.setInt(3, Integer.parseInt(selectedProject.getNota()));
			stmt.setInt(4, Integer.parseInt(selectedProject.getAreaCorrespondiente()));
			stmt.setString(5, selectedProject.getCurso());
			stmt.setString(6, selectedProject.getFecha());
			stmt.setInt(7, Integer.parseInt(selectedProject.getIdProyecto()));

			// Ejecutar la consulta
			int res = stmt.executeUpdate();
			if (res > 0) {
				resultado = true;
				JOptionPane.showMessageDialog(null, "Los cambios se han guardado correctamente.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al guardar los cambios en la base de datos.");
		} finally {
			// Cerrar la conexiÃ³n y la declaraciÃ³n
			try {
				if (stmt != null)
					stmt.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultado;
	}

	/**
	 * Agrega un nuevo proyecto integrador a la base de datos.
	 * 
	 * @return true si el proyecto se agrega correctamente, false en caso contrario.
	 */
	public boolean proyectoNuevo() {
		boolean check = false;
		try {
			Statement statement = conexion.createStatement();
			String query = "INSERT INTO proyectoIntegrador (idProyecto, nombreProyecto, urlProyecto, nota, fecha, curso, grupo, areaCorrespondiente) VALUES ('"
					+ id.trim() + "', '" + nombre.trim() + "', '" + urlP.trim() + "', '" + nota.trim() + "', '"
					+ fecha.trim() + "', '" + curso.trim() + "', '" + grupo.trim() + "', '" + area + "')";
			int resultados = statement.executeUpdate(query);
			System.out.println("Datos guardados correctamente");
			if (resultados != 0) {
				check = true;
			}
		} catch (SQLException a) {
			System.out.println("No se ha podido insertar");
			a.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error de aplicación");
			e.printStackTrace();
		}
		return check;
	}

	/**
	 * MÃ©todo que crea un ArrayList de los Alumnos en la BBDD
	 * 
	 * @return alumnosList - lista de Alumnos de la BBDD
	 */
	public ArrayList<Alumno> obtenerAlumnosList() {
		ArrayList<Alumno> alumnosList = new ArrayList<>();
		try {
			Statement statement = conexion.createStatement();
			String query = "SELECT * FROM alumno";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				int numExpediente = resultSet.getInt("numExpediente");
				int codigo = resultSet.getInt("codigo");
				String nombre = resultSet.getString("nombre");
				String apellidos = resultSet.getString("apellidos");
				int idProyecto = resultSet.getInt("idProyecto");

				// Create an instance of the Alumno class and add it to the list
				Alumno alumno = new Alumno(numExpediente, codigo, nombre, apellidos, idProyecto);
				alumnosList.add(alumno);
			}
		} catch (SQLException e) {
			System.out.println("Error al obtener los alumnos");
			e.printStackTrace();
		}
		return alumnosList;
	}

	public ArrayList<Alumno> obtenerAlumnosListProyecto(String idProyectos) {
		ArrayList<Alumno> alumnosList = new ArrayList<>();
		try {
			Statement statement = conexion.createStatement();
			String query = "SELECT * FROM alumno where idProyecto=" + idProyectos;
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				int numExpediente = resultSet.getInt("numExpediente");
				int codigo = resultSet.getInt("codigo");
				String nombre = resultSet.getString("nombre");
				String apellidos = resultSet.getString("apellidos");
				int idProyecto = resultSet.getInt("idProyecto");

				// Create an instance of the Alumno class and add it to the list
				Alumno alumno = new Alumno(numExpediente, codigo, nombre, apellidos, idProyecto);
				alumnosList.add(alumno);
			}
		} catch (SQLException e) {
			System.out.println("Error al obtener los alumnos");
			e.printStackTrace();
		}
		return alumnosList;
	}

	/**
	 * Comprueba si ya existe un proyecto con el mismo nombre en la base de datos.
	 * 
	 * @return true si el proyecto ya existe, false en caso contrario.
	 */
	public boolean proyectoRepetido(String n) {
		boolean check = false;
		try {
			Statement statement = conexion.createStatement();
			String query = "SELECT * FROM proyectoIntegrador WHERE nombreProyecto = '" + n.trim() + "'";
			ResultSet resultados = statement.executeQuery(query);
			if (resultados.next()) {
				check = true;
			}
		} catch (Exception e) {

		}
		return check;
	}

	public boolean meterAlumnosEnProyecto(String id, ArrayList<String> matriculasComponentes) {
		boolean r = false;
		int contador = 0;
		try {
			// recorre las matriculas de los estudiantes que hay seleccionados
			for (String m : matriculasComponentes) {
				System.out.println("Exp: " + m);
				Statement statement = conexion.createStatement();
				String query = "UPDATE ALUMNO SET idProyecto = " + id + " WHERE numExpediente = " + m;
				int res = statement.executeUpdate(query);
				if (res == 1) {
					contador++;
				}
			}
			if (contador == matriculasComponentes.size()) {
				r = true;
			}
		} catch (SQLException s) {
			System.out.println("");
			s.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error de aplicación");
			e.printStackTrace();
		}

		return r;
	}


	/**
	 * MÃ©todo que elimina el proyecto seleccionado
	 * 
	 * @return check
	 */
	public boolean borrarProyecto() {
		boolean check = false;
		try {
			Statement statement = conexion.createStatement();
			// delete from proyectoIntegrador WHERE proyectoIntegrador = selected project -
			// hace falta aÃ±adir un WHERE?
			String query = "DELETE FROM proyectoIntegrador";
			int resultados = statement.executeUpdate(query);
			System.out.println("Todo correcto");
			if (resultados != 0) {
				check = true;
			}
		} catch (SQLException a) {
			a.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error de aplicación");
			e.printStackTrace();
		}
		return check;
	}

	/**
	 * Muestra por pantalla todos los alumnos
	 * 
	 * @param buscar
	 * @return alumnListk,L
	 */
	public ArrayList<Alumno> todosAlumnos(String buscar) {
		ArrayList<Alumno> alumnosList = new ArrayList();
		try {
			Statement statement = conexion.createStatement();
			String query = buscar;
			ResultSet resultados = statement.executeQuery(query);

			while (resultados.next()) {
				int numEx = resultados.getInt("numExpediente");
				int cod = resultados.getInt("codigo");
				String nombre = resultados.getString("nombre");
				String apellidos = resultados.getString("apellidos");
				int idProyecto = resultados.getInt("idProyecto");

				Alumno alumn = new Alumno(numEx, cod, nombre, apellidos, idProyecto);
				alumnosList.add(alumn);
			}
		} catch (SQLException a) {
		} catch (Exception e) {
		}
		return alumnosList;
	}

	public boolean deleteProyecto(String id) {
		boolean check = false;
		try {
			Statement statement = conexion.createStatement();
			String query = "DELETE FROM proyectoIntegrador WHERE idProyecto = '" + id.trim() + "'";
			int resultados = statement.executeUpdate(query);
			if (resultados != 0) {
				System.out.println("Proyecto borrado");
				check = true;
			} else {
				System.out.println("El proyecto no existe");
			}
		} catch (SQLException a) {
			System.out.println("No se ha podido borrar");
			a.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error de aplicación");
			// e.printStackTrace();
		}
		return check;
	}

	public void saveButton(String id, String nombre, String urlP, String nota, String fecha, String curso,
			String grupo) {
		try {
			Statement statement = conexion.createStatement();
			String sql = "INSERT INTO ProyectoIntegrador (idProyecto, nombreProyecto, urlProyecto, nota, fecha, curso, grupo) VALUES ('"
					+ id.trim() + "', '" + nombre.trim() + "', '" + urlP.trim() + "', '" + nota.trim() + "', '"
					+ fecha.trim() + "', '" + curso.trim() + "', '" + grupo.trim() + "')";
			ResultSet filasActualizadas = statement.executeQuery(sql);

//	        if (filasActualizadas > 0) {

			while (filasActualizadas.next()) {
				String idProyecto = filasActualizadas.getString("idProyecto");
				String nombreProyecto = filasActualizadas.getString("nombreProyecto");
				String urlProy = filasActualizadas.getString("urlProyecto");
				String notaP = filasActualizadas.getString("nota");
				String fechaP = filasActualizadas.getString("fecha");
				String cursoP = filasActualizadas.getString("curso");
				String grupoP = filasActualizadas.getString("grupo");
				String areaP = filasActualizadas.getString("areaCorrespondiente");

				System.out.println("Los datos se han guardado correctamente.");
			}
		} catch (SQLException a) {
			a.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Alumno alumnoSeleccionado(String expediente) {
		Alumno a = null;
		try {
			Statement statement = conexion.createStatement();
			String query = "SELECT * FROM alumno WHERE numExpediente = " + expediente;
			ResultSet results = statement.executeQuery(query);

			if (results.next()) {
				int numEx = results.getInt("numExpediente");
				int cod = results.getInt("codigo");
				String nombre = results.getString("nombre");
				String apellidos = results.getString("apellidos");
				int idProyecto = results.getInt("idProyecto");

				a = new Alumno(numEx, cod, nombre, apellidos, idProyecto);
			}

		} catch (SQLException s) {
		} catch (Exception e) {

		}
		return a;
	}

	/**
	 * GETTERS Y SETTERS
	 */

	public String getUserAlumno() {
		return userAlumno;
	}

	public void setUserAlumno(String userAlumno) {
		this.userAlumno = userAlumno;
	}

	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isCheck() {
		return check;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrlP() {
		return urlP;
	}

	public void setUrlP(String urlP) {
		this.urlP = urlP;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

//	public void cerrarConexion() {
//		try {
//			conexion.close();
//			System.out.print("Conexion cerrada");
//		} catch (Exception e) {
//			System.out.println("Error!");
//			e.printStackTrace();
//		}
//	}
}
