public class WeightedGraph<T> implements WeightedGraphInterface<T>
{
    public static final int NULL_EDGE = 0;
    private static final int DEFCAP = 50;   // default capacity
    private int numVertices;
    private int maxVertices;
    private T[] vertices;
    private int[][] edges;
    private boolean[] marks;   // marks[i] is mark for vertices[i]
    
    // instantiates a graph with capacity maxV vertices
    @SuppressWarnings("unchecked")
    public WeightedGraph(int maxV)
    {
        numVertices = 0;
        maxVertices = maxV;
        vertices = (T[]) new Object[maxV];
        marks = new boolean[maxV];
        edges = new int[maxV][maxV];
    }

    // instantiates a graph with capacity DEFCAP vertices
    public WeightedGraph()
    {
        this(DEFCAP);
    }
    
    // tests if graph is empty
    public boolean empty()
    {
        return (numVertices == 0);
    }
    
    // tests if graph is full
    public boolean full()
    {
        return (numVertices == maxVertices);
    }
    
    // Precondition: Vertex is not already in graph
    // Precondition: Vertex is not null
    // adds vertex to graph
    public void addVertex(T vertex)
    {
        vertices[numVertices] = vertex;
        for (int i = 0; i < numVertices; i++)
        {
            edges[numVertices][i] = NULL_EDGE;
            edges[i][numVertices] = NULL_EDGE;
        }
        numVertices++;
    }
        
    // returns true if graph contains vertex
    public boolean hasVertex(T vertex)
    {
        for (int i = 0; i< vertices.length; i++)
        {
            if (vertex.equals(vertices[i]))
            {
                return true;
            }
        }
        return false;
    }
    
    // adds an edge with the specified weight from fromVertex to toVertex
    public void setEdge(T fromVertex, T toVertex,int weight)
    {
        edges[findIndex(fromVertex)][findIndex(toVertex)] = weight;
    }
        
    // if edge from fromVertex to toVertex exists, return the weight of
    // the edge; otherwise, returns a special "null-edge" value.
    public int weightIs(T fromVertex, T toVertex)
    {
        int fromVertexIndex = findIndex(fromVertex);
        int toVertexIndex = findIndex(toVertex);
        if (edges[fromVertexIndex][toVertexIndex] != 0)
        {
            return edges[fromVertexIndex][toVertexIndex];
        }
        return NULL_EDGE;
    }
    
    private int findIndex(T vertex)
    {
        for (int i = 0; i < vertices.length; i++)
        {
            if (vertex.equals(vertices[i]))
            {
                return i;
            }
        }
        return -1;
    }
    
    // returns a queue of the vertices that are adjacent to the vertex
    public QueueInterface<T> getAdjacentVertices(T vertex)
    {
        ArrayQueue<T> q = new ArrayQueue<T>();
        int fromIndex = findIndex(vertex);
        for (int i = 0; i < numVertices; i++)
        {
            if (edges[fromIndex][i] != NULL_EDGE)
            {
                q.add(vertices[i]);
            }
        }
        return q;
    }
    
    // sets marks for all vertices to false
    public void clearMarks()
    {
        for (int i = 0; i < marks.length; i++)
        {
            marks[i] = false;
        }
    }
    
    // sets mark for vertex to true
    public void markVertex(T vertex)
    {
        marks[findIndex(vertex)] = true;
    }
    
    // returns true if vertex is marked
    public boolean isMarked(T vertex)
    {
        return (marks[findIndex(vertex)] == true);
    }
    
    // returns an unmarked vertex if any exist, otherwise returns null
    public T getUnmarked()
    {
        for (int i = 0; i < marks.length; i++)
        {
            if (marks[i] == false)
            {
                return vertices[i];
            }
        }
        return null;
    }
    
    // return a String representation of this graph
    public String toString()
    {
        String result = "\nGraph representation:\n\t";
        for(int i = 0; i < vertices.length; i++)
            if(vertices[i] != null)
                result += ((String)vertices[i]).substring(0, 3) + "\t";
        result += "\n";
        for(int r = 0; r < vertices.length; r++)
            if(vertices[r] != null)
            {
                result += ((String)vertices[r]).substring(0, 3) + "\t";
                for(int c = 0; c < vertices.length; c++)
                {
                    if(vertices[c] != null)
                        result += edges[r][c] + "\t";
                }
                result += "\n";
        }
        return result;
    }
}