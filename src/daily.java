import jdk.jshell.execution.JdiDefaultExecutionControl;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class daily {
    public static int[] pivotArray(int[] nums, int pivot) {
        Queue<Integer> s1 = new LinkedList<>();
        Queue<Integer> s2 = new LinkedList<>();
        Queue<Integer> s3 = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                s1.add(nums[i]);
            } else if (nums[i] > pivot) {
                s2.add(nums[i]);
            } else {
                s3.add(nums[i]);
            }
        }
        int[] temp = new int[nums.length];
        int i = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || !s3.isEmpty()) {
            if (!s1.isEmpty()) {
                temp[i] = s1.poll();
            } else if (!s3.isEmpty()) {
                temp[i] = s3.poll();
            } else {
                temp[i] = s2.poll();
            }
            i++;
        }
        return temp;
    }

    static class obj {
        int value;
        boolean color;

        obj(int value, boolean color) {
            this.value = value;
            this.color = color;
        }
    }

    static boolean[] visited;
    static int i = 0;

    public static boolean isBipartite(int[][] graph) {
        visited = new boolean[graph.length];
        boolean[] arr = new boolean[graph.length];
        helperforb(arr, 0, graph);
        for (int i = 1; i < arr.length; i++) {
            for (int neighbor : graph[i]) {
                if (arr[i] == arr[neighbor]) {
                    return false; // Adjacent nodes should not have the same color
                }
            }
        }
        return true;
    }

    public static void helperforb(boolean[] arr, int start, int[][] graph) {
        Queue<obj> q = new LinkedList<>();
        q.add(new obj(start, true));
        arr[start] = true;
        visited[start] = true; // Mark start as visited

        while (!q.isEmpty()) {
            obj v = q.poll();
            int node = v.value;
            boolean color = v.color;

            visited[node] = color; // Store the color of the node

            for (int neighbor : graph[node]) { // Corrected iteration
                if (!visited[neighbor]) {
                    q.add(new obj(neighbor, !color)); // Flip color for next node
                    arr[neighbor] = !color;
                    visited[neighbor] = true; // Mark as visited
                }
            }
        }
    }

//    public static void helperforb(boolean[] arr,int start,int[][]graph) {
//        Queue<obj> q = new LinkedList<>();
//        q.add(new obj(start, true));
//        arr[start] = true;
//        while (!q.isEmpty()) {
//            obj v = q.poll();
//            visited[i]=v.color;
//            for (int i = 0; i < graph[v.value].length; i++) {
//                if (!arr[graph[v.value][i]]) {
//                    q.add(new obj(graph[v.value][i], !v.color));
//                    arr[graph[v.value][i]] = true;
//                }
//            }
//        }
//
//    }

    public static int lengthOfLIS(int[] arr) {
        return h(arr, 0, Integer.MIN_VALUE);
    }

    public static int h(int[] arr, int index, int pre) {
        if (index >= arr.length) {
            return 0;
        }
        int left = h(arr, index + 1, pre);
        int right = 0;
        if (arr[index] > pre) {
            right = 1 + h(arr, index + 1, arr[index]);
        }
        return Math.max(left, right);
    }

    public static int h(int[] arr, int index, ArrayList<Integer> al, int pre) {
        if (index >= arr.length) {
            return al.size();
        }
        int left = h(arr, index + 1, al, pre);
        int right = 0;
        if (arr[index] > pre) {
            al.add(arr[index]);
            right = h(arr, index + 1, al, arr[index]);
            al.removeLast();
        }

        return Math.max(left, right);
    }

    public static int maxProfit(int[] prices) {
        int sell = 0;
        int buy = Integer.MAX_VALUE;
        int hold = 0;
        for (int i = 0; i < prices.length; i++) {

            //OVER THINKED APPROACH NOT WORKED FOR 20% CASES
//        if (prices[i] < buy) {
//            buy = prices[i];
//        } else if (prices[i] > buy && prices[i] > sell && i<prices.length-1) {
//            sell = prices[i];
//        }else if(i == prices.length-1 &&  prices[i]>sell){
//            hold+=prices[i]-buy;
//        }
//        else if (prices[i]<sell){
//            hold+=sell-buy;
//            buy=prices[i];
//            sell=0;
//        }
//

            //SIMPLE AND WORK IN ALL CASES
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] > buy) {
                hold += prices[i] - buy;
                buy = prices[i];
            }
        }
        return hold;
    }
//
//    public static boolean canJump(int[] nums) {
//        int balance=nums[0];
//        int distance=1;
//        for(int i=1;i<nums.length;i++){
//            if(nums[i]<balance && balance!=0 || nums[i]==nums[i-1]){
//                if(nums[i] !=nums[i-1]){
//                    balance=nums[i];
//                }
//                distance++;
//            }else if (nums[i]>balance && balance!=0 ){
//                balance=nums[i];
//                distance++;
//            }
//        }
//        return distance == nums.length;
//    }

    public static boolean canJump(int[] nums) {
        int i = 0;
        int step = nums[0];
        int distance = 1;
        while (i < nums.length && step != 0) {
            step = nums[i];
            i += step;

        }
        return i >= nums.length - 1;
    }


    public static void main(String[] args) {
        int[] arr = {-3, 4, 3, 2};
        System.out.println(Arrays.toString(pivotArray(arr, 2)));
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(maxProfit(new int[]{7, 5, 3, 2}));
        System.out.println(canJump(new int[]{2, 1, 0, 0}));
        System.out.println(canJump(new int[]{2, 5, 0, 0}));
        Solutions s = new Solutions();
        s.removeDuplicates(new int[]{0,0,1,1,1,1,2,2,2,3,3});
        System.out.println(s.canJump(new int[]{3,2,2,1,3,3,0}));
    }
}

class Solutions {
    public void removeDuplicates(int[] nums) {
        int n = nums.length;
//        if(n<=2){
//            return n;
//        }

        int j = 2;
        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public  boolean canJump(int[] nums) {
        int i = 0;
        int k = 0;
        while (i < nums.length) {
            int e = nums[i];
            int max = Integer.MIN_VALUE;
            int j = i + 1;
            while (e != 0) {
                if (nums[j] > max) {
                    max = nums[j];
                    j++;
                }e--;
            }

            i = j;
        }
        return i == nums.length;
    }
}
//    class RandomizedSet {
//        HashMap<Integer,Integer>;
//        public RandomizedSet() {
//
//        }
//
//       public int  hashfunction(int value){
//
//       }
//        public boolean insert(int val) {
//
//        }
//
//        public boolean remove(int val) {
//
//        }
//
//        public int getRandom() {
//
//        }
//    }
//}

