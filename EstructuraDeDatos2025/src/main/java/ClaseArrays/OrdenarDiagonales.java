package ClaseArrays;

import java.util.*;
public class OrdenarDiagonales {
    public static void main(String[] args) {
        int[][] mat1 = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        int[][] mat2 = {
            {11, 25, 66, 1, 69, 7},
            {23, 55, 17, 45, 15, 52},
            {75, 31, 36, 44, 58, 8},
            {22, 27, 33, 25, 68, 4},
            {84, 28, 14, 11, 5, 50}
        };
        System.out.println(Arrays.deepToString(ordenarDiagonales(mat1)));
        System.out.println(Arrays.deepToString(ordenarDiagonales(mat2)));
    }
    public static int[][] ordenarDiagonales(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, List<Integer>> diagonales = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diagonales.computeIfAbsent(i - j, k -> new ArrayList<>()).add(mat[i][j]);
            }
        }
        for (List<Integer> diagonal : diagonales.values()) {
            Collections.sort(diagonal);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = diagonales.get(i - j).remove(0);
            }
        }
        return mat;
    }
}
