
public class A2019m85{
    public static int longestPalindrome (int[] arr){
        return longestPalindrome2(arr ,0);
    }

    public static int longestPalindrome2 (int[] arr,int i){
        if(i == arr.length){
            return 0;
        }

        int case1 = longestPalindrome3 (arr,arr.length-1,i,0);
        return Math.max(case1,longestPalindrome2 (arr,1+ i));
    }

    public static int longestPalindrome3 (int[] arr,int j,int i,int sum){
        if(i==j)
            return sum+1;   
        if(i>j)
            return sum;
        int case1=0;int case2 =0;
        if(arr[i]==arr[j]){
            case1 = longestPalindrome3(arr,j-1,1+i,2+sum);

            case2 = longestPalindrome3(arr,j-1,i,sum);
            return Math.max(case1,case2);
        }
        return longestPalindrome3(arr,j-1,i,sum);
    }   
}