
/**
 * Write a description of class a2020m85 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class a2020m85 {
    public static int findMaximum(int[][] mat) {
        if (mat[0][0] == -1)
            return -1;
        return findMaximum(mat, 0, 0, 0);
    }

    private static int findMaximum(int[][] mat, int i, int j, int sum) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat.length || mat[i][j] == -1)
            return sum;
        int right = 0, left = 0, down = 0;
        //int temp = mat[i][j];
        //mat[i][j] = -1;
        if (i % 2 == 0) {
            right = +findMaximum(mat, i, j + 1, sum + mat[i][j]);//temp);
        } else
            left = +findMaximum(mat, i, j - 1, sum + mat[i][j]);//temp);
        down = +findMaximum(mat, i + 1, j, sum + mat[i][j]);//temp);
        //mat[i][j] = temp;
        return Math.max(Math.max(left, right), down);
    }
}
