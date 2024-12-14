class Graph {
    @Getter
    private final ArrayList<Node> graph;
    private GraphTraversalStrategy traversalStrategy;

    public Graph() {
        this.graph = new ArrayList<>();
    }

    public void setTraversalStrategy(GraphTraversalStrategy strategy) {
        this.traversalStrategy = strategy;
    }

    public void traverse(Node start) {
        if (traversalStrategy != null) {
            traversalStrategy.traverse(this, start);
        } else {
            throw new IllegalStateException("Traversal strategy not set.");
        }
    }

    public void resetVisits() {
        for (Node node : graph) {
            node.setVisited(false);
        }
    }

    public Node addNode() {
        Node newNode = new Node();
        graph.add(newNode);
        return newNode;
    }

    public Edge addEdge(Node a, Node b, boolean directed, int weight) {
        return Edge.createEdge(a, b, directed, weight);
    }
}
