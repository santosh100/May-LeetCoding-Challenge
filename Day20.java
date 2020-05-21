/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.ArrayList;
import java.util.Stack;

class Solution {
    
    
    //APPROACH - 1
    /*
    int count=0;
    int value=0;
    public void helper(TreeNode root, int k){
        if(root == null){
            return;
        }
        helper(root.left, k);
        count++;
        if(count == k){
            value = root.val;
        }
        helper(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return value;
    }
    */
    
    // APPROACH - 2
    // speed =>  same as approach - 1
    
    public void helper(TreeNode root, int arr[]){
        if(root == null){
            return;
        }
        
        helper(root.left, arr);
        if(--arr[0] == 0){
            arr[1] = root.val;
        }
        helper(root.right, arr);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        int arr[] = new int[2];
        arr[0] = k;
        helper(root, arr);
        return arr[1];
    }
    
    
    // APPROACH - 3    
    // Slower than Approach 1 and 2
    /*
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            while(root != null){
                stack.push(root);
                root = root.left;                 
            }
                        
            root = stack.pop();
            if(--k == 0)
                return root.val;            
            root = root.right;
        }
    }
    */
    
    // ANOTHER APPROACH
    // Slower than Approach - 1 , 2 and 3
    /*
    public void helper(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }
        
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, list);
        return list.get(k-1);
    }
    */        
    
}