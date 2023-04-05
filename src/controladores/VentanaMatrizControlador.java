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
	public static Object[][] generarMatrizRandom(Object[][] matriz, int dificultad) {
		matriz = Logica.generarGrilla(matriz, dificultad);
		return matriz;
	}
	public static void generarSumaFilas(Object[][] matriz, Integer[] labels, int fila) {
		Logica.setSumasFilas(matriz, labels, fila);
	}
	public static void generarSumaColumnas(Object[][] matriz, Integer[] labels, int col) {
		Logica.setSumasColumnas(matriz, labels, col);
	}
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
