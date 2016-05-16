package com.harsha.demo;

//Java program to print BFS traversal from a given source vertex.
//BFS(int s) traverses vertices reachable from s.
import java.util.*;

/*
  0 ----> 1
  0 ----> 2
  1 ----> 2
  2 ----> 0
  2 ----> 3
  3 ----> 3
  2 => Source 
  
Breadth First Traversal for a Graph

Breadth First Traversal (or Search) for a graph is similar to Breadth First Traversal 
of a tree (See method 2 of this post). The only catch here is, unlike trees, graphs may 
contain cycles, so we may come to the same node again. To avoid processing a node more than 
once, we use a boolean visited array. For simplicity, it is assumed that all vertices are 
reachable from the starting vertex.
For example, in the following graph, we start traversal from vertex 2. When we come to vertex 0, 
we look for all adjacent vertices of it. 2 is also an adjacent vertex of 0. If we don’t mark 
visited vertices, then 2 will be processed again and it will become a non-terminating process. 
A Breadth First Traversal of the following graph is 2, 0, 3, 1.


  
 Depth First Traversal (or Search) for a graph is similar to Depth First Traversal of a tree. 
 The only catch here is, unlike trees, graphs may contain cycles, so we may come to the same 
 node again. To avoid processing a node more than once, we use a boolean visited array.
For example, in the following graph, we start traversal from vertex 2. When we come to vertex 0,
 we look for all adjacent vertices of it. 2 is also an adjacent vertex of 0. If we don’t mark 
 visited vertices, then 2 will be processed again and it will become a non-terminating process. 
 A Depth First Traversal of the following graph is 2, 0, 1, 3.  

 */
public class BFTGraph {
	// This class represents a directed graph using adjacency list
	// representation
	static class Graph {
		private int V; // No. of vertices
		private ArrayList<LinkedList<Integer>> adjList; // Adjacency Lists

		// Constructor
		Graph(int v) {
			V = v;
			adjList = new ArrayList<LinkedList<Integer>>();
			// adjList = new LinkedList[v];
			for (int i = 0; i < v; ++i) {
				adjList.add(new LinkedList<Integer>());
			}
		}

		// Function to add an edge into the graph
		void addEdge(int s, int d) {
			adjList.get(s).add(d);
		}

		// prints BFS traversal from a given source s
		void BFT(int s) {

			// Mark all the vertices as not visited(By default
			// set as false)
			boolean visited[] = new boolean[V];

			// Create a queue for BFS
			LinkedList<Integer> queue = new LinkedList<Integer>();

			// Mark the current node as visited and enqueue it
			visited[s] = true;
			queue.add(s);

			while (queue.size() != 0) {
				// Dequeue a vertex from queue and print it
				s = queue.poll();
				System.out.print(s + " ");

				// Get all adjacent vertices of the dequeued vertex s
				// If a adjacent has not been visited, then mark it
				// visited and enqueue it
				Iterator<Integer> i = adjList.get(s).listIterator();
				while (i.hasNext()) {
					int n = i.next();
					if (!visited[n]) {
						visited[n] = true;
						queue.add(n);
					}
				}
			}
		}

		// A function used by DFS
		void DFTUtil(int v, boolean visited[]) {
			// Mark the current node as visited and print it
			visited[v] = true;
			System.out.print(v + " ");

			// Recur for all the vertices adjacent to this vertex
			Iterator<Integer> i = adjList.get(v).listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n])
					DFTUtil(n, visited);
			}
		}

		// The function to do DFS traversal. It uses recursive DFSUtil()
		void DFT(int v) {
			// Mark all the vertices as not visited(set as
			// false by default in java)
			boolean visited[] = new boolean[V];

			// Call the recursive helper function to print DFS traversal
			DFTUtil(v, visited);
		}
	}

	// Driver method to
	public static void main(String args[]) {
		Graph g = new Graph(4);
		/*
		
		5
		1 2 4
		3 2 3
		2 5 2
		4 1 1
		Graph g = new Graph(5);
		g.addEdge(1, 2);
		g.addEdge(3, 2);
		g.addEdge(2, 5);
		g.addEdge(4, 1);
		 */
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFT(2);

		System.out.println("\nFollowing is Depth First Traversal " + "(starting from vertex 2)");

		g.DFT(2);
	}
}
