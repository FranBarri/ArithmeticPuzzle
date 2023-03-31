package test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;

import controladores.VentanaMatrizControlador;

public class Testeo {
	private Integer[][] matrizFull;
	private Integer[][] matrizIncorrecta;
	private Integer[][] matrizVacia;
	private Integer[] nrosFilas;
	private Integer[] nrosColumnas;
	
	@BeforeEach
	public void setUp() throws Exception {
		matrizFull = new Integer[][] {
			{2, 1, 1, 1},
			{1, 2, 3, 1},
			{2, 4, 3, 3},
			{2, 2, 2, 1},
		};

		matrizIncorrecta = new Integer[][] {
			{2, 3, 4, 2},
			{1, 5, 3, 1},
			{2, 4, 3, 3},
			{2, 2, 2, 1},
		};

		matrizVacia = new Integer[][] {
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
		};

		nrosFilas = new Integer[4];
		nrosFilas[0] = 5;
		nrosFilas[1] = 7;
		nrosFilas[2] = 12;
		nrosFilas[3] = 7;
		
		nrosColumnas = new Integer[4];
		nrosColumnas[0] = 7;
		nrosColumnas[1] = 9;
		nrosColumnas[2] = 9;
		nrosColumnas[3] = 6;
		
	}
	
	//Verificar hayVacias
	@org.junit.jupiter.api.Test
	public void noHayVaciasDevuelveTrue() {
		assertTrue(VentanaMatrizControlador.noHayVacias(matrizFull));
	}
	@org.junit.jupiter.api.Test
	public void noHayVaciasDevuelveFalse() {
		assertFalse(VentanaMatrizControlador.noHayVacias(matrizVacia));
	}
	
	//Verificar suma
	@org.junit.jupiter.api.Test
	public void sumaDevuelveTrue() {
		assertTrue(VentanaMatrizControlador.sumarFilasyColumnas(matrizFull, nrosFilas, nrosColumnas));
	}
	@org.junit.jupiter.api.Test
	public void sumaDevuelveFalse() {
		assertFalse(VentanaMatrizControlador.sumarFilasyColumnas(matrizIncorrecta, nrosFilas, nrosColumnas));
	}
}
