package trabajoPractico1;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

class JuegoGrilla {
    private int[][] grilla;
    Random rand = new Random();

    
    public JuegoGrilla() {
        this.grilla = new int[4][4];
        //creamos grilla de 4x4 con elementos aleatorios
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grilla[i][j] = rand.nextInt(9) + 1; // genera numeros random entre 1 y 9
            }
        }
    }
    
    // funcion que devuelve la suma de los elementos de la fila pasada por parametro
    public static int sumaFila(int[][] matriz, int fila) {
        int sum = 0;
        for (int j = 0; j < matriz[fila].length; j++) {
            sum += matriz[fila][j];
        }
        return sum;
    }

    // funcion que devuelve la suma de los elementos de la columna pasada por parametro
    public static int sumaColumna(int[][] matriz, int col) {
        int sum = 0;
        for (int i = 0; i < matriz.length; i++) {
            sum += matriz[i][col];
        }
        return sum;
    }

    public boolean filaSumaResultado(JTable table,JLabel resultado,int fila) {
        Integer suma = 0;
        int nroFil = table.getRowCount();
        for (int i = 0; i < nroFil; i++) {
            Integer valor = Integer.parseInt(table.getValueAt(fila, i).toString());
            suma+=valor;
        }
        if(suma.toString().equals(resultado.getText())) {
            return true;
        }
        return false;
    }
    
    public boolean columnaSumaResultado(JTable table,JLabel resultado,int columna) {
        Integer suma = 0;
        int numCols = table.getColumnCount();
        for (int i = 0; i < numCols; i++) {
            Integer valor = Integer.parseInt(table.getValueAt(i, columna).toString());
            suma+=valor;
        }
        if(suma.toString().equals(resultado.getText())) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
    int[][] matriz = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    int sumaCol1=sumaColumna(matriz,1);	
    int sumaCol2=sumaColumna(matriz,2);	
    int sumaCol3=sumaColumna(matriz,3);	
    int sumaCol4=sumaColumna(matriz,4);	
    int sumaFila1=sumaFila(matriz,1);
    int sumaFila2=sumaFila(matriz,2);
    int sumaFila3=sumaFila(matriz,3);
    int sumaFila4=sumaFila(matriz,4);


    }
    
}
