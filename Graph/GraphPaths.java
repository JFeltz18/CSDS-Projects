import java.util.Stack;
public class GraphPaths
{
    public static boolean isPathDF(WeightedGraphInterface<String> graph, 
    String startVertex, String endVertex)
    // Returns true if a path exists on graph, from startVertex to endVertex; 
    // otherwise returns false. Uses depth-first search algorithm.
    {
        boolean found = false;
        Stack<String> stack = new Stack<String>();
        graph.clearMarks();
        stack.push(startVertex);
        while (!stack.empty() && !found)
        {
            String tempVertex = stack.pop();
            if (endVertex.equals(tempVertex))
            {
                found = true;
            }
            else
            {
                if (!graph.isMarked(tempVertex))
                {
                    graph.markVertex(tempVertex);
                    ArrayQueue<String> q = (ArrayQueue<String>)graph.getAdjacentVertices(tempVertex);
                    while (!q.empty())
                    {
                        stack.push((String)q.remove());
                    }
                }
            }
        }
        return found;
    }

    public static boolean isPathBF(WeightedGraphInterface<String> graph, 
    String startVertex, String endVertex)
    // Returns true if a path exists on graph, from startVertex to endVertex; 
    // otherwise returns false. Uses breadth-first search algorithm.
    {
        boolean found = false;
        ArrayQueue<String> q = new ArrayQueue<String>();
        graph.clearMarks();
        q.add(startVertex);
        while (!q.empty() && !found)
        {
            String tempVertex = q.remove();
            if (tempVertex.equals(endVertex))
            {
                found = true;
            }
            else
            {
                if (!graph.isMarked(tempVertex))
                {
                    graph.markVertex(tempVertex);
                    ArrayQueue<String> tempQ = (ArrayQueue<String>)graph.getAdjacentVertices(tempVertex);
                    while (!tempQ.empty())
                    {
                        q.add(tempQ.remove());
                    }
                }
            }
        }
        return found;
    }

    public static QueueInterface<Flight> shortestPaths(WeightedGraphInterface<String> graph, 
    String startVertex) throws PQUnderflowException
    // Determines the shortest distance from startVertex to every other reachable vertex in graph.
    {
        graph.clearMarks();
        QueueInterface<Flight> result = new LinkedQueue<Flight>();
        QueueInterface<String> vertices = new LinkedQueue<String>();
        PriorityQueue<Flight> pq = new Heap<Flight>();
        Flight flight = new Flight(startVertex, startVertex, 0);
        pq.add(flight);
        while (!pq.empty())
        {
            flight = pq.remove();
            String vertex = flight.getToVertex();
            if (!graph.isMarked(vertex))
            {
                graph.markVertex(vertex);
                result.add(flight);
                flight.setFromVertex(flight.getToVertex());
                int minDistance = flight.getDistance();
                vertices = graph.getAdjacentVertices(flight.getFromVertex());
                while (!vertices.empty())
                {
                    vertex = vertices.remove();
                    if (!graph.isMarked(vertex))
                    {
                        flight.setToVertex(vertex);
                        int newDistance = minDistance + graph.weightIs(flight.getFromVertex(), vertex);
                        Flight newFlight = new Flight(flight.getFromVertex(), vertex, newDistance);
                        pq.add(newFlight);
                    }
                }
            }
        }
        return result;
    }
}