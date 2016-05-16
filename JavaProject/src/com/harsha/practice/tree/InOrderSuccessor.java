package com.harsha.practice.tree;

//import CtCILibrary.TreeNode;

public class InOrderSuccessor {
 
	public static Node inorderSuccessor(Node node) {
		if(node == null) return null;
		
		// If a node has right subtree then return leftmost child of right subtree as successor
		// step 1 of the above algorithm 
		if(node.right != null) { 
			return leftMostChild(node.right);
		} 
		
		// step 2 of the above algorithm 
		// Go up till we are in left instead of right
		Node p = node.parent;

		// parent not null & if it is right child then move up
		while (p != null && node == p.right) {
			node = p;
			p = p.parent;
		}
		return p;
	}
	
	private static Node leftMostChild(Node node) {
		if(node == null) return null;
		
		while(node.left != null) {
			node = node.left;
		}
		
		return node;
	}
	
	public static void main(String[] args) {
		int[] input = new int[] {0, 1,2,3,4,5,6,7,8,9};
		
		/*
		 			  4
		 		 2       7
		 	   1   3   5    8 
		     0           6     9 
		 
		 */
		
		Node tree = Node.createMinimalBST(input);
		Node.inOrderTraverse(tree);
		System.out.println();
		
		for (int i = 0; i < input.length; i++) {
			Node node = Node.findNode(tree,input[i]);
			Node next = inorderSuccessor(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}		
	}	
}
