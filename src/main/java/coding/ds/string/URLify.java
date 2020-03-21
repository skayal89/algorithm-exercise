package coding.ds.string;

public class URLify {

    public static void main(String ar[]){
        String test=" am dull";
        System.out.println(toURL(test));
    }

    public static String toURL(String s){
        if(s==null) return null;
        int spaces=countSpace(s);
        int len=s.length();
        char ch[]=new char[len+(3*spaces)];
        int i=ch.length-1;
        for(int j=len-1;j>=0;j--){
            char c=s.charAt(j);
            if(c!=' '){
                ch[i--]=c;
            }
            else{
                ch[i--]='0';
                ch[i--]='2';
                ch[i--]='%';
            }
        }
        System.out.println(ch.length);
        System.out.println();
        return new String(ch);
    }

    public static int countSpace(String s){
        int c=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' ') c++;
        }
        return c;
    }
}
