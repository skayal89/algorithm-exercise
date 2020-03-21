package coding.ds.array;

public class MatrixSpiralTraversal {
    static void spiralPrint(int[][] a, int m, int n){
        int left=0, right=n-1, up=0, down=m-1;
        while(left<=right && up<=down){
            for(int i=left;i<=right;i++){
                System.out.print(a[up][i]+" ");
            }
            up++;
            for(int i=up;i<=down;i++){
                System.out.print(a[i][right]+" ");
            }
            right--;
            if(up<down) { // without this condition, few elements will be printed twice in a[][]
                for (int i = right; i >= left; i--) {
                    System.out.print(a[down][i] + " ");
                }
                down--;
            }
            if(left<right) { // without this condition, few elements will be printed twice in a[][]
                for (int i = down; i >= up; i--) {
                    System.out.print(a[i][left] + " ");
                }
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int a[][] = { {1,  2,  3,  4,  5,  6}, // not a square matrix
                {7,  8,  9,  10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };
        spiralPrint(a,3,6);

        System.out.println();
        int b[][] = { {1,  2,  3,  4},
                {7,  8,  9,  10},
                {13, 14, 15, 16},
                {5,6,11,12}
        };
        spiralPrint(b,4,4);
    }
}
