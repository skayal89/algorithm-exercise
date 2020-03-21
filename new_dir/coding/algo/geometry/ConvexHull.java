package coding.algo.geometry;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/*
 * Graham's Scan implementation
 * https://www.geeksforgeeks.org/convex-hull-set-2-graham-scan/
 */
public class ConvexHull {

    void grahamScan(Point[] p, int n){
        // find the bottom-most point and swap it with 0th index
        for (int i = 1; i < n; i++) {
            if(p[0].y>p[i].y){
                Point t=p[0];
                p[0]=p[i];
                p[i]=t;
            }
        }

        Arrays.sort(p, 1, n, new PointComparator(p[0])); // sort from index 1 onwards
        System.out.println(Arrays.toString(p));

        // remove the point which has the same polar angle with p0
        // we only keep the furthest one
        int j=1; // new length of sorted points after removing the points has the same angle
        for (int i = 1; i < n; i++) {
            while (i<n-1 && getOrientation(p[0],p[i],p[i+1])==Orientation.COLINEAR){
                i++;
            }
            p[j++]=p[i];
        }

        // Convex Hull is not possible if size of the array is < 3
        if(j<3) return;

        ExtendedStack<Point> stack=new ExtendedStack<>();
        // first 2 points of sorted array will always be in convex hull
        stack.push(p[0]);
        stack.push(p[1]);
        stack.push(p[2]);

        // start including remaining points to convex hull
        int i=3;
        while (i<j && !stack.empty()){
            Point curr= stack.peek(); // as next-to-top is inaccessible in built-in stack class, we pop it.
            Point prev= stack.nextToTop(); // next-to-top method added by extending the built-in stack
            Point next=p[i];
            if(getOrientation(prev,curr,next)!=Orientation.COUNTER_CLOCKWISE){
                stack.pop(); // curr element can't be considered
            }
            stack.push(next);
            i++;
        }

        // all points of stack are part of convex hull
        while (!stack.empty()){
            System.out.print(stack.pop()+", ");
        }
    }

    /*
     * Comparator to sort in counterclockwise order
     */
    class PointComparator implements Comparator<Point> {

        Point p0;

        PointComparator(Point p0){
            this.p0 = p0;
        }

        @Override
        public int compare(Point p1, Point p2) {
            Orientation orientation=getOrientation(p0, p1, p2); // get the orientation of p0-p1-p2
            if(orientation==Orientation.COLINEAR){ // If two or more points make same angle with p0, keep the farthest point at the end
                return distSquare(p0,p2) >= distSquare(p0,p1) ? -1 : 1; // if p2 is already far from p0 then no need to swap
            }
            return orientation==Orientation.COUNTER_CLOCKWISE ? -1 : 1; // if angle is clockwise then we need to swap
        }
    }

    Orientation getOrientation(Point p1, Point p2, Point p3){
        int k = (p2.y-p1.y)*(p3.x-p2.x)-(p3.y-p2.y)*(p2.x-p1.x);
        return k==0 ? Orientation.COLINEAR : (k>0 ? Orientation.CLOCKWISE : Orientation.COUNTER_CLOCKWISE);
    }

    int distSquare(Point p1, Point p2){
        return (p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y);
    }

    public static void main(String[] args) {
        Point points[] = {
                new Point(0, 3),
                new Point(1, 1),
                new Point(2, 2),
                new Point(4, 4),
                new Point(0, 0),
                new Point(1, 2),
                new Point(3, 1),
                new Point(3, 3)
        };
        new ConvexHull().grahamScan(points, points.length);
    }
}
