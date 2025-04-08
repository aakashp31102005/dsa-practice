import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.util.*;
import  java.lang.*;
public  class temp {
    public static void main(String[] arg) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        temp n = new temp();
        System.out.println(n.largestValues(root));
        List<Integer> rr = new ArrayList<>();
        rr.add(2);
        rr.add(4);
        rr.add(1);
        Optional<Integer> l = rr.stream().max(Comparator.comparingInt(a -> a));
        System.out.println(l);
        System.out.println(numOfUnplacedFruits(new int[]{}, new int[]{3, 5, 4}));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(2);
        pq.add(4);
        System.out.println(pq);
        System.out.println(Arrays.toString(findMaxSum(new int[]{4, 2, 1, 5, 3}, new int[]{10, 20, 30, 40, 50}, 2)));
        letterCombinations();
        List<List<Integer>> ll = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        al.add(3);
        ll.add(al);
        System.out.println(ll);
        combine(4, 2);
        System.out.println(letterCombinations());
        int[]nu={1,2,3};
        System.out.println(permute(nu));
        //combinationSum(new int[]{2,3,5},8);

        boolean[][] arr={{false,false,false},{true,false,false},{false,false,false}};
        System.out.println(isvalid(arr,0,0));


    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ar = new ArrayList<>();
        if (root == null) return ar;
        Queue<TreeNode> p = new LinkedList<>();
        p.add(root);
        while (!p.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = p.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = p.poll();
                max = Math.max(max, node.val);
                if (node.left != null) p.add(node.left);
                if (node.right != null) p.add(node.right);
            }
            ar.add(max);
        }
        return ar;
    }

    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean noplace = false;
        int count = 0;
        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < baskets.length; j++) {
                if (baskets[j] >= fruits[i]) {
                    baskets[j] = fruits[i] - baskets[j];
                    break;
                }
                if (j == baskets.length - 1) {
                    count++;
                }
            }
        }
        return count;
    }

    //TIME LIMIT EXCEED ERROR
    public static long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long[] temp = new long[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if (nums1[j] < nums1[i]) {
                    pq.add(nums2[j]);
                }
            }
            int sum = 0;
            for (int l = 0; l < k; l++) {
                if (!pq.isEmpty())
                    sum += pq.poll();
            }
            temp[i] = sum;
            pq.clear();
        }
        return temp;
    }


    public static List<String> letterCombinations() {
        HashMap<Integer, char[]> hm = new HashMap<>();
        hm.put(2, "abc".toCharArray());
        hm.put(3, "def".toCharArray());
        hm.put(4, "ghi".toCharArray());
        hm.put(5, "jkl".toCharArray());
        hm.put(6, "mno".toCharArray());
        hm.put(7, "pqrs".toCharArray());
        hm.put(8, "tuv".toCharArray());
        hm.put(9, "wxyz".toCharArray());
        return combination(hm, "2", 0, "", new ArrayList<>());

    }

    public static List<String> combination(HashMap<Integer, char[]> hm, String input, int start, String result, ArrayList<String> al) {
        if (result.length() == input.length()) {
            al.add(result);
            return al;
        }
        char[] arr = hm.get(Character.getNumericValue(input.charAt(start)));
        for (int i = 0; i < arr.length; i++) {
            combination(hm, input, start + 1, result + arr[i], al);
        }
        return al;
    }


    public static void combine(int n, int k) {
        List<List<Integer>> ll = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(he(arr, 0, 0, k, ll));
    }

    public static List<List<Integer>> he(int[] arr, int start, int result, int k, List<List<Integer>> ll) {
        String te = String.valueOf(result);
        if (te.length() == k) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(result);
            ll.add(al);
            return ll;
        }
        for (int i = start; i < arr.length; i++) {
            int temp = (start * 10) + arr[i];
            he(arr, i + 1, temp, k, ll);
        }
        return ll;
    }

    public static  List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int element : nums) list.add(element);
        ArrayList<Integer> unp = new ArrayList<>();
        return  helperforpurmutation(unp, list,new ArrayList<>());
    }

    public static List<List<Integer>> helperforpurmutation(ArrayList<Integer> unp, ArrayList<Integer> proc, List<List<Integer>> al) {
        if (proc.size() == 0) {
            al.add(new ArrayList<>(unp));
            return al;
        }
        for (int i = 0; i < proc.size(); i++) {
            int hold = proc.remove(i);
            unp.add(hold);
            helperforpurmutation(unp, proc, al);
            unp.remove(unp.size()-1);
            proc.add(i,hold);
        }
        return al;

    }
//    public static void combinationSum(int[] candidates, int target) {
//    HashSet<Integer> hs=new HashSet<>();
//    hcombinationsum(hs,candidates,target,0,new ArrayList<>(),new ArrayList<>());
//    }
//    public static void hcombinationsum(HashSet<Integer> hs,int[] arr,int target,int start,List<List<Integer>> result,List<Integer> temp){
//        if(target ==0 ) {
//            hs.add(start);
//                result.add(new ArrayList<>(temp));
//                return;
//        }
//
//        if(target <0) {
//            return;
//        }
//    if(!hs.isEmpty() && hs.contains(start)){
//        return;
//    }
//        for(int i=0;i<arr.length;i++){
//            temp.add(arr[i]);
//            hcombinationsum(hs,arr,target-arr[i],arr[i],result,temp);
//            temp.remove(result.size()-1);
//        }
//    }

//    public List<List<String>> solveNQueens(int n) {
//        boolean [] [] matrix=new boolean[n][n];
//        return  solveNqueen(matrix,0,0);
//    }
//    public void solvenqueen(boolean[][]matrix,int row,int col {
//        if(!isvalid(matrix,row,col)){
//            return;
//        }
//        for(int i=0;i<matrix.length;i++){
//            for(int j=0;j<matrix[0].length;j++){
//                path(matrix,row,col);
//                solvenqueen(matrix,i,j);
//            }
//        }
//    }
    public static boolean isvalid(boolean[][] matrix,int row,int col){
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        // Boundary and obstacle check
        if (row < 0 || col < 0 || row >= rowLen || col >= colLen || matrix[row][col]) {
            return false;
        }

        // Movement directions: Left, Right, Up, Down, Bottom-Right Diagonal
        int[] dy = {0, 0, -1, 1, 1};
        int[] dx = {-1, 1, 0, 0, 1};

        for (int j = 0; j < dy.length; j++) {
            int newRow = row - dy[j];
            int newCol = col - dx[j];

            if (newRow >= 0 && newCol >= 0 && newRow < rowLen && newCol < colLen) {
                if (!isvalid(matrix, newRow, newCol)) {
                    return false; // If any recursive call returns false, return false
                }
            }
        }

        return true;
    }
}
class TreeNode  {
     int val;
      TreeNode left;
      TreeNode right;TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }