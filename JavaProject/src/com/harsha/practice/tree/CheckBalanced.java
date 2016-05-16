package com.harsha.practice.tree;

public class CheckBalanced {
	private static int checkHeight(Node root) {
		if(root == null) return -1;
		
		int hleft = checkHeight(root.left);
		if(hleft == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int hright = checkHeight(root.right);
		if(hright == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int diff = hleft - hright;
		
		if(Math.abs(diff) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(hleft, hright) + 1;
		}
		
	}
	
	public static boolean isBalanced(Node root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		int[] input = new int[] {0,1,2,3,4,5,6,7,8,9};
		
		/*
		 			  4
		 		 2       7
		 	   1   3   5    8 
		     0           6     9 
		 
		 */
		
		Node tree = Node.createMinimalBST(input);
		Node.inOrderTraverse(tree);
		System.out.println();	
		System.out.println("Tree Balanced ? : " + isBalanced(tree));
		
		Node temp = Node.findNode(tree, 0);
		Node.insertInOrder(temp, 11);
		Node.insertInOrder(temp, 12);
		System.out.println("Tree Balanced ? : " + isBalanced(tree));
		Node.inOrderTraverse(tree);
	}

}
