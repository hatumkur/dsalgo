package com.harsha.demo;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class LinkedListRemoveDuplicates {
	
	static class Node {
		int data;
		Node next;
		
		public Node(int val) {
			this.data = val;
		}
		
		public int hashCode() {
			int hashCode = 0;
			hashCode = data * 13;
			return hashCode;
		}
		
		public boolean equals(Object obj) {
			if(obj instanceof Node ) {
				Node node = (Node) obj;
				return (node.data == data);
			} 
			return false;
		}
		
		public String toString() {
			return ("" + data);
		}
	}

	public static void main(String[] args) {
		LinkedList<Node> list = new LinkedList<Node>();
		LinkedList<Node> outputList = new LinkedList<Node>();
		
		LinkedHashSet<Node> lhashset = new LinkedHashSet<Node>();
		
		list.add(new Node(10));
		list.add(new Node(20));
		list.add(new Node(30));
		list.add(new Node(10));
		list.add(new Node(10));
		list.add(new Node(20));
		list.add(new Node(30));
		list.add(new Node(10));
		list.add(new Node(50));
		list.add(new Node(60));
		list.add(new Node(70));
		list.add(new Node(80));		
		
		for(Node node : list) {
			if(lhashset.add(node)) {
				outputList.add(node);
			}
			System.out.print(node.toString() + " ");
		}
		System.out.println();
		
		for(Node node : outputList) {
			System.out.print(node.toString() + " ");
		}
		System.out.println();
		
	}

}
