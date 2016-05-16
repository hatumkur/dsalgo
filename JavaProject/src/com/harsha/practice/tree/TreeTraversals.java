package com.harsha.practice.tree;

import java.util.LinkedList;

public class TreeTraversals {
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
			left = right = null;
		}
		
		static void preorderTraversal(Node root) {
			if(root == null) {
				return;
			}
			// VLR
			System.out.printf("%d ", root.data);
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
		
		static void preorderTraversalIter(Node root) {
			if(root == null) return;
			Node node = root;
			// Using linked list as stack
			LinkedList<Node> stack = new LinkedList<Node>();
			stack.push(root);
			while(!stack.isEmpty()) {
				node = stack.pop();
				if(node == null) {
					break;
				}
				System.out.printf("%d ", node.data);
				if(node.right != null) stack.push(node.right);
				if(node.left != null) stack.push(node.left);
			}
		}
		
		static void postorderTraversal(Node root) {
			if(root == null) {
				return;
			}
			// LRV
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.printf("%d ", root.data);
		}
		
		// https://www.youtube.com/watch?v=qT65HltK2uE
		static void postorderTraversalIter(Node root) {
			if(root == null) return;
			Node node = root;
			// Using linked list as stack
			LinkedList<Node> stack1 = new LinkedList<Node>();
			LinkedList<Node> stack2 = new LinkedList<Node>();
			stack1.push(root);
			
			while(!stack1.isEmpty()) {
				node = stack1.pop();
				stack2.push(node);
				if(node.left != null) stack1.push(node.left);
				if(node.right != null) stack1.push(node.right);
			}
			
			while(!stack2.isEmpty()){
				node = stack2.pop();
				System.out.printf("%d ", node.data);
			}
		}
		
		// Single stack
		static void postorderTraversalIterSingleStack(Node root) {
			Node current = root;
			LinkedList<Node> stack = new LinkedList<Node>();
			
			while(!stack.isEmpty() || current != null) {
				if(current != null) {
					stack.push(current);
					current = current.left;
				} else {
					Node temp = stack.peek().right;
					// if top node has no right child and then ready to visit 
					if(temp == null) {
						temp = stack.pop();
						System.out.printf("%d ", temp.data);
						// if top node is right child then ready to visit
						while(!stack.isEmpty() && temp == stack.peek().right) {
							temp = stack.pop();
							System.out.printf("%d ", temp.data);
						}
					} else {
						current = temp;
					}
				}
			}
		}

		static void inorderTraversal(Node root) {
			if(root == null) {
				return;
			}
			// LVR
			inorderTraversal(root.left);
			System.out.printf("%d ", root.data);
			inorderTraversal(root.right);			
		}

		static void inorderTraversalIter(Node root) {
			if(root == null) return;
			Node node = root;
			// Using linked list as stack
			LinkedList<Node> stack = new LinkedList<Node>();
			
			// Push all left nodes to stack
			while(node != null) {
				stack.push(node);
				node = node.left;
			}
			
			while(!stack.isEmpty()) {
				node = stack.pop();
				System.out.printf("%d ", node.data);
				if(node.right != null) {
					node = node.right;
					while(node != null) {
						stack.push(node);
						node = node.left;
					}
				}
			}
		}		
		
	}

	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right = new Node(3);
		//root.right.left = new Node(5);
		//root.right.right = new Node(7);

		System.out.println("PREORDER TRAVERSAL [RECURSIVE]");
		Node.preorderTraversal(root);
		System.out.println("\nPREORDER TRAVERSAL [ITERATIVE]");
		Node.preorderTraversalIter(root);		

		System.out.println("\n\nINORDER TRAVERSAL [RECURSIVE]");
		Node.inorderTraversal(root);
		System.out.println("\nINORDER TRAVERSAL [ITERATIVE]");
		Node.inorderTraversalIter(root);

		System.out.println("\n\nPOSTORDER TRAVERSAL [RECURSIVE]");
		Node.postorderTraversal(root);
		System.out.println("\nPOSTORDER TRAVERSAL [ITERATIVE]");
		Node.postorderTraversalIter(root);	
		System.out.println("\nPOSTORDER TRAVERSAL [ITERATIVE] : ONE STACK");
		Node.postorderTraversalIterSingleStack(root);
		
	}

}
