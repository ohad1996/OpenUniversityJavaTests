
/**
 * Write a description of class classtime here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class b2019m93
{
    /*public static int shortestRoad (int [] road1, int [] road2){
    int min1=0,min2=0,sum1=0,sum11=0,sum2=0,sum22=0;

    for(int i = 0;i<road1.length;i++){sum11 += road1[i];}

    for(int i = 0;i<road2.length;i++){sum22 += road2[i];}

    min1 = sum11;min2 = sum22;
    sum1 = sum11;sum2 = sum22;  
    for(int i = 0;i<road1.length;i++){
    sum2 += -road2[i]+road1[i];
    min1 = Math.min(min1,sum2);
    }

    for(int i = 0;i<road2.length;i++){
    sum1 += - road1[i]+road2[i];
    min2 = Math.min(min2,sum1);
    }

    return Math.min(min1,min2);
    }

    public static int shortestRoad (int [] road1, int [] road2){
        int min1=0,min2=0,sum1=0,sum2=0,cur1=0,cur2=0;

        for(int i=0;i<road1.length;i++){ 
            sum1 += road1[i];
            sum2 += road2[i];
        }

        min1 = sum1;min2 = sum2;
        cur1= sum1;cur2= sum2;
        for(int i=0;i<road1.length;i++){
            cur2 += -road2[i] + road1[i];
            min1 = Math.min(min1,cur2);
        }

        for(int i=0;i<road1.length;i++){
            cur1 += -road1[i] + road2[i];
            min2 = Math.min(min2,cur1);
        }

        return Math.min(min1,min2);
    }

    public static void main (String [] args){
        int [] road1 = {5,4,5,8,12,9,9,3};
        int [] road2 = {7,3,3,12,10,2,10,7};

        System.out.println(shortestRoad(road1,road2) );

    }

    public static boolean isSum (int[] a, int num){
        return isSum(a,num,0,0);
    }

    private static boolean isSum (int[] a, int num,int i,int counter){
        if(num == 0){
            return true;
        }

        if(i>a.length || num<0){
            return false;
        }

        boolean way1,way2;
        if(counter<=1){
            way1 = isSum(a,num-a[i],i+1,counter+1);
        }
        else{
            way1 = isSum(a,num-a[i],i+2,0);
        }

        way2 = isSum(a,num,i+1,0);

        return way1||way2;
    }*/    
    
    
    public static boolean isSum (int[] a, int num){
        return isSum(a,num,0,0);    
    }
    
    private static boolean isSum (int[] a, int num,int i,int count){
        if(num == 0){
            return true;
        }
        if(i>=a.length){
            return false;
        }//break how?
        
        boolean way1,way2;
        way1=way2=false;
        if(count<2 && !(num-a[i]<0)){
            way1 = isSum (a,num-a[i], i+1,count+1);
        }
        else if(count==1 && !(num-a[i]<0)){
            way1 = isSum (a,num-a[i], i+2,0);
        }        
        way2 = isSum (a,num, i+1,0);
        
        
        return way1 || way2;
    }
    
    
    public static void main (String [] args){
        int [] road1 = {5,4,5,8,12,9,9,3};
        int [] road2 = {7,3,3,12,10,2,10,7};
        int [] a = {5,4,2,1,3};
        //System.out.println(shortestRoad(road1,road2) );
        System.out.println(isSum(a,17));
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}