
/**
 * Write a description of class b2020m96Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class b2020m96Tester extends b2020m96
 {
    public static void main(String[] args) {
        int[][] mat = {
                {4, 5, 6, 7, 1},
                {3, 5, 1, 7, 4},
                {4, 5, 6, 5, 8},
                {3, 4, 7, 7, 9},
                {6, 2, 2, 7, 6}};
        System.out.println(maxSumKnight(mat));
        Range a1 = new Range(-7, -3);
        Range a2 = new Range(-1, -1);
        Range a3 = new Range(4, 6);
        Range a4 = new Range(20, 22);
        Range a5 = new Range(110, 114);
        Range[] arange = {a1, a2, a3, a4, a5};
        System.out.println(minimalPositive(arange) == 4);
    }
}
