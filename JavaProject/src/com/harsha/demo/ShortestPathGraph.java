package com.harsha.demo;

/*

I need an algorithm to find shortest path between two points in a map where road distance is indicated by a number.

what is given: Start City A Destination City Z

List of Distances between Cities:

A - B : 10
F - K : 23
R - M : 8
K - O : 40
Z - P : 18
J - K : 25
D - B : 11
M - A : 8
P - R : 15

I thought I could use Dijkstra's algorithm , however it finds shortest distance to all destinations. not just one. 
	
There's no reason not to use Dijkstra's algorithm here. It finds the shortest distance between a starting point 
and all destinations, then you simply select the destination you wanted from the completed list or map of results.    	 
	
I think there is a reason not to use Dijkstra in this case. Dijkstra is good to compute the distance from the 
starting point to all the nodes in the map. If you only want the distance to one point, A* is faster. It's basically 
the same algorithm expect that A* doesn't expand unwanted nodes. Both Dijkstra and A* can be implemented using a 
Fibonacci heap (if you care about performance) and will look very similar in the code. Of course you need a heuristic 
for A*. If you don't have one then Dijkstra is very good indeed. – phoenix7360 Jul 5 '13 at 2:36
   	 
	
I didn't mention the Heuristic method simply because it's not relevant to such a small problem. If we're looking at how 
to drive from New York to California, Dijkstra is a poor choice for self evident reasons, but in this case, 
"There's no reason not to use Dijkstra's algorithm here." – SplinterReality Jul 5 '13 at 2:47
   	 
Like SplinterReality said: There's no reason not to use Dijkstra's algorithm here.

The code below I nicked from here and modified it to solve the example in the question.
*/

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Vertex implements Comparable<Vertex> {
	public final String name;
	public Edge[] edges;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertex previous;

	public Vertex(String argName) {
		name = argName;
	}

	public String toString() {
		return name;
	}

	public int compareTo(Vertex other) {
		return Double.compare(minDistance, other.minDistance);
	}

}

class Edge {
	public final Vertex targetVertex;
	public final double weight;

	public Edge(Vertex argTarget, double argWeight) {
		targetVertex = argTarget;
		weight = argWeight;
	}
}

public class ShortestPathGraph /*Dijkstra*/{
	public static void computePaths(Vertex srcVertex) {
		srcVertex.minDistance = 0.0;
		PriorityQueue<Vertex> vertQueue = new PriorityQueue<Vertex>();
		vertQueue.add(srcVertex);

		while (!vertQueue.isEmpty()) {
			Vertex u = vertQueue.poll();

			// Visit each edge exiting u
			for (Edge e : u.edges) {
				if(e == null) {
					continue;
				}
				Vertex v = e.targetVertex;
				double weight = e.weight;
				double distanceThroughU = u.minDistance + weight;
				if (distanceThroughU < v.minDistance) {
					vertQueue.remove(u);

					v.minDistance = distanceThroughU;
					v.previous = u;
					vertQueue.add(v);
				}
			}
		}
	}

	public static List<Vertex> getShortestPathTo(Vertex target) {
		List<Vertex> path = new ArrayList<Vertex>();
		for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
			path.add(vertex);

		Collections.reverse(path);
		return path;
	}

	public static void main(String[] args) {
		// mark all the vertices
/*		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex D = new Vertex("D");
		Vertex F = new Vertex("F");
		Vertex K = new Vertex("K");
		Vertex J = new Vertex("J");
		Vertex M = new Vertex("M");
		Vertex O = new Vertex("O");
		Vertex P = new Vertex("P");
		Vertex R = new Vertex("R");
		Vertex Z = new Vertex("Z");

		// set the edges and weight
		A.edges = new Edge[] { new Edge(M, 8) };
		B.edges = new Edge[] { new Edge(D, 11) };
		D.edges = new Edge[] { new Edge(B, 11) };
		F.edges = new Edge[] { new Edge(K, 23) };
		K.edges = new Edge[] { new Edge(O, 40) };
		J.edges = new Edge[] { new Edge(K, 25) };
		M.edges = new Edge[] { new Edge(R, 8) };
		O.edges = new Edge[] { new Edge(K, 40) };
		P.edges = new Edge[] { new Edge(Z, 18) };
		R.edges = new Edge[] { new Edge(P, 15) };
		Z.edges = new Edge[] { new Edge(P, 18) }; 
		
		computePaths(A); // run Dijkstra
		System.out.println("Distance to " + R + ": " + R.minDistance);
		List<Vertex> path = getShortestPathTo(R);
		System.out.println("Path: " + path);
				
		*/

/*
5
1 2 4
3 2 3
2 5 2
4 1 1		
 */
		Vertex [] v = new Vertex[5];
		v[0] = new Vertex("1");
		v[1] = new Vertex("2");
		v[2] = new Vertex("3");
		v[3] = new Vertex("4");
		v[4] = new Vertex("5");
		
		v[0].edges = new Edge[] {new Edge(v[1],4)};
		v[2].edges = new Edge[] {new Edge(v[1],3)};
		v[1].edges = new Edge[] {new Edge(v[4],2)};
		v[3].edges = new Edge[] {new Edge(v[0],1)};
		v[4].edges = new Edge[] {null};
 		
		computePaths(v[0]);
		System.out.println("Distance to " + v[1] + ": " + v[1].minDistance);	
		List<Vertex> path = getShortestPathTo(v[1]);	
		System.out.println("Path: " + path);		
		System.out.println("Distance to " + v[2] + ": " + v[2].minDistance);
		path = getShortestPathTo(v[2]);
		System.out.println("Path: " + path);		
		System.out.println("Distance to " + v[3] + ": " + v[3].minDistance);	
		path = getShortestPathTo(v[3]);
		System.out.println("Path: " + path);		
		System.out.println("Distance to " + v[4] + ": " + v[4].minDistance);				
		path = getShortestPathTo(v[4]);
		System.out.println("Path: " + path);		

	}
}
