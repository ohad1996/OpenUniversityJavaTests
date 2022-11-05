
/**
 * Write a description of class b2020m96 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class b2020m96 {
    public static int maxSumKnight(int[][] mat) {
        return maxSumKnight(mat, 0, 0, 0);
    }

    private static int maxSumKnight(int[][] mat, int i, int j, int sum) {
        if (i >= mat.length || j >= mat.length || i < 0 || j < 0 || mat[i][j] == -1)
            return -1000;
        if (i == mat.length - 1 && j == mat[mat.length - 1].length - 1)
            return sum + mat[mat.length - 1][mat.length - 1];
        int upLeft1 = -1, upLeft2 = -1, upRight1 = -1, upRight2 = -1;
        int downLeft1 = -1, downLeft2 = -1, downRight1 = -1, downRight2 = -1;
        int temp = mat[i][j];
        mat[i][j] = -1000;
        if (!(i - 1 >= mat.length || j - 2 >= mat.length || i - 1 < 0 || j - 2 < 0) &&
                Math.abs(temp - mat[i - 1][j - 2]) == 1)
            upLeft1 = maxSumKnight(mat, i - 1, j - 2, sum + temp);
        if (!(i - 2 >= mat.length || j - 1 >= mat.length || i - 2 < 0 || j - 1 < 0) &&
                Math.abs(temp - mat[i - 2][j - 1]) == 1)
            upLeft2 = maxSumKnight(mat, i - 2, j - 1, sum + temp);
        if (!(i - 1 >= mat.length || j + 2 >= mat.length || i - 1 < 0 || j + 2 < 0) &&
                Math.abs(temp - mat[i - 1][j + 2]) == 1)
            upRight1 = maxSumKnight(mat, i - 1, j + 2, sum + temp);
        if (!(i - 2 >= mat.length || j + 1 >= mat.length || i - 2 < 0 || j + 1 < 0) &&
                Math.abs(temp - mat[i - 2][j + 1]) == 1)
            upRight2 = maxSumKnight(mat, i - 2, j + 1, sum + temp);
        if (!(i + 1 >= mat.length || j - 2 >= mat.length || i + 1 < 0 || j - 2 < 0) &&
                Math.abs(temp - mat[i + 1][j - 2]) == 1)
            downLeft1 = maxSumKnight(mat, i + 1, j - 2, sum + temp);
        if (!(i + 2 >= mat.length || j - 1 >= mat.length || i + 2 < 0 || j - 1 < 0) &&
                Math.abs(temp - mat[i + 2][j - 1]) == 1)
            downLeft2 = maxSumKnight(mat, i + 2, j - 1, sum + temp);
        if (!(i + 1 >= mat.length || j + 2 >= mat.length || i + 1 < 0 || j + 2 < 0) &&
                Math.abs(temp - mat[i + 1][j + 2]) == 1)
            downRight1 = maxSumKnight(mat, i + 1, j + 2, sum + temp);
        if (!(i + 2 >= mat.length || j + 1 >= mat.length || i + 2 < 0 || j + 1 < 0) &&
                Math.abs(temp - mat[i + 2][j + 1]) == 1)
            downRight2 = maxSumKnight(mat, i + 2, j + 1, sum + temp);
        mat[i][j] = temp;

        int move1 = Math.max(Math.max(upLeft1, upLeft2), Math.max(upRight1, upRight2));
        int move2 = Math.max(Math.max(downLeft1, downLeft2), Math.max(downRight1, downRight2));

        return Math.max(move1, move2);
    }

    //way1:
    public static int minimalPositive(Range[] rangeA) {
        boolean positive = false;
        if (rangeA[rangeA.length - 1].getBig() <= 0)
            return -1;
        int low = 0;
        int high = rangeA.length - 1;
        int mid = (low + high) / 2;
        while (low - high != 0) {
            if (rangeA[mid].getSmall() <= 0) {
                if (rangeA[mid].getBig() > 0) {
                    return 1;//binary search for the smallest death
                }
                if (rangeA[mid].getBig() <= 0) {
                    int temp = low;
                    low = mid;
                    if (mid == temp) {
                        mid = mid + 1;
                        low = low + 1;
                    } else
                        mid = (low + high) / 2;
                }
            } else {
                high = mid;
                mid = (low + high) / 2;
            }
        }
        return rangeA[mid].getSmall();
    }
    
    //way2:
    /*public static int minimalPositive(Range[] rangeA){
        int hi = rangeA.length -1,low = 0,mid = 0;
        while(low <= hi){
            mid = (low+hi)/2;
            if(hi != low){
                if(rangeA[mid].getBig() <= 0){
                    low = mid + 1;
                }
                if(rangeA[mid].getSmall()<=0 && rangeA[mid].getBig()>0)
                    return 1;
                if(rangeA[mid].getSmall()>0){
                    hi = mid ;
                }
            }
            else{
                if(rangeA[mid].getSmall()>0)
                    return rangeA[mid].getSmall();
                if(rangeA[mid].getBig() <= 0)
                    return -1;  
            }
        }
        System.out.println(mid);
        return -1;
    }*/
}