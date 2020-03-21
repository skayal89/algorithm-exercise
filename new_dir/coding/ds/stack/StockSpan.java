package coding.ds.stack;

import coding.util.ArrayUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] ar) throws ParseException {
        int a[]=new int[]{100,80,60,70,60,75,78,85,106};
        ArrayUtil.print(spans(a));
    }

    public static int[] spans(int a[]){
        int[] span=new int[a.length];
        Stack<Integer> s=new Stack<Integer>();
        s.push(0);
        span[0]=1;
        for(int i=1;i<a.length;i++){
            while(!s.empty() && a[s.peek()]<=a[i])
                s.pop();
            span[i]=s.empty() ? i+1 : i-s.peek();
            s.push(i);
        }
        return span;
    }
}
