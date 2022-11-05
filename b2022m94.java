public class b2022m94
{
    public static int lengthPath(char[][]mat,String pattern){
        int[][] mirror = new int[mat.length][mat[0].length];
        return lengthPath(mirror,mat,pattern,0,0); 
    }  
    
    public static int lengthPath(int[][] mirror,char[][]mat,String pattern,int i,int j){
        if(checkChar(0,pattern,mat[i][j])==false)
            return 0;    
        int up = 0,down=0,left=0,right=0;
        mirror[i][j] = 1;
        if(i-1>=0 && mirror[i-1][j]!=1){
            up += 1+ lengthPath(mirror,mat,pattern,i-1,j);
        }
        if(i+1<mat.length && mirror[i+1][j]!=1){
            down += 1+ lengthPath(mirror,mat,pattern,i+1,j);
        }
        if(j-1>=0 && mirror[i][j-1]!=1){
            left += 1+ lengthPath(mirror,mat,pattern,i,j-1);
        }
        if(j+1<mat.length && mirror[i][j+1]!=1){
            left += 1+ lengthPath(mirror,mat,pattern,i,j+1);
        }
        mirror[i][j]=0;
        return 1+ Math.max(Math.max(up,down),Math.max(left,right));
    }
    
    /*public static boolean checkChar(String pattern,char shit){
        if(pattern.length() == 0 || pattern.equals(""))
            return false;
        if(pattern.charAt(0)== shit)
            return true;
        return checkChar(pattern.substring(1),shit);
    }*/
    public static boolean checkChar(int i,String pattern,char shit){
        if(pattern.length() == i)
            return false;
        if(pattern.charAt(i) == shit)
            return true;
        return checkChar(i+1,pattern,shit);
    }
}
