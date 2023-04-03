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
    
    
    
}
