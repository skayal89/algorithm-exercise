package coding.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableList {
    public static void main(String[] args) {
        List<Integer> l=new ArrayList<>();
        l.add(10);
        l.add(5);
        l.add(20);
        l.add(35);
        /* must go through the source code.
           static class UnmodifiableList<E> extends UnmodifiableCollection<E>
                                  implements List<E> {
         */
        List<Integer> lu=Collections.unmodifiableList(l); // lu can't be structurally modifiable (add, remove are unsupported)
        l.add(22); // element will also be added to unmodified list by adding to original list.
        System.out.println(l);
        System.out.println(lu);
        lu.add(25); // can't be added
    }
}
