package coding.leetcode.contest;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PathCrossing {
    public boolean isPathCrossing(String path) {
        Set<Point> visited = new HashSet<Point>();
        Point current = new Point(0, 0);
        visited.add(new Point(current.x, current.y));
        for (int i = 0; i < path.length(); i++) {
            current.move(path.charAt(i));
            if (visited.contains(current)) {
                return true;
            }
            visited.add(new Point(current.x, current.y));
        }
        return false;
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(char direction) {
            switch (direction) {
                case 'E':
                    x = x + 1;
                    break;
                case 'W':
                    x = x - 1;
                    break;
                case 'S':
                    y = y + 1;
                    break;
                case 'N':
                    y = y - 1;
                    break;
            }
        }

        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            return p.x == this.x && p.y == this.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
