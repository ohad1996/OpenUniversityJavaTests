
/**
 * Write a description of class b2021m60 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class b2021m60 {
    public static boolean split3(int[] arr) {
        return split3(arr, 0, 0, 0, 0);
    }

    private static boolean split3(int[] arr, int index, int s1, int s2, int s3) {
        if (index == arr.length)
            return s1 == s2 && s2 == s3;
        return ((index < arr.length) && (split3(arr, index + 1, s1 + arr[index], s2, s3)))
                || ((index < arr.length) && (split3(arr, index + 1, s1, s2 + arr[index], s3)))
                || ((index < arr.length) && (split3(arr, index + 1, s1, s2, s3 + arr[index])));
    }

    //way1:
    public static int smallestSub(int[] a, int k) {
        int bestCounter = a.length + 1;
        int sum = 0;
        int counter = 0;
        int checkoutArestart = 1;
        for (int i = 0; i < a.length && checkoutArestart != a.length; i++) {
            if (sum < k) {
                sum += a[i];
                counter++;
            }
            if (sum > k && bestCounter > counter)
                bestCounter = counter;
            if (i == a.length - 1) {
                i = checkoutArestart;
                checkoutArestart++;
                counter = 0;
                sum = 0;
            }
        }
        return bestCounter;
    }
    
    //way2 :
    /*public static int smallestSub(int[] a, int k) {
        int i = 0,j= 0;
        int sum=0,bestMin = a.length+1;
        int minArray = a.length+1;
        while(i != a.length){
            if(j < a.length && sum<k){
                sum+=a[j];
                j++;
            }
            else{
                if(sum-a[i] > k){
                    sum -= a[i];
                    i++;
                }
                if(sum>k&&j-i!=bestMin){
                    minArray = j-i;
                    if(minArray<bestMin){
                        bestMin = minArray; 
                    }
                }
                else{
                    i=j;
                    sum=0;
                }
            }
        }  
        return bestMin;
    }*/
}
