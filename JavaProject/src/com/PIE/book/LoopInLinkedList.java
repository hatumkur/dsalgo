package com.PIE.book;

public class LoopInLinkedList {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	static boolean containsLoop(Node root) {
		boolean loopFound = false;
		Node fast, slow;

		if (root == null)
			return false;

		fast = slow = root;

		// fast = fast.next;

		while (fast != null) {
			fast = fast.next;

			// if(fast == null) return false;

			fast = fast.next;
			slow = slow.next;

			if (fast == slow) {
				loopFound = true;
				break;
			}

		}
		if (loopFound) {
			Node loopNode = root;
			while (loopNode != fast) {
				loopNode = loopNode.next;
				fast = fast.next;
			}
			System.out.println("LOOP NODE (data) = " + loopNode.data);
		}
		return loopFound;
	}

	public static void main(String[] args) {
		Node temp, loopNode;
		Node root = new Node(1);
		//loopNode = root;
		root.next = new Node(2);
		temp = root.next;
		temp.next = new Node(3);
		temp = temp.next;
		loopNode = temp;
		temp.next = new Node(4);
		temp = temp.next;
		temp.next = new Node(5);
		temp = temp.next;
		temp.next = new Node(6);
		temp = temp.next;
		//loopNode = temp;
		temp.next = new Node(7);
		temp = temp.next;
		temp.next = new Node(8);
		temp = temp.next;
		temp.next = new Node(9);
		temp = temp.next;
		temp.next = new Node(10);
		temp = temp.next;
		temp.next = null; //loopNode;

		System.out.println(containsLoop(root));
	}

}
