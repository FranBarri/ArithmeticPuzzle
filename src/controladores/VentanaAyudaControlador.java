package controladores;

import ventanas.VentanaAyuda;

public class VentanaAyudaControlador {

	public static VentanaAyuda ventanaAyuda = new VentanaAyuda();
	
	//Eventos
	public static void cerrar() {
		ventanaAyuda.setVisible(false);
	}
	
	public static void mostrar() {
		ventanaAyuda.iniciar();
		ventanaAyuda.setVisible(true);
	}
	
	public static void volverAlInicio() {
		cerrar();
		VentanaMenuControlador.mostrar();
	}
}
