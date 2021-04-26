/***
 * https://leetcode.com/problems/deepest-leaves-sum/
 * */

package com.shams.trees.binarytrees;

import javax.swing.tree.TreeNode;

public class DeepestLeavesSum {

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static void main(String[] args) {
    /**
     *              6
     * 			 7		    	     8
     * 		2     7  	    	1     3
     * 	9     1       4            5
     *
     * */
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(7);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(7);
    root.right.left = new TreeNode(1);
    root.right.right = new TreeNode(3);
    root.left.left.left = new TreeNode(9);
    root.left.right.left = new TreeNode(1);
    root.right.left.left = new TreeNode(4);
    root.right.right.right = new TreeNode(5);
    System.out.println(deepestLeavesSum(root));
  }

  static int sum = 0;

  public static int deepestLeavesSum(TreeNode root) {
    if (root == null) return 0;
    int maxHeight = getHeight(root);

    getDeepestLeavesSum(root, maxHeight, 1);
    return sum;
  }

  static int getHeight(TreeNode root) {
    if (root == null) return 0;

    int left = getHeight(root.left);
    int right = getHeight(root.right);
    return 1 + Math.max(left, right);
  }

  static void getDeepestLeavesSum(TreeNode root, int maxHeight, int curHeight) {

    if (root == null) return;

    if (root.left == null && root.right == null && maxHeight == curHeight) {
      sum += root.val;
    }

    getDeepestLeavesSum(root.left, maxHeight, curHeight + 1);
    getDeepestLeavesSum(root.right, maxHeight, curHeight + 1);
  }
}
