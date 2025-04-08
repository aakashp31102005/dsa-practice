package interview;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class arrayandString {

    public static void main(String[] args) {
        String str = "  hello  world moro";
        String s = " ";
        int i = 0;
        String temp="";
       List<String> al=new ArrayList<>();
        while (i < str.length()) {
            while (Character.toString(str.charAt(i)).hashCode() == s.hashCode()) {
                i++;
                if (!temp.equals("")) {
                    al.addFirst(temp);
                    temp = "";
                }
            }
            temp+=str.charAt(i);
            i++;
            }
            al.addFirst(temp);
            String result="";
            for(String element:al){
                result+=element+" ";
            }
            System.out.println(result);
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));

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
  
}
