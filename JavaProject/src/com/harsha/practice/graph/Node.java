package com.harsha.practice.graph;

public class Node {
	public static int MAX_EDGES = 10;
	private Edge[] adjacent;
	private String name;
	private int count;
	public State state;
	
	public Node(String name){
		this.name = name;
		this.adjacent = new Edge[MAX_EDGES];
		count = 0;
	}

	public void addAdjacent(Edge adj) {
		if(count < MAX_EDGES) {
			this.adjacent[count] = adj;
			count++;
		} else {
			System.out.println("Can't add more adjacents");
		}
	}
	
	public void addAdjacent(Node adj, int weight) {
		if(count < MAX_EDGES) {
			Edge edge = new Edge(adj, weight);
			addAdjacent(edge);
		} else {
			System.out.println("Can't add more adjacents");
		}
	}
	
	public void addAdjacent(Node adj) {
		if(count < MAX_EDGES) {
			Edge edge = new Edge(adj);
			addAdjacent(edge);
		} else {
			System.out.println("Can't add more adjacents");
		}
	}
	
	public Edge[] getAdjacents() {
		return adjacent;
	}
	
	public int getAdjacentCount() {
		return count;
	}
	
	public String getName() {
		return name;
	}
 }

