
public class AdjacencyMatrixGraph {
    private int[][] matrix;

    public AdjacencyMatrixGraph(int size) {
        matrix = new int[size][size];
    }

    public void addEdge(int i, int j) {
        matrix[i][j] = 1;
        matrix[j][i] = 1; // For undirected graph
    }

    public void printGraph() {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.printGraph();
    }
}
