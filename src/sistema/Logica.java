package sistema;

public class Logica {

	public int sumarNumerosIngresados(Integer[][] matriz) { //Tengo que verificar que no sean null ni chars
        int suma = 0;
        for (int f = 0; f <matriz.length; f++) {
        	for (int c = 0; c < matriz[f].length; c++) {
            	suma += matriz[f][c];
        	}
        }
        return suma;
	}
}
