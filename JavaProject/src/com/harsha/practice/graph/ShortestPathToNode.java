package com.harsha.practice.graph;

import java.util.PriorityQueue;

import com.harsha.demo.Edge;

public class ShortestPathToNode {

	public static void computePaths(Node srcNode) {
		//srcNode.minDistance = 0.0;
		PriorityQueue<Node> vertQueue = new PriorityQueue<Node>();
		vertQueue.add(srcNode);

		Edge[] earr;
		while (!vertQueue.isEmpty()) {
			Node u = vertQueue.poll();

			earr = u.getAdjacents();
			// Visit each edge exiting u
			for (int i = 0; i < u.getAdjacentCount(); i++) {
				Node v = earr[i].getNode();

				int weight = earr[i].getWeight();
				//int distanceThroughU = u.minDistance + weight;
				//if (distanceThroughU < v.minDistance) 
				{
					vertQueue.remove(u);

					v.minDistance = distanceThroughU;
					v.previous = u;
					vertQueue.add(v);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
