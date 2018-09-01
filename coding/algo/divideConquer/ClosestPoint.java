package coding.algo.divideConquer;

import lombok.AllArgsConstructor;
import java.util.Arrays;

public class ClosestPoint {

    @AllArgsConstructor
    static class Point{
        int x, y;

        @Override
        public String toString() {
            return "(x="+x+", y="+y+")";
        }
    }

    double closest(Point[] p, int n){
        Point px[]=new Point[n], py[]=new Point[n];
        System.arraycopy(p, 0, px, 0, n);
        System.arraycopy(p, 0, py, 0, n);

        Arrays.sort(px, (p1,p2)->p1.x-p2.x);
        Arrays.sort(py, (p1,p2)->p1.y-p2.y);

        System.out.println(Arrays.toString(px));
        System.out.println(Arrays.toString(py));

        return closestUtil(px, 0, n-1, py);
    }

    private double closestUtil(Point[] px, int low, int high, Point py[]){
        int n=high-low+1; // high always be inclusive
        if(n<=3){
            return bruteForce(px, low, high);
        }

        int mid=(low+high)/2; // would always be use for px[mid]. Will encounter OutOfBounds if we use py[mid].
        Point pyl[]=new Point[mid-low+1]; // need to be careful for the size. we should not use n to calculate the size
        Point pyr[]=new Point[high-mid];
        int li=0, ri=0; // pyl and pyr should use different indexes
        for (int i=0;i<n;i++){ // need to consider px[mid] while populating pyl and pyr
            if(py[i].x<=px[mid].x)   pyl[li++]=py[i];
            else pyr[ri++]=py[i]; // populating pyl and pyr in sorted order in O(n) time as py is already sorted
        }

        double dl=closestUtil(px, low, mid, pyl);
        double dr=closestUtil(px, mid+1, high, pyr);
        double d=Math.min(dl,dr);

        Point strip[]=new Point[n]; // at this point, size of strip[] is unknown but max it can be n (i.e high-low+1)
        int j=0; // we will get the size of strip[]
        for (int i = 0; i < n; i++) {
            if(Math.abs(py[i].x-px[mid].x)<=d){ // Careful: need to compare py with px[mid]
                strip[j++]=py[i];
            }
        }
        return Math.min(d, stripClosest(strip, j, d));
    }

    private double stripClosest(Point strip[], int n, double d){
        double minDistance=d;
        for (int i=0;i<n;i++){ // O(n) times because of strip[j].y-strip[i].y<minDistance. See below example.
            for (int j=i+1;j<n && strip[j].y-strip[i].y<minDistance;j++){
                if(distance(strip[i],strip[j])<minDistance){
                    minDistance=distance(strip[i],strip[j]);
                }
            }
        }
        return minDistance;
        /*
        sorted array = {2,4,5,7,9,11,15,19}
        minDiff = 4

        i=0, j=3 i.e a[0]=2, a[3]=7 nad 7-2 > minDiff
        then we need not to compare indexes after j because all values
        after jth index will be greater than minDiff too.
         */
    }

    private double bruteForce(Point[] p, int low, int high){
        double min=Double.MAX_VALUE;

        for(int i=low;i<=high;i++){ // low high must be used. O(n^2)
            for(int j=i+1;j<=high;j++){
                double d=distance(p[i],p[j]);
                if(d<min)   min=d;
            }
        }
        return min;
    }

    private double distance(Point p1, Point p2){
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
    }

    public static void main(String[] args) {
        Point p[] = {
                new Point(2, 3),
                new Point(12, 30),
                new Point(40, 50),
                new Point(6, 2),
                new Point(11, 10),
                new Point(3, 4),
                new Point(4, 3),
                new Point(5, 0),
                new Point(7, 1),
        };

        System.out.println(new ClosestPoint().closest(p, p.length));
    }
}
