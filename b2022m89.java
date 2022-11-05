
/**
 * Write a description of class b2022m89 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class b2022m89
{
    public static boolean isJump(String str1,String str2,int step){
        if(str2.length()>str1.length()){
            return false;
        }
        return isJump(str1,str2,0,0,step);
    }

    public static boolean isJump(String str1,String str2,int i,int j,int step){
        if( i==str2.length()){
            return true;
        }
        if(j < str1.length() && str2.charAt(i) == str1.charAt(j)){
            return isJump(str1,str2,i+1,j+step,step);
        }
        else{
            return false;
        }
    }
}
