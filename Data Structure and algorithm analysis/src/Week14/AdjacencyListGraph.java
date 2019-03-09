package Week14;
import java.util.LinkedList;
/**
 * ProjectName:    Data Structure and algorithm analysis
 * Author:         Archibald Chain
 * CreateDate:     2018/12/14 18:06
 * Version:        1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */





public class AdjacencyListGraph {
    // A user define class to represent a graph.
    // A graph is an array of adjacency lists.
    // Size of array will be V (number of vertices
    // in graph)
    static class Graph
    {
        int V;
        LinkedList<Integer> adjListArray[];

        // constructor
        Graph(int V)
        {
            this.V = V;

            // define the size of array as
            // number of vertices
            adjListArray = new LinkedList[V];

            // Create a new list for each vertex
            // such that adjacent nodes can be stored
            for(int i = 0; i < V ; i++){
                adjListArray[i] = new LinkedList<>();
            }
        }
    }

    // Adds an edge to an undirected graph
    static void addEdge(Graph graph, int src, int dest)
    {
        // Add an edge from src to dest.
        graph.adjListArray[src].add(dest);

        // Since graph is undirected, add an edge from dest
        // to src also
        graph.adjListArray[dest].add(src);
    }

    // A utility function to print the adjacency list
    // representation of graph
    static void printGraph(Graph graph)
    {
        for(int v = 0; v < graph.V; v++)
        {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer pCrawl: graph.adjListArray[v]){
                System.out.print(" -> "+pCrawl);
            }
            System.out.println("\n");
        }
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        // create the graph given in above figure
        int V = 5;
        int[][] adjacencyMap = {
                {0,1,1,0,0},
                {0,0,0,1,0},
                {0,0,0,0,0},
                {1,1,0,0,0},
                {1,0,0,1,0},
        };
        Graph graph = new Graph(V);

        for (int i = 0; i < adjacencyMap.length; i++) {
            for (int j = 0; j < adjacencyMap[i].length; j++) {
                if (adjacencyMap[i][j] != 0){
                    addEdge(graph, i, j);
                }

            }
        }


        // print the adjacency list representation of
        // the above graph
        printGraph(graph);
    }
}
// This code is contributed by Sumit Ghosh

