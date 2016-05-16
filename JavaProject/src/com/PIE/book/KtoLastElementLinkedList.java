package com.PIE.book;

public class KtoLastElementLinkedList {

	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	static Node kthElementFromLast(Node root, int k) {
		Node fast, slow; 
		fast = slow = root;
		
		if(k <= 0) {
			System.out.println("Invalid input ---");
			return null;
		}
		
		// Move the fast cursor to kth element from the start
		for(int i = 0; i < k; i++) {
			if(fast == null) {
				System.out.println("Invalid input ---");
				return null;
			}
			fast = fast.next;
		}
		
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		System.out.println("Kth Element to Last :" + slow.data);
		
		return slow;
	}
	
	public static void main(String[] args) {
		Node temp = null;
		Node root = new Node(1); 
		root.next = new Node(2); temp = root.next;
		temp.next = new Node(3); temp = temp.next;
		temp.next = new Node(4); temp = temp.next;
		temp.next = new Node(5); temp = temp.next;
		temp.next = new Node(6); temp = temp.next;
		temp.next = new Node(7); temp = temp.next;
		temp.next = new Node(8); temp = temp.next;
		temp.next = new Node(9); temp = temp.next;
		temp.next = new Node(10); 
		
		// 1 -> 2 -> 3 -> 4-> 5-> 6-> 7-> 8-> 9-> 10
		
		kthElementFromLast(root, 1);
		
	}

}
