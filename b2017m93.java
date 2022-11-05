
/**
 * Write a description of class b2017m93 here.
 *עליכם לכתוב שיטה רקורסיבית המקבלת כפרמטר מטריצה ריבועית בוליאנית ומחזירה כמה
איזורי true שונים קיימים במטריצה. אם לא קיימים איזורי true יוחזר 0 .
שימו לב שאיזור true מורכב לפחות מתא אחד. 
 * @author (your name)
 * @version (a version number or a date)
 */
public class b2017m93
{
    /*public static void creatIntMat (boolean[][]mat,int [][]mirrorMat,int i,int j){
        if(i == mat.length)
            return ;
        if(j == mat[i].length){
            creatIntMat (mat,mirrorMat,i+1,0);
            return;
        }
        if(mat[i][j] == true){
            mirrorMat[i][j] =1;
        }
        creatIntMat (mat,mirrorMat,i,j+1);
    }*/
    public static int cntTrueReg (boolean[][]mat) {
        return cntTrueReg (mat,0,0);
    }
    
    private static int cntTrueReg (boolean[][]mat,int i,int j) {
        if(i == mat.length)
            return 0;
        if(j == mat[i].length)
            return cntTrueReg (mat,i+1,0);

        if(mat[i][j] == false)
             return cntTrueReg (mat,i,j+1);
        
        destroyArea(mat,i,j);
        return 1 + cntTrueReg(mat,i,j+1);
    }
    
    private static void destroyArea(boolean[][]mat,int i,int j){
        /*if(mat[i][j]==false)
            return ;*/
        mat[i][j]=false;
        if(i-1>=0 && mat[i-1][j]==true){
            destroyArea(mat,i-1,j);
        }
        if(i+1<mat.length && mat[i+1][j]==true){
            destroyArea(mat,i+1,j);
        }
        
        if(j-1>=0 && mat[i][j-1]==true){
            destroyArea(mat,i,j-1);
        }
        if(j+1<mat.length && mat[i][j+1]==true){
            destroyArea(mat,i,j+1);
        }
    }
    
    public static void main(){
        boolean mat[][] = 
        {
            {false,false,false,false,true},
            {false,true,true,true,false},
            {false,false,true,true,false},
            {true,false,false,false,false},
            {true,true,false,false,false},
        };
        System.out.println(cntTrueReg(mat));
    }
}