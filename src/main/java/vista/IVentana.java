package vista;

import java.awt.Graphics;

import control.ControladorProyecto;

public interface IVentana {
	//para que otra persona modifique nuestro código necesitan la interfaz para saber que métodos son obligatorios
	
	public void inicializarComponentes();
	
	public void hacerVisible();
}
