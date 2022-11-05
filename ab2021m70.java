
/**
 * Write a description of class ab2020m85 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ab2021m70 {
    public static int findMaxPrice(int[] prices, int n) {
        return findMaxPrice(prices, n, 1);
    }

    /**
     * צעד בסיסי - להשוות בין המיקום עצמו לבין המיקומים הבאים
     * תנאי עצירה - 1. הגעה לסוף המערך
     * 2. נגמר הס"מ לקזז
     */

    public static int findMaxPrice(int[] prices, int n, int index) {
        if (index == prices.length)//n<0||index>prices.length-1
            return 0;
        if (n == 0)
            return 0;
        if (n - index < 0) {
            return Integer.MIN_VALUE;
        }
        int suj1 = prices[index] + findMaxPrice(prices, n - index, index);
        int suj2 = findMaxPrice(prices, n, index + 1);
        return Math.max(suj1, suj2);
    }

    /*
    public static int findMaxPrice(int[]prices,int n,int index){
    int offer1=0,offer2=0;
    if(index == prices.length )
    return 0;
    if(n<=0)
    return 0;
    if(n-index>=0){
    offer1 = prices[index]+findMaxPrice(prices,n-index,index);
    offer2 = findMaxPrice(prices,n,index+1);
    }
    return Math.max(offer1,offer2);
    }  */

    public static int getmedian(int[] a, int[] b) {
        int[] newShit = new int[a.length + b.length];//2
        int j = 0, k = 0;
        for (int i = 0; i < newShit.length; i++){
            if (j < b.length && k < a.length) {
                if (a[k] >= b[j]) {
                    newShit[i] = b[j];
                    j++;
                } 
                else {
                    newShit[i] = a[k];
                    k++;
                }
            } else if (j == b.length && k < a.length) {
                newShit[i] = a[k];
                k++;
            } else if (j < b.length && k == a.length) {
                newShit[i] = b[j];
                j++;
            }
        }
        return (newShit[newShit.length / 2] + newShit[(newShit.length / 2) - 1]) / 2;
    }

}