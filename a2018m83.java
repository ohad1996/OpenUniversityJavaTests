
/**
 * עליכם לכתוב שיטה רקורסיבית המקבלת גודל של מערך n ומספר מקסימלי max ומחזירה את
מספר האפשרויות שיש למלא את המערך במספרים מהתחום 1 עד max כך שיהיו מסודרים
בסדר לא יורד
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class a2018m83
{
    public static int howManySorted(int n, int max){
        return  howManySorted(n,max,0,1);
    }
    private static int howManySorted(int n, int max,int i,int count){
        if(i==n){
            return 1;
        }
        int way1=0 ,way2=0;
        //way1 - when we decide to move foward!
        //way2 - dont move but increase count! +1
        way1 =  howManySorted(n,max,i+1,count);
        if(count<max)
            way2 = howManySorted(n,max,i,count+1);
        
        return way1+way2;
    }
    
    public static void main (String[]args){
        System.out.println(howManySorted(2, 3));
    }
    //WAY2
    /*
    public static int howManySorted(int n, int max) {
        int arr[] = new int[n];
        return howManySorted(arr,max,0,1) ;
    }
    
    private static int howManySorted(int[] arr, int max,int i,int cur){
        if(i == arr.length){
            printArr(arr);
            return 1;
        }

        int way1 = 0;int way2 = 0;
        int tmp = arr[i];
        if(arr[i] == cur)
            way1 = howManySorted(arr,max,i+1,cur);
        else{
            arr[i] = cur;
            way1 = howManySorted(arr,max,i+1,cur);
        }
        
        if(cur<max)
                way2 = howManySorted(arr,max,i,cur+1);      
        return way1 + way2;
    }
    private static void printArr(int[]arr){
        for(int i =0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.print("\n");
    }
    
    //WAY3
    private static int howManySorted( int max,int[]arr,int i,int curr){
        if(i == arr.length){ 
            printArr(arr);
            return 1;
        }

        int way1=0,way2=0;
        int temp = arr[i];
        
        arr[i] = curr;
        way1 = howManySorted(max,arr,i+1,curr);

        arr[i] = temp;
        if(curr<max){
            arr[i] = curr;
            way2 = howManySorted(max,arr,i,curr+1);
        }

        return way1+way2;
    }
    */
}

