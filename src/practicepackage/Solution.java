package practicepackage;

import java.util.*;

class NumArray {
    int[] arr;
    public NumArray(int[] nums) {
    this.arr= Arrays.copyOf(nums,nums.length);
    }
    public int sumRange(int left, int right) {
        int sum=0;
        for(int i=left;i<=right;i++){
            sum+=arr[i];
        }
        return sum;
    }

}
public class Solution
{
    public static void main(String[] args) {
//        NumArray nm=new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
//        System.out.println(nm.sumRange(0, 5));
//        NumArrays nms=new NumArrays(new int[]{-2, 0, 3, -5, 2, -1});
//        System.out.println(nms.sumRange(0, 5));
        System.out.println(removeDigit("1341",'3'));
        int a=10;
        String s=Integer.toString(a);
        System.out.println(s);
        largestDivisibleSubset(new int[]{});
    }
    public static String removeDigit(String number, char digit) {
        List<String> al=new ArrayList<>();
            for(int i=0;i<number.length();i++){
                if(number.charAt(i) ==digit) {
                    String left = "";
                    String right = "";
                    left = number.substring(0, i);
                    if (i + 1 <= number.length() - 1) {
                        right = number.substring(i + 1, number.length());
                    }
                    al.add(left + right);
                }
        }
            String max="0";
            for(String element:al){
               if(element.compareTo(max) >0){
                   max=element;
               }
            }
        return max;
    }
    public static void largestDivisibleSubset(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=1+1;j<nums.length;j++){
                held(nums,i,j,new ArrayList<>());
            }
    }}
    public static void held(int[]num,int i,int j,List<Integer> al){
     if(i >=num.length || j >=num.length){
         System.out.println(al);
         return;
     }
     if(num[i] % num[j]==0 || num[j] % num[i]==0){
         al.add(num[i]);
         al.add(num[j]);
         held(num,i+2,j+2,al);
     }
    }
    }

class NumArrays {
    int []num;
    public NumArrays(int[] nums) {
        num=new int[nums.length];
        num[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            num[i]=nums[i]+num[i-1];
        }
        // System.out.println(Arrays.toString(num));
    }

    public int sumRange(int left, int right) {
        if(left==0){
            return num[right];
        }

        return num[right]-num[left-1];
    }
}

