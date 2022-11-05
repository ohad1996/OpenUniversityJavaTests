
/**
 * Write a description of class a2017m86 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class a2017m86 {
    public static int edit(String str1, String str2) {
        return edit2(str1, str2, 0, 0);
    }
    
    
    public static int edit2(String str1, String str2, int index, int index2) {
        if (index == str1.length() || index2 == str2.length())
            return 0;
        if (str1.charAt(index) == str2.charAt(index2))
            return edit2(str1, str2, index + 1, index2 + 1);
        else {
            return 1 + edit2(str1, str2, index + 1, index2);
        }
    }
    
    //way:
    public static int countTriplets(int[] arr, int num) {
        int left=0,right=arr.length-1,curr=0,count=0;
        
        for(;curr<arr.length;curr++){
            num -= arr[curr];
            left = curr+1;
            while(left<right){
                if(num - (arr[left]+arr[right])>0){
                    count+=right-left;
                    left++;
                    right = arr.length-1;
                }
                else{
                    right--;
                }
            }
            num += arr[curr];
        }
        return count;
    }
}
