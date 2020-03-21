package coding.ds.array;

import coding.util.ArrayUtil;

import java.util.Date;
import java.sql.Timestamp;

public class ZeroMatrix {
    public static void main(String[] args) {
        int a[][]=new int[][]{{1,2,0,0},{7,2,9,7},{5,5,6,7}};
        ArrayUtil.print(a);
        convert(a);
        System.out.println("Result:");
        ArrayUtil.print(a);
        System.out.println(new Timestamp(new Date().getTime()));
    }

    public static void convert(int a[][]){
        boolean r=false,c=false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(i==0 && a[i][j]==0){
                    r=true;
                }
                if(j==0 && a[i][j]==0){
                    c=true;
                }
                if(i>0 && j>0 && a[i][j]==0){
                    a[0][j]=0;
                    a[i][0]=0;
                }
            }
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[i].length; j++) {
                if(a[0][j]==0 || a[i][0]==0){
                    a[i][j]=0;
                }
            }
        }

        if(r) {
            for (int i = 0; i < a.length; i++) {
                a[0][i]=0;
            }
        }
        if(c) {
            for (int i = 0; i < a[0].length; i++) {
                a[i][0]=0;
            }
        }
    }
}
