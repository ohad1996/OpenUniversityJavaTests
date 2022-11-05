
/**
 * Write a description of class testera2020m85 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class testera2020m85 extends a2020m85 {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, -1, 1, 1},
                {1, 0, 0, -1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, 1, 1, 1},
                {1, 1, -1, -1, 1}};
        System.out.println(findMaximum(mat));
    }
}
