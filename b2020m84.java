
/**
 * Write a description of class b2020m84 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class b2020m84 {
    public static void findWord(char[][] arr, String word){
        findWord(arr, word,0,0);
    }

    private static void findWord(char[][] arr, String word,int i,int j){
        if(i == arr.length){
            System.out.println("no Such Word");
            return;
        }
        if(j == arr.length){
            findWord(arr,word,i+1,0);
            return;
        }
        if(!findWord(arr,new int[arr.length][arr.length],word,i,j,0))
            findWord(arr,word,i,j+1);
    }

    private static boolean findWord(char[][] arr,int[][]mat,String word,
    int i,int j,int count){
        if(count == word.length()-1 && arr[i][j] == word.charAt(count)){
            mat[i][j] = count+1;
            printArr(mat);
            return true;
        }
        if(arr[i][j] != word.charAt(count))
            return false;

        boolean up,down,left,right;
        up=down=left=right=false;
        
        char temp = arr[i][j];
        arr[i][j] = 'A';
        mat[i][j] = count+1;
        
        if(i>0){
            up = findWord(arr,mat,word,i-1,j,count+1);
            if(up){//ment for to do not print more successful ways
                arr[i][j] = temp;
                return true;
            }
        }
        if(i+1<arr.length){
            down = findWord(arr,mat,word,i+1,j,count+1);
            if(down){//ment for to do not print more successful ways
                arr[i][j] = temp;
                return true;
            }
        }
        if(j>0){
            left = findWord(arr,mat,word,i,j-1,count+1);
            if(left){//ment for to do not print more successful ways
                arr[i][j] = temp;
                return true;
            }
        }
        if(j+1<arr.length){
            right = findWord(arr,mat,word,i,j+1,count+1);
            if(right){//ment for to do not print more successful ways
                arr[i][j] = temp;
                return true;
            }
        }

        mat[i][j] = 0;
        arr[i][j] = temp;
        return up||down||left||right;
    }

    private static void printArr(int[][]mat){
        for(int i=0;i<mat.length;i++){
            for(int j =0 ;j<mat.length;j++)
                System.out.print(mat[i][j]);
            System.out.println();
        }
    }

    public boolean isHighFactorInRange(int n, int low, int high){
        return true;
    }
}