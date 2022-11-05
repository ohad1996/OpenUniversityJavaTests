
/**
 * Write a description of class a2020m87 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class a2020m87
{
    public static int totalWays(int[][]mat,int k){
        return totalWays(mat,k,0,0,0,true);
    }

    private static int totalWays(int[][]mat,int k,int i, int j,
    int count,boolean flag){
        if(i == mat.length-1 && j== mat[i].length-1){
            if(count == k)
                return 1;
            return 0;
        }
        if(i == mat.length || j== mat[i].length){
            return 0;
        }

        /*way1 - down=true, way2 - right=false*/
        int way1,way2;
        way1=way2=0;

        if(flag){
            if(i == 0 && j ==0){
                way1 = totalWays(mat,k,i+1,j,count,true);
                way2 = totalWays(mat,k,i,j+1,count,false);
            }
            else{
                way1 = totalWays(mat,k,i+1,j,count,true);
                way2 = totalWays(mat,k,i,j+1,count+1,false);
            }
        }
        else{            
            way1 = totalWays(mat,k,i+1,j,count+1,true);
            way2 = totalWays(mat,k,i,j+1,count,false);
        }
        return way1 + way2;
    }   

    public static void printTriplets(int[]a,int num){
        int k,c,b;
        k=c=a[0];
        for(int i = 0 ; i<a.length-2;i++){
            k = i;
            num /= a[i];
            c=a.length-1;
            b=i+1;
            while(b<c){
                if(a[b]*a[c] == num){
                    System.out.println(""+a[k]+"\t"+a[b]+"\t"+a[c]);
                    b++;
                }
                else if(a[b]*a[c] < num){
                    b++;
                }
                else{
                    c--;
                }
            }
            num*=a[i];
        }
    }

    public static void main(){
        int [][]mat={
                {0,0,0},
                {0,0,0},
                {0,0,0}
            };
        int a[] = {1,2,3,4,5,6,7,8,9};
        System.out.println(totalWays(mat,1));
        System.out.println(totalWays(mat,2));
        System.out.println(totalWays(mat,3));
        System.out.println(totalWays(mat,4));
        printTriplets(a,40);
    }
}
