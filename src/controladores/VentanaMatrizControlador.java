package controladores;

import sistema.Dificultad;
import sistema.Logica;
import ventanas.VentanaMatriz;

public class VentanaMatrizControlador {
	
	public static VentanaMatriz ventanaMatriz = new VentanaMatriz();
	
	//Eventos
	public static void cerrar() {
		ventanaMatriz.setVisible(false);
	}
	
	public static void mostrar() {
		ventanaMatriz.setVisible(true);
	}
		
	//Anadir timer para ver cuanto tarda en resolver matriz
	
	/*
	 * Valida que la tabla no tenga celdas nulas (celdas no editadas)
	 * y celdas vacias luego de editarlas y borrar su valor.
	 */
	public static boolean noHayVacias(Object[][] matriz) {
		return Logica.noHayVacias(matriz);
	}
	public static boolean sumarFilasyColumnas(Object[][] matriz, Integer[] filas, Integer[] columnas) {
		return Logica.sumaFilasyColumnas(matriz, filas, columnas);			
	}
	
	public static void setDificultad(Dificultad dificultad) {
		switch(dificultad) {
		case FACIL:
			ventanaMatriz.iniciarFacil();
			break;
		case MEDIO:
			ventanaMatriz.iniciarMedio();
			break;
		case DIFICIL:
			ventanaMatriz.iniciarDificil();
			break;
		}
		ventanaMatriz.setVisible(true);

	}
}
