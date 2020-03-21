package coding.java8;

public class StringPoolTest {

    public static void main(String[] args) {
        String a="hi"; // in string pool
        String b="hi"; // in string pool
        System.out.println(a==b); // a and b both points to same object in string pool
        String c=new String("hi"); // different object will be created
        System.out.println(a==c); // a is referring to string pool but c is not
        /*
         * When the intern method is invoked, if the pool already contains a
         * string equal to this {@code String} object as determined by
         * the {@link #equals(Object)} method, then the string from the pool is
         * returned. Otherwise, this {@code String} object is added to the
         * pool and a reference to this {@code String} object is returned.
         */
        c = c.intern();
        System.out.println(a==c); // returns true now
    }
}
