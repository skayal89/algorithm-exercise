package coding.algo.backtracking;


import java.util.Arrays;

public class PlaceSpaces {
    void insertSpace(String s, int n){
        char[] ch=new char[2*n];
        util(s,0,ch);
    }

    private void util(String s, int i, char[] c){
        if(s.length()==1){
            c[i]=s.charAt(0);
            System.out.println(new String(c,0,i+1));
            return;
        }
        c[i]=s.charAt(0);
        util(s.substring(1),i+1,c);
        c[i+1]=' ';
        util(s.substring(1),i+2,c);
    }

    public static void main(String[] args) {
        new PlaceSpaces().insertSpace("abc",3);
    }
}
