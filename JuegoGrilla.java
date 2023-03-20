package trabajoPractico1;

import javax.swing.JFrame;

class JuegoGrilla {
    private int tamaño;
    private int[][] grilla;
    private int[] sumaFilas;
    private int[] sumaColumnas;
    
    public JuegoGrilla(int tamaño, int[] sumaFilas, int[] sumaColumnas) {
        this.tamaño = tamaño;
        this.grilla = new int[tamaño][tamaño];
        this.sumaFilas = sumaFilas;
        this.sumaColumnas = sumaColumnas;

        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                grilla[i][j] = 0;
            }
        }
    }
    public boolean ingresarValor(int fila, int columna, int valor) {
        if (fila >= 0 && fila < tamaño && columna >= 0 && columna < tamaño) {
            grilla[fila][columna] = valor;
            return true;
        } else {
            return false;
        }
    }
}
