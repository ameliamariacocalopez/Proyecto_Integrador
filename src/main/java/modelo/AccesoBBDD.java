package modelo;

import java.sql.*;
import java.util.ArrayList;

public class AccesoBBDD {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/ProyectoIntegrador";
	private String user = "root";
	private String pwd = "root";

	//s_consulProyect y consulProyect.java
	private String userAlumno, usrname, resultado;
	private String password = "";
	private boolean check;
	int r;
	
	//addProyect.java
	private String id, nombre, urlP, nota, fecha, curso, grupo;
	private int area;
	
	Connection conexion = null;

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

	//Login page
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
	
	//Consultar project page	
	public ArrayList<ProyectoIntegrador> cargarProyectos(String buscar) {
        		ArrayList<ProyectoIntegrador> proyectos = new ArrayList();
            try {
        			Statement statement = conexion.createStatement();
        			String query = buscar;
        			ResultSet resultados = statement.executeQuery(query);

                while (resultados.next()) {
                    String idProyecto = resultados.getString("idProyecto");
                    String nombre = resultados.getString("nombreProyecto");
                    String urlProy = resultados.getString("urlProyecto");
                    String notaP = resultados.getString("nota");
                    String fechaP = resultados.getString("fecha");
                    String cursoP = resultados.getString("curso");
                    String grupoP = resultados.getString("grupo");
                    int areaP = resultados.getInt("areaCorrespondiente");

                    ProyectoIntegrador proyecto = new ProyectoIntegrador(idProyecto, nombre, urlProy, notaP, fechaP, cursoP, grupoP, areaP);
                    proyectos.add(proyecto);
                }
            } catch (SQLException a) {

            } catch (Exception e) {

            }
            return proyectos;
	 }
	
	//Add project page
	public boolean proyectoNuevo(){
		boolean check = false;
		try {
			Statement statement = conexion.createStatement();
			String query = "INSERT INTO proyectoIntegrador (idProyecto, nombreProyecto, urlProyecto, nota, fecha, curso, grupo, areaCorrespondiente) VALUES ('" + id.trim() + "', '" + nombre.trim() + "', '" + urlP.trim() + "', '" + nota.trim() + "', '" + fecha.trim() + "', '" + curso.trim() + "', '" + grupo.trim() + "', '" + area + "')";
			int resultados = statement.executeUpdate(query);
			System.out.println("Datos guardados correctamente");
			if(resultados != 0) {
				check = true;
			}
			//Restablecer textos a vacios
		} catch (SQLException a) {
			System.out.println("No se ha podido insertar");
			a.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error de aplicación");
			e.printStackTrace();
		}
		return check;
	}
	
	public boolean proyectoRepetido(){
		boolean check = false;
		try {
			Statement statement = conexion.createStatement();
			String query = "SELECT * FROM proyectoIntegrador WHERE nombreProyecto = '" + nombre.trim() + "'";
			ResultSet resultados = statement.executeQuery(query);
			if(resultados.next()) {
				check = true;
			}
		} catch (Exception e) {
			
		}
		return check;
	}

	//Delete project page
	public ArrayList<ProyectoIntegrador> deleteProyects(String buscar) {
		ArrayList<ProyectoIntegrador> proyectos = new ArrayList();
    try {
			Statement statement = conexion.createStatement();
			String query = buscar;
			ResultSet resultados = statement.executeQuery(query);

        while (resultados.next()) {
            String idProyecto = resultados.getString("idProyecto");
            String nombre = resultados.getString("nombreProyecto");
            String urlProy = resultados.getString("urlProyecto");
            String notaP = resultados.getString("nota");
            String fechaP = resultados.getString("fecha");
            String cursoP = resultados.getString("curso");
            String grupoP = resultados.getString("grupo");
            int areaP = resultados.getInt("areaCorrespondiente");

            ProyectoIntegrador proyecto = new ProyectoIntegrador(idProyecto, nombre, urlProy, notaP, fechaP, cursoP, grupoP, areaP);
            proyectos.add(proyecto);
        }
    } catch (SQLException a) {

    } catch (Exception e) {

    }
    return proyectos;
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
	
	

//	public int getR() {
//		return r;
//	}
//
//	public void setR(int r) {
//		this.r = r;
//	}

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
