
/**
 * Write a description of class b2019m84 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class a2019m84
{
    public static boolean sumPower3(int num){
        return sumPower3(num,0);
    }

    private static boolean sumPower3(int num,int pw){
        if(num==0)
            return true;

        int newNum = (int)(num - Math.pow(3,pw));
        if(newNum < 0)
            return false;

        return sumPower3(newNum,pw+1) || sumPower3(num,pw+1);
    }

    public static void main(){
        System.out.print(sumPower3(38));
    }
}