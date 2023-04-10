package test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;

import controladores.VentanaMatrizControlador;

public class Testeo {
	private Integer[][] matrizFull4;
	private Integer[][] matrizIncorrecta4;
	private Integer[][] matrizVacia4;
	private Integer[] nrosFilas4;
	private Integer[] nrosColumnas4;
	private Integer[][] matrizFull5;
	private Integer[][] matrizIncorrecta5;
	private Integer[][] matrizVacia5;
	private Integer[] nrosFilas5;
	private Integer[] nrosColumnas5;
	private Integer[][] matrizFull6;
	private Integer[][] matrizIncorrecta6;
	private Integer[][] matrizVacia6;
	private Integer[] nrosFilas6;
	private Integer[] nrosColumnas6;
	
	@BeforeEach
	public void setUp() throws Exception {
		//Matriz 4x4
		matrizFull4 = new Integer[][] {
			{2, 1, 1, 1},
			{1, 2, 3, 1},
			{2, 4, 3, 3},
			{2, 2, 2, 1},
		};

		matrizIncorrecta4 = new Integer[][] {
			{2, 3, 4, 2},
			{1, 5, 3, 1},
			{2, 4, 3, 3},
			{2, 2, 2, 1},
		};

		matrizVacia4 = new Integer[][] {
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
			{null, null, null, null},
		};

		nrosFilas4 = new Integer[4];
		nrosFilas4[0] = 5;
		nrosFilas4[1] = 7;
		nrosFilas4[2] = 12;
		nrosFilas4[3] = 7;
		
		nrosColumnas4 = new Integer[4];
		nrosColumnas4[0] = 7;
		nrosColumnas4[1] = 9;
		nrosColumnas4[2] = 9;
		nrosColumnas4[3] = 6;
		
		//Matriz 5x5
		matrizFull5 = new Integer[][] {
			{1, 1, 1, 1, 1},
			{1, 1, 3, 1, 1},
			{2, 3, 3, 3, 1},
			{1, 1, 2, 1, 2},
			{2, 3, 1, 1, 3},
		};

		matrizIncorrecta5 = new Integer[][] {
			{2, 3, 4, 2, 2},
			{1, 5, 3, 1, 3},
			{2, 4, 3, 3, 4},
			{2, 2, 2, 1, 6},
			{1, 3, 1, 1, 3},
		};

		matrizVacia5 = new Integer[][] {
			{null, null, null, null, null},
			{null, null, null, null, null},
			{null, null, null, null, null},
			{null, null, null, null, null},
			{null, null, null, null, null},
		};

		nrosFilas5 = new Integer[5];
		nrosFilas5[0] = 5;
		nrosFilas5[1] = 7;
		nrosFilas5[2] = 12;
		nrosFilas5[3] = 7;
		nrosFilas5[4] = 10;
		
		nrosColumnas5 = new Integer[5];
		nrosColumnas5[0] = 7;
		nrosColumnas5[1] = 9;
		nrosColumnas5[2] = 10;
		nrosColumnas5[3] = 7;
		nrosColumnas5[4] = 8;
		
		//Matriz 6x6
		matrizFull6 = new Integer[][] {
			{1, 1, 2, 3, 4, 5},
			{1, 5, 3, 2, 4, 3},
			{1, 6, 8, 2, 3, 7},
			{1, 7, 9, 1, 2, 5},
			{1, 2, 5, 6, 4, 1},
			{1, 3, 5, 1, 1, 2},
		};

		matrizIncorrecta6 = new Integer[][] {
			{2, 3, 4, 2, 2},
			{1, 5, 3, 1, 3},
			{2, 4, 3, 3, 4},
			{2, 2, 2, 1, 6},
			{1, 3, 1, 1, 3},
		};

		matrizVacia6 = new Integer[][] {
			{null, null, null, null, null},
			{null, null, null, null, null},
			{null, null, null, null, null},
			{null, null, null, null, null},
			{null, null, null, null, null},
		};

		nrosFilas6 = new Integer[6];
		nrosFilas6[0] = 16;
		nrosFilas6[1] = 18;
		nrosFilas6[2] = 27;
		nrosFilas6[3] = 25;
		nrosFilas6[4] = 19;
		nrosFilas6[5] = 13;
		
		nrosColumnas6 = new Integer[6];
		nrosColumnas6[0] = 6;
		nrosColumnas6[1] = 24;
		nrosColumnas6[2] = 32;
		nrosColumnas6[3] = 15;
		nrosColumnas6[4] = 18;
		nrosColumnas6[5] = 23;
		
	}
	
	//Verificar hayVacias 4x4
	@org.junit.jupiter.api.Test
	public void noHayVaciasDevuelveTrue4x4() {
		assertTrue(VentanaMatrizControlador.noHayVacias(matrizFull4));
	}
	@org.junit.jupiter.api.Test
	public void noHayVaciasDevuelveFalse4x4() {
		assertFalse(VentanaMatrizControlador.noHayVacias(matrizVacia4));
	}
	//Verificar suma 4x4
	@org.junit.jupiter.api.Test
	public void sumaDevuelveTrue4x4() {
		assertTrue(VentanaMatrizControlador.sumarFilasyColumnas(matrizFull4, nrosFilas4, nrosColumnas4));
	}
	@org.junit.jupiter.api.Test
	public void sumaDevuelveFalse4x4() {
		assertFalse(VentanaMatrizControlador.sumarFilasyColumnas(matrizIncorrecta4, nrosFilas4, nrosColumnas4));
	}
	
	//Verificar hayVacias 5x5
	@org.junit.jupiter.api.Test
	public void noHayVaciasDevuelveTrue5x5() {
		assertTrue(VentanaMatrizControlador.noHayVacias(matrizFull5));
	}
	@org.junit.jupiter.api.Test
	public void noHayVaciasDevuelveFalse5x5() {
		assertFalse(VentanaMatrizControlador.noHayVacias(matrizVacia5));
	}
	//Verificar suma 5x5
	@org.junit.jupiter.api.Test
	public void sumaDevuelveTrue5x5() {
		assertTrue(VentanaMatrizControlador.sumarFilasyColumnas(matrizFull5, nrosFilas5, nrosColumnas5));
	}
	@org.junit.jupiter.api.Test
	public void sumaDevuelveFalse5x5() {
		assertFalse(VentanaMatrizControlador.sumarFilasyColumnas(matrizIncorrecta5, nrosFilas5, nrosColumnas5));
	}
	
	//Verificar hayVacias 6x6
	@org.junit.jupiter.api.Test
	public void noHayVaciasDevuelveTrue6x6() {
		assertTrue(VentanaMatrizControlador.noHayVacias(matrizFull6));
	}
	@org.junit.jupiter.api.Test
	public void noHayVaciasDevuelveFalse6x6() {
		assertFalse(VentanaMatrizControlador.noHayVacias(matrizVacia6));
	}
	//Verificar suma 5x5
	@org.junit.jupiter.api.Test
	public void sumaDevuelveTrue6x6() {
		assertTrue(VentanaMatrizControlador.sumarFilasyColumnas(matrizFull6, nrosFilas6, nrosColumnas6));
	}
	@org.junit.jupiter.api.Test
	public void sumaDevuelveFalse6x6() {
		assertFalse(VentanaMatrizControlador.sumarFilasyColumnas(matrizIncorrecta6, nrosFilas6, nrosColumnas6));
	}
}
