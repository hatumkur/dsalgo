/*
    (1) Using Adjacency matrix
    (2) Using Adjacency List

*/

/*
    (1) Using Adjacency matrix

    Vertex
    Edge/Neighbor => Adjacency

    Graph => Vertex[], Adjacency[][]
    'n' Vertices => 'n(n-1)' possible edges for Directed graph (n*n)
    'n' Vertices => 'n(n-1)/2' possible edges for Non Directed graph (n*n)

    Memory intensive design => Space = O(n*n)
    To check path exists between two vertices => Time = O(n) (To get vertex index)

*/

class Vertex {  // implement comparable interface
    private String name;
    public String name();

    public Vertex(String name) {
        this.name = name;
    }
}

class Edge { // implement comparable interface
    int startVertex, endVertex;
    int weight;

    public Edge(int firstVIndex, int secondVIndex, int weight) {
        this.startVertex = firstVIndex;
        this.endVertex = secondVIndex;
        this.weight = weight;
    }
}

class Graph {
    private Vertex[] vertices;
    private Edge[][] adjacencies;

    private boolean isDirected;
    private int currVCount;
    private int maxVCount;
    // Looks up vertexIndex by vertexname
    private HashMap<String, Integer> verticesMap;

    public Graph(int maxVCount) { }
    public void addVertex(Vertex v) { }
    public void addEdge(Edge e) { }
    public int getVertexIndex(String name) {}
}

/*
    (2) Adjacency List
*/

class Graph {
    private ArrayList<Vertex> vertices;
    private ArrayList< LinkedList<Edge> > adjacencies;
    private boolean isDirected;

    // Looks up vertexIndex by vertexname
    private HashMap<String, Integer> verticesMap;

    public Graph(boolean isDirected) {}
    public void addVertex(Vertex v) {}
    public void addEdge(Edge e) {}
    public int getVertexIndex(String name) {}
}
