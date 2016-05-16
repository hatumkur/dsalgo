package com.harsha.temp;

class TNode {
	Data dw;
	TNode left;
	TNode right;
	
	TNode(int data) {
		dw = new Data(data);
		left = null;
		right = null;
	}
	
}
class Data {
	int data;
	
	Data(int data) {
		this.data = data;
	}
}
public class CheckBST {

	public static Integer prevInorderData = null;
	public static boolean checkBST(TNode root) {
		if(root == null) return true;

		if(!checkBST(root.left)) return false;
		
		//if(prevInorderData!= null)
		//System.out.printf("PREV DATA %d CURRENT DATA %d \n", prevInorderData, root.dw.data);
		
		if(prevInorderData != null && root.dw.data <= prevInorderData) {
			//System.out.printf("PREV DATA %d CURRENT DATA %d \n", prevInorderData, root.dw.data);
			return false;
		}
		
		if(prevInorderData!= null)
		System.out.printf("%d ",prevInorderData);
		prevInorderData = root.dw.data;
		//System.out.printf("%d ",prevInorderData);
		
		if(!checkBST(root.right)) return false;
		
		return true;
	}	
	
	public static boolean checkBST2(TNode root, Data prevData) {
		if(root == null) return true;

		if(!checkBST2(root.left, prevData)) return false;
		
		//if(prevData != null)
		//	System.out.printf("PREV DATA2 %d CURRENT DATA2 %d \n", prevData.data, root.dw.data);

		if(prevData != null && root.dw.data <= prevData.data) {
			System.out.printf("PREV DATA2 %d CURRENT DATA2 %d \n", prevData.data, root.dw.data);
			return false;
		}
		
		if(prevData!= null)
		System.out.printf("%d ",prevData.data);
		
		Data temp = prevData;
		prevData = root.dw;
		//System.out.printf("%d ",root.dw.data);
		if(root.right != null) prevData = root.dw;
		
		if(!checkBST2(root.right, temp)) return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		//int[] arr = { 1, 2, 3, 4, 5 };
		
		TNode root = new TNode(20);
		root.right = new TNode(30);
		root.left = new TNode(10);
		root.left.right = new TNode(25);
		
		System.out.println(checkBST(root));
		System.out.println();
		System.out.println(checkBST2(root, null));
		System.out.println();
	}

}
