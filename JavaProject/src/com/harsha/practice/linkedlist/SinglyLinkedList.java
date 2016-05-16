package com.harsha.practice.linkedlist;

public class SinglyLinkedList {
	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node head = null;

	/* Function to reverse the linked list */
	Node reverse(Node node) {
		Node current = node;		
		Node tprev = null;
		Node tnext = null;

		while (current != null) {
			tnext = current.next; // Store next pointer
			current.next = tprev; // Current node next will point to prev
			
			tprev = current; // Store current 
			current = tnext; // current now points to next
		}
		node = tprev;
		return node;
	}

	// prints content of double linked list
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList slistDemo = new SinglyLinkedList();
		slistDemo.head = new Node(85);
		slistDemo.head.next = new Node(15);
		slistDemo.head.next.next = new Node(4);
		slistDemo.head.next.next.next = new Node(20);

		System.out.println("Original Linked list is :");
		slistDemo.printList(slistDemo.head);
		slistDemo.head = slistDemo.reverse(slistDemo.head);
		System.out.println("");
		System.out.println("Reversed linked list : ");
		slistDemo.printList(slistDemo.head);
	}
	
	
	public static Node reverse2(Node root) {
		Node current = root;
		Node prev = null;
		Node next = null;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			
			prev = current;
			current = next;
		}
		root = prev;
		return root;
	}

}
