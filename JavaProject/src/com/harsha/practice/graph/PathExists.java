package com.harsha.practice.graph;

import java.util.LinkedList;

// (1) count path

public class PathExists {
	
	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		Node[] temp = new Node[6];

		temp[0] = new Node("a");
		temp[1] = new Node("b");
		temp[2] = new Node("c");
		temp[3] = new Node("d");
		temp[4] = new Node("e");
		temp[5] = new Node("f");

		temp[0].addAdjacent(temp[1]); // a -> b
		temp[0].addAdjacent(temp[2]); // a -> c
		temp[0].addAdjacent(temp[3]); // a -> d
		temp[3].addAdjacent(temp[4]); // d -> e 
		temp[4].addAdjacent(temp[5]); // e -> f
		temp[3].addAdjacent(temp[2]); // d -> c
		temp[2].addAdjacent(temp[5]); // c -> f		
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}
	
	// Use BFS 
	public static int pathCount(Graph g, Node start, Node end) {
		if(g == null || start == null || end == null) return 0;
		
		LinkedList<Node> q = new LinkedList<Node>();
		Node [] narr = g.getVertices();
		for(int i = 0; i < g.getVerticesCount(); i++) {
			narr[i].state = State.Unvisited;
		}
		
		start.state = State.Visiting;
		q.add(start);
		Node n, t;
		Edge[] earr;
		int count = 0;
		while(!q.isEmpty()) {
			n = q.removeFirst();
			if(n != null) {
				earr = n.getAdjacents();
				for(int i = 0; i < n.getAdjacentCount(); i++) {
					t = earr[i].getNode();
					if(t.state == State.Unvisited) {
						if(end == t) {
							count++;
							//return true;
						} else {
							t.state = State.Visiting;
							q.add(t);
						}
					}
				}
				n.state = State.Visited;
			}
		}
		
		//System.out.println("COUNT = " + count);
		return count;
		
	}

	public static void main(String[] args) {
		
		Graph g = createNewGraph();
		Node[] n = g.getVertices();
		Node start = n[3];
		Node end = n[5];
		int count = 0;
		System.out.printf("PATH EXISTS BETWEEN %s & %s : ? ", start.getName(), end.getName());
		count = pathCount(g, start, end); 
		System.out.println("COUNT1 = " + count);
		System.out.println();
		
		end = n[1];
		System.out.printf("PATH EXISTS BETWEEN %s & %s : ? ", start.getName(), end.getName());
		count = pathCount(g, start, end); 
		System.out.println("COUNT2 = " + count);		
		System.out.println();		
	}

}
