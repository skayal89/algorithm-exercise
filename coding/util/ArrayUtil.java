package coding.util;

public class ArrayUtil {
    public static void print(int a[]){
        for(int i:a){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void print(int a[][]){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void print(boolean a[][]){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void print(boolean[] a) {
        for(boolean i:a){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
