package coding.ds.stack;

import java.util.Stack;

public class LargestHistogram {

    static int largestArea(int a[]){
        int i=0,top=-1, area=0, max=Integer.MIN_VALUE, n=a.length;
        Stack<Integer> s=new Stack<Integer>();
        while(i<n){
            if(s.empty() || a[s.peek()]<=a[i]){
                s.push(i);
                i++;
            }
            else{
                while(!s.empty() && a[s.peek()]>a[i]){
                    top=s.pop();
                    area=s.empty() ? i*a[top] : a[top]*(i-s.peek()-1);
                    if(area>max)   max=area;
                }
            }
        }
        while(!s.empty()){
            top=s.pop();
            area=s.empty() ? i*a[top] : a[top]*(i-s.peek()-1);
            if(area>max)   max=area;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a=new int[]{6, 2, 5, 4, 5, 1, 6}; // answer = 12
        System.out.println(largestArea(a));
    }
}
