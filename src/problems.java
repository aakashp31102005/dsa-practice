import java.util.HashMap;

import com.sun.source.tree.Tree;
import practicepackage.TreeNode;
public class problems {
    public static void main(String[] args) {
        System.out.println(fib(7, new HashMap<>()));
        System.out.println(tabulationfib(5));
        Solution s = new Solution();
        System.out.println(s.climbStairs(10));
       // System.out.println(s.canCross(new int[]{0,1,3,5,6,8,12,17}));
        int[] ar=new int[]{2,3,1,1};
        System.out.println(s.subsetsum(ar,4, ar.length-1,new HashMap<>()));
        TreeNode one=new TreeNode(1);
        one.left=new TreeNode(2);
        TreeNode two=new TreeNode(1);
        two.right=new TreeNode(2);
        System.out.println(s.isSameTree(one,two));
        System.out.println(s.perfectSum(new int[]{5,2,3,3,4,5,5,4,3,2,2,32,4,52,23,2,23,2},5));
        int[] t=new int[]{2,1,1,2};
        System.out.println(s.hrob(t,t.length-1,0,new HashMap<>()));
        System.out.println(s.rob(t));
    }

    public static int fib(int n, HashMap<Integer, Integer> hm) {
        if (n <= 1) {
            return n;
        }
        if (hm.containsKey(n)) {
            return hm.get(n);
        }
        int subvalue = fib(n - 1, hm) + fib(n - 2, hm);
        hm.put(n, subvalue);
        return subvalue;
    }

    public static int tabulationfib(int n) {
        int[] tabulationarray = new int[n + 1];
        tabulationarray[0] = 0;
        tabulationarray[1] = 1;
        for (int i = 2; i <= n; i++) {
            tabulationarray[i] = tabulationarray[i - 1] + tabulationarray[i - 2];
        }
        return tabulationarray[n];
    }
}
    class Solution {
        HashMap<Integer,Integer> hm=new HashMap<>();
        public int climbStairs(int n) {
            if(n<0) return 0;
            if(n<=1) return 1;
            if(hm.containsKey(n)){
                return hm.get(n);
            }
            int left=climbStairs(n-1);
            int right=climbStairs(n-2);
            hm.put(n,left+right);
            return left+right;
        }

        public boolean canCross(int[] stones) {

           return cancrosshelper(stones,1,0 );
        }

        //not working
        public boolean cancrosshelper(int[] stones,int k,int i) {
            if(i == stones.length-1){
                return  true;
            }

            boolean hold=false;
            if (k - 1 == stones[i + 1] - stones[i]) {
               hold= cancrosshelper(stones,k-1,i+1);
            }
            else if (k == stones[i + 1] - stones[i]) {
                hold=cancrosshelper(stones,k,i+1);
            }
            else if(k+1 == stones[i+1]-stones[i]){
                hold=cancrosshelper(stones,k+1,i+1);
            }
            else{
                return  false;
             }
            return hold;
        }


        public static int ninja(int [][] arr,int d,int last){
            if(d ==0){
                int max=0;
                for(int i=0;i<arr[0].length;i++){
                    if(i !=last){
                        if(max<arr[d][i]){
                            max=arr[d][i];
                        }
                    }

                }return max;
            }
            int max=0;
            for(int i=0;i<arr.length;i++){
                if(arr[d][i]!=last){
                    int l=arr[d][i]+ninja(arr,d-1,i);
                    if(max < l)
                        max=l;
                }
            }
            return max;
        }

        public  boolean subsetsum(int[] arr,int target,int index,HashMap<String,Boolean> hm){
            if(target == arr[index]) return true;
            if(index ==0) return false;
            String  s=Integer.toString(target);
            s+=Integer.toString(index);
            if(hm.containsKey(s) ){
                return hm.get(s);
            }
            boolean nottake=subsetsum(arr,target-1,index-1,hm);
            boolean take=subsetsum(arr,target,index-1,hm);
            boolean result=nottake||take;
            hm.put(s,result);
            return result;
        }
        public boolean  isSameTree(TreeNode p,TreeNode q){
            if(p!=null && q!=null && p.val!=q.val){
                return false;
            }
            if( p == null && q == null) return true;
            if(p == null || q== null) return false;
            boolean left = isSameTree(p.left, q.left);
            boolean right = isSameTree(p.right, q.right);
            return left && right;
        }

        public int perfectSum(int[] nums, int target) {
           return hperfectsum(nums, nums.length-1,target,0,new HashMap<>());
        }
        public int hperfectsum(int[] nums,int index,int target,int value,HashMap<String,Integer> hm){
            if (index < 0) {
                if(target==0){
                    return 1;
                }else return  0;
            }
            String key = index + "," + target;
            if (hm.containsKey(key)) {
                return hm.get(key);
            }
            int unpick=hperfectsum(nums,index-1,target,value, hm);
            int pick=hperfectsum(nums,index-1,target-nums[index],value+nums[index],hm);
            hm.put(key,unpick+pick);
            return unpick+pick;
        }
        public int rob(int[] nums) {
            int current=hrob(nums,nums.length-1,0,new HashMap<>());
            int beforecurrent=hrob(nums,nums.length-2,0,new HashMap<>());
            return  Math.max(current,beforecurrent);
        }
        public int hrob(int[] arr,int index,int value,HashMap<String,Integer> hm){
            if(index<0){
                return value;
            }
            String key=index+"-"+value+",";
            if(hm.containsKey(key)){
                return hm.get(key);
            }
            int left=hrob(arr,index-2,value,hm);
            int right=hrob(arr,index-2,value+arr[index],hm);
            int result=Math.max(left,right);
            hm.put(key, result);
            return result;
        }
        private int hrob(int[] arr, int index, HashMap<Integer, Integer> hm) {
            if (index < 0) {
                return 0;
            }


            if (hm.containsKey(index)) {
                return hm.get(index);
            }


            int robThis = arr[index] + hrob(arr, index - 2, hm);
            int skipThis = hrob(arr, index - 1, hm);

            int result = Math.max(robThis, skipThis);
            hm.put(index, result);

            return result;
        }

        //more optimissed
        private int hrobs(int[] arr, int index, HashMap<Integer, Integer> hm) {
            if (index < 0) {
                return 0;
            }


            if (hm.containsKey(index)) {
                return hm.get(index);
            }


            int robThis = arr[index] + hrob(arr, index - 2, hm);
            int skipThis = hrob(arr, index - 1, hm);

            int result = Math.max(robThis, skipThis);
            hm.put(index, result);

            return result;
        }
}



