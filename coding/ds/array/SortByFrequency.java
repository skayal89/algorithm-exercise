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

        /* Java 8 way
        List<Model> val= map.values().stream()
                .sorted((m1, m2) -> m1.freq != m2.freq ? m2.freq - m1.freq : m1.index - m2.index)
                .collect(Collectors.toList());
        */

        Collection<Model> collection=map.values();
        List<Model> models=new ArrayList<>(collection);
        Collections.sort(models, new Comparator<Model>() {
            @Override
            public int compare(Model m1, Model m2) {
                return m1.freq != m2.freq ? m2.freq - m1.freq : m1.index - m2.index;
            }
        });

        System.out.println(models);
        print(models);
    }


    void print(List<Model> val){
        for (Model m : val) {
            for (int i = 0; i < m.freq; i++) {
                System.out.print(m.element+" ");
            }
        }
    }

    static String getMinNumberForPattern(String seq)
    {
        int n = seq.length();

        if (n >= 9)
            return "-1";

        char result[] = new char[n + 1];

        int count = 1;

        // The loop runs for each input character as well as
        // one additional time for assigning rank to each remaining characters
        for (int i = 0; i <= n; i++)
        {
            if (i == n || seq.charAt(i) == 'I')
            {
                for (int j = i - 1; j >= -1; j--)
                {
                    result[j + 1] = (char) ((int) '0' + count++);
                    if (j >= 0 && seq.charAt(j) == 'I')
                        break;
                }
            }
            for (int k = 0; k <= n; k++) {
                System.out.print(result[k]);
            }
            System.out.println();
        }
        return new String(result);
    }

    public static void main(String[] args) {
        int a[]=new int[]{2, 5, 2, 8, 5, 6, 8, 8};
        new SortByFrequency().sort(a,a.length);

        String inputs[] = { "IIIDDIID", "IDID", "I", "DD", "II", "DIDI", "IIDDD", "DDIDDIID" };
        System.out.println();
        for(String input : inputs)
        {
            System.out.println(getMinNumberForPattern(input));
        }
    }
}
