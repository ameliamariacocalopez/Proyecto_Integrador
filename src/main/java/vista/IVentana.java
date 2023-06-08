package vista;

import java.awt.Graphics;

public interface IVentana {
	//para que otra persona modifique nuestro cÃ³digo necesitan la interfaz para saber que mÃ©todos son obligatorios
	/**
	 * Inicializa los componentes de la ventana.
	 */
	public void inicializarComponentes();
	
	/**
	 * Hace la ventana visible.
	 */
	public void hacerVisible();
}
