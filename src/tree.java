import com.sun.source.tree.Tree;

import java.util.*;

public class tree {
   static  class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int value){
            this.val=value;
        }
    }
    static int count=1;
    public static  int goodNodes(TreeNode root) {
        helper(root,root.val);
        return count;
    }
    public static void helper(TreeNode root,int value){
        if(root == null) {
            return;
        }
        int further=0;
        if(root.val>=value){
            count++;
            value=root.val;
        }
        helper(root.left,value);
        helper(root.right,value);
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int i=0;
        TreeNode root=new TreeNode(preorder[i]);
        helpfor(root,i+1,preorder);
        return root;
    }
    public void helpfor(TreeNode root,int i,int[] arr){
        if(i>=arr.length) return;
        if(arr[i]<root.val) {
            TreeNode left=new TreeNode(arr[i]);
            root.left=left;
            helpfor(left,i+1,arr);
        }
        else if(arr[i]>arr[i]){
            TreeNode right=new TreeNode(arr[i]);
            root.right=right;
            helpfor(right,i+1,arr);
        }

    }


    public static void preorder(TreeNode root){
        if(root == null) return;
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }

    static int cont=0;
    public static int  distributeCoins(TreeNode root) {
        cont=0;
        fu1(root,0);
        return cont;
    }
    public static int fu(TreeNode root,int value){
        if(root == null){
            return value;
        }
        if(root.val == 1 || root.val ==0){
            int lv=fu(root.left,value);
            root.val=1;
            lv-=1;
            return fu(root.right,lv);
        }else{
            int lv=fu(root.left,root.val);
            root.val=1;
            lv=lv+value-1;
            return fu(root.right,lv);
    }
    }

    public static int fu1(TreeNode root,int value){
        if(root == null){
            return value;
        }
        if(root.val == 1 || root.val ==0){
            int lv=fu1(root.left,value);
            root.val=1;
            cont += Math.abs(lv - value);
            lv-=1;
            return fu1(root.right,lv);
        }else{
            int lv=fu1(root.left,root.val);
            root.val=1;
            cont += Math.abs(lv - value);
            lv=lv+value-1;
            return fu1(root.right,lv);
        }
    }

    public static void main(String[] args) {
        // Creating test case: [3,0,0]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        int[] arr={8,5,1,7,10,9,12};
        tree t=new tree();
        TreeNode r=t.bstFromPreorder(arr);
       // preorder(r);
        TreeNode ro=new TreeNode(0);
        ro.left=new TreeNode(3);
        ro.right=new TreeNode(0);
    }
}
