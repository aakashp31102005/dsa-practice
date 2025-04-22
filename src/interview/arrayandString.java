package interview;

import java.lang.reflect.Array;
import java.util.*;
import  java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**static{
    for(int i = 0; i < 500; i++){
        maxArea(new int[]{0,0});
    }
}
 The static block calling maxArea 500 times is a performance hack to:
 Trigger JIT compilation,
 Warm up the JVM,
 Make your solution run faster on LeetCode.
 It’s useful when:
 You're running against tight time limits (like LeetCode's performance-based scoring).
 The function has complex logic and is called frequently.
 You want to get the most accurate runtime in Java compared to faster languages like C++.*/

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

        //---------------------------swap neighbors------------------------------------------------//
        inplaceswap("abcdef");
       //------------------------------swap by ascii code------------------------------------------//
        asciiswap("acdfeg");

        //-----------------------------return k'th largest element in array---------------------------//
        System.out.println(kthLargestNumber(new String[]{"2","21","12","1"},3));

        //------------------------------left rotate an array by one-----------------------------------//
        rotateArray(new int[]{5,7,3,2},4);

        //-----------------------------move zeros to end------------------------------------------------//
        int[] snarray=new int[]{1, 2, 3, 0, 0};
        System.out.println(Arrays.toString(snarray));
        moveZeroes(snarray);
        System.out.println(Arrays.toString(snarray));


        //----------------------------INTERSECTION OF SORTED ARRAY--------------------------//
        ArrayList<Integer> al=new ArrayList<>();
        al.add(1);
        al.add(43);
        al.add(55);
        int target=Collections.binarySearch(al,0);
        System.out.println(target);
       findArrayIntersection(new ArrayList<>(Arrays.asList(1,2,2,3,4)),5,new ArrayList<>(Arrays.asList(1,2,2)),3);
        //--------------------union of two array--------------------------//
        union(new ArrayList<>(Arrays.asList(5,6)),new ArrayList<>(Arrays.asList(7,8)));

        //-------------------------missing number-------------------------//
        System.out.println(missingNumber(new int[]{0,1}));

        //----------------------------consecutive ones--------------------------//
        System.out.println(findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));

        //--------------------------------2sum in o(n)-------------------------//
        System.out.println(Arrays.toString(twoSum(new int[]{-1,0},-1)));

        //-----------------------------valid palindrome------------------------//
        isPalindrome("a,b;c;c'b'a");
                                      //valid palidrome 2//
        validPalindrome("zryxeededexyz");
        //--------------------container with max water---------------------------//
            maxArea(new int[]{1,1});
    //---------------------squares of sorted array----------------------------//
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11})));
        //-------------------remove duplicates(fast and slow pointer)-----------------------//
        removeDuplicates(new int[]{1,1,2});
    //----------------------------------Max Sum Subarray of size K------------------------//
    System.out.println(maximumSumSubarray(new int[]{100,200,300,400},2));

    //----------------------------------min lenght of subbarray of sum equal to target-----------------------//
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    //---------------------------------------max avg sum within k----------------------------------//
        System.out.println(findMaxAverage(new int[]{4,2,1,3,3},2));
        double a= (double) 1 /2;
        System.out.println(a);
    //-------------------- checking k consecutive one and zeros---------------------------//
        System.out.println(kconsecutive1s0s("000000000000000000100111101011000", 5));
    //------------------------------------ Check If a String Contains All Binary Codes of Size K---/
        System.out.println(hasAllCodes("0110",2));
    //---------------------------longest ones---------------------------------//
        System.out.println(longestOnes(new int[]{0,0,0,1},4));
    //-----------------checkInclusion-----------------------------//
        System.out.println(isPermutation("abc","bca"));

        System.out.println(maxSatisfied(new int[]{1},new int[]{0},1));

    }


    public static  int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int base=0;
            for(int i=0;i<grumpy.length;i++){
                if(grumpy[i] != 1){
                    base+=customers[i];
                }
            }
            int recovery=Integer.MIN_VALUE;
           for(int i=0;i<=grumpy.length-minutes;i++){
               int wsum=0;
               for(int j=i;j<i+minutes;j++){
                   if(grumpy[j] == 1){
                       wsum+=customers[j];
                   }
               }
               recovery=Math.max(wsum,recovery);
           }
           return recovery+base;
    }
    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] freq = new int[26]; // Only for lowercase letters

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
    }

    public static int longestOnes(int[] nums, int k) {
            int len=0;
            int tempk=k;
            int i=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j] == 0){
                    tempk--;
                }
                if(tempk<0 || nums.length==k){
                    int wlen;
                    if(nums.length==k){
                        wlen=j-i+1;
                    }else wlen=j-i;
                    len=Math.max(wlen,len);
                }
                while(tempk <0){
                    if(nums[i] == 0){
                        tempk++;
                    }
                    i++;
                }
            }
            return len;
    }
    public static  boolean hasAllCodes(String s, int k) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<=s.length()-k;i++){
            String temp=s.substring(i,i+k);
            if(!set.contains(temp)){
                set.add(temp);
            }
        }
        if (set.size()==Math.pow(2,k)){
            return true;
        }return false;
    }

    public static  boolean kconsecutive1s0s(String s, int k) {
            int zp=1;
            int op=1;
            for(int i=1;i<s.length();i++){
                if(s.charAt(i)==s.charAt(i-1)){
                    if(zp!=k && s.charAt(i)=='0'){
                        zp++;
                    }else if(op !=k && s.charAt(i)=='1'){
                        op++;
                    }
                }else{
                    if(s.charAt(i)=='0' && zp!=k){
                        zp=1;
                    }else if(s.charAt(i)=='1' && op!=k){
                        op=1;
                    }
                }
            }
            if(zp == k && op ==k){
                return true;
            }return false;
    }

    public static double findMaxAverage(int[] nums, int k) {
            int left=0;
            double ravg;
            int rsum=0;
            for(int i=0;i<k;i++){
                rsum+=nums[i];
            }
            ravg=(double) rsum/k;
            for(int right=k;right<nums.length;right++){
                int wsum=rsum+nums[right]-nums[left];
                left++;
                double wavg=(double) wsum/k;
                ravg=Math.max(wavg,ravg);
                rsum=wsum;
            }
            return ravg;
    }
        public static int minSubArrayLen(int target, int[] nums) {
            int left = 0;
            int track = target;
            int minlen = Integer.MAX_VALUE;

            for (int right = 0; right < nums.length; right++) {
                track -= nums[right];
                while (track <= 0) {
                    int windowlen = right - left + 1;
                    minlen = Math.min(minlen, windowlen);
                    track += nums[left];
                    left++;
                }
            }
            return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
    public static int maximumSumSubarray(int[] arr, int k) {
        //normal 2 loop bruteforce or navie solution o(n*k)
//        int max=Integer.MIN_VALUE;
//        for(int i=0;i<=arr.length-k;i++){
//            int sum=0;
//            for(int j=i;j<k+i;j++){
//                sum+=arr[j];
//            }
//            max=Math.max(max,sum);
//        }
//        sliding window o(n)
//step1:check the problems question satisfies sw condtion that is it require contigous block
//step2:which pattern in sliding window :fixed size
//step3:type of subpatter:sum,max,min,frequence,distinct:sum
//step4:reference variable
//step5:updatte reference variable value with running window value
        int rv=0;
        for(int i=0;i<k;i++){
            rv+=arr[i];
        }
        int windowsum=rv;
        for(int i=1;i<=arr.length-k;i++){
            windowsum=windowsum-arr[i-1]+arr[k+i-1];
            //update reference variable with computed window value
            rv=Math.max(windowsum,rv);
        }
        return  rv;
}


    public static int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
            nums[k++] = nums[i];
        }

        return k;
    }
    public static  int[] sortedSquares(int[] nums){
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        int[] temp=new int[nums.length];
        int j=temp.length-1;
        int i=0;
        int k=temp.length-1;
        while(i<temp.length && j>=0 && k>=0){
            if(nums[i]<nums[j]){
                temp[k]=nums[j];
                j--;
            }else{
                temp[k]=nums[i];
                i++;
            }
            k--;
        }
        return temp;
    }
    public static int maxArea(int[] height) {
        int n=height.length;
        int l=0;
        int r=n-1;
        int maxc=0;
        while(l!=r){
            int minh=Math.min(height[l],height[r]);
            int breadth=r-l;
            int capacity=breadth*minh;
            maxc=Math.max(maxc,capacity);
            if(minh==height[l]){
                l++;
            }else{
                r--;
            }
        }
        return maxc;
    }
    public static  boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                // try skipping left or right character
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private static  boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void isPalindrome(String s) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
        Matcher matcher = pattern.matcher(s);
        List<String> all=new ArrayList<>();
        while(matcher.find()){
            all.add(matcher.group());
        }
        String tem=String.join("",all).toLowerCase();
        int len=tem.length();
        boolean result=true;
        for(int i=0,j=tem.length()-1;i<=len/2 && j>=len/2;i++,j--){
            if(tem.charAt(i) == tem.charAt(j)){
                result=true;
            }else{
                result=false;
                break;
            }
        }
        System.out.println(result);
        System.out.println(tem);
    }
    public static  int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> hm=new HashMap<>();
            ArrayList<Integer> al=new ArrayList<>(2);
            int[] array=new int[2];
            for(int i=0;i<nums.length;i++){
                if(hm.containsKey(nums[i])){
                    //al.add(hm.get(nums[i]));
                    array[0]=hm.get(nums[i]);
                    //al.add(i+1);
                    array[1]=i+1;
                    break;
                }int complement=target-nums[i];
                hm.put(complement,i+1);
            }
            return array;
    }

    public static  int findMaxConsecutiveOnes(int[] nums) {
        int result=0;
        ArrayList<Integer> al=new ArrayList<>();
        for(int element:nums){
            if(element == 1){
                result++;
            }else {
                al.add(result);
                result=0;
            }
        }al.add(result);
        return Collections.max(al);
    }

    public static  int missingNumber(int[] nums) {
            int sum1=0;
            ArrayList<Integer> al=new ArrayList<>();
            for(int i=1;i<=nums.length;i++){
                sum1+=i;
            }
            int sum2=0;
            for(int element:nums){
                sum2+= element;
            }
            return sum1-sum2;
    }
    public static void union(ArrayList<Integer> al1,ArrayList<Integer> al2){
        Set<Integer> s = new HashSet<>(al1);
        for(Integer el:al2){
            if(!s.contains(el)){
                s.add(el);
            }
        }
        System.out.println(s);
    }



    public static void findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m)
    {
        Set<Integer> s=new HashSet<>(arr2);
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(s.contains(arr1.get(i))){
                result.add(arr1.get(i));
            }
        }
        System.out.println(result);
    }

    public static void moveZeroes(int[] nums) {
                int i=0;
                int j=0;
                while(i<nums.length && j<nums.length){
                    if(nums[i]==0) {
                        if (j+1 <nums.length && nums[j + 1] == 0) {
                            j++;
                        } else if (j+1 <nums.length && nums[j + 1] != 0) {
                            nums[i] = nums[j + 1];
                            nums[j + 1] = 0;
                            j++;
                            i++;
                        }else{
                            i++;
                        }
                    }else{
                        i++;
                        j++;
                    }
                }

//more optimised
// public static void moveZeroes(int[] nums) {
//            int k=0;
//            for(int i=0; i<nums.length; i++){
//                if(nums[i]!=0){
//                    int t=nums[i];
//                    nums[i]=nums[k];
//                    nums[k]=t;
//                    k++;
//                }
//            }
//        }
    }

    static int[] rotateArray(int[] arr, int n) {
                for(int i=1;i<n;i++){
                    int temp=arr[i-1];
                    arr[i-1]=arr[i];
                    arr[i]=temp;
                }
                return  arr;
    }

    public static String kthLargestNumber(String[] nums, int k) {
            BigInteger[] arr = new BigInteger[nums.length];
            for(int i=0;i<arr.length;i++){
                arr[i]=new BigInteger(nums[i]);
            }
            Arrays.sort(arr);
            BigInteger result= arr[arr.length-k];
            return result.toString();

//        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
//            if (b.length() != a.length()) {
//                return b.length() - a.length(); // longer string = larger number
//            } else {
//                return b.compareTo(a); // if equal length, compare lexicographically
//            }
//        });
//        pq.add("1");
//        pq.add("999");
//        pq.add("1982");
//        pq.add("0");
//        pq.add("8");
//        while (!pq.isEmpty()) {
//            System.out.println(pq.poll()); // descending order: 1982, 999, 8, 1, 0
//        }
        }


        public  static  void asciiswap(String str){
        char [] a=str.toCharArray();
        for(int i=1;i<a.length;i++){
            if(Character.toString(a[i]).hashCode()-Character.toString(a[i-1]).hashCode()==2 ||
                    Character.toString(a[i]).hashCode()-Character.toString(a[i-1]).hashCode()==-2){
                char te=a[i];
                a[i]=a[i-1];
                a[i-1]=te;
            }
        }
        str=new String(a);
        System.out.println(str);
        }


        public static void inplaceswap(String str) {
            char[] arr = str.toCharArray();
            for (int i = 1; i < arr.length; i += 2) {
                char temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
            // from this we can convert character array to string by creating object for string
            System.out.println(new String(arr));
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

