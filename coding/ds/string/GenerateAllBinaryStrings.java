package coding.ds.string;

/*
https://www.geeksforgeeks.org/generate-all-binary-strings-from-given-pattern/
[Google]
 */
public class GenerateAllBinaryStrings {
    static void generate(char ch[], int i){
        if(i>=ch.length){
            System.out.println(String.valueOf(ch));
            return;
        }
        if(ch[i]=='?'){
            ch[i]='0';
            generate(ch,i+1);
            ch[i]='1';
            generate(ch,i+1);
            ch[i]='?';
        }
        else generate(ch,i+1);
    }

    public static void main(String[] args) {
//        generate("1??0101".toCharArray(),0);
        generate("1??0?101".toCharArray(),0);
    }
}
