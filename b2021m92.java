
/**
 * Write a description of class b2021m92 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class b2021m92
{
    public static int printExpr(int []arr,int num){
        return printExpr(arr,num,0,"",0);
    }
    
    private static int printExpr(int []arr,int num,int i,String calc,int sum){
        if(i==arr.length){
            if(num==sum){
                System.out.println(calc);
                return 1;
            }
            return 0;
        }
        
        int way1,way2,way3;
        way1=way2=way3=0;
        way1 = printExpr(arr,num,1+i,calc,sum);
        String temp = calc;
        calc += "+"+arr[i];
        way2 = printExpr(arr,num,1+i,calc,sum+arr[i]);
        calc = temp;
        calc += "-"+arr[i];
        way3 = printExpr(arr,num,1+i,calc,sum-arr[i]);
        
        
        return way1+way2+way3;
    }
    
    public static void main(String[]args){
        int[]arr = {1,3,6,2};
        System.out.print(printExpr(arr,4));
    }
}