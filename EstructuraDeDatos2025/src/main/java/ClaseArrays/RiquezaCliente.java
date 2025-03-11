package ClaseArrays;

public class RiquezaCliente {
    public static void main(String[] args) {
        int[][] cuentas1 = {{1, 2, 3}, {3, 2, 1}};
        int[][] cuentas2 = {{1, 5}, {7, 3}, {3, 5}};
        int[][] cuentas3 = {{2, 8, 7}, {7, 1, 3}, {1, 9, 5}};
        System.out.println(riquezaMaxima(cuentas1));
        System.out.println(riquezaMaxima(cuentas2)); 
        System.out.println(riquezaMaxima(cuentas3)); 
    }
    public static int riquezaMaxima(int[][] cuentas) {
        int maxRiqueza = 0;
        for (int i = 0; i < cuentas.length; i++) {
            int riquezaCliente = 0;
            for (int j = 0; j < cuentas[i].length; j++) {
                riquezaCliente += cuentas[i][j];
            }
            maxRiqueza = Math.max(maxRiqueza, riquezaCliente);
        }
        return maxRiqueza;
    }
}
