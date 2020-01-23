package divideAndConquer;

/**
 * @author Xiaoming.
 * Created with IntelliJ IDEA on 2018/02/26 17:07.
 * Description :
 */
public class MatrixMultiply {

    public int[][] squareMatrixMultiply(int[][] a, int[][] b) {
        /*if (a.length != a[a.length - 1].length && b.length != b[b.length - 1].length){
            return null;
        }*/
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    /*public int[][] squareMatrixMultiplyRecursive(int[][] a, int[][] b,
                                                 int aStartIndex, int aEndIndex, int bStartIndex, int bEndIndex) {
        int n = aEndIndex - aStartIndex + 1;
        int[][] c = new int[n][n];
        if (n == 1) {
            c[0][0] = a[aStartIndex][aEndIndex] * b[bStartIndex][bEndIndex];
        } else {
            int aMid = (aEndIndex - aStartIndex) / 2;
            int bMid = (bEndIndex - bStartIndex) / 2;
        }
    }*/
}
