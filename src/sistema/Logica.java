package sistema;

public class Logica {
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
