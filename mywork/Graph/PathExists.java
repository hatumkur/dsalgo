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

class Graph {
     private ArrayList<Vertex> vertices;
     private ArrayList< LinkedList<Edge> > adjacencies;
     private boolean isDirected;

     // Looks up vertexIndex by vertex name
     private HashMap<String, Integer> verticesMap;

     public Graph(boolean isDirected) {}
     public void addVertex(Vertex v) {}
     public void addEdge(Edge e) {}
     public int getVertexIndex(String vname) {}
     public ArrayList<Vertex> getVertices() {}
     public LinkedList<Edge> getAdjacencies(String vname) {}
     public ArrayList< LinkedList<Edge> > getAdjacencyList() {}
 }

public boolean isPathExists(Graph g, Vertex source, Vertex dest) {
    if(g == null) return false;

    // Key: Vertex.name  Value: Visited or not flag
    HashMap<String, Boolean> visitedMap = new HashMap<String, Boolean>();

    ArrayList<Vertex> vertices = g.getVertices();

    // Initialized visited map
    for(int i = 0; i < vertices.length(); i++) {
        visitedMap.put(vertices.getAt(i).name, false);
    }

    if(!visitedMap.containsKey(source.name) ||
        visitedMap.containsKey(dest.name)) {
        return false;
    }

    // Queue needed for BFS (Breadth First Search)
    LinkedList<Vertex> queue = new LinkedList<Vertex>();
    visitedMap.put(source.name, true);
    queue.add(source);

    Vertex v;
    LinkedList<Edge> adjList;

    while(!queue.isEmpty()) {
        v = queue.removeFirst();

        adjList = g.getAdjacencies(v.name);
        while(adjList != null && adjList.size() > 0) {
            Edge e = adjList.removeFirst();

            String endName = g.getVertex(e.endVertex).name;
            // If destination node found then return
            if(endName.equals(dest.name) == 0) {
                //System.out.println(" " + dest.name);
                return true;
            }

            // Continue with BFS
            if(!visitedMap.get(v.name)) {
                visitedMap.put(v.name, true);
                queue.add(v);
            }

        }
    }

    // If BFS is complete without visited d
    return false;

}
