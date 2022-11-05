
/**
 * Write a description of class b202185 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class a2021m85
{
    /*public static int minPrice(int[][] mat){
        return minPrice(mat,0,0);  
    }

    private static int minPrice(int[][] mat,int i , int j){
        if(i==mat.length-1 && j==mat.length-1)
            return 0;
        if(mat[i][j] == 0)
            return minPrice(mat,i ,j+1);
        int here=0,right=90000000;
        here = mat[i][j]+minPrice(mat,j ,j);
        if(j+1 != mat.length)
            right = mat[i][j+1]+minPrice(mat,j+1 ,j+1);
        return Math.min(right,here);
        
        /*if(j== mat[0].length)
        return 0;
        min1 = CalculateRoad(mat,i,j);
        if(min > min1)
        min = min1;  
        return minPrice( mat,i ,j+1,min,min1);
         
    } 
    
    //WAY2
    /*public static int minPrice(int[][] mat){
        return minPrice(mat,0,0,0);    
    }
    
    private static int minPrice(int[][] mat,int i , int j,int price){
        if(i == mat.length-1 && j == mat[0].length-1)
            return price;
        int way1 = 0,way2=0;
        way1 = minPrice(mat,i+1,i+1,price+mat[i][j+1]); 
        
        if(j+2 >= mat.length){
            way2 = way1;
        }
        else{
            way2 = minPrice(mat, i+2 , i+2,price+mat[i][j+2]);
        }
        return Math.min(way1,way2);
    }*/
    
    public static boolean findAverage (int [] arr, double x){
        int indLow=0,indHi=1,count =1;
        double retzef = arr[indLow];
        double Ave =retzef/count;
        while(indHi != arr.length){
            Ave =retzef/count ;
            if(Ave < x ){
                if(Ave<(retzef-arr[indLow])/(count-1)){
                    retzef -= arr[indLow];
                    count--;
                    indLow++;
                }
                else{
                    retzef += arr[indHi];
                    count++;
                    indHi++;
                }
            }
            else if(Ave > x){
                if(Ave > (retzef+arr[indLow])/(count+1)){
                    retzef += arr[indLow];
                    count++;
                    indHi++;
                }
                else{
                    retzef -= arr[indLow];
                    count--;
                    indLow++;
                }
            }
            else
                return true;
        }
        return false;
    }
    
    
    public static int minPrice(int[][] mat){
        return minPrice(mat,0,1,0);
    }
    
    private static int minPrice(int[][] mat,int i,int j,int price){
        if(i == mat.length-1 && j== mat.length-1){
            return price;
        }
        if(j == i){
            j++;
        }
        int here = 0;int next = 999999;
        
        if(j<mat.length-1){
            next = minPrice(mat,j+1,j+1, price+mat[i][j+1]);
        }
        
        here =  minPrice(mat,j,j, price+mat[i][j]);
        
        return Math.min(here,next);
    }
}

