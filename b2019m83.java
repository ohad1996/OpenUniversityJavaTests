public class b2019m83{
    /*{
    public static int longestPath(int [][]mat,int x,int y){
    return longestPath(mat,x,y,0,0,0);
    }

    private static int longestPath(int [][]mat,int x,int y,int i,int j,int sum){
    if(i==x && j == y){
    return sum;
    }   
    int temp = mat[i][j];
    mat[i][j] = 0;
    int up=0,down=0,left=0,right=0;
    if(i+1 < mat.length && mat[i+1][j] ==1){
    right = longestPath(mat,x,y,i+1,j,sum+1);
    }

    if(i-1 < mat.length && mat[i-1][j] ==1){
    left = longestPath(mat,x,y,i-1,j,sum+1);
    }

    if(j-1 < mat.length && mat[j-1][j] ==1){
    up = longestPath(mat,x,y,i,j-1,sum+1);
    }

    if(j+1 < mat.length && mat[j+1][j] ==1){
    down = longestPath(mat,x,y,i,j+1,sum+1);
    }

    mat[i][j] = temp;

    return Math.max(Math.max(left,right),Math.max(up,down));
    }

     */

    public static int longestPath(int [][]mat,int x,int y){
        if(mat[0][0] == 0 || mat[x][y] == 0)
            return -1;
        return longestPath(mat,x,y,0,0,1); 
    }

    private static int longestPath(int [][]mat,int x,int y,int i,int j,int count){
        if(i == x && j==y){
            return count;
        }
        int temp = mat[i][j]; 
        mat[i][j] = -1; 

        int up,down,left,right;
        up=down=left=right=0;
        if(i-1>=0 && mat[i-1][j]==1)
            down = longestPath(mat,x,y,i-1,j,count+1);

        if(j-1>=0 && mat[i][j-1]==1)
            left = longestPath(mat,x,y,i,j-1,count+1);

        if(i+1< mat.length&& mat[i+1][j]==1)
            up = longestPath(mat,x,y,i+1,j,count+1);

        if(j+1<mat[i].length && mat[i][j+1]==1)
            right = longestPath(mat,x,y,i,j+1,count+1);

        mat[i][j] = temp;
        return Math.max(Math.max(up,down),Math.max(left,right));
    }

    public static int howMAnyNN(int[][] mat){//NN= negative numbers
        int i= mat.length-1,j=0,totalNN =0;
        while(j<mat[i].length){
            if(mat[i][j] < 0 ){
                totalNN += i+1;
                j++;
            }
            else{
                if(i-1>=0 && mat[i-1][j] < 0){//4+4+4+ 
                    totalNN += i;
                    j++; 
                }
                else{ 
                    int k = 0,mid;
                    while(i-k != 1){
                        mid = (k+i)/2;
                        if(mat[mid][j]>=0){
                            i = mid; 
                        }
                        else{
                            k = mid;
                        }
                    }
                    totalNN += i;
                    j++;
                }
            }
        }
        return totalNN;
    }

    public static void main(){
        int [][]mat = {
                {1,1,1,1,1,1,1},
                {1,1,0,1,0,0,1},
                {1,1,1,1,0,1,1}
            };
            
        int [][]mat2 = {
                {-1,-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,0,0,1},
                {-1,-1,-1,-1,0,1,1},
                {-1,-1,-1,1,0,1,1},
                 {1,1,1,1,1,1,1}
            };
        System.out.println(longestPath(mat,2,5));
           System.out.println( howMAnyNN(mat2));
    }
}
