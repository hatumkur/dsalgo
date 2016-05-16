package Q4_03_List_of_Depths;

import CtCILibrary.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class QuestionBFS {

	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> levelSiblingArr = new ArrayList<LinkedList<TreeNode>>();
		
		/* "Visit" the root */
		LinkedList<TreeNode> siblingsList = new LinkedList<TreeNode>();
		if (root != null) {
			siblingsList.add(root);
		}
		
		while (siblingsList.size() > 0) {
			levelSiblingArr.add(siblingsList); // Add previous level
			LinkedList<TreeNode> parentsList = siblingsList; // Go to next level
			siblingsList = new LinkedList<TreeNode>(); 
			for (TreeNode parent : parentsList) {
				/* Visit the children */
				if (parent.left != null) {
					siblingsList.add(parent.left);
				}
				if (parent.right != null) {
					siblingsList.add(parent.right);
				}
			}
		}

		return levelSiblingArr;
	}
	
	public static void printResult(ArrayList<LinkedList<TreeNode>> result){
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()){
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
	

	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);
	}

}
