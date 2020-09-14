package tim.d637.average_of_levels_in_binary_tree;

import tim.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        //define list for left and right
        List<TreeNode> ts = new ArrayList<TreeNode>();
        int level = 0;
        List<Double> avg = new ArrayList<Double>();
        avg.add(root.val / 1.0);
        if (root.left != null) {
            ts.add(root.left);
        }
        if (root.right != null) {
            ts.add(root.right);
        }
        while (ts.size() > 0) {
            long sum = 0;
            List<TreeNode> tsSub = new ArrayList<TreeNode>();
            for (TreeNode tn : ts) {
                sum += tn.val;
                if (tn.left != null) {
                    tsSub.add(tn.left);
                }
                if (tn.right != null) {
                    tsSub.add(tn.right);
                }
            }
            double currentAvg = sum / (ts.size() * 1.0);
            avg.add(currentAvg);
            ts = tsSub;
        }
        return avg;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
        root.left = new TreeNode(2147483647);
        root.right = new TreeNode(2147483647);
        Solution s = new Solution();
        List<Double> rtn = s.averageOfLevels(root);
        System.out.println(rtn);
    }
}