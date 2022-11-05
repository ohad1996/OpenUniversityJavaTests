
/**
 * Write a description of class b2020m81 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class b2020m81 {
    public static int makeSum(int[] length, int k, int num) {
        return makeSum(length, k, num, 0);
    }

    public static int makeSum(int[] length, int k, int num, int counter) {
        if (length.length == counter || k == 0)
            return 0;
        if (k < 0 || (num == 0 && k != 0))
            return Integer.MIN_VALUE;
        int stay = 1 + makeSum(length, k - length[counter], num - 1, counter);
        int shiftUp = makeSum(length, k, num, counter + 1);
        return Math.max(stay, shiftUp);
    }

    public static void minimumSubK(int[] arr, int k) {
        int counter = 0;
        int minSum = Integer.MAX_VALUE;
        int nowSum = 0;
        int restart = 1;
        int indexS = 0, indexSB = 0;
        int indexE = 0, indexEB = 0;
        for (int i = 0; i < arr.length; i++) {
            if (counter < k) {
                if (counter == 0) {
                    indexS = i;
                }
                if (counter == k - 1) {
                    indexE = i;
                }
                nowSum += arr[i];
                counter++;
            }
            if (counter == k) {
                if (nowSum < minSum) {
                    minSum = nowSum;
                    indexSB = indexS;
                    indexEB = indexE;
                }
                //System.out.println("("+indexSB+","+indexEB+")");
                counter = 0;
                i = restart - 1;
                restart++;
                nowSum = 0;
            }
        }
        System.out.println("minimum sum sub-array is (" + indexSB + "," + indexEB + ")");
    }
}