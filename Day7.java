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

import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || (root.left == null  && root.right == null)){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<TreeNode> queue2;
        
        while(!queue.isEmpty()){
            TreeNode xParent = null;
            TreeNode yParent = null;
            queue2 = new LinkedList<>();
            
            while(!queue.isEmpty()){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    if(temp.left.val == x){
                        xParent = temp;
                    }
                    if(temp.left.val == y){
                        yParent = temp;
                    }
                    queue2.add(temp.left);
                }
                if(temp.right != null){
                    if(temp.right.val == x){
                        xParent = temp;
                    }
                    if(temp.right.val == y){
                        yParent = temp;
                    }
                    queue2.add(temp.right);
                }
            }
        
            // check parents
            if(xParent != null && yParent != null){
                if(xParent != yParent){
                    return true;
                }else{
                    return false;
                }
            }
            queue = queue2;
        }
        return false;
    }
}