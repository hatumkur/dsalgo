package com.harsha.practice.tree;

public class LowestCommonAnscestor {
	
	// Checks whether a node exist in the tree
	private static boolean covers(Node root, Node p) {
		if(p == null || root == null) return false;
		
		if(root == p) return true;
		return covers(root.left,p) || covers(root.right, p);
	}
	
	public static Node commonAnscestor(Node root, Node p, Node q) {
		// Error check
		if(!covers(root, p) || !covers(root,q)) return null;
		
		return lca(root, p, q);
	}
	
	private static Node lca(Node root, Node p, Node q) {
		if(root == null || p == null || q == null) {
			return root;
		}
		
		boolean isfoundInLeft_p = covers(root.left, p);
		boolean isfoundInLeft_q = covers(root.left, q);
		
		if(isfoundInLeft_p != isfoundInLeft_q) return root;
		
		Node node = (isfoundInLeft_p) ? root.left : root.right;
		
		return lca(node, p, q);
	}

	public static void main(String[] args) {
		int[] input = new int[] {0,1,2,3,4,5,6,7,8,9};
		
		Node tree = Node.createMinimalBST(input);
		Node.inOrderTraverse(tree);
		System.out.println();
		
		Node p = Node.findNode(tree, 3);
		Node q = Node.findNode(tree, 8);
		
		Node result = commonAnscestor(tree, p, q);
		if (result != null) {
			System.out.println("LCA found " + result.data);
		} else {
			System.out.println("LCA Not found");
		}
		
	}

}
