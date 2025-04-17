package interview;

import java.util.ArrayList;
import java.util.Collections;

public class trees {
//    public static void main(String[] args) {
//        System.out.println(minOperations(new int[]{3,2},6));
//    }
//    public static  int minOperations(int[] nums, int k) {
//        ArrayList<Integer> al=new ArrayList<>();
//                for(int i=0;i<nums.length;i++) {
//                    h(nums.clone(), 0, al, i,k);
//                }
//                return Collections.max(al);
//    }
//    public static void h(int[]nums,int count,ArrayList<Integer> al,int index,int target){
//        if(nums[index] == 0){
//            al.add(count);
//            return;
//        }
//        nums[index] -=1;
//        int sum=0;
//        for(int element:nums){
//            sum+=element;
//        }
//        if(sum%target == 0){
//            al.add(count+1);
//        }
//        h(nums,count+1,al,index,target);
//    }
public static void main(String[] args) {
    System.out.println(minOperations(new int[]{3, 2}, 6)); // Expected: 5
}

    public static int minOperations(int[] nums, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            h(nums.clone(), 0, al, i, k);
        }
        return Collections.max(al);
    }

    public static void h(int[] nums, int count, ArrayList<Integer> al, int index, int target) {
        if (nums[index] == 0) {
            al.add(count);
            return;
        }

        nums[index] -= 1;

        int sum = 0;
        for (int element : nums) {
            sum += element;
        }

        if (sum % target == 0) {
            al.add(count + 1); // Add this as a valid option
            // BUT DO NOT RETURN HERE — explore further
        }

        h(nums, count + 1, al, index, target);
    }
}
