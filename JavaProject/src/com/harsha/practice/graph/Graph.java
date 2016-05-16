package com.harsha.practice.graph;

public class Graph {
	public static int MAX_VERTICES = 10;
	private Node[] vertices;
	private int count;
	
	public Graph() {
		vertices = new Node[MAX_VERTICES];
		count = 0;
	}
	
	public void addNode(Node node) {
		if(count < MAX_VERTICES) {
			vertices[count] = node;
			count++;
		} else {
			System.out.println("can't add more node, maximum count reached");
		} 
	}
	
	public Node[] getVertices() {
		return vertices;
	}
	
	public int getVerticesCount() {
		return count;
	}
	
}
