package com.harsha.temp;


class Node {
	int data;
	Node left;
	Node right;
	Node parent;
	
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	public Node(int data, Node parent) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = parent;
	}	
	// Create binary search tree
	private static Node createMinimalBST(int[] arr, int start , int end, Node parent) {
		if(end < start) return null;
		
		int mid = (start + end)/2;
		Node root = new Node(arr[mid], parent);
		root.left = createMinimalBST(arr, start, mid-1, root);
		root.right = createMinimalBST(arr, mid+1, end, root);
		
		return root;
	}
	
	public static Node createMinimalBST(int[] arr) {
		return createMinimalBST(arr, 0, arr.length -1, null);
	}
	
	public static void inOrderTraverse(Node root) {
		if(root == null) return;
		
		inOrderTraverse(root.left);
		System.out.printf("%d ", root.data);		
		inOrderTraverse(root.right);
	}

	public static void getInorderTraverseString(Node root, StringBuilder str) {
		if(root == null) return;
		
		getInorderTraverseString(root.left,str);
		str.append(root.data + " ");		
		getInorderTraverseString(root.right,str);
	}
	
	public static void getPreorderTraverseString(Node root, StringBuilder str) {
		if(root == null) return;
		
		str.append(root.data + " ");
		getPreorderTraverseString(root.left,str);
		getInorderTraverseString(root.right,str);
	}	
	
	public static Node findNode(Node root, int val) {
		if(root == null) return null;
		
		if(root.data == val) {
			return root;
		} else if (val < root.data) {
			return findNode(root.left, val);
		} else if (val > root.data) {
			return findNode(root.right, val);
		}
		
		return null;
	}
	
	public static void insertInOrder(Node root, int d) {
		if (d <= root.data) {
			if (root.left == null) {
				root.left = new Node(d);
			} else {
				insertInOrder(root.left, d);
			}
		} else {
			if (root.right == null) {
				root.right = new Node(d);
			} else {
				insertInOrder(root.right, d);
			}
		}
	}	
} 