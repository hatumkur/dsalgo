package com.harsha.practice.graph;

public class Edge {
	private Node node;
	private int weight;
	
	public Edge(Node n, int w) {
		this.node = n;
		this.weight = w;
	}
	
	public Edge(Node n) {
		this.node = n;
		this.weight = 1;
	}
	
	public Node getNode() {
		return node;
	}
	
	public int getWeight() {
		return weight;
	}
}
