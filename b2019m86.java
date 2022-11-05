
/**
 * Write a description of class b2019m86 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class b2019m86
{
    /*public static boolean deadEnd(int[][]mat,int i,int j){
    if((i-mat[i][j]>=0 && mat[i-mat[i][j]][j]!= 0)||
    (i+mat[i][j]<mat.length && mat[i+mat[i][j]][j]!= 0)||
    (j-mat[i][j]>=0 && mat[i][i-mat[i][j]]!= 0)||
    (j+mat[i][j]<mat[i].length && mat[i][j+mat[i][j]]!= 0)){
    return true;
    }
    return false;
    }*/

    public static int howManyPaths(int[][]mat){
        return  howManyPaths(mat,0,0);
    }

    public static int howManyPaths(int[][]mat,int i,int j){
        if(i == mat.length-1 && j == mat[i].length-1){
            return 1;
        }
        if(mat[i][j] == 0)//deadEnd(mat,i,j)){
            return 0;

        int k = mat[i][j];//the defenition
        mat[i][j] = 0;
        int up,down,left,right;
        up=down=left=right=0;

        if(i-k>=0)
            up += howManyPaths(mat,i-k,j);
        if(i+k<mat.length )
            down += howManyPaths(mat,i+k,j);
        if(j-k>=0)
            left += howManyPaths(mat,i,j-k);
        if(j+k<mat[i].length )
            right += howManyPaths(mat,i,j+k);

        mat[i][j] = k;

        return up+down+left+right;
    }

    public static int meetingPoint(int[] a,int[] b){
        int hia,hib,lowa,lowb,mida,midb,best = Integer.MAX_VALUE;
        lowa = a.length-1;hia = 0;
        lowb=0;hib=b.length-1;
        
        mida =(hia+lowa)/2;
        midb= (hib+lowb)/2;
        int mid = Math.min(mida,midb);
        
        while(lowa>=hia && lowb<=hib){
            mida =(hia+lowa)/2;
            midb = (hib+lowb)/2;
            mid = Math.min(mida,midb);
            if(a[mid] < b[mid]){
                hib = mid-1;
                lowa = mid-1;
            }
            else if(a[mid]>b[mid]){
                hia = mid+1;
                lowb = mid+1;
            }
            else{
                if(best > mid) 
                    best = mid;
                hib = mid-1;
                lowa= mid-1;
            }
        }
        
        return best != Integer.MAX_VALUE ? best : -1;
    }

    public static void main (){
        int[][]mat = {
                {1,3,1,6},
                {2,8,1,2},
                {6,2,7,5},
                {2,4,1,3}
            };

        int[]a = {19,19,16,15,15,15,13,13,5};
        int[]b = {0,12,13,14,14,15,15,19,25,30,35};
        System.out.println(howManyPaths(mat));
        System.out.println(meetingPoint(a,b));
    }
}
