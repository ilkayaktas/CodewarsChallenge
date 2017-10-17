package dailyexperiment;

/**
 * Created by iaktas on 17.10.2017 at 13:22.
 */

public class MatrixDeterminant {
    public static int determinant(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        } else if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            int total = 0;
            for (int i = 0; i < matrix[0].length; i++) {
                total += (i%2==0?1:-1) * matrix[0][i] * determinant(subMatrix(matrix, 0, i));
            }
            return total;
        }
    }

    private static int[][] subMatrix(int[][] matrix, int removedRow, int removedCol) {
        int[][] subMatrix = new int[matrix.length - 1][matrix.length - 1];
        for (int i = 0, sub_i = 0; i < matrix.length; i++) {
            if (i == removedRow) continue;
            for (int j = 0, sub_j = 0; j < matrix.length; j++) {
                if (j == removedCol) continue;
                subMatrix[sub_i][sub_j] = matrix[i][j];
                sub_j++;
            }
            sub_i++;
        }

        return subMatrix;
    }
}
