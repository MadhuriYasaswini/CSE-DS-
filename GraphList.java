import java.util.ArrayList;
import java.util.List;

public class GraphList {
    private List<List<Integer>> adjList;
    private int numVertices;

    public GraphList(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices) {
            adjList.get(source).add(destination);
            adjList.get(destination).add(source); // For undirected graph
        }
    }
    public void printGraph(){
        for (int i = 0; i < numVertices; i++){
            System.out.print("Vertex " + i + " is connected to: ");
            for (Integer neighbor : adjList.get(i)){
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphList graph = new GraphList(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1ones, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();
    }
}
