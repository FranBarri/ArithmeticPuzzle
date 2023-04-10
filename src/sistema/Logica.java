package sistema;

import java.util.Random;

public class Logica {
    private static Random rand = new Random();

    public static Object[][] generarGrilla(Object[][] grilla, int dificultad) {
        grilla = new Integer[dificultad][dificultad];
        for (int i = 0; i < dificultad; i++) {
            for (int j = 0; j < dificultad; j++) {
                grilla[i][j] = rand.nextInt(9) + 1; // genera numeros random entre 1 y 9
            }
        }
        return grilla;
    }
    
    // funcion que devuelve la suma de los elementos de la fila pasada por parametro
    public static void setSumasFilas(Object[][] matriz, Integer[] labels, int fila) {
        int sum = 0;
        for (int j = 0; j < matriz[fila].length; j++) {
            sum += Integer.parseInt(matriz[fila][j].toString());
        }
        labels[fila] = sum;
    }

    // funcion que devuelve la suma de los elementos de la columna pasada por parametro
    public static void setSumasColumnas(Object[][] matriz, Integer[] labels, int col) {
        int sum = 0;
        for (int i = 0; i < matriz.length; i++) {
            sum += Integer.parseInt(matriz[i][col].toString());
        }
        labels[col] = sum;
    }

	public static boolean noHayVacias(Object[][] matriz) {
	    boolean ret = true;
	    for (int i = 0; i < matriz.length; i++) {
	        for (int j = 0; j < matriz[0].length; j++) {
				Object valor = matriz[i][j];
	            if (valor == null) {
	            	ret = false;
	            } else {
	            	ret = ret && !valor.toString().isEmpty();
	            }
	        }
	    }
	    return ret;
	}
	public static boolean sumaFilasyColumnas(Object[][] matriz, Integer[] resultadoColumna, Integer[] resultadoFila) {
		boolean filaRet=false;
		boolean columnaRet=false;
		filaRet = filaSumaResultado(matriz, resultadoColumna);
		if (filaRet) {
			columnaRet = (columnaSumaResultado(matriz, resultadoFila));
			return filaRet && columnaRet;
		}
		return false;
	}
	
	private static boolean filaSumaResultado(Object[][] matriz,Integer[] resultado) {
		Integer suma = 0;
		boolean ret = true;
		for (int i = 0; i < matriz.length; i++) {
			suma = 0;
			Object[] fila = matriz[i];
			for (int j = 0;j<matriz[0].length; j++) {
				Integer valor = Integer.parseInt(fila[j].toString());
				suma+=valor;				
			}
			if (resultado[i] == null || resultado[i].toString().isEmpty()) {
				ret = false;
			}
			ret = ret && suma.toString().equals(resultado[i].toString());		
		}
		return ret;
	}

	private static boolean columnaSumaResultado(Object[][] matriz,Integer[] resultado) {
		Integer suma = 0;
		boolean ret = true;
		for (int i = 0; i < matriz[0].length; i++) {
			suma = 0;
			for (int j = 0; j < matriz.length; j++) {
				Integer valor = Integer.parseInt(matriz[j][i].toString());
				suma += valor;                
			}
			if (resultado[i] == null || resultado[i].toString().isEmpty()) {
				return false;
			}
			ret = ret && suma.toString().equals(resultado[i].toString());
		}
		return ret;
	}
}
