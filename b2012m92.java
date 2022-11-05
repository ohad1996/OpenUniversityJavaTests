
/**
 * Write a description of class classtime2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class b2012m92
{
    public static void mirror(int[] a){
        mirror(a,0,a.length-1);
    }
    
    private static void mirror(int[] a,int i, int j){
        if(i>=j){
            printArr(a,0);  
            return;
        }    
        mirror(a,i+1,j-1);
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        mirror(a,i+1,j-1);
    }
    
    private static void printArr(int[]arr,int i){
        if(i==arr.length){
            System.out.println();
            return;
        }
        System.out.print(arr[i]);
        printArr(arr,i+1);
    }
    
    public static void main(String[]args){
        int[]arr = {5,3,1,4};
        mirror(arr);
    }
    
    
}
