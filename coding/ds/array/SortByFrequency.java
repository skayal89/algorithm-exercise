package coding.ds.array;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

/*
https://www.geeksforgeeks.org/sort-elements-by-frequency/
 */
public class SortByFrequency {

    @AllArgsConstructor
    @ToString
    static class Model{
        int element, freq, index;
    }

    void sort(int a[], int n){
        Map<Integer,Model> map=new HashMap<>();
        for (int i=0;i<n;i++){
            if(map.containsKey(a[i])){
                Model m=map.get(a[i]);
                m.freq++;
                map.put(a[i],m);
            }
            else {
                map.put(a[i], new Model(a[i], 1, i));
            }
        }

        List<Model> val= map.values().stream()
                .sorted((m1, m2) -> m1.freq != m2.freq ? m2.freq - m1.freq : m1.index - m2.index)
                .collect(Collectors.toList());

        System.out.println(val);
        print(val);
    }


    void print(List<Model> val){
        for (Model m : val) {
            for (int i = 0; i < m.freq; i++) {
                System.out.print(m.element+" ");
            }
        }
    }

    public static void main(String[] args) {
        int a[]=new int[]{2, 5, 2, 8, 5, 6, 8, 8};
        new SortByFrequency().sort(a,a.length);
    }
}
