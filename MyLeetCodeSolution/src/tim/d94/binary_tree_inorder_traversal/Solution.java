package tim.d94.binary_tree_inorder_traversal;

import tim.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        ldr(root, res);
        return res;
    }

    public void ldr(TreeNode n, List<Integer> result){
        if(n == null){
            return;
        }
        ldr(n.left, result);
        result.add(n.val);
        ldr(n.right, result);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode k = new TreeNode(9);
        a.left = b;
        b.right = c;
        c.left = d;
        a.right = e;
        e.right =f;
        f.left = g;
        g.left = h;
        g.right = k;
        Solution s = new Solution();
        List<Integer> res = s.inorderTraversal(a);
        System.out.println(res);
    }
}