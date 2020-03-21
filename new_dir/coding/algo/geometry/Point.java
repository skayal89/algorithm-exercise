package coding.algo.geometry;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Point {
    int x, y;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
