
/**
 * Write a description of class a2016m83 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class a2016m83
{
    public static int minPoints(int [][]mat){
        return 1+ minPoints(mat,0,0,0,0);
    }

    private static int minPoints(int [][]mat,int i ,int j,int neg,int pos){
        if(i == mat.length -1 && j == mat[i].length -1 ){
            if(mat[i][j]<0)
                neg += mat[i][j];
            else
                pos+= mat[i][j];
            if(neg == 0)
                return 0;
            return Math.abs(pos + neg); 
        }
        if(i == mat.length  || j == mat[i].length ){
            return 50000;
        }

        int way1,way2;
        way1=way2=50000;//Integer.MAX_VALUE;

        if(mat[i][j]<0)
            neg += mat[i][j];
        else
            pos+= mat[i][j];
        way1 = minPoints(mat,i+1,j,neg,pos);
        way2 = minPoints(mat,i,j+1,neg,pos);

        return Math.min(way1,way2);
    }

    public static boolean findX(int [] arr,int x){
        int low,hi,mid;
        return false;
    }

    public static void main(){
        int [][][]mat ={
            {
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5},
            },
            {
                {2,-3,3},
                {5,-10,1},
                {10,30,5},
            }
        };
        System.out.println(minPoints(mat[0]));
        System.out.println(minPoints(mat[1]));
    }
}