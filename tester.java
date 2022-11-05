
/**
 * Write a description of class tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class tester extends b2021m62 {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 9, 10, 65, 66, 73, 74},
                {4, 3, 12, 11, 68, 67, 76, 75},
                {29, 30, 21, 22, 93, 94, 85, 86},
                {32, 31, 24, 23, 96, 95, 88, 87},
                {225, 226, 233, 234, 161, 162, 169, 170},
                {228, 227, 236, 235, 164, 163, 172, 171},
                {253, 254, 245, 246, 189, 190, 181, 182},
                {256, 255, 248, 247, 192, 191, 184, 183}};
        System.out.println(search(mat, 190) + "\n");

        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1};//true
        int[] arr1 = {2, 1, 1, 1, 1, 1, 1, 1};//false
        int[] arr3 = {1, 1, 1, 1, 1, 1, 1, 1, 1};//false
        int[] arr4 = {3, 1, 1, 1, 1, 1, 1, 1, 1, 1};//false
        int[] arr5 = {-3, 5, 12, 14, -9, 13};//true
        int[] arr6 = {-3, 5, -12, 14, -9, 13};//false
        int[] arr7 = {-3, 5, -12, 14, -9};//false
        System.out.println(equalSplit(arr));
        System.out.println(equalSplit(arr1));
        System.out.println(equalSplit(arr3));
        System.out.println(equalSplit(arr4));
        System.out.println(equalSplit(arr5));
        System.out.println(equalSplit(arr6));
        System.out.println(equalSplit(arr7));
    }
}
