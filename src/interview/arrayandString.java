package interview;

import javax.swing.plaf.IconUIResource;
import java.sql.SQLOutput;
import java.util.*;

public class arrayandString {

    public static void main(String[] args) {
        String str = "  hello world  ";
        System.out.println(str.trim());
        //---------------------------pivot index---------------------------------//
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
        maxklensumsubarray();

        //------------------------------------------sumregion------------------------//
        NumMatrix nm=new NumMatrix(new int[][]{{3, 0, 1, 4, 2},{5, 6, 3, 2, 1}
        ,{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}});
        nm.sumRegion(2, 1, 4, 3);

        //------------------------max-count in matrix-----------------------------------//
        System.out.println(nm.maxCount(3,3,new int[][]{{2,2},{3,3}}));

        //-------------------------reverse words in string without split and trim functions---------------------//
        System.out.println(reverseWords(str));

        //---------------------------find length of last words--------------------------------//
        String var1="   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(var1));

        }

        public static void reverseneighbor(){

        }
    public static String reverseWords(String s) {
        String ss = " ";
        int i = 0;
        String temp = "";
        List<String> al=new ArrayList<>();
        while (i < s.length()) {
            while (i<s.length() && Character.toString(s.charAt(i)).hashCode() == ss.hashCode()) {
                i++;
                if (!temp.equals("")) {
                    al.addFirst(temp);
                    temp = "";
                }
            }
            if(i< s.length()) {
                temp += s.charAt(i);
            }
            i++;
        }
        if(!temp.isEmpty()) al.addFirst(temp);
        String result="";
        int index=0;
        for(String element:al){
            if(index<al.size()-1) {
                result += element + " ";
            }
            index++;
        }
        result+=al.get(index-1);
        return result;
    }

    public static int lengthOfLastWord(String s) {
            String result=s.trim();
            int count=0;
            for(int i=result.length()-1;i>=0;i--){
                if(!Character.toString(result.charAt(i)).equals(" ")){
                    count++;
                }else if(count != 0){
                    break;
                }
            }
            return count;
    }
    public static int pivotIndex(int[] nums) {

            List<Integer> left=new ArrayList<>();
            int leftval=0;
            left.add(leftval);
            leftval=nums[0];
            for(int i=1;i<nums.length;i++){
                left.add(leftval);
                leftval+=nums[i];
            }

            int right=0;
            List<Integer> al=new ArrayList<>();
            al.add(right);
            right=nums[nums.length-1];
            for(int i=nums.length-2;i>=0;i--){
                al.add(right);
                right+=nums[i];
            }

        Collections.reverse(al);
        System.out.println(al);
        System.out.println(left);
        for(int i=0;i<nums.length;i++){
            if(al.get(i).equals(left.get(i))) return i;
        }
        return -1;
    }
    public static void maxklensumsubarray() {
        int k = 3;
        int[] arr = new int[]{100, 200, 300, 400};
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;

        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        System.out.println(maxSum);

    }
    }
class NumMatrix {
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        int i=col1;
        int j=row1;
        while( j<=row2){
            if(i<=col2){
                sum+=matrix[j][i];
                i++;
            }else if(j<=row2 && i>col2){
                j++;
                i=col1;
            }
        }
        return sum ;
    }
    public int maxCount(int m, int n, int[][] ops) {
        int x=ops[0][1];
        int y=ops[0][1];
        for(int i=0;i<ops.length;i++){
            x=Math.min(ops[i][0],x);
            y=Math.min(ops[i][1],y);
        }
        return  x*y;
    }
}

