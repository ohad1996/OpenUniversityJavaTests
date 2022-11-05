
/**
 * Write a description of class b2022m91 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class b2022m91
{
    public static int cheapRt(int[]stations,int step1,int step2,int limit){
        return cheapRt(stations,step1,step2,limit,0,0,"");
    }

    private static int cheapRt(int[]stations,int step1,
    int step2,int limit,int i,int count,String str){
        if(i>=stations.length){
            return Integer.MAX_VALUE;        
        }
        if(i==stations.length-1){
            count+= stations[i];
            str+= i+"->"+stations[i]+"\t="+count+"";
            System.out.println(str);
            return count;
        }

        int way1,way2;
        way1=way2=Integer.MAX_VALUE;
        str+=i+"->"+stations[i]+"\t";

        way1 = cheapRt(stations,step1,step2,limit,i+step1,count+stations[i],str);

        if(limit!=0)
            way2 = cheapRt(stations,step1,step2,limit-1,i+step2,count+stations[i],str);

        return Math.min(way1,way2);
    }

    public static void main(){
        int[]arr = {2,4,8,3,10,1,12,3,2};
        System.out.println(cheapRt(arr,3,2, 4));

        int [] a = {2,3,8,-10,7,6,-11,4};
        System.out.println(findTriplet(a));
    }

    public static int findTriplet(int [] arr)
    {
        int p1 = arr[0], p2 = arr[0], p3 = arr[0],n1=arr[0],n2=arr[0];
        for(int i = 0 ; i<arr.length;i++){
            if(arr[i]>p1){ p1 = arr[i];}  
        }
        for(int i = 0 ; i<arr.length;i++){
            if(arr[i]>p2 && arr[i]!=p1){ p2 = arr[i];}   
        }
        for(int i = 0 ; i<arr.length;i++){
            if(arr[i]>p3 && arr[i]!=p1 && arr[i]!=p2){ p3 = arr[i];}   
        }
        for(int i = 0 ; i<arr.length;i++){
            if(arr[i]<n1 ){ n1 = arr[i];}   
        }
        for(int i = 0 ; i<arr.length;i++){
            if(arr[i]<n2 && arr[i]!=n1){ n2 = arr[i];}   
        }
        if(n1 * n2 * p1 > p1 * p2 * p3)
            System.out.println(p1+" "+n2+" "+n1);
        else if(n1 * n2 * p1 <= p1 * p2 * p3)
            System.out.println(p1+" "+p2+" "+p3);
        return n1 * n2 * p1>p1*p2*p3 ? n1 * n2 * p1: p1 * p2 * p3;
    }
}
