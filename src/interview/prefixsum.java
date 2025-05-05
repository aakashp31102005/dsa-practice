package interview;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.Arrays;
import java.util.HashMap;

public class prefixsum {
    public static void main(String[] args) {
        int[][] matrix=new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrixx nm=new NumMatrixx(matrix);
        nm.sumRegion(2, 1, 4, 3);
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,9}));
        System.out.println("hello world");
    }

    public static int pivotIndex(int[] nums) {
    int[] pivot=new int[nums.length+1];
    for(int i=1;i<pivot.length;i++){
        pivot[i]=pivot[i-1]+nums[i-1];
    }
    for(int i=0;i<pivot.length;i++){
        int left=pivot[i];
        if(i+1<pivot.length) {
            int right = pivot[pivot.length - 1] - pivot[i + 1];
            if(right == left){
                return i;
            }
            }
        }
        return -1;
        }
        public int subarraysDivByK(int[] nums, int k) {
            HashMap<Integer,Integer> hm=new HashMap<>();
            hm.put(0,1);
            int prefix=0;
            int count=0;
            for(int i=0;i<nums.length;i++){
                prefix+=nums[i];
                int mod = ((prefix % k) + k) % k;
                count+=hm.getOrDefault(mod,0);
                hm.put(mod,hm.getOrDefault(mod,0)+1);
            }
            return count;
        }
    }
class NumMatrixx {
    int[][] matrix;

    public NumMatrixx(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        this.matrix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                this.matrix[i][j] = this.matrix[i - 1][j] +
                        this.matrix[i][j - 1] -
                        this.matrix[i - 1][j - 1] +
                        matrix[i - 1][j - 1];
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = this.matrix[row2 + 1][col2 + 1]
                - this.matrix[row2 + 1][col1]
                - this.matrix[row1][col2 + 1]
                + this.matrix[row1][col1];
        return result;
    }
}
