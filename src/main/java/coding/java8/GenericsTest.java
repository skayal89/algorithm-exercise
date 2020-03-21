package coding.java8;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
    public static void main(String[] args) {
        List<? super Object> l=new ArrayList<>();
        l.add(10);
        l.add("a");

        List<? super Rect> lrs=new ArrayList<>();
        lrs.add(new RectSub());
        lrs.add(new Rect());
//        lrs.add(new Box()); we can't use super class Box

//        can't be use in that way
//        List<? extends Rect> lre=new ArrayList<>();
//        lre.add(new Rect());
//

        List<Rect> rects=new ArrayList<>();
        List<RectSub> rectSubs=new ArrayList<>();
        upperBoundTest(rects);
        upperBoundTest(rectSubs);
    }

    static void upperBoundTest(List<? extends Rect> lre){
        for (Rect r : lre){

        }
    }

    static void lowerBoundTest(List<? super Rect> lre){
        Rect r=(Rect)lre.get(0);
    }

    static class Box{
        int name;
    }

    static class Rect extends Box implements Shape{
        int x;
    }

    static class Round extends Box implements Shape{
        int y;
    }

    static class Ordinary extends Box{
        int z;
    }

    static class RectSub extends Rect{
        int a;
    }

    static interface Shape{

    }
}
