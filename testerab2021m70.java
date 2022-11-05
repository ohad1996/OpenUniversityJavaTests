
/**
 * Write a description of class testerab2021m70 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class testerab2021m70 extends ab2021m70 {
    public static void main(String[] args) {
        int[] arr = {0, 4, 3, 10, 9, 10, 17, 17, 20};
        System.out.println(findMaxPrice(arr, 8));
        int[] a1 = {1, 12, 15, 26, 38};
        int[] a2 = {12, 13, 18, 30, 45};
        int[] a3 = {4, 7, 8, 20};//{4,7,8,20,30,33,49,50}
        int[] a4 = {30, 33, 49, 50};
        System.out.println(getmedian(a1, a2));
        System.out.println(getmedian(a3, a4));
    }
}
