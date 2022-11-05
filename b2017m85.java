
/**
 * Write a description of class b2017m85 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class b2017m85 {
    /*public static int oneFiveSeven(int n) {
    if (n == 0)
    return 0;
    if (n < 0)
    return Integer.MAX_VALUE - 1;
    int one = 1 + oneFiveSeven(n - 1);
    int five = 1 + oneFiveSeven(n - 5);
    int seven = 1 + oneFiveSeven(n - 7);
    return Math.min(Math.min(one, five), seven);
    }

    public static void main(String[] args) {
        int x = oneFiveSeven(7);
        System.out.println(x);
    }*/

    public static int oneFiveSeven(int n){
        return oneFiveSeven( n,0);
    }

    private static int oneFiveSeven(int n,int sum){
        if(n==0)
            return sum;
        if(n<0)
            return Integer.MAX_VALUE;
            
        int one = oneFiveSeven(n-1,sum+1);
        int five = oneFiveSeven(n-5,sum+1);
        int seven = oneFiveSeven(n-7,sum+1);
        return Math.min(Math.min(one,five),seven);
    } 
}