
/**
 * Write a description of class b2021m62 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class b2021m62 {
    public static boolean search(int[][] mat, int num) {
        if (num < mat[0][0] || num > mat[mat.length - 1][0])
            return false;
        int cord1Row = (mat.length - 1) / 2, cord1Col = 0;
        int cord2Row = (mat.length - 1) / 2, cord2Col = mat.length / 2;
        int cord3Row = mat.length - 1, cord3Col = mat.length / 2;
        int cord4Row = mat.length - 1, cord4Col = 0;
        int proportion = mat.length;
        while (num != num - 1) {
            if (cord4Row - cord1Row == 1) {
                return num == mat[cord1Row][cord1Col] ||
                        num == mat[cord2Row][cord2Col] ||
                        num == mat[cord3Row][cord3Col] ||
                        num == mat[cord4Row][cord4Col];
            } else if (num <= mat[cord1Row][cord1Col]) {
                cord1Row -= (proportion) / 4;
                cord1Col += 0;
                cord2Row -= (proportion) / 4;
                cord2Col -= (proportion) / 4;
                cord3Row -= (proportion) / 2;
                cord3Col -= (proportion) / 4;
                cord4Row -= (proportion) / 2;
                cord4Col += 0;
                proportion /= 2;
            } else if (num <= mat[cord2Row][cord2Col]) {
                cord1Row -= (proportion) / 4;
                cord1Col += proportion / 2;
                cord2Row -= (proportion) / 4;
                cord2Col += (proportion) / 4;
                cord3Row -= (proportion) / 2;
                cord3Col += (proportion) / 4;
                cord4Row -= proportion / 2;
                cord4Col += proportion / 2;
                proportion /= 2;
            } else if (num <= mat[cord3Row][cord3Col]) {
                cord1Row += proportion / 4;
                cord1Col += proportion / 2;
                cord2Row += proportion / 4;
                cord2Col += proportion / 4;
                cord3Row += 0;
                cord3Col += proportion / 4;
                cord4Row += 0;
                cord4Col += mat.length / 2;
                proportion /= 2;
            } else if (num <= mat[cord4Row][cord4Col]) {
                cord1Row += proportion / 4;
                cord1Col += 0;
                cord2Row += proportion / 4;
                cord2Col -= (proportion) / 4;
                cord3Row += 0;
                cord3Col -= (proportion) / 4;
                cord4Row += 0;
                cord4Col += 0;
                proportion /= 2;
            }
        }
        return false;
    }

    /**
     * @param arr the array that given
     * @return if the first statment is true and also the inner statment is true we will get true for the equalation of 2 sums
     */
    public static boolean equalSplit(int[] arr) {
        if (arr.length % 2 == 0) {  // Checking if we can split the array for 2 equal groups.
            return equalSplit(arr, 0, 0, 0, 0);
        }
        return false;
    }

    private static boolean equalSplit(int[] arr, int index, int sum1Counter, int sum1, int sum2) {
        if (index == arr.length)
            return sum1 == sum2 && sum1Counter == arr.length / 2;
        if (index <= arr.length && (equalSplit(arr, index + 1, sum1Counter + 1, sum1 + arr[index], sum2)))
            return true;
        return index <= arr.length && equalSplit(arr, index + 1, sum1Counter, sum1, sum2 + arr[index]);
    }
    /*
    /**
     * @param arr   the given array
     * @param pivot the point we moving all over the array
     * @param sum1  summarise 1 of the numbers
     * @param sum2  summarise 2 of the numbers
     * @return true or false if the 2 summarise are equals
     */
    /*
    public static boolean equalSplit(int[] arr, int pivot, int sum1, int sum2) {
        if (pivot == arr.length) { // STOP - if the pivot is get to the end of the array so this is the sign to stop.
            return sum1 == sum2; // return if the 2 summarize are equal at the end of the array.
        }
        return equalSplit(arr, pivot + 1, sum1 + arr[pivot], sum2) || // this recursive return in one time she adding the number to the sum1 and other time to sum2 thats will cover all the options.
                equalSplit(arr, pivot + 1, sum1, sum2 + arr[pivot]);
    }
    */
}
