package com.harsha.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;

// http://www.geeksforgeeks.org/connect-nodes-at-same-level/
// BFS or pre order traversal VLR
// Preorde works only for complete binary tree
// http://code.geeksforgeeks.org/sLzZLK
public class ConnectSiblingsTree {

	//LinkedList<Node> list = new LinkedList<Node> ();
	public static ArrayList< LinkedList<Node> > connectSiblings(Node root) {
		if(root == null) return null;
		
		ArrayList<LinkedList<Node>> levelSiblingsArray = new ArrayList<LinkedList<Node>>();
		
		LinkedList<Node> siblingsList = new LinkedList<Node>();
		//siblingsArray.add(siblings);
		siblingsList.add(root);
		
		while(!siblingsList.isEmpty()) {
			// Add previous level
			levelSiblingsArray.add(siblingsList);
			LinkedList<Node> parentsList = siblingsList;
			// Create list for holding siblings in next level
			siblingsList = new LinkedList<Node>();
			
			for(Node parent : parentsList) {
				if(parent.left != null) {
					siblingsList.add(parent.left);
				}
				
				if(parent.right != null) {
					siblingsList.add(parent.right);
				}
			}
		}
		
		return levelSiblingsArray;
	} 
	
	public static void printResults(ArrayList<LinkedList<Node>> results) {
		int level = 0;
		for(LinkedList<Node> list : results) {
			level++;
			System.out.printf("SIBLINGS @level = %d  \n", level);
			for(Node node : list) {
				System.out.printf("%d ", node.data);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int [] input = new int [] {0,1,2,3,4,5,6,7,8,9};
		Node tree = Node.createMinimalBST(input);
		Node.inOrderTraverse(tree);
		System.out.println();
		
		ArrayList<LinkedList<Node>> results = connectSiblings(tree);
		printResults(results);
	}

}
