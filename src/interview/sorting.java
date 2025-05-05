package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sorting {
    public static void main(String[] args) {
        int[] arr1=new int[]{5,4,3,2};
        bubble(arr1);
        System.out.println(Arrays.toString(arr1));
        int [] arr2=new int[]{2,1,4,3,5};
        selection(arr2);
        System.out.println(Arrays.toString(arr2));
        int [] arr3=new int[]{4,2,1,3,2,5};
        insertion(arr3);
        System.out.println(Arrays.toString(arr3));
        int [] arr4=new int[]{3, 1, 5, 4, 2};//[1-n]
        int [] arr5=new int[]{4, 0, 2, 1, 3};//[0ton-1]
        cyclic(arr4);
        System.out.println(Arrays.toString(arr4));
        cyclic0to(arr5);
        System.out.println(Arrays.toString(arr5));
        //-----------------merge sort-------------------//
        int[] arr6=new int[]{38, 27, 43, 3, 9, 82, 10};
        merge(arr6,0,arr6.length-1);
        System.out.println(Arrays.toString(arr6));
        int[] arr7=new int[]{38, 27, 43, 3, 9, 82, 10};
        quicksort(arr7,0,arr7.length-1);
        System.out.println(Arrays.toString(arr7));
        countsort(new int[]{6,1,4,2,3,2});
        System.out.println( threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2},0));
        //-----------------1122. Relative Sort Array--------------------//
        System.out.println(Arrays.toString(relativeSortArray(new int[]{28,6,22,8,44,17},new int[]{22,28,8,6})));
        //---------------------922. Sort Array By Parity II------------------//
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{2,0,3,4,1,3})));
        //----------------1329. Sort the Matrix Diagonally---------------------//
        System.out.println(Arrays.deepToString(diagonalSort(new int[][] {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        })));
    }
    
    // beding
    public static int[][] diagonalSort(int[][] mat) {
        int startrow=mat.length-1;
        int startcol=0;
        for(int i=0;i<mat.length*mat[0].length;i++){
            int temprow=startrow;
            int tempcol=startcol;
            while(temprow<mat.length && tempcol <mat[0].length){
                int minrow=temprow;
                int mincol=tempcol;
                for(int it=temprow+1,jt=tempcol+1;it<mat.length && jt<mat[0].length;it++,jt++){
                    if(mat[it][jt]<mat[minrow][mincol]){
                        minrow=it;
                        mincol=jt;
                    }
                }
                int tempelement=mat[minrow][mincol];
                mat[minrow][mincol]=mat[temprow][tempcol];
                mat[temprow][tempcol]=tempelement;
                temprow++;
                tempcol++;
            }
            if(startrow >=0) {
                startrow--;
            }
            if(startrow<0) {
                startcol++;
            }
            if(startrow<0) {
                startrow++;
            }
        }
        return mat;
    }


    public static int[] sortArrayByParityII(int[] nums) {
            int odd=1;
            int even=0;
            while(odd < nums.length && even < nums.length){
                if(nums[odd]%2 == 0 && nums[even]%2==1 ){
                    int temp=nums[odd];
                    nums[odd]=nums[even];
                    nums[even]=temp;
                }
                 if(nums[odd] %2 ==1){
                    odd+=2;
                }if(nums[even]%2 == 0){
                     even+=2;
                }
            }
            return nums;
    }
    public static  int[] relativeSortArray(int[] arr1, int[] arr2) {
                int left=0;
                for(int i=0;i<arr2.length;i++){
                    for (int right=left;right<arr1.length;right++){
                        if(arr1[right] == arr2[i]){
                            int temp=arr1[right];
                            arr1[right]=arr1[left];
                            arr1[left]=temp;
                            left++;
                        }
                    }
                }
                for(int i=left;i<arr1.length;i++){
                    int min=i;
                    for(int j=i+1;j< arr1.length;j++){
                        if(arr1[j] < arr1[min]) {
                            min = j;
                        }
                    }
                    int temp=arr1[min];
                    arr1[min]=arr1[i];
                    arr1[i]=temp;
                }

                return arr1;
    }



    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> al=new ArrayList<>();
        for(int i=0;i<nums.length-3;i++){
            for (int j=i+1;j<nums.length-2;j++){
                int left=j+1;
                int right=nums.length-1;
                while(left<right){
                    int twosum=nums[left]+nums[right];
                    int currsum=twosum+nums[i]+nums[j];
                    if(currsum == target){
                        List<Integer> templist=Arrays.asList(nums[i],nums[j],nums[left],nums[right]);
                        if(!al.contains(templist)){al.add(templist);}
                        left++;
                        right--;
                    }if(currsum <target){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return al;
    }

    public static  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void countsort(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        //step one make count array
        int[] freq=new int[max+1];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]=freq[arr[i]]+1;
        }

        //step 2 cumulative sum
        for(int i=1;i<freq.length;i++){
            freq[i]=freq[i]+freq[i-1];
        }

        //step 3
        int[] resultarray=new int[arr.length];
        int j=0;
        for(int i=resultarray.length-1;i>=0;i--){
           resultarray[freq[arr[i]]-1]=arr[i];
            freq[arr[i]]=freq[arr[i]]-1;
        }
        System.out.println(Arrays.toString(resultarray));
        }

        public static void quicksort(int[] arr, int left, int right) {
            if (left < right) {
                int pivotindex = quicksorthelper(arr, left, right);
                quicksort(arr, left, pivotindex);
                quicksort(arr, pivotindex + 1, right);
            }
        }

        public static int quicksorthelper(int[] arr, int left, int right) {
            int pivot = arr[left];
            int i = left - 1;
            int j = right + 1;

            while (true) {
                do {
                    i++;
                } while (arr[i] < pivot);

                do {
                    j--;
                } while (arr[j] > pivot);

                if (i >= j)
                    return j;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
    }

    public static void merge(int[] arr,int left,int right){
        if(left <right){
            int mid=(left + (right - left) / 2);
            merge(arr,left,mid);
            merge(arr,mid+1,right);
            merger(arr,left,mid,right);
        }
    }
    public static  void merger(int[] arr,int left,int mid,int right){
        int n=mid-left+1;
        int m=right -mid;
        int[] larray=new int[n];
        int[] rarray=new int[m];
        for(int i=0;i<n;i++){
            larray[i]=arr[left+i];
        }
        for(int i=0;i<m;i++){
            rarray[i]=arr[mid+1+i];
        }
        int i=0;
        int j=0;
        int k=left;
        while(i<larray.length && j<rarray.length){
            if(larray[i]<=rarray[j]){
                arr[k]=larray[i];
                i++;
            }else{
                arr[k]=rarray[j];
                j++;
            }
            k++;
        }
        while(i<n){
            arr[k]=larray[i];
            i++;
            k++;
        }
        while(j<m){
            arr[k]=rarray[j];
            j++;
            k++;
        }
    }


    public static void cyclic0to(int[] arr){
        int i=0;
        while(i<arr.length){
            int correctindexofi=arr[i];
            if(correctindexofi != i){
                int temp=arr[correctindexofi];
                arr[correctindexofi]=arr[i];
                arr[i]=temp;
            }else{
                i++;
            }
        }
    }
    public static void cyclic(int[] arr){
    int i=0;
    while(i<arr.length){
        int correctindexofi=arr[i]-1;
        if(correctindexofi != i){
            int temp=arr[correctindexofi];
            arr[correctindexofi]=arr[i];
            arr[i]=temp;
        }else{
            i++;
        }
    }
    }
    public static void bubble(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                    if(arr[j] > arr[j+1]){
                        int temp=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                    }
            }
        }
    }
    public static void selection(int [] arr){
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i;j<arr.length-1;j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        }
    }
    public static void insertion(int [] arr){
        for(int i=0;i<arr.length;i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j] >key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }
}
