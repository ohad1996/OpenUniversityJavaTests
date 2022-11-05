
/**
 * Write a description of class a2022m87 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class a2022m87
{
    /*public static boolean isIdentity(int[][] mat,int x, int size){
    return isIdentity(mat,x,size,x,x); 
    }

    private static boolean isIdentity(int[][] mat,int x, int size,int i,int j){
    if((i == x+size-1)&&(j == x+size-1)&&mat[i][j]==1){
    return true;
    }

    if((mat[i][j] == 1 && i==j)||((mat[i][j] == 0 && i!=j))){
    if((i == x+size-1)){
    return isIdentity(mat,x,size,x,j+1);
    }
    else
    return isIdentity(mat,x,size,i+1,j);
    }
    return false;
    }

    public static int maxMatrix(int [][] mat){
    return maxMatrix(mat,0,mat[0].length);
    }

    private static int maxMatrix(int [][] mat,int x,int size){
    if(size ==1 && mat[x][x] != 1 ){
    return 0;
    }
    if(isIdentity(mat,x,size)){
    return size;
    }

    return maxMatrix(mat,x+1,size-2);
    }*/

    public static boolean isIdentity(int[][]mat,int x,int size){
        return isIdentity(mat, x,size,x,x);
    }

    private static boolean isIdentity(int[][]mat,int x,int size,
    int i,int j){
        if(size == 1)
            if(mat[x][x] == 1)
                return true;
            else 
                return false;
        if(mat[x][x] != 1)
            return false;
        boolean way1,way2;
        way1 = isIdentity(mat,size-1,i,j+1); 
        way2 = isIdentity(mat,size-1,i+1,j);

        if(way1 && way2){
            return isIdentity(mat,x+1,size-1, x+1,x+1);
        }
        return false;
    }

    private static boolean isIdentity(int[][]mat,int size,int i,int j){
        if(size == 0){
            return true;
        }
        if(mat[i][j] != 0){
            return false;
        }

        if(j>i)
            return isIdentity(mat,size-1, i, j+1);
        else
            return isIdentity(mat,size-1, i+1, j);
    }

    public static int maxMatrix(int[][]mat){
        return maxMatrix(mat,mat.length,0,0);
    }

    private static int maxMatrix(int[][]mat,int size,int i,int j){
        if(size == -1)
            return 0;
        if(!isIdentity(mat,i,size))
            return maxMatrix(mat,size-2,i+1,j+1);
        return size;
    }

    //יעילות
    //incomplete
    public static int findMissingIndex(int[]a){
        int hi=a.length,low=0,mid;
        while(hi - low + 1!= 3){
            mid = (hi+low)/2;
            if(hi - low + 1% 2 == 0)//for slice the subArry to 2 equal parts
            {
                int d1,d2;
                d1 = a[mid]-a[low];
                d2 = a[hi] - a[mid+1];
                if(d1>d2){
                    hi = mid;
                }
                else if(d2>d1){
                    low = mid;
                }
                else{
                    if(a[mid+1] - a[mid] == a[mid]-a[mid-1])
                        return a.length;
                    return mid+1;
                }
            }
            else{
                int d1,d2;
                d1 = a[mid]-a[low];
                d2 = a[hi] - a[mid];
                if(d1>d2){
                    hi = mid;
                }
                else if(d2>d1){
                    low = mid;
                }
                else{
                    return a.length;
                }
            }
        }
        return 1;
    }

    public static void main (){
        int[][]mat = {
                {1,0,0,0,3},
                {0,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,0},
                {0,0,0,0,1}};
        System.out.print(maxMatrix(mat));
    }
}