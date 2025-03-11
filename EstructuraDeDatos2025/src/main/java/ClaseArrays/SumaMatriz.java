package ClaseArrays;

public class SumaMatriz {
    public static void main(String[] args) {
        int[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] mat2 = {{10, 20}, {30, 40}};
        System.out.println(calcularSuma(mat1));
        System.out.println(calcularSuma(mat2)); 
    }
    public static int calcularSuma(int[][] mat) {
        int suma = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                suma += mat[i][j];
            }
        }
        return suma;
    }
}