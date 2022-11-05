
/**
 * Write a description of class EX14 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class a2018m85 {
    public static int longestSlope(int[][]mat,int num){
        return longestSlope(mat,num,0,0);
    }

    private static int longestSlope(int[][]mat,int num,int i,int j){
        if(i == mat.length){
            return 0;
        }
        if(j == mat[0].length){
            return longestSlope(mat,num,i+1, 0);
        }

        int resHere = slopeCalc(mat,num,i,j);
        int resNext = longestSlope(mat,num,i,j+1);
        return Math.max(resHere,resNext);
    }

    private static int slopeCalc(int[][]mat,int num,int i,int j){
        if(!((i-1>=0 && mat[i][j]-mat[i-1][j] == num)||
        (i+1 <= mat.length-1 && mat[i][j]-mat[i+1][j] == num)||
        (j-1>=0 && mat[i][j]-mat[i][j-1]== num)||
        (j+1 <= mat[i].length-1 && mat[i][j]-mat[i][j+1]== num))){
            return 1;
        }

        //if(deadEnd(mat,i,j,num))
           // return 1;

        int up=0,down=0,left=0,right=0;

        if(i-1 >= 0 && mat[i][j]-mat[i-1][j] == num){
            up = slopeCalc(mat,num,i-1,j);   
        }

        if(i+1 <= mat.length-1 && mat[i][j]-mat[i+1][j]== num){
            down = slopeCalc(mat,num,i+1,j);   
        }

        if(j-1 >= 0 && mat[i][j]-mat[i][j-1]== num){
            left = slopeCalc(mat,num,i,j-1);   
        }

        if(j+1 <= mat[0].length-1 && mat[i][j]-mat[i][j+1]== num){
            right = slopeCalc(mat,num,i,j+1);   
        }

        return 1+ Math.max(Math.max(up,down),Math.max(left,right));
    }

    private static boolean deadEnd(int[][] mat, int i, int j, int num) {
        //checks if the slope can't move up
        if (i - 1 >= 0 && (mat[i][j] - mat[i - 1][j] == num))
            return false;
        //checks if the slope can't move down
        if (i + 1 < mat.length && (mat[i][j] - mat[i + 1][j] == num))
            return false;
        //checks if the slope can't move left
        if (j - 1 >= 0 && (mat[i][j] - mat[i][j - 1] == num))
            return false;
        //checks if the slope can't move right
        if (j + 1 < mat[0].length && (mat[i][j] - mat[i][j + 1] == num))
            return false;
        return true;//incase we found a path for the slope
    }

    public static void main(){
        int[][]mat = {
                {3,13,15,28,38},
                {55,54,53,27,26},
                {54,12,52,51,50},
                {50,10,8,53,11}};
        System.out.println(longestSlope(mat,1));
        System.out.println(longestSlope(mat,2));

    }
}